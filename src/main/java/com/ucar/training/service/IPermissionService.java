package com.ucar.training.service;

import com.ucar.training.entity.Permission;

import java.util.List;

public interface IPermissionService {
    void addPermission(Permission permission);
    void delPermission(Permission permission);
    void updatePermission(Permission permission);
    Permission getPermissionById(int id);
    Permission getPermissionByName(String mname);
    List<Permission> getAllPermission();
    void close();
}
