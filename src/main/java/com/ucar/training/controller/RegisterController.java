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

    @RequestMapping("/toRegister")
    public String toRegister(HttpServletRequest request){
        List<Role> roles = roleServiceImpl.getAllRoles();
        request.setAttribute("allRole",roles);
        return "forward:register.jsp";
    }

    @RequestMapping("/checkUser")
    public void checkUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        User u = userServiceImpl.getUser(username);
        PrintWriter out= response.getWriter();
        if(u == null){
            out.print("0");
            out.flush();
            return;
        }
        out.print("1");
        out.flush();
    }

    @RequestMapping("/Register")
    public void Register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User();
        String username = request.getParameter("username");
        user.setUsername(username);
        String rid = request.getParameter("rid");
        user.setRid(Integer.parseInt(rid));
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

        userServiceImpl.addUser(user);

        System.out.println("已注册用户数:" + userServiceImpl.getAllUser().size());
        request.setAttribute("tip","注册成功");
        request.getRequestDispatcher( "register.jsp").forward(request,response);
    }
}
