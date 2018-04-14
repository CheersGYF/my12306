package com.neuedu.my12306.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.neuedu.my12306.dao.ICityDao;
import com.neuedu.my12306.model.City;
import com.neuedu.my12306.utils.DBUtil;

public class CityDaoImpl implements ICityDao{
	private Connection conn;
	@Override
	public void setConnection(Connection conn) {
		// TODO Auto-generated method stub
		this.conn= conn;
	}

	@Override
	public City findCityById(int id) {
		// TODO Auto-generated method stub
		City city = null;
		ResultSet rSet =null;
		PreparedStatement statement = null;
		String sql = "select * from tab_city where id = ?";
		try {
			statement = conn.prepareStatement(sql);
			statement.setInt(1, id);
			rSet = statement.executeQuery();
			
			while(rSet.next()){
				
				city = new City();
				city.setId(rSet.getInt("id"));
				city.setCityId(rSet.getString("cityId"));
				city.setCity(rSet.getString("city"));
				city.setFather(rSet.getString("father"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.colseAll(null, statement, rSet);
		}
		
		return city;
	}
	
	@Override
	public City findCityByCityId(String cityId) {
		// TODO Auto-generated method stub
		City city = null;
		ResultSet rSet =null;
		PreparedStatement statement = null;
		String sql = "select * from tab_city where cityId = ?";
		try {
			statement = conn.prepareStatement(sql);
			statement.setString(1, cityId);
			rSet = statement.executeQuery();
			
			while(rSet.next()){
				
				city = new City();
				city.setId(rSet.getInt("id"));
				city.setCityId(rSet.getString("cityId"));
				city.setCity(rSet.getString("city"));
				city.setFather(rSet.getString("father"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.colseAll(null, statement, rSet);
		}
		
		return city;
	}
	
	/**
	 * 根据省份查找城市信息 - 用于省市联动 ajax查询
	 * @param province 省份
	 * @return 城市列表
	 */
	@Override
	public List<City> findByProvince(String provinceId) {
		// 
		List<City> list= new ArrayList<>();
		ResultSet rSet =null;
		PreparedStatement statement = null;
		String sql = "select * from tab_city where father = ?";
		try {
			statement = conn.prepareStatement(sql);
			statement.setString(1,provinceId);
			rSet = statement.executeQuery();
			
			while(rSet.next()){
				City city = new City();
				city.setId(rSet.getInt("id"));
				city.setCityId(rSet.getString("cityId"));
				city.setCity(rSet.getString("city"));
				city.setFather(rSet.getString("father"));
				list.add(city);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			DBUtil.colseAll(null, statement, rSet);
		}
		
		return list;
	}

	@Override
	public boolean deleteCity(City city) {
		// 声明对象
		PreparedStatement statement = null;
		// 用于接收返回结果
		boolean result = false;
		String sql = "delete from tab_city where id = ?";
		try {
			statement = conn.prepareStatement(sql);
			statement.setInt(1, city.getId());
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
	public boolean addCity(City city) {
		// 声明对象
		PreparedStatement statement = null;
		// 用于接收返回结果
		boolean result = false;
		String sql = "insert into tab_city values(?,?,?,?)";
		try {
			statement = conn.prepareStatement(sql);
			statement.setInt(1, city.getId());
			statement.setString(2, city.getCityId());
			statement.setString(3, city.getCity());
			statement.setString(4, city.getFather());
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
	public boolean editCity(City city) {
		// 声明对象
		PreparedStatement statement = null;
		// 用于接收返回结果
		boolean result = false;
		String sql = "update tab_city set id =?, cityId =?, city=?, father=? where id=?";
		try {
			statement = conn.prepareStatement(sql);
			statement.setInt(1, city.getId());
			statement.setString(2, city.getCityId());
			statement.setString(3, city.getCity());
			statement.setString(4, city.getFather());
			statement.setInt(5, city.getId());
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
	public City findByCity(String city) {
		ResultSet rSet =null;
		PreparedStatement statement = null;
		City city2=null;
		String sql = "select * from tab_city where city= ?";
		try {
			statement = conn.prepareStatement(sql);
			statement.setString(1, city);
			rSet = statement.executeQuery();
			
			while(rSet.next()){
				
				city2 = new City();
				city2.setId(rSet.getInt("id"));
				city2.setCityId(rSet.getString("cityId"));
				city2.setCity(rSet.getString("city"));
				city2.setFather(rSet.getString("father"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.colseAll(null, statement, rSet);
		}
		
		return city2;
	}

	


}
