package com.ucar.training.entity;

/**
 * @program:training_servlet
 * @description:权限表
 * @author:linshaoxiong
 * @create:2019-08-21 15:44
 **/
public class Permission {
    private int id;
    private String permissionName;
    private String permissionUrl;

    public Permission(int id, String permissionName, String permissionUrl) {
        this.id = id;
        this.permissionName = permissionName;
        this.permissionUrl = permissionUrl;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public String getPermissionUrl() {
        return permissionUrl;
    }

    public void setPermissionUrl(String permissionUrl) {
        this.permissionUrl = permissionUrl;
    }
}
