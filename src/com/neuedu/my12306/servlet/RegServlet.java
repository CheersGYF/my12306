package com.neuedu.my12306.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.neuedu.my12306.model.CertType;
import com.neuedu.my12306.model.City;
import com.neuedu.my12306.model.Province;
import com.neuedu.my12306.model.User;
import com.neuedu.my12306.model.UserType;
import com.neuedu.my12306.service.IUserService;
import com.neuedu.my12306.service.impl.UserServiceImpl;
import com.neuedu.my12306.utils.DBUtilStrTo;
import com.neuedu.my12306.utils.DateUtil;
import com.neuedu.my12306.utils.Md5Utils;

/**
 * 注册servlet
 */
@WebServlet("/RegServlet")
public class RegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private IUserService userService;
    private Logger logger = Logger.getRootLogger();
    
    public RegServlet() {
        super();
        // 控制层调用业务层
        userService = new UserServiceImpl();
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 接收参数前设置编码
		// 设置了请求编码后，tomcat服务器能够根据设置的编码进行转换，
		// http 协议默认的传输数据使用的编码字符集市ISO-8859-1
		// tomcat 服务器能够把网络传输来的iso-8859-1编码的内容转换成指定的编码内容UTF-8
		request.setCharacterEncoding("UTF-8");
		// 设置响应对象的编码
		// 设置响应编码后，服务器向浏览器发生数据时，会设置内容编码信息。浏览器将根据服务器返回的编码格式进行数据显示
		
		response.setCharacterEncoding("UTF-8");
		
		String js = request.getParameter("op");
		logger.info("执行用于注册功能，操作是toreg ====  " + js);
		if(js != null){
			switch (js){
			case "toreg":// 打开注册页
				toReg(request,response); // 调用打开注册页的方法进行注册
				break;
			case "checkname":
				checkName(request,response);
				break;
			case "doreg":// 提交注册
				doReg(request,response);
				break;
			case "city" :// 查询城市信息
				findCity(request,response);
				break;
			default:
				break;
			}
		}else{
			// 没有提交操作返回注册页面
			//toReg(request,response);
			response.sendRedirect("RegServlet?op=toreg");
		}
	}
	
	// 打开注册页的方法 用于查询省份信息，并传输到注册页面进行显示
	private void toReg(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException,IOException{
		logger.info("执行用于注册功能，操作是toreg方法");
		// 1. 接收用户输入
		// 2. 调用业务类执行业务计算
		List<Province> list = userService.findAllProvince();
		List<UserType> userTypes = userService.findUserType();
		List<CertType> certTypes = userService.findCertType();
		// 3. 根据计算结果，进行页面跳转控制
		// 把省份信息绑定在请求作用域，传递到jsp页面进行数据显示
		request.setAttribute("province", list);
		request.setAttribute("userType", userTypes);
		request.setAttribute("certType", certTypes);
		request.getRequestDispatcher("UserRegistration.jsp").forward(request, response);
		logger.info("执行用于注册功能，操作是toreg方法-执行成功");
	}
	// 查找城市信息，用于页面进行ajax加载城市，
	private void findCity(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException,IOException{
		//1.接收用户输入
		String provinceId = request.getParameter("pid");
		//2.调用服务层进行业务计算
		List<City> list = userService.findByProvince(provinceId);
		//3.根据计算结果，返回json数据 - json是一种数据结构，这种数据结构是所有编程语言都可以识别和解析的，在互联网应用中经常用于数据传输。
		// 把查询到的城市信息java数据结构转换为javaScript能够识别的json数据结构
		String json = new Gson().toJson(list);
		// 通过网络响应对象，调用输出流，向浏览器客户端写字符串的形式输出数据
		response.setContentType("application/json; charset=UTF-8");
		response.getWriter().write(json);
		
	}
	private void checkName(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException,IOException{
		logger.info("执行用于注册功能，操作是checkName方法");
		//1.接收用户输入
		String userName = request.getParameter("uName");
		//2.调用服务层进行业务计算
		// 如果userName已经被注册则返回false 如果可用则返回true
		boolean result = userService.findUserByName(userName);
		logger.info("执行用于注册功能，操作是checkName方法2");
		//3. 根据计算结果，返回用户名状态
		/**
		 *  String json = null;
		 * if(result){ // 账号已经存在，不可用
		 * 	json = "{\"result\":true}";
		 * }else{ // 账号可用
		 * 	json = "{\"result\":false}";
		 *} 
		 */
		 
		 
		
		// 把返回的java数据结构的布尔值 ， 转换为
		String json = new Gson().toJson(result);
		// 通过网络响应对象，调用输出流，向浏览器客户端写字符串的形式输出数据
		response.setContentType("application/json; charset=UTF-8");
		response.getWriter().write(json);
		
	}
	// 接收用户输入完成注册功能的方法
	private void doReg(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		// 1.接收用户输入
		
		String userName =request.getParameter("userName");
		String password = request.getParameter("password");
		String realName = request.getParameter("realName");
		String sex = request.getParameter("sex");
		String city = request.getParameter("city");
		String certType = request.getParameter("certType");
		String cert = request.getParameter("cert");
		String birthday = request.getParameter("birthday");
		String userType = request.getParameter("userType");
		String content = request.getParameter("content");
		String rule ="1";
		String loginIp = request.getRemoteAddr();
		password = Md5Utils.md5(password);
		logger.info("doReg方法中打印userName"+userName);
		logger.info("doReg方法中打印realName"+realName);
		
		User user =new User(/*userName,password,city,realName,userType,cert,birthday,userType,content*/);
		user.setRule(rule);
		user.setLoginIp(loginIp);
		user.setUserName(userName);
		user.setPassword(password);
		user.setRealName(realName);
		user.setSex(sex);
		user.setCity(DBUtilStrTo.strToInt(city));
		user.setCertType(DBUtilStrTo.strToInt(certType));
		user.setCert(cert);
		user.setBirthday(DateUtil.parseDate(birthday, DateUtil.SHORT));
		user.setUserType(DBUtilStrTo.strToInt(userType));
		user.setContent(content);
		user.setStatus("1");
		user.setImagePath("");
		logger.info("用于注册账户的sevlet层"+sex);
		
		
		//logger.info("输出获取的字符串" +userName+password+realName+sex+city);
		//logger.info("输出获取的字符串" +certType+cert+birthday+userType+content);
		
		
		/*user.setUserName(userName);
		user.setPassword(request.getParameter("password"));
		user.setRealName(request.getParameter("realName"));
		user.setSex(request.getParameter("sex"));
		// 通过获取城市名称获取城市id
		ICityDao cityDao = new CityDaoImpl();
		City city=cityDao.findByCity(request.getParameter("city"));
		user.setCity(city.getId());
		
		//user.setCertType();
		user.setCert(request.getParameter("cert"));
		user.setBirthday(DateUtil.parseDate(request.getParameter("birthday"), DateUtil.SHORT));
		// 通过获取用户类型content来获取id
		IUserTypeDao userType = new UserTypeDaoImpl();
		UserType userType2=userType.findByContent(request.getParameter("userType"));
		user.setUserType(userType2.getId());
		
		user.setContent(request.getParameter("content"));*/
		// 2.进行业务计算
		boolean ret = userService.addUser(user);
		// 3.进行跳转控制
		
		if(ret){
			// 如果注册成功，跳转到登录页面进行登录
			request.getRequestDispatcher("Login.html").forward(request, response);
		}else{
			// 注册失败返回注册页面重新注册
			toReg(request,response);
		}
	}

}
