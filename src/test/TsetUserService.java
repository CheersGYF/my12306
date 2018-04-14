package test;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.neuedu.my12306.model.CertType;
import com.neuedu.my12306.model.User;
import com.neuedu.my12306.model.UserType;
import com.neuedu.my12306.service.IUserService;
import com.neuedu.my12306.service.impl.UserServiceImpl;
import com.neuedu.my12306.utils.DateUtil;


public class TsetUserService {
	private Logger logger = Logger.getRootLogger();
	/*@Test
	public void testFindUserName(){
		String userName ="mm";
		IUserService userService = new UserServiceImpl();
		if(userService.findUserName(userName)==1){
			logger.info("此用户名可以使用！");
		}else{
			logger.info("此用户名已经被注册，请重新输入！");
		};
	}*/
	/*@Test
	public void testFindUserByName(){
		String userName ="user1234";
		IUserService userService = new UserServiceImpl();
		if(userService.findUserByName(userName)){
			logger.info("此用户名已经被注册，请重新输入！");
		}else{
			logger.info("此用户名可以使用！");
		};
	}*/
	/*@Test
	public void testfindUserType(){
		IUserService userService = new UserServiceImpl();
		List<UserType> list = new ArrayList<>();
		list = userService.findUserType();
		if(list.size()!=0){
			Iterator<UserType> iterator = list.iterator();
			while(iterator.hasNext()){
				logger.info(iterator.next().getContent());
				
			}
		}
	}*/
	
	/*@Test
	public void testfindCertType(){
		IUserService userService = new UserServiceImpl();
		List<CertType> list = new ArrayList<>();
		list = userService.findCertType();
		if(list.size()!=0){
			Iterator<CertType> iterator = list.iterator();
			logger.info("证件类型01");
			while(iterator.hasNext()){
				logger.info(iterator.next().getContent());
				
			}
		}
	}*/
	/*@Test
	public void testDeleteUser(){
		int arr[] ={5,3};
		IUserService userService = new UserServiceImpl();
		if(userService.deleteUser(arr)){
			logger.info("此用户名已经被注册，请重新输入！");
		}else{
			logger.info("此用户名可以使用！");
		}
	}*/
	@Test
	public void testeditUser(){
		User user= null;
		int id = 25;
		String uName = "jjjjjjj";
		String pword = "password";
		String rule = "1";
		String sex = "2";
		int city = 90;
		String realName = "realName";
		int certType = 1;
		String cert = "1215";
		Date birthday =DateUtil.parseDate("2016-12-23", "yyyy-mm-dd");
		int userType = 2;
		String content ="content";
		String status = "1";
		String loginIp = "192.168.1.1.1"; 
		String imagePath = "";
		user = new User(id, uName,pword,rule,sex,city,realName,
				certType,cert,birthday,userType,content,status,loginIp,imagePath);
		IUserService userService = new UserServiceImpl();
		if(userService.editUser(user)){
			logger.info("修改成功！");
		}else{
			logger.info("修改失败！");
		}
	}
}
