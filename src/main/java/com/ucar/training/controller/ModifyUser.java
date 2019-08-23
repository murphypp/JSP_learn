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
import java.io.IOException;
import java.util.List;

/**
 * @program:training_servlet
 * @description:修改用户信息
 * @author:linshaoxiong
 * @create:2019-08-07 13:52
 **/
public class ModifyUser extends HttpServlet {
    private UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password1");
        String email    = request.getParameter("email");
        String realname = request.getParameter("realname");
        String phone    = request.getParameter("phone");
        String age      = request.getParameter("age");
        String sex      = request.getParameter("sex");
        String permission = request.getParameter("permission");
        String[] hobbyList = request.getParameterValues("hobby");
        String sign = request.getParameter("sign");
        int roleId =Integer.parseInt(request.getParameter("roleId")) ;
        String hobby="";
        for(String str:hobbyList){
            hobby=hobby+","+str;
        }
        hobby=hobby.replaceFirst(",","");
        User tmpUser = new User(username,password,email,realname,Integer.parseInt(age),sex,phone,permission,hobby,sign,roleId);
        if(userService.modifyUser(tmpUser)){
            List<User> userList = userService.selectALL();
            ServletContext context = request.getServletContext();
            context.setAttribute("userList",userList);
            System.out.println("修改成功，执行跳转");
            String message = "修改成功！";
            request.setAttribute("message",message);
            request.getRequestDispatcher("/userinfo.jsp").forward(request,response);
        }

       /* List<User> userList = RegisterServlet.getUserList();
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
        }*/

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
