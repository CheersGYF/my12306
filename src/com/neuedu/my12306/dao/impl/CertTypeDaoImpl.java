package com.neuedu.my12306.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.neuedu.my12306.dao.ICertTypeDao;
import com.neuedu.my12306.model.CertType;
import com.neuedu.my12306.utils.DBUtil;

public class CertTypeDaoImpl implements ICertTypeDao {
	private Connection conn;
	@Override
	public void setConnection(Connection conn) {
		// TODO Auto-generated method stub
		this.conn=conn;
	}
	@Override
	public List<CertType> findAll() {
		// TODO Auto-generated method stub
		CertType certType = null;
		ResultSet rSet =null;
		PreparedStatement statement = null;
		List<CertType> list =new ArrayList<>();
		String sql = "select * from tab_certtype";
		try {
			statement = conn.prepareStatement(sql);
			rSet = statement.executeQuery();
			
			while(rSet.next()){
				
				certType = new CertType();
				certType.setId(rSet.getInt("id"));
				certType.setContent(rSet.getString("content"));
				list.add(certType);
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
	public boolean deleteCertType(CertType certType) {
		// 声明对象
		PreparedStatement statement = null;
		// 用于接收返回结果
		boolean result = false;
		String sql = "delete from tab_certType where id = ?";
		try {
			statement = conn.prepareStatement(sql);
			statement.setInt(1, certType.getId());
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
	public boolean addCertType(CertType certType) {
		// 声明对象
		PreparedStatement statement = null;
		// 用于接收返回结果
		boolean result = false;
		String sql = "insert into tab_certType values(?,?)";
		try {
			statement = conn.prepareStatement(sql);
			statement.setInt(1, certType.getId());
			statement.setString(2, certType.getContent());
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
	public boolean editCertType(CertType certType) {
		// 声明对象
		PreparedStatement statement = null;
		// 用于接收返回结果
		boolean result = false;
		String sql = "update tab_certType set id=?,content=? where id= ?";
		try {
			statement = conn.prepareStatement(sql);
			statement.setInt(3, certType.getId());
			statement.setInt(1, certType.getId());
			statement.setString(2, certType.getContent());
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
	
	
}
