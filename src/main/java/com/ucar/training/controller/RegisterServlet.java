package com.ucar.training.controller;

import com.ucar.training.entity.User;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @program:training_servlet
 * @description:处理注册消息
 * @author:linshaoxiong
 * @create:2019-08-01 14:27
 **/
public class RegisterServlet extends HttpServlet {
    static private List<User> userList = new ArrayList<>();
    static {
        System.out.println("静态代码块初始化");
        userList.add(new User("admin","admin","12@12.com","lin",1,"男","111","1","写代码,篮球,足球","123"));
        userList.add(new User("shaoxiong.lin","111111","12@12.com","lin",1,"男","111","0","篮球,足球","123"));
        userList.add(new User("shaoxiong","111111","12@12.com","lin",1,"女","111","0","写代码,足球","123"));
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
        String privileges = request.getParameter("privileges");
        String[] hobbyList = request.getParameterValues("hobby");
        String sign = request.getParameter("sign");
        String hobby="";
        for(String str:hobbyList){
            hobby=hobby+","+str;
        }
        System.out.println(hobby);
        User a = new User(username,password,email,realname,Integer.parseInt(age),sex,phone,privileges,hobby,sign);
        userList.add(a);
        ServletContext application = getServletContext();
        application.setAttribute("userList",userList);
        System.out.println(application.getAttribute("userList"));
        System.out.println("注册成功，执行跳转");
        String message = "注册成功！";
        request.setAttribute("message",message);
        request.getRequestDispatcher("/login.jsp").forward(request,response);
    }
    public void doPost(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException
    {
        doGet(req,resp);
    }
    static public List<User> getUserList(){
        return userList;
    }

}
