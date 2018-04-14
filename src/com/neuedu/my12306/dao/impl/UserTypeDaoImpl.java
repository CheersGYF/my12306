package com.neuedu.my12306.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.neuedu.my12306.dao.IUserTypeDao;
import com.neuedu.my12306.model.UserType;
import com.neuedu.my12306.utils.DBUtil;

public class UserTypeDaoImpl implements IUserTypeDao {
	private Connection conn;
	@Override
	public void setConnection(Connection conn) {
		// TODO Auto-generated method stub
		this.conn= conn;
	}

	@Override
	public List<UserType> findAll() {
		// TODO Auto-generated method stub
		UserType userType = null;
		ResultSet rSet =null;
		PreparedStatement statement = null;
		List<UserType> list = new ArrayList<>();
		String sql = "select * from tab_usertype";
		try {
			statement = conn.prepareStatement(sql);
			rSet = statement.executeQuery();
			
			while(rSet.next()){
				
				userType = new UserType();
				userType.setId(rSet.getInt("id"));
				userType.setContent(rSet.getString("content"));
			list.add(userType);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.colseAll(null, statement, rSet);
		}
		
		return list;
	}

	@Override
	public boolean deleteCity(UserType userType) {
		// 声明对象
		PreparedStatement statement = null;
		// 用于接收返回结果
		boolean result = false;
		String sql = "delete from tab_UserType where id = ?";
		try {
			statement = conn.prepareStatement(sql);
			statement.setInt(1, userType.getId());
			//执行sql语句  判断是否有数据进行更新
			if (statement.executeUpdate()>0) {
				// 更新成功返回true
				result = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 返回结果
		return result;

	}

	@Override
	public boolean addCity(UserType userType) {
		// 声明对象
		PreparedStatement statement = null;
		// 用于接收返回结果
		boolean result = false;
		String sql = "insert into tab_UserType values(?,?)";
		try {
			statement = conn.prepareStatement(sql);
			statement.setInt(1, userType.getId());
			statement.setString(2, userType.getContent());
			//执行sql语句  判断是否有数据进行更新
			if (statement.executeUpdate()>0) {
				// 更新成功返回true
				result = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 返回结果
		return result;

	}

	@Override
	public boolean editCity(UserType userType) {
		// 声明对象
		PreparedStatement statement = null;
		// 用于接收返回结果
		boolean result = false;
		String sql = "update tab_userType set id =?, content =? where id=?";
		try {
			statement = conn.prepareStatement(sql);
			statement.setInt(1, userType.getId());
			statement.setString(2, userType.getContent());
			statement.setInt(3, userType.getId());
			//执行sql语句  判断是否有数据进行更新
			if (statement.executeUpdate()>0) {
				// 更新成功返回true
				result = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 返回结果
		return result;

	}

	@Override
	public UserType findByContent(String content) {
		ResultSet rSet =null;
		PreparedStatement statement = null;
		UserType userType=null;
		String sql = "select * from tab_userType where content= ?";
		try {
			statement = conn.prepareStatement(sql);
			statement.setString(1, content);
			rSet = statement.executeQuery();
			
			while(rSet.next()){
				
				userType = new UserType();
				userType.setId(rSet.getInt("id"));
				userType.setContent(rSet.getString("content"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.colseAll(null, statement, rSet);
		}
		
		return userType;
	}

}
