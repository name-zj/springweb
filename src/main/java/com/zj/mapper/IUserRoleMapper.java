package com.zj.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;

public interface IUserRoleMapper {

    @Update("update user_role " +
            "set roleId=#{roleId} " +
            "where userId=#{userId}")
    public void updateRoleIdByUserId(int userId, int roleId);

    @Insert("insert into user_role(userId,roleId) " +
            "values(#{userId},#{roleId})")
    public void addUserRole(int userId, int roleId);
}
