package test;

import java.sql.Connection;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.neuedu.my12306.dao.IUserDao;
import com.neuedu.my12306.dao.impl.UserDaoImpl;
import com.neuedu.my12306.model.User;
import com.neuedu.my12306.utils.DBUtil;
import com.neuedu.my12306.utils.Md5Utils;


public class TestUserDao {
	private Logger logger = Logger.getRootLogger();
	
	// 注解语法 org.junit.Test是一个注解类
	@Test
	public void testFindUser(){
		// 注册驱动打开连接
		Connection connection = DBUtil.openConnection();
		
		IUserDao userDao = new UserDaoImpl();
		userDao.setConnection(connection);
		
		User user = new User();
		user.setUserName("user123");
		String password = Md5Utils.md5("123456");
		logger.info(password);
		user.setPassword(password);
		User user2 = userDao.findUserByPassword(user);
		if(user2 != null){
			logger.info("查询用户成功:"+user2.getRealName());
		}else{
			logger.info("账号或密码错误！");
		}
		// 关闭连接
		DBUtil.colseAll(connection, null, null);
	}
	
	@Test
	public void testFindByPage(){
		Connection connection = DBUtil.openConnection();
		
		IUserDao userDao = new UserDaoImpl();
		userDao.setConnection(connection);
		
		int page = 1;
		int size = 2;
		List<User> user = userDao.findByPage(page, size);
		if(user != null){
			logger.info("查询用户成功:"+user.size());
			Iterator<User> iterator =user.iterator();
			while(iterator.hasNext()){
				logger.info(iterator.next().getRealName());
			}
		}else{
			logger.info("账号或密码错误！");
		}
		// 关闭连接
		DBUtil.colseAll(connection, null, null);
	}
}
