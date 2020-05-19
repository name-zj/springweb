package com.zj.service;

import com.github.pagehelper.Page;
import com.zj.entity.Role;

import java.util.List;

public interface IRoleService {
    public Page<Role> findAllRoleByPageAndSize(Integer pageNum, Integer pageSize);
    public List<Role> findAllRole();
    public void deleteRoleById(int id);
    public void addRole(Role role);
    public void updateRole(Role role);
    public Role findRoleById(int id);
}
