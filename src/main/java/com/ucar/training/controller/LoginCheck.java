package com.ucar.training.controller;

import com.ucar.training.controller.RegisterServlet;
import com.ucar.training.dao.impl.UserDaoImpl;
import com.ucar.training.entity.Permission;
import com.ucar.training.entity.Role;
import com.ucar.training.entity.User;
import com.ucar.training.services.impl.PermissionService;
import com.ucar.training.services.impl.RoleService;
import com.ucar.training.services.impl.UserService;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program:training_servlet
 * @description:检测登录账号的合法性
 * @author:linshaoxiong
 * @create:2019-08-02 09:24
 **/
public class LoginCheck extends HttpServlet {
    private UserService userService = new UserService();
    private PermissionService permissionService = new PermissionService();
    private RoleService roleService = new RoleService();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        List<User> userList = userService.selectALL();
        User user = userService.selectOne(username);
        //找到用户
        if(user!=null){
            //密码正确
            if(user.getPassword().equals(password)){
                //登录成功，记录session
                HttpSession session = req.getSession();
                session.setAttribute("user",username);
                session.setAttribute("permission",user.isPermission());
                session.setAttribute("nowUser",user);
                System.out.println("已经记录session:"+session.getAttribute("user"));

                //登录成功，记录context
                ServletContext context = req.getServletContext();
                context.setAttribute("userList",userList);
                //记录权限表信息
                List<Permission> permissionList = permissionService.selectAllByUsername(username);
                for(Permission p:permissionList){
                    System.out.println(p.getPermissionName());
                }

                List<Permission> permissionListAll = permissionService.selectAll();
                context.setAttribute("permissionListAll",permissionListAll);
                session.setAttribute("permissionList",permissionList);
                //记录角色表信息
                List<Role> roleListAll = roleService.selectAll();
                context.setAttribute("roleListAll",roleListAll);
                //记录角色-权限信息
                Map<String,List<Permission>> rolePermissionMap = new HashMap<>();
                for(User tmpUser:userList){
                    int roleId = roleService.selectRoleByUsername(tmpUser.getUsername()).getId();
                    List<Permission> tmpPermission = roleService.selectPermissionByRoleId(roleId);
                    rolePermissionMap.put(tmpUser.getUsername(),tmpPermission);
                }
                context.setAttribute("rolePermissionMap",rolePermissionMap);
                //跳转登录成功页面
                req.getRequestDispatcher("transit.jsp").forward(req,resp);
            }else{
                //密码错误
                resp.sendRedirect("login.jsp?message=password_error");
                return;
            }
        }
        resp.sendRedirect("login.jsp?message=login_error");
        return;
        /*
        for(User user:userList){
            if(username.equals(user.getUsername())){
                if (password.equals(user.getPassword())){
                    //登录成功，记录session
                    HttpSession session = req.getSession();
                    session.setAttribute("user",username);
                    session.setAttribute("privileges",user.isPrivileges());
                    session.setAttribute("nowUser",user);
                    System.out.println("已经记录session:"+session.getAttribute("user"));

                    //登录成功，记录context
                    ServletContext context = req.getServletContext();
                    context.setAttribute("userList",userList);
                    System.out.println("已经记录context:"+context.getAttribute("userList"));
                    //跳转登录成功页面
                    //req.setAttribute("userList",userList);
                    req.getRequestDispatcher("transit.jsp").forward(req,resp);
                    //resp.sendRedirect("transit.jsp");
                }else{
                    resp.sendRedirect("login.jsp?message=password_error");
                    return;
                }
            }
        }
        resp.sendRedirect("login.jsp?message=login_error");
        return;*/
    }
}
