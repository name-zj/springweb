package com.zj.service;

import com.zj.service.IRoleService;
import com.zj.entity.Role;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RoleTests {
    @Autowired
    private IRoleService roleService;

    @Test
    public void testFindAllRole() {
//        List<Role> roles = roleService.findAllRole();
//        for (Role role : roles) {
//            System.out.println(role);
//        }
    }

    @Test
    public void updateUser(){
        Role role = new Role();
        role.setId(1);
        role.setRolename("管理员");
        role.setIsRead(1);
        role.setIsWrite(1);
        roleService.updateRole(role);
    }

    @Test
    void addRole(){
        Role role = new Role();
        role.setRolename("1234");
        role.setIsRead(1);
        role.setIsWrite(1);
        roleService.addRole(role);
    }

}
