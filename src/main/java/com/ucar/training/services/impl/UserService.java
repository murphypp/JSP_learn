package com.ucar.training.services.impl;

import com.ucar.training.dao.IUserDao;
import com.ucar.training.dao.impl.UserDaoImpl;
import com.ucar.training.entity.User;
import com.ucar.training.services.IUserService;

import java.util.List;

/**
 * @program:training_servlet
 * @description:业务层
 * @author:linshaoxiong
 * @create:2019-08-14 11:28
 **/
public class UserService implements IUserService {
    private IUserDao userDao = new UserDaoImpl() ;

    @Override
    public boolean registerUser(User user) {
        User tmpUser = userDao.find(user.getUsername(),user.getPassword());
        if(tmpUser==null){
            userDao.addUser(tmpUser);
            return true;
        }
        else
            return false;
    }

    @Override
    public User loginUser(String username, String password) {
        return userDao.find(username,password);
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
        return userDao.find(username);
    }

    @Override
    public void modify(User user) {
        userDao.modifyUser(user);
    }
}
