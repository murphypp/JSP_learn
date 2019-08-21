package com.ucar.training.controller;


import com.ucar.training.entity.User;
import com.ucar.training.service.impl.UserServiceImpl;
import com.ucar.training.utils.UserUtil;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class RegisterServlet extends HttpServlet{

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User user = new User();
        String username = request.getParameter("username");
        user.setUsername(username);
        String authority = request.getParameter("authority");
        if (authority==null){
            authority="common";
        }
        String password = request.getParameter("password");
        user.setPassword(password);
        String age = request.getParameter("age");
        user.setAge(Integer.parseInt(age));
        String sex = request.getParameter("sex");
        user.setSex(sex);
        String[] allLike = request.getParameterValues("likes");
        String likes = UserUtil.getUserLikes(allLike);
        user.setHobby(likes);
        String sign = request.getParameter("area");
        user.setSign(sign);

        UserServiceImpl service = new UserServiceImpl();
        service.addUser(user);

        String source = request.getParameter("source");
        if ("addUser".equals(source)) {
            System.out.println("添加了新用户：当前用户数：" + service.getAllUser().size());
            request.setAttribute("tip","添加成功");
            request.getRequestDispatcher("addUser.jsp").forward(request,response);
        }else {
            System.out.println("已注册用户数:" + service.getAllUser().size());
            request.setAttribute("tip","注册成功");
            request.getRequestDispatcher( "register.jsp").forward(request,response);
        }
        service.after();
    }
}
