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
import java.util.Iterator;
import java.util.List;

/**
 * @program:training_servlet
 * @description:管理员删除用户
 * @author:linshaoxiong
 * @create:2019-08-07 14:03
 **/
public class DeleteUser extends HttpServlet {
    private UserDaoImpl userDao = new UserDaoImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String username = req.getParameter("username");
            HttpSession session = req.getSession();
            Boolean privileges = ((User)session.getAttribute("nowUser")).isPrivileges();
            if(!privileges)
                return;
            String message ="";
            if(userDao.deleteUser(username)){
                System.out.println("删除用户成功！");
                message="删除用户成功！";
            }
            /*List<User> userList = RegisterServlet.getUserList();
            Iterator<User> u = userList.iterator();
            while (u.hasNext()){
                User user = u.next();
                if(user.getUsername().equals(username)){
                        u.remove();
                        System.out.println("删除用户成功！");
                        message="删除用户成功！";
                }
            }*/
        List<User> userList =userDao.getAllUser();
        ServletContext context = req.getServletContext();
        context.setAttribute("userList",userList);
            req.setAttribute("message",message);
            req.getRequestDispatcher("userinfo.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
