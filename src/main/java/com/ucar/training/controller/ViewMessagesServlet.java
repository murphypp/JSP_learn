package com.ucar.training.controller;

import com.ucar.training.entity.Message;
import com.ucar.training.service.impl.IMessageServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ViewMessagesServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request,response);
    }
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String select = request.getParameter("select") +"";

        IMessageServiceImpl service = new IMessageServiceImpl();
        List<Message> messages = service.getAllMessage();
        System.out.println("查看留言板："+select +1);
        if(!"".equals(select)){
            messages = service.getUserMessages(select);
        }

        request.setAttribute("allMessages",messages);
        request.getRequestDispatcher("messages.jsp").forward(request,response);
    }
}
