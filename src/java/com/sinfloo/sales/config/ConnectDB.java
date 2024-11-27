package com.sinfloo.sales.config;

import com.sinfloo.sales.controller.ServletContextProvider;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import javax.servlet.ServletContext;

import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConnectDB {

    private static final String PROPERTIES_FILE = "application.properties";

    private static final String URL;
    private static final String USER;
    private static final String PASS;
    private static final String DRIVER;

    private static final int MAX_POOL;
    private static final List<Connection> CONNECTIONS_POOLS;

    static {
        Properties properties = loadProperties();
        URL = properties.getProperty("database.url");
        USER = properties.getProperty("database.user");
        PASS = properties.getProperty("database.password");
        DRIVER = properties.getProperty("database.driver");
        MAX_POOL = Integer.parseInt(properties.getProperty("database.maxpool"));
        CONNECTIONS_POOLS = new ArrayList<>(MAX_POOL);
    }

    private static Properties loadProperties() {
        Properties properties = new Properties();
        ServletContext context = ServletContextProvider.getContextServlet();
        String path = context.getRealPath("/WEB-INF").concat("\\").concat(PROPERTIES_FILE);
        try (FileInputStream inputStream = new FileInputStream(path)) {
            if (inputStream != null) {
                properties.load(inputStream);
            } else {
                throw new IOException("application.properties not found in WEB-INF");
            }
        } catch (Exception e) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, e);
            throw new RuntimeException("Error loading properties file", e);
        }
        return properties;
    }

    private static void registerDriver(String driver) {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    private static Connection createConnection() throws SQLException {
        registerDriver(DRIVER);
        return DriverManager.getConnection(URL, USER, PASS);
    }

    private static void initializeConnectionPool() {
        for (int i = 0; i < MAX_POOL; i++) {
            try {
                CONNECTIONS_POOLS.add(createConnection());
            } catch (SQLException e) {
                throw new RuntimeException("Error creating connection", e);
            }
        }
    }

    public static void releaseConnection(Connection connection) {
        if (connection != null) {
            synchronized (connection) {
                CONNECTIONS_POOLS.add(connection);
            }
        }
    }

    public static Connection getConnection() {
        synchronized (CONNECTIONS_POOLS) {
            if (CONNECTIONS_POOLS.isEmpty()) {
                initializeConnectionPool();
            }
        }
        return CONNECTIONS_POOLS.remove(CONNECTIONS_POOLS.size() - 1);
    }

}
