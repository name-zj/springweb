package com.zj.service;

import com.github.pagehelper.Page;
import com.zj.entity.User;

public interface IUserService {
    public User findUserByNameAndPwd(User user);

    public Page<User> findAllUsers(Integer pageNum, Integer pageSize);

    public User findUserById(int id);

    public void deleteUserById(int id);

    public int addUser(User user);

    public void updateUser(User user);

    public void logicDeleteUserById(int id);
}
