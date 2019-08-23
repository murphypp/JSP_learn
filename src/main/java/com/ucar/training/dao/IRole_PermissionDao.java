package com.ucar.training.dao;

import com.ucar.training.entity.Role_Permission;

/**
 * @program:training_servlet
 * @description:角色-权限表Dao
 * @author:linshaoxiong
 * @create:2019-08-23 09:09
 **/
public interface IRole_PermissionDao {
    String[] findPermissionNameByRoleId(int id);
    int[]    findPermissionIdByRoleId(int id);
    boolean modifyRolePermission(Role_Permission role_permission);
    public boolean addRecord(int roleId,int perId,String permissionName);

}
