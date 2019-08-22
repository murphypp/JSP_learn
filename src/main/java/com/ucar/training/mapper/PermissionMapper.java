package com.ucar.training.mapper;

import com.ucar.training.entity.Permission;

import java.util.List;

public interface PermissionMapper {
    int addPermission(Permission permission);
    int delPermission(Permission permission);
    int updatePermission(Permission permission);
    Permission getPermissionById(int id);
    Permission getPermissionByName(String mname);
    List<Permission> getAllPermission();
}
