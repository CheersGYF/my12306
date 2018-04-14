package com.neuedu.my12306.dao;

import java.util.List;

import com.neuedu.my12306.model.City;

public interface ICityDao extends IBaseDao{
	/**
	 * 通过id查找城市信息
	 * @param id 城市id
	 * @return 城市信息
	 */
	public City findCityById(int id);
	/**
	 * 根据城市表示查找城市信息
	 * @param cityId 城市标示
	 * @return 城市信息
	 */
	public City findCityByCityId(String cityId);
	/**
	 * 根据省份查找城市信息 - 用于省市联动 ajax查询
	 * @param province 省份
	 * @return 城市列表
	 */
	public List<City> findByProvince(String province);
	/**
	 * 删除城市信息
	 * @return 删除成功返回true 删除失败返回false
	 */
	public boolean deleteCity(City city);
	/**
	 * 增加城市信息
	 * @return 增加成功返回true 增加失败返回false
	 */
	public boolean addCity(City city);
	/**
	 * 修改城市信息
	 * @return 修改成功返回true 修改失败返回false
	 */
	public boolean editCity(City city);
	
	public City findByCity(String city);
}
