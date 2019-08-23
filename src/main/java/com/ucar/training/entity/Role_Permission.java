package com.ucar.training.entity;

/**
 * @program:training_servlet
 * @description:角色-权限表
 * @author:linshaoxiong
 * @create:2019-08-22 13:55
 **/
public class Role_Permission {
    private int roleId;
    private int[] permissionId;
    private String[] PermissionName;

    public String[] getPermissionName() {
        return PermissionName;
    }

    public void setPermissionName(String[] permissionName) {
        PermissionName = permissionName;
    }



    public int[] getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(int[] permissionId) {
        this.permissionId = permissionId;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

}
