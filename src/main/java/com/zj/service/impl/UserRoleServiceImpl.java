package com.zj.service.impl;

import com.zj.mapper.IUserRoleMapper;
import com.zj.service.IUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserRoleServiceImpl implements IUserRoleService {
    @Autowired
    private IUserRoleMapper userRoleMapper;

    @Override
    @Transactional
    public void updateRoleIdByUserId(int userId, int roleId) {
        userRoleMapper.updateRoleIdByUserId(userId, roleId);
    }

    @Override
    @Transactional
    public void addUserRole(int userId, int roleId) {
        userRoleMapper.addUserRole(userId, roleId);
    }
}
