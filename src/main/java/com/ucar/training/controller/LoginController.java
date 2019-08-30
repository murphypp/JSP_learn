package com.ucar.training.controller;

import com.ucar.training.entity.Permission;
import com.ucar.training.entity.Role;
import com.ucar.training.entity.User;
import com.ucar.training.service.IRoleService;
import com.ucar.training.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @program:training_servlet
 * @description:用户登录控制台
 * @author:linshaoxiong
 * @create:2019-08-29 10:30
 **/
@Controller
public class LoginController {
    @Resource
    private IUserService userService;
    @Resource
    private IRoleService roleService;

    @RequestMapping("/login")
    public String loginCheck(String username, String password, HttpSession session, HttpServletRequest request){
        User user = userService.getUserByUsername(username);
        if(user!=null&&user.getPassword().equals(password)){
            //登录成功
            System.out.println(username+" "+password+"登录成功！");
            session.setAttribute("currentUser",user);
            return "redirect:roleCheck.action";
        }else{
            System.out.println(username+" "+password+"登录失败！");
            request.setAttribute("message","用户名或者密码错误！");
            return  "forward:login.jsp";
        }
    }

    @RequestMapping("/roleCheck")
    public String roleCheck(HttpSession session,HttpServletRequest request){
        User user =(User)session.getAttribute("currentUser");
        Role role =roleService.getRoleByUsername(user.getUsername());
        List<Permission> permissionList= role.getPermissions();
        session.setAttribute("currentPermission",permissionList);
        session.setAttribute("currentRole",role);
        return "forward:transit.jsp";
    }
}
