package com.ucar.training.controller;

import com.ucar.training.entity.Permission;
import com.ucar.training.entity.Role;
import com.ucar.training.service.IPermissionService;
import com.ucar.training.service.IRoleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class RoleController {
    @Resource
    private IRoleService roleServiceImpl;
    @Resource
    private IPermissionService permissionServiceImpl;
    @RequestMapping("/delRole")
    public String delRole(String rid,String rname){
        Role role = new Role();
        role.setRid(Integer.parseInt(rid));
        role.setRname(rname);
        roleServiceImpl.delRolePermissions(role.getRid());
        roleServiceImpl.delRole(role);
        return "redirect:roleManage.action";
    }
    @RequestMapping("/toUpdateRole")
    public String toUpdateRole(String rid, HttpServletRequest request){
        Role role =roleServiceImpl.getRoleById(Integer.parseInt(rid));
        request.setAttribute("updatingRole",role);
        request.setAttribute("permissions",permissionServiceImpl.getAllPermission());
        return "forward:/update/updateRole.jsp";
    }
    @RequestMapping("/updatingRole")
    public String updateRole(String rid,String rname,String[] permission){
        Role role = new Role();
        role.setRid(Integer.parseInt(rid));
        role.setRname(rname);

        roleServiceImpl.delRolePermissions(role.getRid());
        roleServiceImpl.addRolePermission(role.getRid(),permission);
        return "redirect:roleManage.action";
    }
    @RequestMapping("/toAddRole")
    public String toAddRole(HttpServletRequest request){
        List<Permission> permissions = permissionServiceImpl.getAllPermission();
        request.setAttribute("permissions",permissions);
        return "forward:/add/addRole.jsp";
    }
    @RequestMapping("/addRole")
    public String addRole(String rid, String rname,String[] permission){
        Role role = new Role();
        role.setRid(Integer.parseInt(rid));
        role.setRname(rname);
        roleServiceImpl.addRole(role);
        roleServiceImpl.addRolePermission(role.getRid(),permission);
        return "redirect:roleManage.action";
    }
    @RequestMapping("/roleManage")
    public String roleManage(HttpServletRequest request){
        List<Role> roles =roleServiceImpl.getAllRoles();
        request.setAttribute("roles",roles);
        return "forward:/manage/roleManage.jsp";
    }
}
