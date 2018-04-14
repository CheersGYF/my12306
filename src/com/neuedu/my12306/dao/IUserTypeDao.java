package com.neuedu.my12306.dao;

import java.util.List;

import com.neuedu.my12306.model.UserType;
/**
 * 
 * @author hp
 *
 */
public interface  IUserTypeDao extends IBaseDao{
	/**
	 * 查找所有用户类型信息
	 * @return 用户类型列表
	 */
	public List<UserType> findAll();
	/**
	 * 删除用户类型
	 * @return 删除成功返回true 删除失败返回false
	 */
	public boolean deleteCity(UserType userType);
	/**
	 * 增加用户类型
	 * @return 增加成功返回true 增加失败返回false
	 */
	public boolean addCity(UserType userType);
	/**
	 * 修改用户类型
	 * @return 修改成功返回true 修改失败返回false
	 */
	public boolean editCity(UserType userType);
	
	/**
	 * 通过用户类型内容获取用户类型
	 * @param content
	 * @return
	 */
	public UserType findByContent(String content);
}
