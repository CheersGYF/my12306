package com.neuedu.my12306.utils;

import java.sql.*;

/**
 * <pre>
 * java数据库编程技术叫jdbc，jdbc编程需要用到4个基本参数和执行6个步骤
 * 
 * 本例设计一个数据库工具类，用于保存四个参数和通用的步骤
 * 
 *<pre>
 */
public final class DBUtil {//final类不会被继承，是一个终结类
	//驱动：驱动类是由数据库厂商所提供的 ，不同数据库有不同的数据库驱动
	private static final String driver="oracle.jdbc.driver.OracleDriver";
	//路径：jdbc协议地址，
	private static final String url="jdbc:oracle:thin:@localhost:1521:orcl";
	//用户名
	private static final String user="my12306";
	//密码
	private static final String passWord="123456";
	
	/**
	 * 打开数据库操作
	 * @return
	 */
	public static Connection openConnection(){
		Connection conn=null;
		//注册驱动
		try {
			Class.forName(driver);
			//打开连接
			try {
				conn = DriverManager.getConnection(url,user,passWord);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("打开数据库失败，连接异常");
			}
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
			System.out.println("打开数据库连接失败，找不到驱动类!");
		}
		return conn;
	}
	
	/**
	 * 关闭数据库连接
	 */
	
	public static void colseAll(Connection conn,Statement stmt,ResultSet rs){
		//注意：关闭顺序从小到大，单独捕获异常，进行非空判断
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
			}
		}//关闭结果集
		
		if(stmt!=null){
			try {
				stmt.close();
			} catch (SQLException e) {
			}
		}//关闭状态连接
		
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
			}
		}//关闭数据库连接
	}//关闭连接
	
	/**
	 * 打开事务
	 * @param conn
	 */
	public static void openTransaction(Connection conn){
		try {
			conn.setAutoCommit(false);
		} catch (SQLException e) {
		}
		
	}
	/**
	 * 提交事务
	 * @param conn
	 */
	public static void commitTransaction(Connection conn){
		try {
			
			conn.commit();
			conn.setAutoCommit(true);
		} catch (SQLException e) {
		}
		
	}
	
	/**
	 * 回滚事务
	 * @param conn
	 */
	public static void rollbackTransaction(Connection conn){
		try {
			conn.rollback();
			conn.setAutoCommit(true);
		} catch (SQLException e) {
		}
	}
	
}
