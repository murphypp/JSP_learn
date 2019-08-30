package com.ucar.training.controller;

import com.ucar.training.entity.Permission;
import com.ucar.training.service.IPermissionService;
import com.ucar.training.service.IRoleService;
import com.ucar.training.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
public class ActionController {
    @Resource
    private IUserService userServiceImpl;
    @Resource
    private IRoleService roleServiceImpl;
    @Resource
    private IPermissionService permissionServiceImpl;
    @RequestMapping("/action")
    public String action(String action){
        Permission permission = permissionServiceImpl.getPermissionByName(action);
        if(permission == null){
            return null;
        }
        return "forward:"+permission.getUrl()+".action";
    }


}
