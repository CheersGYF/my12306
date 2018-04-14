package test;

import java.sql.Connection;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.neuedu.my12306.dao.IUserDao;
import com.neuedu.my12306.dao.impl.UserDaoImpl;
import com.neuedu.my12306.model.User;
import com.neuedu.my12306.utils.DBUtil;
import com.neuedu.my12306.utils.DateUtil;
import com.neuedu.my12306.utils.Md5Utils;

public class TsetAddUser {
private Logger logger = Logger.getRootLogger();
	
	// 注解语法 org.junit.Test是一个注解类
	@Test
	public void testAddUser(){
		// 注册驱动打开连接
		Connection connection = DBUtil.openConnection();
		
		IUserDao userDao = new UserDaoImpl();
		userDao.setConnection(connection);
		
		User user2 = new User();
			user2.setUserName("wsl");
			user2.setPassword(Md5Utils.md5("305230"));
			user2.setRule("1");
			user2.setSex("2");
			user2.setCity(60);
			user2.setRealName("dasf");
			user2.setCert("215") ;
			user2.setCertType(2);
			user2.setBirthday(DateUtil.parseDate("1995-12-15", "yyyy-mm-dd"));
			user2.setUserType(2);
			user2.setContent("dfhs");
			user2.setStatus("1");
			user2.setLoginIp("172.15.12.5.2");
			user2.setImagePath("");
		boolean result = userDao.addUser(user2);
		if(result){
			logger.info("修改用户成功:"+user2.getRealName());
		}else{
			logger.info("账号或密码错误！");
		}
		// 关闭连接
		DBUtil.colseAll(connection, null, null);
	}
}
