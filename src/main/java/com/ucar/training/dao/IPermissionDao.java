package com.ucar.training.dao;

import com.ucar.training.entity.Permission;
import com.ucar.training.entity.User;

import java.util.List;

/**
 * @program:training_servlet
 * @description:权限表Dao层
 * @author:linshaoxiong
 * @create:2019-08-21 15:48
 **/
public interface IPermissionDao {

    /**
     * 根据用户名来查找权限
     * @param username
     * @return Permission
     */
    List<Permission> findPermissionByUsername(String username);

    List<Permission> getAllPermission();

    Permission getPermissionIdByName(String permissionName);



    /**
     * 添加权限
     * @param permission
     * @return true/false
     */
    boolean addPermission(Permission permission);

    /**
     * 删除权限
     * @param id
     * @return true/false
     */
    boolean deletePermission(int id);

    /**
     * 修改权限
     * @param
     * @return true/false
     */
    boolean modifyPermission(Permission permission);


}
