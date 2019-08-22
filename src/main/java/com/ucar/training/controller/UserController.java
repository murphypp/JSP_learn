package com.ucar.training.controller;

import com.ucar.training.entity.User;
import com.ucar.training.service.IMessageService;
import com.ucar.training.service.IRoleService;
import com.ucar.training.service.IUserService;
import com.ucar.training.util.UserUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {
    @Resource
    private IUserService userServiceImpl;
    @Resource
    private IMessageService messageServiceImpl;
    @Resource
    private IRoleService roleServiceImpl;
    @RequestMapping("/userManage")
    public String userManage(HttpServletRequest request){
        request.setAttribute("users",userServiceImpl.getAllUser());
        return "forward:/manage/userManage.jsp";
    }
    @RequestMapping("/delUser")
    public String delUser(String deleted, HttpServletRequest request){
        userServiceImpl.deleteUser(deleted);
        messageServiceImpl.delUserMessages(deleted);
        request.setAttribute("tip","删除用户"+ deleted+ "成功！");
        return "forward:userManage.action";
    }
    @RequestMapping("toUpdateUser")
    public String toUpdateUser(String username, HttpServletRequest request){
        request.setAttribute("updatingUser",userServiceImpl.getUser(username));
        request.setAttribute("roles",roleServiceImpl.getAllRoles());
        return "forward:/update/updateUser.jsp";
    }
    @RequestMapping("updateUser")
    public String updateUser(HttpServletRequest request){
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
        return "redirect:userManage.action";
    }
}
