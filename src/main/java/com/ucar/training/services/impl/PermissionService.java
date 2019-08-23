package com.ucar.training.services.impl;

import com.ucar.training.dao.IPermissionDao;
import com.ucar.training.dao.IUserDao;
import com.ucar.training.entity.Permission;
import com.ucar.training.entity.User;
import com.ucar.training.services.IPermissionService;
import com.ucar.training.util.DBUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @program:training_servlet
 * @description:提供权限表服务
 * @author:linshaoxiong
 * @create:2019-08-21 16:37
 **/
public class PermissionService implements IPermissionService {
    private IPermissionDao permissionDao ;
    private SqlSession sqlSession;
    //创建Mapper对象
    public PermissionService(){
        sqlSession = DBUtil.getSession();
        permissionDao = sqlSession.getMapper(IPermissionDao.class);
    }

    public void after(){
        sqlSession.commit();
        sqlSession.clearCache();
        sqlSession.close();
    }

    public Permission getPermisionIdByName(String permissionName){
        return permissionDao.getPermissionIdByName(permissionName);
    }


    public List<Permission> selectAllByUsername(String username) {
        return permissionDao.findPermissionByUsername(username);
    }

    @Override
    public List<Permission> selectAll(){
        return permissionDao.getAllPermission();
    }

    @Override
    public boolean addPermission(Permission permission) {
        try{
            return permissionDao.addPermission(permission);
        }finally {
            sqlSession.commit();
        }
    }

    @Override
    public boolean deletePermission(int id) {
        try {
            permissionDao.deletePermission(id);
            sqlSession.commit();
            return true;
        }catch (Exception e){
            return  false;
        }
    }

    @Override
    public boolean modifyPermission(Permission permission) {
       try{
           return permissionDao.modifyPermission(permission);
       }finally {
           sqlSession.commit();
       }
    }


}
