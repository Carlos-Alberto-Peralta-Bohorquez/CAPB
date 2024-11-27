
package com.sinfloo.sales.controller;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;


public class ServletContextProvider extends HttpServlet {

    private static ServletContext context;
    
    public static void setServletContext(ServletContext context){
        ServletContextProvider.context=context;
    }

    public static ServletContext getContextServlet(){
        return context;
    }
}
