package com.ucar.training.controller;

import com.ucar.training.entity.User;
import com.ucar.training.service.impl.UserServiceImpl;
import com.ucar.training.utils.UserUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateUserServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         String username = request.getParameter("username");
         String sex = request.getParameter("sex");
         String age = request.getParameter("age");
         String[] allLikes = request.getParameterValues("likes");
         String likes = UserUtil.getUserLikes(allLikes);
         String sign = request.getParameter("area");

         UserServiceImpl service = new UserServiceImpl();
         User user  = service.getUser(username);
         user.setSex(sex);
         user.setSign(sign);
         user.setLikes(likes);
         user.setAge(Integer.parseInt(age));
         service.updateUser(user);

         request.setAttribute("tip","用户"+username+"的信息已更新");
         request.getRequestDispatcher("manage.jsp").forward(request,response);
    }
}
