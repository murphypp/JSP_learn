package com.ucar.training.service.impl;

import com.ucar.training.entity.Permission;
import com.ucar.training.mapper.PermissionMapper;
import com.ucar.training.service.IPermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PermissionServiceimpl implements IPermissionService {
    @Resource
    private PermissionMapper permissionMapper;
    @Override
    public void addPermission(Permission permission) {
        permissionMapper.addPermission(permission);
    }

    @Override
    public void delPermission(Permission permission) {
        permissionMapper.delPermission(permission);
    }

    @Override
    public void updatePermission(Permission permission) {
        permissionMapper.updatePermission(permission);
    }

    @Override
    public Permission getPermissionById(int id) {
        return permissionMapper.getPermissionById(id);
    }

    @Override
    public Permission getPermissionByName(String mname) {
        return permissionMapper.getPermissionByName(mname);
    }

    @Override
    public List<Permission> getAllPermission() {
        return permissionMapper.getAllPermission();
    }

    @Override
    public void close() {

    }
}
