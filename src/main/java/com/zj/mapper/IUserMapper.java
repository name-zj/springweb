package com.zj.mapper;


import com.github.pagehelper.Page;
import com.zj.entity.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;


public interface IUserMapper {

    @Select("select * " +
            "from user " +
            "where username=#{username} and password=#{password} and isDelete=0")
    public User findUserByNameAndPwd(User user);

    @Select("select u.id,u.username,u.password,r.rolename " +
            "from user u,role r,user_role ur " +
            "where u.isDelete=0 and r.id=ur.roleId and ur.userId=u.id " +
            "order by u.id")
    public Page<User> findAllUsers();

    @Select("select u.username,u.password,u.id,r.rolename " +
            "from user u,role r,user_role ur " +
            "where u.id=ur.userId and r.id=ur.roleId and u.id=#{id}")
    public User findUserById(int id);

    @Delete("delete from user " +
            "where id=#{id}")
    public void deleteUserById(int id);

    @Update("update user " +
            "set isDelete=1 " +
            "where id=#{id}")
    public void logicDeleteUserById(int id);

    @Insert("insert into user (username,password,isDelete) " +
            "values (#{username},#{password},0)")
    public void addUser(User user);

    @Update("update user " +
            "set username=#{username}, password=#{password} " +
            "where id=#{id}")
    public void updateUser(User user);

    @Select("select id " +
            "from user " +
            "order by id DESC limit 1")
    public int findLastUser();
}
