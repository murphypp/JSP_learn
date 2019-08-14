package com.ucar.training.controller;

import com.ucar.training.controller.RegisterServlet;
import com.ucar.training.dao.impl.UserDaoImpl;
import com.ucar.training.entity.User;

import javax.servlet.ServletContext;
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
    private UserDaoImpl userDao = new UserDaoImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println("现在登录用户："+username+"密码："+password);
        List<User> userList =userDao.getAllUser();
        User user = userDao.find(username);
        //找到用户
        if(user!=null){
            //密码正确
            if(user.getPassword().equals(password)){
                //登录成功，记录session
                HttpSession session = req.getSession();
                session.setAttribute("user",username);
                session.setAttribute("privileges",user.isPrivileges());
                session.setAttribute("nowUser",user);
                System.out.println("已经记录session:"+session.getAttribute("user"));
                //登录成功，记录context
                ServletContext context = req.getServletContext();
                context.setAttribute("userList",userList);
                System.out.println("已经记录context:"+context.getAttribute("userList"));
                //跳转登录成功页面
                //req.setAttribute("userList",userList);
                req.getRequestDispatcher("transit.jsp").forward(req,resp);
                //resp.sendRedirect("transit.jsp");
            }else{
                //密码错误
                resp.sendRedirect("login.jsp?message=password_error");
                return;
            }
        }
        resp.sendRedirect("login.jsp?message=login_error");
        return;
        /*
        for(User user:userList){
            if(username.equals(user.getUsername())){
                if (password.equals(user.getPassword())){
                    //登录成功，记录session
                    HttpSession session = req.getSession();
                    session.setAttribute("user",username);
                    session.setAttribute("privileges",user.isPrivileges());
                    session.setAttribute("nowUser",user);
                    System.out.println("已经记录session:"+session.getAttribute("user"));

                    //登录成功，记录context
                    ServletContext context = req.getServletContext();
                    context.setAttribute("userList",userList);
                    System.out.println("已经记录context:"+context.getAttribute("userList"));
                    //跳转登录成功页面
                    //req.setAttribute("userList",userList);
                    req.getRequestDispatcher("transit.jsp").forward(req,resp);
                    //resp.sendRedirect("transit.jsp");
                }else{
                    resp.sendRedirect("login.jsp?message=password_error");
                    return;
                }
            }
        }
        resp.sendRedirect("login.jsp?message=login_error");
        return;*/
    }
}
