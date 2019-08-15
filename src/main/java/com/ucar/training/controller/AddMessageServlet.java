package com.ucar.training.controller;

import com.ucar.training.entity.Message;
import com.ucar.training.service.impl.MessageServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddMessageServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String content = request.getParameter("message");
        String username = (String) request.getSession().getAttribute("current");
        String warn = (String)request.getAttribute("warning")+"";
        MessageServiceImpl service = new MessageServiceImpl();
        if( warn.equals("")){
            Message m = new Message(content,username);
            service.addMessage(m);
            System.out.println("用户" + username + "发布了一条留言");
        }else {
            System.out.println("用户"+username+"发布了敏感留言");
        }

        request.setAttribute("count",service.getUserMessages(username).size());
        service.after();
        request.getRequestDispatcher("leaveMessage.jsp").forward(request,response);
    }
}
