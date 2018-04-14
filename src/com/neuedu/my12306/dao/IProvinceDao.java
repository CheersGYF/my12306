package com.neuedu.my12306.dao;

import java.util.List;

import com.neuedu.my12306.model.City;
import com.neuedu.my12306.model.Province;

public interface IProvinceDao extends IBaseDao {
	/**
	 * 根据id查找省份
	 * @param id 省份id
	 * @return 省份信息
	 */
	 
	public Province findByCity(City city);
	/**
	 * 查询所有省份
	 * 
	 * @return 返回省份列表
	 */
	public List<Province> findAllProvince();
	/**
	 * 删除证件信息
	 * @return 删除成功返回true 删除失败返回false
	 */
	public boolean deleteProvince(Province province);
	/**
	 * 增加证件类型
	 * @return 增加成功返回true 增加失败返回false
	 */
	public boolean addProvince(Province province);
	/**
	 * 修改证件信息
	 * @return 修改成功返回true 修改失败返回false
	 */
	public boolean editProvince(Province province);
}
