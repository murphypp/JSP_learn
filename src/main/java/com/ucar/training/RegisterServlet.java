package com.ucar.training;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * @program:training_servlet
 * @description:处理注册消息
 * @author:linshaoxiong
 * @create:2019-08-01 14:27
 **/
//@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    static private List<User> userList = new ArrayList<>();
    static {
        userList.add(new User("shaoxiong.lin","111111","12@12.com","lin",1,"男","111"));
        userList.add(new User("shaoxiong","111111","12@12.com","lin",1,"男","111"));
    }
    public void  doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //处理注册消息并用集合保存
        request.setCharacterEncoding("UTF-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password1");
        String email    = request.getParameter("email");
        String realname = request.getParameter("realname");
        String phone    = request.getParameter("phone");
        String age      = request.getParameter("age");
        String sex      = request.getParameter("sex");
        User a = new User(username,password,email,realname,Integer.parseInt(age),sex,phone);
        userList.add(a);

        System.out.println("注册成功，执行跳转");
        request.setAttribute("userList",userList);
        request.getRequestDispatcher("/register.jsp").forward(request,response);
    }
    public void doPost(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException
    {
        doGet(req,resp);
    }
    static public List<User> getUserList(){
        return userList;
    }

}
