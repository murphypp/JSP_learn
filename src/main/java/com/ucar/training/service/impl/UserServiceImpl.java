package com.ucar.training.service.impl;

import com.ucar.training.dao.IUserDao;
import com.ucar.training.entity.User;
import com.ucar.training.mapper.UserMapper;
import com.ucar.training.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program:training_servlet
 * @description:业务层
 * @author:linshaoxiong
 * @create:2019-08-14 11:28
 **/

@Service
public class UserServiceImpl implements IUserService {

    @Resource
    private UserMapper userMapper;


    @Override
    public void addUser(User user) {
        userMapper.addUser(user);
    }

    @Override
    public void deleteUser(String username) {
        userMapper.deleteUser(username);
    }

    @Override
    public User getUserByUsername(String username) {
        return userMapper.getUserByUsername(username);
    }



    @Override
    public List<User> getAllUser() {
        return  userMapper.getAllUser();
    }

    @Override
    public void updateUser(User user) {
        userMapper.updateUser(user);
    }

    /*private IUserDao userMapper ;
    private SqlSession sqlSession;
    //创建Mapper对象
    public UserService(){
        sqlSession = DBUtil.getSession();
        userMapper = sqlSession.getMapper(IUserDao.class);
    }

    public void after(){
        sqlSession.commit();
        sqlSession.clearCache();
        sqlSession.close();
    }

    @Override
    public boolean registerUser(User user) {
            return userMapper.addUser(user);
    }

    @Override
    public User loginUser(String username, String password) {
            return userMapper.findUserByPassword(username,password);
    }

    @Override
    public List<User> selectAll() {
        return userMapper.getAllUser();
    }

    @Override
    public boolean deleteUser(String username) {
        try{
            if(userMapper.deleteUser(username))
                return true;
            else
                return false;

        }finally {
            sqlSession.commit();
        }
        }


    @Override
    public User selectOne(String username) {
        return userMapper.findUserByUsername(username);
    }

    @Override
    public boolean updateUser(User user) {
        try{
            return userMapper.updateUser(user);
        }finally {
            sqlSession.commit();
        }
    }
*/

    /*
    @Override
    public boolean registerUser(User user) {
        User tmpUser = userMapper.findUserByPassword(user.getUsername(),user.getPassword());
        if(tmpUser==null){
            userMapper.addUser(tmpUser);
            return true;
        }
        else
            return false;
    }

    @Override
    public User loginUser(String username, String password) {
        return userMapper.findUserByPassword(username,password);
    }

    @Override
    public List<User> selectAll() {
        return userMapper.getAllUser();
    }

    @Override
    public boolean deleteUser(String username) {
        if(userMapper.deleteUser(username))
            return true;
        else
            return false;
    }

    @Override
    public User selectOne(String username) {
        return userMapper.findUserByUsername(username);
    }

    @Override
    public void update(User user) {
        userMapper.updateUser(user);
    }*/
}
