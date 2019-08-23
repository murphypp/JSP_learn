package com.ucar.training.services.impl;

import com.ucar.training.dao.IRoleDao;
import com.ucar.training.entity.Permission;
import com.ucar.training.entity.Role;
import com.ucar.training.services.IRoleService;
import com.ucar.training.util.DBUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @program:training_servlet
 * @description:角色表服务
 * @author:linshaoxiong
 * @create:2019-08-22 13:49
 **/
public class RoleService implements IRoleService {
    private IRoleDao roleDao;
    private SqlSession sqlSession;
    //创建Mapper对象
    public RoleService(){
        sqlSession = DBUtil.getSession();
        roleDao = sqlSession.getMapper(IRoleDao.class);
    }

    public void after(){
        sqlSession.commit();
        sqlSession.clearCache();
        sqlSession.close();
    }


    @Override
    public List<Permission> selectPermissionByRoleId(int id){
        return roleDao.findPermissionById(id);
    }

    @Override
    public  boolean addRolePermission(int role_id,int per_id,String perName){
        try{
        return  roleDao.addRolePermission(role_id,per_id,perName);
        } finally {
            sqlSession.commit();
        }
    }

    @Override
    public boolean deleteRolePermission(int role_id,int per_id){
        return roleDao.deleteRolePermission(role_id,per_id);
    }



    public Role selectRoleByUsername(String username) {
        return roleDao.findRoleByUsername(username);
    }

    @Override
    public List<Role> selectAll(){
        return roleDao.getAllRole();
    }

    @Override
    public boolean addRole(Role role) {
        try{
            return roleDao.addRole(role);
        }finally {
            sqlSession.commit();
        }
    }

    @Override
    public boolean deleteRole(int id) {
        try {
            roleDao.deleteRole(id);
            sqlSession.commit();
            return true;
        }catch (Exception e){
            return  false;
        }
    }

    @Override
    public boolean modifyRole(Role role) {
        try{
            return roleDao.modifyRole(role);
        }finally {
            sqlSession.commit();
        }
    }
}
