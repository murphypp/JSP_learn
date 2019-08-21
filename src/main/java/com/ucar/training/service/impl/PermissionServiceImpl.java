package com.ucar.training.service.impl;

import com.ucar.training.dao.IPermissionDao;
import com.ucar.training.entity.Permission;
import com.ucar.training.service.IPermissionService;
import com.ucar.training.utils.DBUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class PermissionServiceImpl implements IPermissionService {
    private SqlSession session;
    private IPermissionDao permissionDao;
    public PermissionServiceImpl(){
        session = DBUtil.getSession();
        permissionDao = session.getMapper(IPermissionDao.class);
    }
    @Override
    public void close(){
        session.commit();
        session.close();
    }
    @Override
    public void addPermission(Permission permission) {
        permissionDao.addPermission(permission);
    }

    @Override
    public void delPermission(Permission permission) {
        permissionDao.delPermission(permission);
    }

    @Override
    public void updatePermission(Permission permission) {
        permissionDao.updatePermission(permission);
    }

    @Override
    public Permission getPermissionById(int id) {
        return permissionDao.getPermissionById(id);
    }

    @Override
    public Permission getPermissionByName(String mname) {
        return permissionDao.getPermissionByName(mname);
    }

    @Override
    public List<Permission> getAllPermission() {
        return permissionDao.getAllPermission();
    }
}
