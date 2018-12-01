package com.wsc.oa.identity.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.wsc.common.util.pager.PageModel;
import com.wsc.oa.identity.domain.Dept;
import com.wsc.oa.identity.domain.Module;
import com.wsc.oa.identity.domain.Role;
import com.wsc.oa.identity.domain.User;
import com.wsc.oa.identity.dto.UserModule;
import com.wsc.oa.identity.vo.TreeData;

public interface IdentityService {
	//查询所有的部门
	List<Dept> getAllDepts();
	
	//异步登陆的业务层接口方法
	Map<String, Object> login(Map<String, Object> params);
	
	//根据用户的主键查询用户的信息，包含了延迟加载的部门和职位信息
	User getUserById(String userId);
	
	//修改自己
	void updateSelf(User user , HttpSession session);
	
	//异步加载部门与职位的json字符串信息协会到页面
	Map<String, Object> getAllDeptsAndJobsAjax();
	
	//分页查询用户信息
	List<User> getUsersByPager(User user , PageModel pageModel);
	
	//批量删除用户
	void deleteUserByUserIds(String ids);
	
	//检查用户是否已经被注册
	String isUserValidAjax(String userId);
	
	//注册用户
	void addUser(User user);
	
	//根据用户userId修改用户信息
	void updateUser(User user);
	
	//激活用户
	void activeUser(User user);
	
	//加载所有的模块树
	List<TreeData> loadAllModuleTrees();
	
	//根据父节点查询所有的子模块,分页
	List<Module> getModulesByParent(String parentCode , PageModel pageModel);
	
	
	//根据父节点查询所有的子模块，不分页
	List<Module> getModulesByParent(String parentCode);
	
	//批量删除菜单
	void deleteModules(String ids);
	
	//为当前的父节点菜单添加子节点模块
	void addModule(String parentCode , Module module);
	
	//根据编号查询模块信息
	Module getModuleByCode(String code);
	
	//修改模块
	void updateModule(Module module);
	
	//分页查询角色信息
	List<Role> getRoleByPager(PageModel pageModel);
	
	//添加角色
	void addRole(Role role);
	
	//批量删除角色
	void deleteRole(String ids);
	
	//根据id查询角色
	Role getRoleById(Long id);
	
	//修改角色
	void updateRole(Role role);
	
	//分页查询属于这个角色下的用户信息
	List<User> selectRoleUser(Role role , PageModel pageModel);
	
	//查询不属于某个角色下的用户信息
	List<User> selectNotRoleUser(Role role , PageModel pageModel);
	
	//给用户绑定角色
	void bindUser(Role role , String ids);
	
	//给用户解绑角色
	void unBindUser(Role role , String ids);
	
	//查询当前角色在当前模块下拥有的操作权限编号
	List<String> getRoleModuleOperasCodes(Role role , String parentCode);
	
	//给角色绑定某个模块下的操作权限
	void bindPopedom(String codes , Role role , String parentCode);
	
	//查询当前用户的权限模块
	List<UserModule> getUserPopedomModules();

}
