package com.ucar.training.controller;

import com.ucar.training.dao.impl.UserDaoImpl;
import com.ucar.training.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @program:training_servlet
 * @description:检查用户名是否已经被注册
 * @author:linshaoxiong
 * @create:2019-08-01 15:54
 **/
public class RegisterCheck extends HttpServlet {
    private UserDaoImpl userDao = new UserDaoImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("正在检验用户名...");
        String username = request.getParameter("username");
        if(userDao.find(username)!=null)
            response.getWriter().print("1");
        /*List<User> userList =userDao.getAllUser();
        for(User test:userList){
            if(test.getUsername().equals(username))
                response.getWriter().print("1");
        }*/
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
