package com.ucar.training.controller;

import com.ucar.training.controller.RegisterServlet;
import com.ucar.training.dao.impl.UserDaoImpl;
import com.ucar.training.entity.User;
import com.ucar.training.services.impl.UserService;

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
    private UserService userService = new UserService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String username = request.getParameter("username");
            HttpSession session = request.getSession();
            Boolean permission = ((User)session.getAttribute("nowUser")).isPermission();
            if(!permission)
                return;
            String message ="";
            if(userService.deleteUser(username)){
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
        List<User> userList =userService.selectALL();
        ServletContext context = request.getServletContext();
        context.setAttribute("userList",userList);
        request.setAttribute("message",message);
        request.getRequestDispatcher("userinfo.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
