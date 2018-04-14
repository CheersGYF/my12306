package com.neuedu.my12306.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neuedu.my12306.model.User;
import com.neuedu.my12306.service.impl.UserServiceImpl;
import com.neuedu.my12306.utils.Md5Utils;

/**
 * Servlet implementation class LoginServlet
 */
// 配置在浏览器客户端调用的网址， 是servlet3.0的特性
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      private  UserServiceImpl userService;
    
    public LoginServlet() {
        super();
        userService =new UserServiceImpl();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1.接受用户的输入
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		// 2.调用业务类进行业务处理
		User paramUser = new User();
		paramUser.setUserName(userName);
		paramUser.setPassword(Md5Utils.md5(password));
		User user = userService.login(paramUser);
		// 3.根据业务处理的结果，进行页面跳转控制 -- 控制器
		// 登录成功跳转到管理员界面，登录失败跳转到注册页面
		// 此为重定向
		if (user == null) {
			response.sendRedirect("RegServlet?op=toreg");
		}else{
			response.sendRedirect("Admin/Index.html");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
