package com.ucar.training.controller;

import com.ucar.training.dao.impl.IUserImpl;
import com.ucar.training.entity.User;
import com.ucar.training.service.impl.IServiceImpl;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;

public class UserAjaxServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
    @Override
    @SuppressWarnings("unchecked")
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        String username = request.getParameter("username");
        IServiceImpl service = new IServiceImpl();
        User u = service.getUser(username);
        PrintWriter out= response.getWriter();
        if(u == null){
            out.print("0");
            out.flush();
            return;
        }
        out.print("1");
        out.flush();
    }
}
