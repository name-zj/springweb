package com.zj.mapper;

import com.github.pagehelper.Page;
import com.zj.entity.Role;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface IRoleMapper {

    @Select("select * " +
            "from role " +
            "order by id")
    public Page<Role> findAllRoleByPageAndSize();

    @Select("select * " +
            "from role")
    public List<Role> findAllRole();

    @Delete("delete from user " +
            "where id=#{id}")
    public void deleteRoleById();

    @Update("update role " +
            "set rolename=#{rolename},isRead=#{isRead},isWrite=#{isWrite} " +
            "where id=#{id}")
    public void updateRole(Role role);

    @Insert("insert into role(isRead,isWrite,rolename) " +
            "values(#{isRead},#{isWrite},#{rolename})")
    public void addRole(Role role);

    @Select("select * " +
            "from role " +
            "where id=(select roleId from user_role where userId=#{id})")
    public Role findRoleById(int id);
}
