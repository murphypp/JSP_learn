package com.ucar.training.service.impl;

import com.ucar.training.dao.IRoleDao;
import com.ucar.training.entity.Permission;
import com.ucar.training.entity.Role;
import com.ucar.training.entity.RolePermission;
import com.ucar.training.service.IRoleService;
import com.ucar.training.utils.DBUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class RoleServiceImpl implements IRoleService {
    private SqlSession session;
    private IRoleDao roleDao;
    public RoleServiceImpl(){
        session = DBUtil.getSession();
        roleDao = session.getMapper(IRoleDao.class);
    }
    @Override
    public void close(){
        session.close();
    }

    @Override
    public void delRolePermissions(int rid) {
        roleDao.delRolePermissionsById(rid);
        session.commit();
    }

    @Override
    public void addRolePermission(int rid,String[] permissions) {
        int[] mid = new int[permissions.length];
        RolePermission rolePermission = new RolePermission();
        rolePermission.setRid(rid);
        for (int i=0;i<permissions.length;i++){
            mid[i]=Integer.parseInt(permissions[i]);
            rolePermission.setMid(mid[i]);
            roleDao.addRolePermission(rolePermission);
        }
        session.commit();
    }

    @Override
    public Role getRoleById(int rid) {
        return roleDao.getRoleById(rid);
    }

    @Override
    public Role getRoleByUsername(String username) {
        return roleDao.getUserRoleByUsername(username);
    }

    @Override
    public void addRole(Role role) {
        roleDao.addRole(role);
        session.commit();
    }

    @Override
    public void delRole(Role role) {
        roleDao.delRole(role);
        session.commit();
    }

    @Override
    public List<Role> getAllRoles() {
        return roleDao.getAllRoles();
}
}
