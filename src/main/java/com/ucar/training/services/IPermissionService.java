package com.ucar.training.services;

import com.ucar.training.entity.Permission;

import java.util.List;

/**
 * @program:training_servlet
 * @description:提供权限表服务
 * @author:linshaoxiong
 * @create:2019-08-21 16:37
 **/
public interface IPermissionService {

    public Permission getPermisionIdByName(String permissionName);
    public List<Permission> selectAllByUsername(String username);
    public List<Permission> selectAll();
    boolean addPermission(Permission permission);
    boolean deletePermission(int id);
    boolean modifyPermission(Permission permission);

}
