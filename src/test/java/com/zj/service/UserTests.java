package com.zj.service;


import com.zj.service.IUserService;
import com.zj.entity.User;
import com.zj.util.PageResult;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@EnableTransactionManagement
class UserTests {
	@Autowired
	private IUserService userService;

	@Test
	public void findUserByNameAndPwd() {
		User user = new User();
		user.setUsername("123");
		user.setPassword("123");
		User user2 = userService.findUserByNameAndPwd(user);
		System.out.println(user2.getUsername());
	}

	@Test
	public void deleteUserById(){
		int id = 22;
		userService.deleteUserById(id);
	}

	@Test
	public void updateUser(){
		User user = new User();
		user.setId(1);
		user.setUsername("123");
		user.setPassword("123");
		userService.updateUser(user);
	}

	@Test
	public void findAllUsers(){
		List<User> users = new ArrayList<>();
		users = userService.findAllUsers(1,3);
		PageResult<User> pageResult = new PageResult<>(users);
		for(User user : pageResult.getList()){
			System.out.println(user);
		}
	}

	@Test
	public void addUser(){
		User user = new User();
		user.setUsername("123");
		user.setPassword("123");
		userService.addUser(user);
	}
}
