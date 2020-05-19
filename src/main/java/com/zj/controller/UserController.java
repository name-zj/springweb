package com.zj.controller;

import com.github.pagehelper.Page;
import com.zj.entity.Role;
import com.zj.entity.User;
import com.zj.service.IRoleService;
import com.zj.service.IUserRoleService;
import com.zj.service.IUserService;
import com.zj.util.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;
    @Autowired
    private IRoleService roleService;
    @Autowired
    private IUserRoleService iUserRoleService;

    /**
     * 通过用户ID删除用户
     * @param id
     * @param session
     * @return
     */
    @RequestMapping(value = "deleteUserById", method = RequestMethod.GET)
    public ModelAndView deleteUserById(
            @RequestParam("id")int id,
            HttpSession session){
        userService.deleteUserById(id);
        return allUserView("fakeFlag", session);
    }

    @RequestMapping(value = "logicDeleteUserById", method = RequestMethod.GET)
    public ModelAndView logicDeleteUserById(
            @RequestParam("id")int id,
            HttpSession session){
        userService.logicDeleteUserById(id);
        return allUserView("fakeFlag", session);
    }

    /**
     * 分页查找全部用户
     * @param session
     * @return
     */
    @RequestMapping(value = "allUserView", method = RequestMethod.GET)
    public ModelAndView allUserView(
            @RequestParam(value="pageFlag",required = false)String pageFlag,
            HttpSession session){
        session.setAttribute("rolePage","1");
        Page<User> users = null;
        int page = Integer.parseInt(session.getAttribute("page").toString());
        if("previousPage".equals(pageFlag)){
            page = page -1;
        }else if("nextPage".equals(pageFlag)){
            page = page +1;
        }else{
            page = 1;
        }
        users  = userService.findAllUsers(page,3);
        ModelAndView model = new ModelAndView("index");
        PageResult<User> pageResult = new PageResult<>(users);
        if(pageResult.isIsLastPage()){
            page = pageResult.getPages();
        }else if(pageResult.isIsFirstPage()){
            page = 1;
        }
        //遍历查出每个用户对应的角色
//        for(User user : pageResult.getList()){
//            user.setRoleName(roleService.findRoleById(user.getId()).getRolename());
//        }
        session.setAttribute("page",page);
        session.setAttribute("chosedItem", "userManager");
        session.setAttribute("users", pageResult.getList());
        session.setAttribute("content", "userList.ftl");
        return model;
    }

    /**
     * 登录页
     * @return
     */
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView index(){
        ModelAndView model = new ModelAndView("login");
        return model;
    }

    /**
     * 根据用户信息查找用户是否存在
     * @param username
     * @param password
     * @param session
     * @return
     */
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public ModelAndView login(
            @RequestParam(value = "username") String username,
            @RequestParam(value = "password") String password,
            HttpSession session){
        User sendUser = new User();
        sendUser.setPassword(password);
        sendUser.setUsername(username);
        User getUser =userService.findUserByNameAndPwd(sendUser);
        ModelAndView model;
        if(getUser != null){
//            Page<User> users  = userService.findAllUsers(1,3);
//            PageResult<User> pageResult = new PageResult<>(users);
//            session.setAttribute("users", pageResult.getList());
            session.setAttribute("getUser", getUser);

            Role role = roleService.findRoleById(getUser.getId());
            if(role.getIsWrite()==1){
                //如果具有写的权限，则显示操作栏
                session.setAttribute("ifShow","Show");
            }else if(role.getIsRead()==1){
                //如果只具有读的权限，则不显示操作栏
                session.setAttribute("ifShow","ifShow");
            }
            session.setAttribute("page", "1");
//            session.setAttribute("content", "userList.ftl");
            model = allUserView("fakeFlag", session);
        }else{
            model = new ModelAndView("login");
        }
        return model;
    }

    /**
     * 跳转到更新用户信息界面
     * @param id
     * @param session
     * @return
     */
    @RequestMapping(value = "updateUserView", method = RequestMethod.GET)
    public ModelAndView updateUserView(
            @RequestParam int id,
            HttpSession session){
        ModelAndView model = new ModelAndView("index");
        User user = userService.findUserById(id);
        List<Role> roles = new ArrayList<>();
        roles = roleService.findAllRole();
        session.setAttribute("user",user);
        session.setAttribute("roles",roles);
        session.setAttribute("content","user.ftl");
        return model;
    }

    /**
     * 更新用户信息
     * @param id
     * @param password
     * @param username
     * @param session
     * @return
     */
    @RequestMapping(value = "updateUser", method = RequestMethod.POST)
    public ModelAndView updateUser(
            @RequestParam int id,
            @RequestParam String password,
            @RequestParam String username,
            @RequestParam int roleId,
            HttpSession session){
        User user = new User();
        user.setId(id);
        user.setPassword(password);
        user.setUsername(username);
        userService.updateUser(user);
        iUserRoleService.updateRoleIdByUserId(id,roleId);
        return allUserView("fakeFlag", session);
    }

    /**
     * 跳转到添加用户信息界面
     * @param session
     * @return
     */
    @RequestMapping(value = "addUserView", method = RequestMethod.GET)
    public ModelAndView addUserView(HttpSession session){
        ModelAndView model = new ModelAndView("index");
        List<Role> roles = new ArrayList<>();
        roles = roleService.findAllRole();
        session.setAttribute("content","addUser.ftl");
        session.setAttribute("roles",roles);
        return model;
    }

    /**
     * 添加用户信息
     * @param password
     * @param username
     * @param session
     * @return
     */
    @RequestMapping(value = "addUser", method = RequestMethod.POST)
    public ModelAndView addUser(
            @RequestParam("password") String password,
            @RequestParam("username") String username,
            @RequestParam("roleId") int roleId,
            HttpSession session){
        User user = new User();
        user.setPassword(password);
        user.setUsername(username);
        //获取新添加的用户id,并在用户-角色关联表里增加一条相应记录
        int addUserId = userService.addUser(user);
        iUserRoleService.addUserRole(addUserId, roleId);
        return allUserView("fakeFlag", session);
    }


    /**
     * 根据用户id查找用户
     * @param id
     * @param session
     * @return
     */
    @RequestMapping(value = "findUserById", method = RequestMethod.GET)
    public ModelAndView findUserById(@RequestParam("uid") int id, HttpSession session){
        User user = userService.findUserById(id);
        List<User> users = new ArrayList<>();
        users.add(user);
        session.setAttribute("users",users);
        session.setAttribute("content","");
        session.setAttribute("content", "userList.ftl");
        ModelAndView model = new ModelAndView("index");
        return model;
    }

}
