package com.ucar.training.controller;

import com.ucar.training.dao.impl.IUserImpl;
import com.ucar.training.service.impl.IServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteUserServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
    @Override
    @SuppressWarnings("unchecked")
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        IServiceImpl iService = new IServiceImpl();
        String username = request.getParameter("deleted");
        System.out.println("要删除的用户名：" + username);
        iService.deleteUser(username);

        this.getServletContext().setAttribute("allUser",iService.getAllUser());
        request.setAttribute("tip","删除用户"+ username+ "成功！");
        request.getRequestDispatcher("manage.jsp").forward(request,response);
    }
}
