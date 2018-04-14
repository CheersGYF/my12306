package com.neuedu.my12306.service;

import java.util.List;

import com.neuedu.my12306.model.CertType;
import com.neuedu.my12306.model.City;
import com.neuedu.my12306.model.Province;
import com.neuedu.my12306.model.User;
import com.neuedu.my12306.model.UserType;

/**
 * 编写一个业务接口，设计接口操作
 * @author hp
 *
 */
public interface IUserService {
	/**
	 * 用户登录方法：使用账号密码登录
	 * @param user 用户信息
	 * @return 用户信息
	 */
	public User login(User user);
	/**
	 * 查询所有用户信息 用于用户管理的列表显示模块
	 * 
	 * @return 查询的用户结果集
	 */
	public List<User> findAll();
	
	/**
	 * 查询所有省份
	 * @return
	 */
	public List<Province> findAllProvince();
	
	/**
	 * 根据省份编号来查询城市信息
	 * @param procince
	 * @return
	 */
	public List<City> findByProvince(String province);
	/**
	 * 查找用户名是否存在
	 * @param userName 
	 * @return 
	 */
	public boolean findUserByName(String userName);
	
	/**
	 * 查找所有用户类型
	 * @return
	 */
	public List<UserType> findUserType();
	
	/**
	 * 查找证件类型
	 * @return
	 */
	public List<CertType> findCertType();
	
	/**
	 * 添加新用户
	 * @param user
	 * @return
	 */
	public boolean addUser(User user);
	/**
	 * 添加用户
	 * @param ids 用户id
	 * @return 成功返回true 失败返回false
	 */
	public boolean deleteUser(int[] ids);
	
	/**
	 * 修改旅客信息
	 * @param user 要修改的用户
	 * @return 修改后的信息
	 */
	public boolean editUser(User user);
	
}
