package com.sinfloo.sales.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.sinfloo.sales.constants.ConstantEnpoint;
import com.sinfloo.sales.constants.ConstantMessages;
import com.sinfloo.sales.model.Employes;
import com.sinfloo.sales.model.User;
import com.sinfloo.sales.model.dao.EmployesDao;
import com.sinfloo.sales.model.dao.impl.EmployesDaoImpl;
import java.io.IOException;
import java.nio.file.AccessDeniedException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class ControllerLogin extends HttpServlet {
    
    private EmployesDao employesDao;

    @Override
    public void init() throws ServletException {
        super.init(); 
        ServletContextProvider.setServletContext(getServletContext());
    }   
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Map<String,Object>result=new HashMap<>();
        String pathInfo=request.getPathInfo();
        HttpSession session=request.getSession();
        try {
            switch (pathInfo) {
                case ConstantEnpoint.LOGIN:
                    if(request.getMethod().equals(ConstantEnpoint.POST)){
                        ObjectMapper mapper=new ObjectMapper();
                        User user=mapper.readValue(request.getReader(), User.class);
                        Employes employe=getEmployesDao().getObjectByUser(user);
                        if(employe!=null && employe.getEmployeId()>0){
                            result.put("employe", employe);
                            session.setAttribute("sessionUser", employe);
                        }else{
                            throw new Exception(ConstantMessages.MESSAGE_VAL_401);
                        }
                    }else{
                        throw  new AccessDeniedException(ConstantMessages.MSG_PAGE_NOT_FOUND);
                    }
                    break;
                default:
                   throw  new AccessDeniedException(ConstantMessages.MSG_PAGE_NOT_FOUND);
            }
            result.put(ConstantMessages.STATUS_KEY, ConstantMessages.STATUS_200);
            result.put(ConstantMessages.MESSAGE_KEY, ConstantMessages.MESSAGE_VAL_200);
        } catch (NullPointerException | IOException e) {
            result.put(ConstantMessages.STATUS_KEY, ConstantMessages.STATUS_400);
            result.put(ConstantMessages.MESSAGE_KEY, e.getLocalizedMessage());
        }catch (Exception e){
            result.put(ConstantMessages.STATUS_KEY, ConstantMessages.STATUS_400);
            result.put(ConstantMessages.MESSAGE_KEY, e.getLocalizedMessage());
        }
        ObjectMapper mapper=new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        
        String resultJson=mapper.writeValueAsString(result);
        response.setContentType(ConstantMessages.CONTENT_TYPE_JSON);
        response.setCharacterEncoding(ConstantMessages.ENCODE_UFT8);
        response.getWriter().write(resultJson);
    }
    
    private EmployesDao getEmployesDao(){
        if(employesDao==null){
            employesDao=new EmployesDaoImpl();
        }
        return  employesDao;
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
    }

}
