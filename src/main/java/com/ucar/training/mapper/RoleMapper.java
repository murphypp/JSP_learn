package com.ucar.training.mapper;

import com.ucar.training.entity.Role;

import java.util.List;

public interface RoleMapper {
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

    int addRolePermission(int rid, int mid);
}
