package com.ucar.training.controller;

import com.ucar.training.entity.Message;
import com.ucar.training.service.impl.MessageServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class MessageManageServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request,response);
    }
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String select = request.getParameter("select");
        if(select == null)select = "";
        MessageServiceImpl service = new MessageServiceImpl();
        List<Message> messages = service.getAllMessage();
        if(!"".equals(select)){
            messages = service.getUserMessages(select);
        }

        request.setAttribute("allMessages",messages);
        request.getRequestDispatcher("messageManage.jsp").forward(request,response);
    }
}
