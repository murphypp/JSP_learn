package com.ucar.training.services;

import com.ucar.training.entity.Role_Permission;

/**
 * @program:training_servlet
 * @description:角色-权限服务
 * @author:linshaoxiong
 * @create:2019-08-23 09:20
 **/
public interface IRole_PermissionService {

    public boolean modifyRolePermission(Role_Permission role_permission);
    public String[] findPermissionNameByRoleId(int id);
    public int[]    findPermissionIdByRoleId(int id);
}
