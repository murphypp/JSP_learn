package com.ucar.training.service;

import com.ucar.training.entity.Permission;
import com.ucar.training.entity.Role;

import java.util.List;

public interface IRoleService {
    Role getRoleById(int rid);
    Role getRoleByUsername(String username);
    void addRole(Role role);
    void delRole(Role role);
    List<Role> getAllRoles();
    void close();
    void delRolePermissions(int rid);

    void addRolePermission(int rid,String[] permissions);
}
