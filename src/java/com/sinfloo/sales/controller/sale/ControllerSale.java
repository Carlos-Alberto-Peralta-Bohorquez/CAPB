
package com.sinfloo.sales.controller.sale;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.sinfloo.sales.constants.ConstantEnpoint;
import com.sinfloo.sales.constants.ConstantMessages;
import com.sinfloo.sales.constants.Constants;
import com.sinfloo.sales.controller.ControllerProduct;
import com.sinfloo.sales.model.Employes;
import java.io.IOException;
import java.nio.file.AccessDeniedException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ControllerSale extends HttpServlet {

    private static final Logger LOGGER=Logger.getLogger(ControllerSale.class.getName());
    
    private ObjectMapper objectMapper;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Map<String, Object> result = new HashMap<>();
        String pathInfo = request.getPathInfo() == null ? ConstantEnpoint.ROOT : request.getPathInfo();
        HttpSession session = request.getSession();
        Employes sessionUser = (Employes) session.getAttribute(Constants.USERLOGIN);
        try {
            if (sessionUser != null) {
                switch (pathInfo) {
                    case ConstantEnpoint.ROOT:
                        request.getRequestDispatcher(ConstantEnpoint.PAGE_SALE).forward(request, response);
                        break;                   
                    default:
                        throw new AccessDeniedException(ConstantMessages.MSG_PAGE_NOT_FOUND);
                }
                result.put(ConstantMessages.STATUS_KEY, ConstantMessages.STATUS_200);
                result.put(ConstantMessages.MESSAGE_KEY, ConstantMessages.MESSAGE_VAL_200);
            } else {
                throw new AccessDeniedException(ConstantMessages.MESSAGE_VAL_404);
            }
        } catch (AccessDeniedException e) {
            LOGGER.log(Level.INFO,"ERROR: {0}",e.getMessage());
            request.setAttribute("error", e.getMessage());
            request.getRequestDispatcher(ConstantEnpoint.PAGE_NOTFOUND).forward(request, response);
        }catch(Exception e){
            LOGGER.log(Level.INFO,"ERROR: {0}",e.getMessage());
            result.put(ConstantMessages.STATUS_KEY, ConstantMessages.STATUS_400);
            result.put(ConstantMessages.MESSAGE_KEY, e.getMessage());
        }
        String resultJson=getObjectMapper().writeValueAsString(result);
        response.setContentType(ConstantMessages.CONTENT_TYPE_JSON);
        response.setCharacterEncoding(ConstantMessages.ENCODE_UFT8);
        response.getWriter().write(resultJson);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private ObjectMapper getObjectMapper() {
        if (objectMapper == null) {
            objectMapper = new ObjectMapper();
            objectMapper.registerModule(new JavaTimeModule());
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
            objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        }
        return objectMapper;
    }
}
