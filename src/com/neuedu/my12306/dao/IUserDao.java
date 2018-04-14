package com.neuedu.my12306.dao;

import java.util.List;

import com.neuedu.my12306.model.User;

/**
 * <pre>
 * 面向接口编程思想：耦合和解耦合
 * 
 * 1.接口是一种规范，他约束了接口的实现类必须实现接口的方法
 * 2.这是数据操作接口，一般用于数据库的基本操作：增、删、查、改操作
 * 3.接口可以继承多个接口,
 * 4.类是单一继承的，一个类只能有一个父类，一个类可以实现多个接口一个接口可以击沉咁多个接口
 * public interface IUserDao extends IBaseDao,Serializable {
 * <pre>
 * @author hp
 *
 */
public interface IUserDao extends IBaseDao {
	
	/**
	 * 方法1 使用基本数据类型，传递多个参数
	 * @param userName 用户名
	 * @param password 用户密码
	 * @return 返回User类型对象
	 */
	public User findUserByPassword(String userName,String password);
	
	/**
	 * 方法2 使用对象类型，传递一个包装类型
	 * @param user User型用户对象
	 * @return 返回User类型对象
	 */
	public User findUserByPassword(User user);
	/**
	 * 查询所有用户信息
	 * @return 用户集合
	 */
	public List<User> findAll();
	
	/**
	 * 分页查询用户信息
	 * @param page 第n页
	 * @param size 每页查询s条记录
	 * @return 用户集合
	 */
	public List<User> findByPage(int page , int size);
	
	/**
	 * 新增用户信息
	 * @param user 要新增的用户信息
	 * @return 成功返回ture 失败返回false
	 */
	public boolean addUser(User user);
	
	/**
	 * 修改用户信息
	 * @param user 用户信息
	 */
	public boolean editUser(User user);
	/**
	 * 通过主键查询
	 * @param id
	 * @return 返回查询的用户信息
	 */
	public User findById(int id);
	
	/**
	 * 批量删除
	 * @param ids 用户id
	 * @return  成功返回ture 失败返回false
	 */
	public boolean deleteById (int[] ids);
	
	/**
	 * 不定条件模糊查询
	 * @param user 查询条件User类
	 * @return 结果集
	 */
	public List<User> searchUsers(User user); 
	
	/**
	 * 带分页的多条件模糊查询
	 * @param user 查询条件User类
	 * @param page 第几页
	 * @param size 每页显示条数
	 * @return 结果集
	 */
	public List<User> searchUser(User user,int page , int size); 
}
