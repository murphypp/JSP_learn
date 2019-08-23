package com.ucar.training.services.impl;

import com.ucar.training.dao.IUserDao;
import com.ucar.training.dao.impl.UserDaoImpl;
import com.ucar.training.entity.User;
import com.ucar.training.services.IUserService;
import com.ucar.training.util.DBUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @program:training_servlet
 * @description:业务层
 * @author:linshaoxiong
 * @create:2019-08-14 11:28
 **/
public class UserService implements IUserService {
    private IUserDao userDao ;
    private SqlSession sqlSession;
    //创建Mapper对象
    public UserService(){
        sqlSession = DBUtil.getSession();
        userDao = sqlSession.getMapper(IUserDao.class);
    }

    public void after(){
        sqlSession.commit();
        sqlSession.clearCache();
        sqlSession.close();
    }

    @Override
    public boolean registerUser(User user) {
            return userDao.addUser(user);
    }

    @Override
    public User loginUser(String username, String password) {
            return userDao.findUserByPassword(username,password);
    }

    @Override
    public List<User> selectALL() {
        return userDao.getAllUser();
    }

    @Override
    public boolean deleteUser(String username) {
        try{
            if(userDao.deleteUser(username))
                return true;
            else
                return false;

        }finally {
            sqlSession.commit();
        }
        }


    @Override
    public User selectOne(String username) {
        return userDao.findUserByUsername(username);
    }

    @Override
    public boolean modifyUser(User user) {
        try{
            return userDao.modifyUser(user);
        }finally {
            sqlSession.commit();
        }
    }


    /*
    @Override
    public boolean registerUser(User user) {
        User tmpUser = userDao.findUserByPassword(user.getUsername(),user.getPassword());
        if(tmpUser==null){
            userDao.addUser(tmpUser);
            return true;
        }
        else
            return false;
    }

    @Override
    public User loginUser(String username, String password) {
        return userDao.findUserByPassword(username,password);
    }

    @Override
    public List<User> selectALL() {
        return userDao.getAllUser();
    }

    @Override
    public boolean deleteUser(String username) {
        if(userDao.deleteUser(username))
            return true;
        else
            return false;
    }

    @Override
    public User selectOne(String username) {
        return userDao.findUserByUsername(username);
    }

    @Override
    public void modify(User user) {
        userDao.modifyUser(user);
    }*/
}
