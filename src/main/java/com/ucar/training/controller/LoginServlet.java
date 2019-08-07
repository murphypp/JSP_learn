package com.ucar.training.controller;


import com.ucar.training.dao.impl.IUserImpl;
import com.ucar.training.entity.User;
import com.ucar.training.service.IService;
import com.ucar.training.service.impl.IServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Set;

public class LoginServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
    @Override
    @SuppressWarnings("unchecked")
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /**
         * flag = 0 ->登录失败
         * flag = 1 ->登录成功。是普通用户
         * flag = 2 ->登录成功，是管理员
         */
        int flag=0;
        String username = request.getParameter("username") + "";
        String password = request.getParameter("password") + "";
        Set<User> all = new IServiceImpl().getAllUser();
        if(all != null){
            for (User u : all
            ) {
                if(username.equals(u.getUsername())){
                    if(password.equals(u.getPassword())){
                        flag = 1;
                        if("admin".equals(u.getAuthority())){
                            flag = 2;
                        }
                    }
                }
            }
        }
        if (flag == 1){
            System.out.println("普通用户"+username+"成功登录!");
            HttpSession session = request.getSession();
            session.setAttribute("current",username);
            request.getRequestDispatcher("leaveMessage.jsp").forward(request,response);
        }else if(flag == 2){
            System.out.println("管理员成功登录：" + username);
            HttpSession session = request.getSession();
            session.setAttribute("current",username);
            session.setAttribute("users",all);
            request.getRequestDispatcher("manage.jsp").forward(request,response);
        }
        else {
            System.out.println("登录失败：不存在的用户名：" + username);
            request.setAttribute("unexist","用户名或密码错误");
            request.getRequestDispatcher("login.jsp").forward(request,response);
        }
    }
}
