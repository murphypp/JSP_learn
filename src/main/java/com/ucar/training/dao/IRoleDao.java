package com.ucar.training.dao;

import com.ucar.training.entity.Permission;
import com.ucar.training.entity.Role;

import java.util.List;

/**
 * @program:training_servlet
 * @description:角色表Dao层
 * @author:linshaoxiong
 * @create:2019-08-21 15:48
 **/
public interface  IRoleDao {
    /**
     * 根据用户名来查找角色
     * @param username
     * @return Permission
     */
    Role findRoleByUsername(String username);

    /**
     * 根据角色id返回所有权限
     * @param id
     * @return Permission
     */
     List<Permission> findPermissionById(int id);

    /**
     * 返回所有角色
     * @return List
     */
    List<Role> getAllRole();

    /**
     * 添加角色
     * @param role
     * @return true/false
     */
    boolean addRole(Role role);

    boolean addRolePermission(int role_id,int per_id,String perName);

    boolean deleteRolePermission(int role_id,int per_id);

    /**
     * 删除角色
     * @param id
     * @return true/false
     */
    boolean deleteRole(int id);

    /**
     * 修改角色
     * @param
     * @return true/false
     */
    boolean modifyRole(Role role);

}
