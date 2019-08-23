package com.ucar.training.services;

import com.ucar.training.entity.Permission;
import com.ucar.training.entity.Role;

import java.util.List;

/**
 * @program:training_servlet
 * @description:角色表服务
 * @author:linshaoxiong
 * @create:2019-08-22 13:47
 **/
public interface IRoleService {

    public List<Permission> selectPermissionByRoleId(int id);
    public Role selectRoleByUsername(String username);
    public List<Role> selectAll();
    public  boolean addRole(Role role);
    public boolean deleteRole(int id);
    public boolean modifyRole(Role role);
    public boolean addRolePermission(int role_id,int per_id,String perName);
    public boolean deleteRolePermission(int role_id,int per_id);


}
