package com.ucar.training.controller;


import com.ucar.training.service.impl.IUserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username") + "";
        String password = request.getParameter("password") + "";
        IUserServiceImpl service = new IUserServiceImpl();
        /*
          flag = 0 ->登录失败
          flag = 1 ->登录成功。是普通用户
          flag = 2 ->登录成功，是管理员
         */
        int flag = service.getPass(username,password);

        if (flag == 1){
            System.out.println("用户"+username+"成功登录!");
            HttpSession session = request.getSession();
            session.setAttribute("current",username);
            request.getRequestDispatcher("addMessage").forward(request,response);
        }else if(flag == 2){
            System.out.println("管理员成功登录：" + username);
            HttpSession session = request.getSession();
            session.setAttribute("current",username);
            session.setAttribute("users",service.getAllUser());
            request.getRequestDispatcher("manage.jsp").forward(request,response);
        }
        else {
            System.out.println("登录失败：不存在的用户名：" + username);
            request.setAttribute("warn","用户名或密码错误");
            request.getRequestDispatcher("login.jsp").forward(request,response);
        }
    }
}
