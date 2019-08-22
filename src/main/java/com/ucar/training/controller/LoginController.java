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

@Controller
public class LoginController {
    @Resource
    private IUserService userServiceImpl;
    @Resource
    private IRoleService roleServiceImpl;
    @RequestMapping("/login")
    public String doLogin(String username, String password, HttpSession session, HttpServletRequest request){
        int flag = userServiceImpl.getPass(username,password);
        if (flag == 1) {
            session.setAttribute("current", userServiceImpl.getUser(username));
            return "redirect:/checkRole.action";
        }
        else {
            System.out.println("登录失败：用户名或密码错误" + username);
            request.setAttribute("warn","用户名或密码错误");
            return "forward:login.jsp";
        }
    }
    @RequestMapping("/checkRole")
    public String checkRole(HttpSession session, HttpServletRequest request){
        User user = (User) session.getAttribute("current");
        if(user == null)return "redirect:login.jsp";
        Role role = roleServiceImpl.getRoleByUsername(user.getUsername());
        List<Permission> permissions = role.getPermissions();
        session.setAttribute("currentRole",role);
        return "forward:user.jsp";
    }
}
