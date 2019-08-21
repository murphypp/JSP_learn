package com.ucar.training.dao;

import com.ucar.training.entity.Permission;
import com.ucar.training.entity.Role;
import com.ucar.training.entity.RolePermission;

import java.util.List;

public interface IRoleDao {
    /*
    通过用户名查找其对应的角色
     */
    Role getUserRoleByUsername(String username);
    /*
    添加角色
     */
    int addRole(Role role);
    /*
    删除角色
     */
    int delRole(Role role);
    /*
    查询全部角色
     */
    List<Role> getAllRoles();

    Role getRoleById(int rid);

    int delRolePermissionsById(int rid);

    int addRolePermission(RolePermission rolePermission);
}
