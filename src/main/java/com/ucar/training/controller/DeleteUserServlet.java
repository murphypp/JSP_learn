package com.ucar.training.controller;

import com.ucar.training.service.impl.MessageServiceImpl;
import com.ucar.training.service.impl.UserServiceImpl;

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
        String username = request.getParameter("deleted");
        System.out.println("要删除的用户名：" + username);

        UserServiceImpl userService = new UserServiceImpl();
        userService.deleteUser(username);
        MessageServiceImpl messageService = new MessageServiceImpl();
        messageService.delUserMessages(username);

        this.getServletContext().setAttribute("allUser",userService.getAllUser());
        userService.after();
        messageService.after();
        request.setAttribute("tip","删除用户"+ username+ "成功！");
        request.getRequestDispatcher("manage.jsp").forward(request,response);

    }
}
