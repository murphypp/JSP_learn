package com.ucar.training.service.impl;



import com.ucar.training.dao.IUserDao;
import com.ucar.training.entity.User;
import com.ucar.training.service.IUserService;
import com.ucar.training.utils.DBUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.Set;

public class UserServiceImpl implements IUserService {
    private SqlSession session;
    private IUserDao userDao;
    public UserServiceImpl(){
        session = DBUtil.getSession();
        userDao = session.getMapper(IUserDao.class);
    }
    public void after(){
        session.commit();
        session.clearCache();
        session.close();
    }
    @Override
    public void addUser(User u) {
        userDao.addUser(u);
    }

    @Override
    public void deleteUser(String username) {
        userDao.delUser(username);
    }

    @Override
    public void updateUser(User u) {
        userDao.updateUser(u);
    }

    @Override
    public Set<User> getAllUser() {
        return userDao.getAllUser();

    }

    @Override
    public User getUser(String username) {
        return userDao.findUserByUsername(username);
    }

    @Override
    public int getPass(String username, String password) {
        User u = getUser(username);
        if(u !=null && u.getUsername().equals(username)){
            if(u.getPassword().equals(password)){
                if(u.getAuthority().equals("admin")){
                    return 2;
                }
                return 1;
            }
        }
        return 0;
    }
    /*
    private static UserDaoImpl iUser = new UserDaoImpl();

    @Override
    public void addUser(User u) {
        iUser.addUser(u);
    }

    @Override
    public void deleteUser(String username) {
        for (User u: iUser.getAllUser()
        ) {
            if (username.equals(u.getUsername())){
                iUser.delUser(username);
                break;
            }
        }
    }

    @Override
    public void updateUser( User u) {
        iUser.updateUser(u);
    }

    @Override
    public Set<User> getAllUser() {
        return iUser.getAllUser();
    }

    @Override
    public User getUser(String username) {
        return iUser.findUserByUsername(username);
    }

    @Override
    public int getPass(String username, String password) {
        User u = getUser(username);
        if(u !=null && u.getUsername().equals(username)){
            if(u.getPassword().equals(password)){
                if(u.getAuthority().equals("admin")){
                    return 2;
                }
                return 1;
            }
        }
        return 0;
    }
    */

}
