package com.ucar.training.dao;

import com.ucar.training.controller.RegisterServlet;
import com.ucar.training.entity.User;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @program:training_servlet
 * @description:修改用户信息
 * @author:linshaoxiong
 * @create:2019-08-07 13:52
 **/
public class ModifyUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        System.out.println(username);
        List<User> userList = RegisterServlet.getUserList();
        for(User u :userList){
            if(u.getUsername().equals(username)){
                u.setAge(Integer.parseInt(req.getParameter("age")));
                u.setEmail(req.getParameter("email"));
                u.setPassword(req.getParameter("password1"));
                u.setPhone(req.getParameter("phone"));
                u.setRealname(req.getParameter("realname"));
                u.setSex(req.getParameter("sex"));
                u.setSign(req.getParameter("sign"));
            }
        }

        System.out.println("修改成功，执行跳转");
        String message = "修改成功！";
        req.setAttribute("message",message);
        req.getRequestDispatcher("/userinfo.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
