package com.ucar.training.controller;

import com.ucar.training.entity.User;
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
    private IRoleService roleServiceImpl;

    @RequestMapping("/userManage")
    public String userManage(HttpServletRequest request){
        request.setAttribute("userList",userServiceImpl.getAllUser());
        return "forward:/manage/userManage.jsp";
    }

    @RequestMapping("/deleteUser")
    public String deleteUser(HttpServletRequest request){
        String deleted = request.getParameter("username");
        userServiceImpl.deleteUser(deleted);
        return "redirect:/userManage.action";
    }
    @RequestMapping("toUpdateUser")
    public String toUpdateUser(HttpServletRequest request){
        String username = request.getParameter("username");
        request.setAttribute("updatingUser",userServiceImpl.getUserByUsername(username));
        return "forward:/update/updateUser.jsp";
    }
    @RequestMapping("updateUser")
    public String updateUser(HttpServletRequest request){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email    = request.getParameter("email");
        String realname = request.getParameter("realname");
        String phone    = request.getParameter("phone");
        String age      = request.getParameter("age");
        String sex      = request.getParameter("sex");
        String[] hobbyList = request.getParameterValues("hobby");
        String sign = request.getParameter("sign");
        int rid =Integer.parseInt(request.getParameter("rid")) ;
        String hobby="";
        for(String str:hobbyList){
            hobby=hobby+","+str;
        }
        hobby=hobby.replaceFirst(",","");
        User tmpUser = new User(username,password,email,realname,Integer.parseInt(age),sex,phone,hobby,sign,rid);
        userServiceImpl.updateUser(tmpUser);
        return "redirect:userManage.action";
    }
}
