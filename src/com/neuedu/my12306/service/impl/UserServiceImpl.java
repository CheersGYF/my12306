package com.neuedu.my12306.service.impl;

import java.sql.Connection;
import java.util.List;

import org.apache.log4j.Logger;

import com.neuedu.my12306.dao.ICertTypeDao;
import com.neuedu.my12306.dao.ICityDao;
import com.neuedu.my12306.dao.IProvinceDao;
import com.neuedu.my12306.dao.IUserDao;
import com.neuedu.my12306.dao.IUserTypeDao;
import com.neuedu.my12306.dao.impl.CertTypeDaoImpl;
import com.neuedu.my12306.dao.impl.CityDaoImpl;
import com.neuedu.my12306.dao.impl.ProvinceDaoImpl;
import com.neuedu.my12306.dao.impl.UserDaoImpl;
import com.neuedu.my12306.dao.impl.UserTypeDaoImpl;
import com.neuedu.my12306.model.CertType;
import com.neuedu.my12306.model.City;
import com.neuedu.my12306.model.Province;
import com.neuedu.my12306.model.User;
import com.neuedu.my12306.model.UserType;
import com.neuedu.my12306.service.IUserService;
import com.neuedu.my12306.utils.DBUtil;

public class UserServiceImpl implements IUserService {
	private IUserDao userDao =null;
	private IProvinceDao provinceDao =null;
	private ICityDao cityDao = null;
	private IUserTypeDao userTypeDao = null;
	private ICertTypeDao certTypeDao = null;
	private Logger logger =Logger.getRootLogger();
	
	public UserServiceImpl(){
		super();
		userDao = new UserDaoImpl();
		provinceDao = new ProvinceDaoImpl();
		cityDao = new CityDaoImpl();
		userTypeDao = new UserTypeDaoImpl();
		certTypeDao = new CertTypeDaoImpl();
	}
	
	@Override
	public User login(User user) {
		// TODO Auto-generated method stub
		
		Connection connection = DBUtil.openConnection();
		try {
			userDao.setConnection(connection);
			return userDao.findUserByPassword(user);
		} catch (Exception e) {
			// TODO: handle exception
			// 日志器的级别是警告级别
			logger.warn("执行用户登录，发生数据库操作异常！",e);
			return null; // 查询异常，返回null
		}finally{
			DBUtil.colseAll(connection, null, null);
		}
	}

	@Override
	public List<User> findAll() {
		// 打开数据库连接
		Connection connection = DBUtil.openConnection();
		try {
			userDao.setConnection(connection);
			return userDao.findAll();
		} catch (Exception e) {
			// 日志器的级别是警告级别
			logger.warn("执行用户查询，发生数据库操作异常！",e);
			// 查询异常，返回null
			return null; 
		}finally{
			DBUtil.colseAll(connection, null, null);
		}
	}

	@Override
	public List<Province> findAllProvince() {
		// 打开数据库连接
		Connection connection = DBUtil.openConnection();
		try {
			provinceDao.setConnection(connection);
			return provinceDao.findAllProvince();
		} catch (Exception e) {
			// 日志器的级别是警告级别
			logger.warn("执行省份查询，发生数据库操作异常！",e);
			// 查询异常，返回null
			return null; 
		}finally{
			DBUtil.colseAll(connection, null, null);
		}
	}

	@Override
	public List<City> findByProvince(String province) {
		// 打开数据库连接
		Connection connection = DBUtil.openConnection();
		try {
			cityDao.setConnection(connection);
			return cityDao.findByProvince(province);
		} catch (Exception e) {
			// 日志器的级别是警告级别
			logger.warn("执行城市查询，发生数据库操作异常！",e);
			// 查询异常，返回null
			return null; 
		}finally{
			DBUtil.colseAll(connection, null, null);
		}
	}

	
	@Override
	public boolean findUserByName(String userName) {
		boolean ret = false;
		Connection connection = DBUtil.openConnection();
		try {
			userDao.setConnection(connection);
			User user = new User();
			user.setUserName(userName);
			List<User> list = userDao.searchUsers(user);
			logger.warn("执行账号检查，发生数据库异常！00"+list.size());
			if (list.size() == 0) {
				logger.warn("执行账号检查，发生数据库异常！01");
				ret = true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.warn("执行账号检查，发生数据库异常！",e);
		}finally{
			DBUtil.colseAll(connection, null, null);
		}
		return ret;
		
	}

	@Override
	public List<UserType> findUserType() {
		// 打开数据库连接
		Connection connection = DBUtil.openConnection();
		try {
			userTypeDao.setConnection(connection);
			return userTypeDao.findAll();
		} catch (Exception e) {
			// 日志器的级别是警告级别
			logger.warn("执行用户类型查询，发生数据库操作异常！",e);
			// 查询异常，返回null
			return null; 
		}finally{
			DBUtil.colseAll(connection, null, null);
		}
	}

	@Override
	public List<CertType> findCertType() {
		// 打开数据库连接
		Connection connection = DBUtil.openConnection();
		try {
			certTypeDao.setConnection(connection);
			return certTypeDao.findAll();
		} catch (Exception e) {
			// 日志器的级别是警告级别
			logger.warn("执行证件类型查询，发生数据库操作异常！",e);
			// 查询异常，返回null
			return null; 
		}finally{
			DBUtil.colseAll(connection, null, null);
		}
	}

	@Override
	public boolean addUser(User user) {
		boolean ret = false;
		Connection connection = DBUtil.openConnection();
		try {
			// 开启事务；
			DBUtil.openConnection();
			userDao.setConnection(connection);
			ret = userDao.addUser(user);
			// 提交事务
			DBUtil.commitTransaction(connection);
			logger.warn("执行账号检查，发生数据库异常！00"+ret);
		} catch (Exception e) {
			// TODO: handle exception
			DBUtil.rollbackTransaction(connection);
			logger.warn("执行账号检查，发生数据库异常！",e);
		}finally{
			DBUtil.colseAll(connection, null, null);
		}
		return ret;
	}

	@Override
	public boolean deleteUser(int[] ids) {
		boolean ret = false;
		Connection connection = DBUtil.openConnection();
		try {
			// 开启事务；
			DBUtil.openConnection();
			userDao.setConnection(connection);
			ret = userDao.deleteById(ids);
			// 提交事务
			DBUtil.commitTransaction(connection);
			logger.warn("执行账号检查，发生数据库异常！00"+ret);
		} catch (Exception e) {
			// TODO: handle exception
			DBUtil.rollbackTransaction(connection);
			logger.warn("执行账号检查，发生数据库异常！",e);
		}finally{
			DBUtil.colseAll(connection, null, null);
		}
		return ret;
	}

	@Override
	public boolean editUser(User user) {
		boolean ret = false;
		Connection connection = DBUtil.openConnection();
		try {
			// 开启事务；
			DBUtil.openConnection();
			userDao.setConnection(connection);
			ret = userDao.editUser(user);
			// 提交事务
			DBUtil.commitTransaction(connection);
			logger.warn("用户信息修改成功！");
		} catch (Exception e) {
			// TODO: handle exception
			DBUtil.rollbackTransaction(connection);
			logger.warn("用户信息修改失败！" ,e);
		}finally{
			DBUtil.colseAll(connection, null, null);
		}
		return ret;
	}
	
}
