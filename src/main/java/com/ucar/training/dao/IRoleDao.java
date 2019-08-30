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
     * 添加角色
     * @param role
     * @return true/false
     */
    void addRole(Role role);
    /**
     * 删除角色
     * @param id
     * @return true/false
     */
    void deleteRole(int id);
    /**
     * 修改角色
     * @param
     * @return true/false
     */
    void updateRole(Role role);
    /**
     * 根据用户名来查找角色
     * @param username
     * @return Permission
     */
    Role getRoleByUsername(String username);
    /**
     * 根据角色id返回所有权限
     * @param id
     * @return Permission
     */
    List<Permission> getPermissionByRoleId(int id);
    /**
     * 返回所有角色
     * @return List
     */
    List<Role> getAllRole();
    /**
     * 增加角色的某个权限
     */
    void addRolePermission(int role_id,int per_id,String perName);
    /**
     * 删除角色的某个权限
     */
    void deleteRolePermission(int role_id,int per_id);

}
