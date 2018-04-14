package com.neuedu.my12306.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.neuedu.my12306.model.User;
import com.neuedu.my12306.service.IUserService;
import com.neuedu.my12306.service.impl.UserServiceImpl;

/**
 * Servlet implementation class UserAdminServlet
 */
@WebServlet("/UserAdminServlet")
public class UserAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IUserService userService;
	private Logger logger = Logger.getRootLogger();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserAdminServlet() {
        super();
        userService = new UserServiceImpl();
        // TODO Auto-generated constructor stub
    }

	/**
	 * <pre>
	 * 1.在servlet中，使用doGet处理get方法请求；使用doPost处理post请求
	 * 2.如果需要同时处理两种请求: 1).在doGet调用dopost方法或在doPost中调用doget方法
	 * 		2).直接使用service方法代替doPost和doGet，即service可以同时处理get和post请求
	 * <pre>
	 * 
	 * 
	 */						
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 在浏览器客户端使用op传递管理操作
		String op = request.getParameter("op");
		switch(op){
		case "all":
			findAllUser(request,response);
			break;
		default:
			// 如果没有传参返回登录页面
			// 这是请求转发技术
			// 在jsp服务端编程中，有两种页面跳转技术：请求转发和重定向 
			// 
			request.getRequestDispatcher("./login.html").forward(request, response);
			break;
		}
	}
	// 编写用于管理用户列表的方法
	private void findAllUser(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		
		// 1.接收用户输入
		// 2. 调用服务类进行业务计算
		List<User> list = userService.findAll();
		
		// 3. 根据业务计算结果进行页面跳转设置
		// jsp 传递数据有4个作用域对象： page， request，session，application
		// 可以使用4个不同的作用域在不同的作用范围传递数据，在（浏览器）客户端可以使用参数或cookie传递数据
		request.setAttribute("users", list);// 把数据绑定到请求对象当中，并传递到user_list.jsp
		request.getRequestDispatcher("Admin/user_list.jsp").forward(request, response);
	}
}
