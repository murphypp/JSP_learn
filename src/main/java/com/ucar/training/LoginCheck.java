package com.ucar.training;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * @program:training_servlet
 * @description:检测登录账号的合法性
 * @author:linshaoxiong
 * @create:2019-08-02 09:24
 **/
public class LoginCheck extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        List<User> userList = RegisterServlet.getUserList();
        for(User user:userList){
            if(username.equals(user.getUsername())){
                System.out.println(username+"------"+user.getUsername());
                if (password.equals(user.getPassword())){
                    //登录成功，记录session
                    HttpSession session = req.getSession();
                    session.setAttribute("user",username);
                    System.out.println("已经记录session"+session.toString());
                    //跳转登录成功页面
                    req.setAttribute("userList",userList);
                    req.getRequestDispatcher("/message.jsp").forward(req,resp);
                }else{
                    resp.sendRedirect("login.jsp?message=password_error");
                }
            }
        }
        resp.sendRedirect("login.jsp?message=login_error");
    }
}
