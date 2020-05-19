package com.zj.controller;

import com.github.pagehelper.Page;
import com.zj.entity.Role;
import com.zj.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private IRoleService roleService;

    /**
     * 查找全部角色
     * @param pageRoleFlag
     * @param session
     * @return
     */
    @RequestMapping(value = "findAllRoleByPageAndSize", method = RequestMethod.GET)
    public ModelAndView findAllRoleByPageAndSize(
            @RequestParam(value = "pageRoleFlag", required = false) String pageRoleFlag,
            HttpSession session){
        Page<Role> roles = null;
        int rolePage = Integer.parseInt(session.getAttribute("rolePage").toString());
        if("previousRolePage".equals(pageRoleFlag)){
            rolePage = rolePage -1;
        }else if("nextRolePage".equals(pageRoleFlag)){
            rolePage = rolePage +1;
        }else{
            rolePage = 1;
        }
        roles = roleService.findAllRoleByPageAndSize(rolePage,2);
        session.setAttribute("roles", roles);
        session.setAttribute("chosedItem", "roleManager ");
        session.setAttribute("content", "roleList.ftl");
        ModelAndView model = new ModelAndView("index");
        return model;
    }

    /**
     * 根据id删除角色
     * @param id
     * @param session
     * @return
     */
    @RequestMapping(value = "deleteRoleById", method = RequestMethod.GET)
    public ModelAndView deleteRoleById(
            @RequestParam int id,
            HttpSession session){
        roleService.deleteRoleById(id);
        return findAllRoleByPageAndSize("fakeFlag",session);
    }

    /**
     * 跳转到更新角色信息界面
     * @param id
     * @param session
     * @return
     */
    @RequestMapping(value = "updateRoleView", method = RequestMethod.GET)
    public ModelAndView updateRoleView(
            @RequestParam int id,
            HttpSession session){
        ModelAndView model = new ModelAndView("index");
        Role role = roleService.findRoleById(id);
        session.setAttribute("role",role);
        session.setAttribute("content","role.ftl");
        return model;
    }

    /**
     * 更新角色信息
     * @param id
     * @param rolename
     * @param isRead
     * @param isWrite
     * @param session
     * @return
     */
    @RequestMapping(value = "updateRole", method = RequestMethod.POST)
    public ModelAndView updateRole(
            @RequestParam int id,
            @RequestParam String rolename,
            @RequestParam int isRead,
            @RequestParam int isWrite,
            HttpSession session){
        Role role = new Role();
        role.setId(id);
        role.setRolename(rolename);
        role.setIsRead(isRead);
        role.setIsWrite(isWrite);
        roleService.updateRole(role);
        return findAllRoleByPageAndSize("fakeFlag",session);
    }

    /**
     * 跳转到添加角色界面
     * @param session
     * @return
     */
    @RequestMapping(value = "addRoleView", method = RequestMethod.GET)
    public ModelAndView addRoleView(HttpSession session){
        ModelAndView model = new ModelAndView("index");
        session.setAttribute("content","addRole.ftl");
        return model;
    }

    /**
     * 添加角色信息
     * @param rolename
     * @param isRead
     * @param isWrite
     * @param session
     * @return
     */
    @RequestMapping(value = "addRole", method = RequestMethod.POST)
    public ModelAndView addRole(
            @RequestParam String rolename,
            @RequestParam int isRead,
            @RequestParam int isWrite,
            HttpSession session){
        Role role = new Role();
        role.setRolename(rolename);
        role.setIsRead(isRead);
        role.setIsWrite(isWrite);
        roleService.addRole(role);
        return findAllRoleByPageAndSize("fakeFlag",session);
    }
}
