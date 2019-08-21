package com.ucar.training.controller;

import com.ucar.training.service.impl.MessageServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteMessageServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ID = request.getParameter("ID");
        MessageServiceImpl service = new MessageServiceImpl();
        service.deleteMessage(ID);

        request.setAttribute("allMessages",service.getAllMessage());
        service.after();
        request.getRequestDispatcher("messageManage.jsp").forward(request,response);
    }
}
