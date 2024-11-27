package com.sinfloo.sales.model.dao.impl;

import com.sinfloo.sales.config.ConnectDB;
import com.sinfloo.sales.constants.ConstantMessages;
import com.sinfloo.sales.model.Product;
import com.sinfloo.sales.model.dao.ProductDao;
import com.sinfloo.sales.utils.Utils;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProductDaoImpl implements ProductDao {
    
    private static final Logger LOGGER = Logger.getLogger(ProductDaoImpl.class.getName());
    
    @Override
    public List<Product> getAll() {
        
        List<Product> products = new ArrayList<>();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = ConnectDB.getConnection();
            ps = connection.prepareStatement("select * from m_product");
            rs = ps.executeQuery();
            while (rs.next()) {                
                Product product = new Product();
                product.setProductId(rs.getInt("n_id_product"));
                product.setCode(rs.getString("c_serie"));
                product.setName(rs.getString("c_name"));
                product.setDescription(rs.getString("c_description"));
                product.setPrice(rs.getDouble("n_price"));
                product.setStock(rs.getInt("n_stock"));
                product.setState(rs.getString("c_state"));
                products.add(product);
            }
        } catch (SQLException e) {
            LOGGER.log(Level.INFO, "ERROR:{0}", e.getMessage());
        } catch (Exception e) {
            LOGGER.log(Level.INFO, "ERROR:{0}", e.getMessage());
            if (connection != null) {
                ConnectDB.releaseConnection(connection);
            }
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (connection != null) {
                    ConnectDB.releaseConnection(connection);
                }
            } catch (SQLException e) {
                LOGGER.log(Level.INFO, "ERROR:{0}", e.getMessage());
            }
        }
        return products;
    }
    
    @Override
    public Product getObjectById(int id) {
        Product product = new Product();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = ConnectDB.getConnection();
            ps = connection.prepareStatement("select * from m_product where n_id_product=?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {                
                product.setProductId(rs.getInt("n_id_product"));
                product.setCode(rs.getString("c_serie"));
                product.setName(rs.getString("c_name"));
                product.setDescription(rs.getString("c_description"));
                product.setPrice(rs.getDouble("n_price"));
                product.setStock(rs.getInt("n_stock"));
                product.setState(rs.getString("c_state"));
            }
        } catch (SQLException e) {
            LOGGER.log(Level.INFO, "ERROR:{0}", e.getMessage());
        } catch (Exception e) {
            LOGGER.log(Level.INFO, "ERROR:{0}", e.getMessage());
            if (connection != null) {
                ConnectDB.releaseConnection(connection);
            }
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (connection != null) {
                    ConnectDB.releaseConnection(connection);
                }
            } catch (SQLException e) {
                LOGGER.log(Level.INFO, "ERROR:{0}", e.getMessage());
            }
        }
        return product;
    }
    
    @Override
    public Product getObjectByCode(String code) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public int saveObject(Map<String, Object> requestBody) {
        int r = 0;
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            mappingRequestToValidate(requestBody);
            connection = ConnectDB.getConnection();
            
            StringBuilder queryInsert = new StringBuilder();
            queryInsert.append("INSERT INTO m_product(");
            queryInsert.append("c_serie");
            queryInsert.append(",c_name");
            queryInsert.append(",c_description");
            queryInsert.append(",n_price");
            queryInsert.append(",n_stock");
            queryInsert.append(",c_state");
            queryInsert.append(")values(?,?,?,?,?,?)");
            
            StringBuilder queryUpdate=new StringBuilder();
            queryUpdate.append("update m_product set ");
            queryUpdate.append("c_serie=? ");
            queryUpdate.append(",c_name=? ");
            queryUpdate.append(",c_description=? ");
            queryUpdate.append(",n_price=? ");
            queryUpdate.append(",n_stock=? ");
            queryUpdate.append(",c_state=? where n_id_product=?");
                      
            if(Utils.convertStringToNumeric(requestBody.get("productId").toString())==0){
                if(existProductByName(requestBody.get("name").toString())){
                    throw new Exception(ConstantMessages.MESSAGE_VAL_410);
                }
                ps = connection.prepareStatement(queryInsert.toString());
                ps.setString(1, "P".concat(Utils.generateCodeWithDate()));
            }else{
                ps = connection.prepareStatement(queryUpdate.toString());
                ps.setString(1, requestBody.get("code").toString());
                ps.setInt(7, Integer.parseInt(String.valueOf(Utils.convertStringToNumeric(requestBody.get("productId").toString()))));
            }
            
            ps.setString(2, requestBody.get("name").toString());
            ps.setString(3, requestBody.get("description").toString());
            ps.setDouble(4, Utils.convertStringtoDecimal(requestBody.get("price").toString()));
            ps.setInt(5, Integer.parseInt(String.valueOf(Utils.convertStringToNumeric(requestBody.get("stock").toString()))));
            ps.setString(6, requestBody.get("state").toString());
            
            r = ps.executeUpdate();
            
        } catch (SQLException e) {
            LOGGER.log(Level.INFO, "ERROR:{0}", e.getLocalizedMessage());
        } catch (Exception e) {
            LOGGER.log(Level.INFO, "ERROR:{0}", e.getLocalizedMessage());
            if (connection != null) {
                ConnectDB.releaseConnection(connection);
            }
            throw new NumberFormatException(e.getLocalizedMessage());
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (connection != null) {
                    ConnectDB.releaseConnection(connection);
                }
            } catch (SQLException e) {
                LOGGER.log(Level.INFO, "ERROR:{0}", e.getLocalizedMessage());
            }
        }
        return r;
    }
    
    @Override
    public void deleteObjectById(int id) {
        Connection connection=null;
        PreparedStatement ps=null;
        try {
            StringBuilder query=new StringBuilder();
            query.append("DELETE FROM m_product where n_id_product=?");
            
            connection=ConnectDB.getConnection();
            ps=connection.prepareStatement(query.toString());
            ps.setInt(1, id);
            
            ps.executeUpdate();
            
        } catch (SQLException e) {
            LOGGER.log(Level.INFO, "ERROR:{0}", e.getLocalizedMessage());
        } catch (Exception e) {
            LOGGER.log(Level.INFO, "ERROR:{0}", e.getLocalizedMessage());
            if (connection != null) {
                ConnectDB.releaseConnection(connection);
            }
            throw new NumberFormatException(e.getLocalizedMessage());
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (connection != null) {
                    ConnectDB.releaseConnection(connection);
                }
            } catch (SQLException e) {
                LOGGER.log(Level.INFO, "ERROR:{0}", e.getLocalizedMessage());
            }
        }
    }
    
    @Override
    public boolean existProductByName(String name) {
        boolean r=false;
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = ConnectDB.getConnection();
            ps = connection.prepareStatement("select n_id_product from m_product where c_name=?");
            ps.setString(1, name);
            rs = ps.executeQuery();
            while (rs.next()) {                
                r=true;
            }
        } catch (SQLException e) {
            LOGGER.log(Level.INFO, "ERROR:{0}", e.getMessage());
        } catch (Exception e) {
            LOGGER.log(Level.INFO, "ERROR:{0}", e.getMessage());
            if (connection != null) {
                ConnectDB.releaseConnection(connection);
            }
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (connection != null) {
                    ConnectDB.releaseConnection(connection);
                }
            } catch (SQLException e) {
                LOGGER.log(Level.INFO, "ERROR:{0}", e.getMessage());
            }
        }
        return r;
    }
    
    private void mappingRequestToValidate(Map<String, Object> requestBody) {
        for (Map.Entry<String, Object> entry : requestBody.entrySet()) {
            if (mandatoryColumns().contains(entry.getKey())) {
                Utils.isNullOrEmty(entry.getKey(), String.valueOf(entry.getValue()));
            }
        }
    }
    
    private Set<String> mandatoryColumns() {
        Set<String> columns = new HashSet<>();
        columns.add("name");
        columns.add("price");
        columns.add("description");
        columns.add("stock");
        columns.add("state");
        return columns;
    }
}
