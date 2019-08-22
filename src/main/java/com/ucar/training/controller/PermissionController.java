package com.ucar.training.controller;

import com.ucar.training.entity.Permission;
import com.ucar.training.service.IPermissionService;
import com.ucar.training.service.IRoleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class PermissionController {
    @Resource
    private IPermissionService permissionServiceImpl;
    @Resource
    private IRoleService roleServiceImpl;
    @RequestMapping("/menuManage")
    public String menuManage(HttpServletRequest request){
        List<Permission> permissions = permissionServiceImpl.getAllPermission();
        request.setAttribute("permissions",permissions);

        return "forward:/manage/menuManage.jsp";
    }
    @RequestMapping("/addMenu")
    public String addMenu(String mid, String mname, String uri){
        Permission permission = new Permission();
        permission.setMid(Integer.parseInt(mid));
        permission.setMname(mname);
        permission.setUri(uri);
        permissionServiceImpl.addPermission(permission);
        return "redirect:menuManage.action";
    }
    @RequestMapping("/toUpdateMenu")
    public String toUpdateMenu(String mid, HttpServletRequest request){
        Permission permission = permissionServiceImpl.getPermissionById(Integer.parseInt(mid));
        request.setAttribute("updating",permission);
        return "forward:/update/updateMenu.jsp";
    }
    @RequestMapping("/updatingMenu")
    public String updatingMenu(String mid, String mname, String uri){
        Permission permission = new Permission();
        permission.setMid(Integer.parseInt(mid));
        permission.setMname(mname);
        permission.setUri(uri);
        permissionServiceImpl.updatePermission(permission);
        return "redirect:menuManage.action";
    }
    @RequestMapping("/delMenu")
    public String delMenu(String mid){
        Permission permission = permissionServiceImpl.getPermissionById(Integer.parseInt(mid));
        permissionServiceImpl.delPermission(permission);
        return "redirect:menuManage.action";
    }

}
