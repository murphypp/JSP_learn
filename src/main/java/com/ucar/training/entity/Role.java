package com.ucar.training.entity;

/**
 * @program:training_servlet
 * @description:角色表
 * @author:linshaoxiong
 * @create:2019-08-21 15:44
 **/
public class Role {
    private  int id;
    private  String  roleName;
    private  String  rolePs;

    public Role(int id, String roleName, String rolePs) {
        this.id = id;
        this.roleName = roleName;
        this.rolePs = rolePs;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public void setRolePs(String rolePs) {
        this.rolePs = rolePs;
    }

    public int getId() {
        return id;
    }

    public String getRoleName() {
        return roleName;
    }

    public String getrolePs() {
        return rolePs;
    }


}
