package com.neuedu.my12306.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.neuedu.my12306.dao.IProvinceDao;
import com.neuedu.my12306.model.City;
import com.neuedu.my12306.model.Province;
import com.neuedu.my12306.utils.DBUtil;

public class ProvinceDaoImpl implements IProvinceDao {
	private Connection conn;
	@Override
	public void setConnection(Connection conn) {
		// TODO Auto-generated method stub
		this.conn = conn;
	}

	@Override
	public Province findByCity(City city) {
		// TODO Auto-generated method stub
		Province province = null;
		ResultSet rSet =null;
		PreparedStatement statement = null;
		String sql = "select * from tab_province where provinceid = ?";
		try {
			String provinceId =city.getFather();
			statement = conn.prepareStatement(sql);
			statement.setString(1, provinceId);
			rSet = statement.executeQuery();
			
			while(rSet.next()){
				
				province = new Province();
				province.setId(rSet.getInt("id"));
				province.setProvinceId(rSet.getString("provinceId"));
				province.setProvince(rSet.getString("province"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.colseAll(null, statement, rSet);
		}
		
		return province;
	}
	
	/**
	 * 查询所有省份
	 * 
	 * @return 返回省份列表
	 */
	@Override
	public List<Province> findAllProvince() {
		Province province = null;
		List<Province> list =new ArrayList<>();
		ResultSet rSet =null;
		PreparedStatement statement = null;
		String sql = "select * from tab_province";
		try {
			statement = conn.prepareStatement(sql);
			rSet = statement.executeQuery();
			
			while(rSet.next()){
				
				province = new Province();
				province.setId(rSet.getInt("id"));
				province.setProvinceId(rSet.getString("provinceId"));
				province.setProvince(rSet.getString("province"));
				list.add(province);
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
	public boolean deleteProvince(Province province) {
		// 声明对象
		PreparedStatement statement = null;
		// 用于接收返回结果
		boolean result = false;
		String sql = "delete from tab_province where id = ?";
		try {
			statement = conn.prepareStatement(sql);
			statement.setInt(1, province.getId());
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
	public boolean addProvince(Province province) {
		// 声明对象
		PreparedStatement statement = null;
		// 用于接收返回结果
		boolean result = false;
		String sql = "insert into tab_province values(?,?,?)";
		try {
			statement = conn.prepareStatement(sql);
			statement.setInt(1, province.getId());
			statement.setString(2, province.getProvinceId());
			statement.setString(3, province.getProvince());
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
	public boolean editProvince(Province province) {
		// 声明对象
		PreparedStatement statement = null;
		// 用于接收返回结果
		boolean result = false;
		String sql = "update tab_province set id =?, provinceId =?, province=? where id=?";
		try {
			statement = conn.prepareStatement(sql);
			statement.setInt(1, province.getId());
			statement.setString(2, province.getProvinceId());
			statement.setString(3, province.getProvince());
			statement.setInt(4, province.getId());
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
