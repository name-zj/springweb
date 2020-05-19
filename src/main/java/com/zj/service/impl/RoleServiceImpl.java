package com.zj.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zj.entity.Role;
import com.zj.mapper.IRoleMapper;
import com.zj.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private IRoleMapper roleMapper;

    @Override
    public Page<Role> findAllRoleByPageAndSize(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return roleMapper.findAllRoleByPageAndSize();
    }

    @Override
    public List<Role> findAllRole() {
        return roleMapper.findAllRole();
    }

    @Override
    @Transactional
    public void deleteRoleById(int id) {
        roleMapper.deleteRoleById();
    }

    @Override
    @Transactional
    public void addRole(Role role) {
        roleMapper.addRole(role);
    }

    @Override
    @Transactional
    public void updateRole(Role role) {
        roleMapper.updateRole(role);
    }

    @Override
    public Role findRoleById(int id) {
        return roleMapper.findRoleById(id);
    }
}
