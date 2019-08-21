package com.ucar.training.dao;

import com.ucar.training.entity.Permission;

import java.util.List;

public interface IPermissionDao {
    int addPermission(Permission permission);
    int delPermission(Permission permission);
    int updatePermission(Permission permission);
    Permission getPermissionById(int id);
    Permission getPermissionByName(String mname);
    List<Permission> getAllPermission();
}
