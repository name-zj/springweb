package com.zj.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zj.entity.User;
import com.zj.mapper.IUserMapper;
import com.zj.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//@Service,表示这是一个服务类的方法，以便被扫描到
@Service
public class UserServiceImpl implements IUserService {
    //@Autowired，自动注入的注解，这个会将mapper里面定义的方法自动注入进来
    @Autowired
    private IUserMapper userMapper;

    public User findUserByNameAndPwd(User user){
        return userMapper.findUserByNameAndPwd(user);
    }

    public Page<User> findAllUsers(Integer pageNum, Integer pageSize) {
        //用插件进行分页
        PageHelper.startPage(pageNum, pageSize);
        return userMapper.findAllUsers();
    }

    public User findUserById(int id){
        return userMapper.findUserById(id);
    }


    //@Transactional，开启事务的标志，这样在执行失败后会自动回滚
    @Transactional
    public void deleteUserById(int id){
        userMapper.deleteUserById(id);
    }

    /**
     * 插入一条用户信息，并返回该用户id
     * @param user
     * @return
     */
    @Transactional
    public int addUser(User user){
        userMapper.addUser(user);
        return userMapper.findLastUser();
    }

    @Transactional
    public void updateUser(User user){
        userMapper.updateUser(user);
    }

    @Transactional
    public void logicDeleteUserById(int id){
        userMapper.logicDeleteUserById(id);
    }

}
