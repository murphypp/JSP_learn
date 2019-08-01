package com.ucar.training;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @program:training_servlet
 * @description:检查用户名是否已经被注册
 * @author:linshaoxiong
 * @create:2019-08-01 15:54
 **/
public class RegisterCheck extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("正在检验用户名...");
        List<User> userList = RegisterServlet.getUserList();
        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        for(User test:userList){
            if(test.getUsername().equals(username))
                response.getWriter().print("1");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
