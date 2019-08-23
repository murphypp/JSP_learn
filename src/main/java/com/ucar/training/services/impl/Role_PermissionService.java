package com.ucar.training.services.impl;

import com.ucar.training.dao.IPermissionDao;
import com.ucar.training.dao.IRole_PermissionDao;
import com.ucar.training.entity.Role_Permission;
import com.ucar.training.services.IRole_PermissionService;
import com.ucar.training.util.DBUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @program:training_servlet
 * @description:角色-权限服务
 * @author:linshaoxiong
 * @create:2019-08-23 09:22
 **/
public class Role_PermissionService implements IRole_PermissionService {
    private IRole_PermissionDao role_permissionDao;
    private SqlSession sqlSession;

    //创建Mapper对象
    public Role_PermissionService(){
        sqlSession = DBUtil.getSession();
        role_permissionDao = sqlSession.getMapper(IRole_PermissionDao.class);
    }

    public void after(){
        sqlSession.commit();
        sqlSession.clearCache();
        sqlSession.close();
    }

    @Override
    public boolean modifyRolePermission(Role_Permission role_permission) {
        try{
            int roleId  = role_permission.getRoleId();
            int[] perIdList = role_permission.getPermissionId();
            String [] perStringName = role_permission.getPermissionName();
            for(int i=0;i<perIdList.length;i++){
                role_permissionDao.addRecord(roleId,perIdList[i],perStringName[i]);
            }
            return true;
        }finally {
            sqlSession.commit();
        }
    }

    @Override
    public String[] findPermissionNameByRoleId(int id) {
        return role_permissionDao.findPermissionNameByRoleId(id);
    }

    @Override
    public int[] findPermissionIdByRoleId(int id) {
        return role_permissionDao.findPermissionIdByRoleId(id);
    }
}
