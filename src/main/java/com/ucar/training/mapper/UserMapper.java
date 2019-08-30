package com.ucar.training.mapper;

import com.ucar.training.entity.User;

import java.util.List;

/**
 * @program:training_servlet
 * @description:用户
 * @author:linshaoxiong
 * @create:2019-08-29 14:00
 **/
public interface UserMapper {
    /**
     * 增加用户
     * @param  user
     * @return int
     */
    int addUser(User user);
    /**
     * 删除一个用户
     * @param username
     * @return int
     */
    int deleteUser(String username);
    /**
     * 根据username，返回一个用户
     * @param  username
     * @return User
     */
    User getUserByUsername(String username);
    /**
     * 查询所有用户
     * @return List<User>
     */
    List<User> getAllUser();
    /**
     * 修改用户
     * @param user
     */
    int updateUser(User user);
}
