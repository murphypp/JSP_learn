package com.ucar.training.controller;

import com.ucar.training.entity.Role;
import com.ucar.training.entity.User;
import com.ucar.training.service.IRoleService;
import com.ucar.training.service.IUserService;
import com.ucar.training.util.UserUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@Controller
public class RegisterController {
    @Resource
    private IUserService userServiceImpl;
    @Resource
    private IRoleService roleServiceImpl;

    @RequestMapping("/Register")
    public void Register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password1");
        String email    = request.getParameter("email");
        String realname = request.getParameter("realname");
        String phone    = request.getParameter("phone");
        String age      = request.getParameter("age");
        String sex      = request.getParameter("sex");
        String[] hobbyList = request.getParameterValues("hobby");
        String sign = request.getParameter("sign");
        String hobby="";
        for(String str:hobbyList){
            hobby=hobby+","+str;
        }
        hobby=hobby.replaceFirst(",","");
        User user = new User(username,password,email,realname,Integer.parseInt(age),sex,phone,hobby,sign);
        userServiceImpl.addUser(user);
        request.setAttribute("message","注册成功!");
        request.getRequestDispatcher( "login.jsp").forward(request,response);
    }
}
