package com.sinfloo.sales.controller;

import com.sinfloo.sales.constants.ConstantEnpoint;
import com.sinfloo.sales.constants.ConstantMessages;
import com.sinfloo.sales.model.Employes;
import java.io.IOException;
import java.nio.file.AccessDeniedException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ControllerMain extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String pathInfo = request.getPathInfo();
        HttpSession session = request.getSession();
        Employes employe = (Employes) session.getAttribute("sessionUser");
        try {
            if (employe != null) {
                switch (pathInfo) {
                    case ConstantEnpoint.HOME:
                        if (request.getMethod().equals(ConstantEnpoint.GET)) {
                            request.getRequestDispatcher(ConstantEnpoint.PAGE_MAIN).forward(request, response);
                        } else {
                            throw new AccessDeniedException(ConstantMessages.MSG_PAGE_NOT_FOUND);
                        }
                        break;
                    case ConstantEnpoint.LOGOUT:
                        session.invalidate();
                        response.sendRedirect(request.getContextPath()+ConstantEnpoint.PAGE_LOGIN);
                        break;
                    default:
                        throw new AccessDeniedException(ConstantMessages.MSG_PAGE_NOT_FOUND);
                }
            } else {
                throw new AccessDeniedException(ConstantMessages.MESSAGE_VAL_404);
            }

        } catch (NullPointerException | IOException e) {
            request.setAttribute("error", e.getMessage());
            if (e.getLocalizedMessage().equals(ConstantMessages.MESSAGE_VAL_404)) {
                response.sendRedirect(request.getContextPath() + ConstantEnpoint.PAGE_LOGIN);
            } else {
                request.getRequestDispatcher(ConstantEnpoint.PAGE_NOTFOUND).forward(request, response);
            }
        }

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

}
