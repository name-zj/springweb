package com.zj.service;

public interface IUserRoleService {

    public void updateRoleIdByUserId(int userId, int roleId);

    public void addUserRole(int userId, int roleId);
}
