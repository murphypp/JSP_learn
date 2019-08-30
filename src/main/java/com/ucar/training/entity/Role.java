package com.ucar.training.entity;

import java.util.List;

public class Role {
    private int rid;
    private String rname;
    private List<Permission> permissionList;


    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    public List<Permission> getPermissions() {
        return permissionList;
    }

    public void setPermissions(List<Permission> permissionList) {
        this.permissionList = permissionList;
    }
}
