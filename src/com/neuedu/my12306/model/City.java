package com.neuedu.my12306.model;

public class City {
	// 属性
	private  int id; // 用户id
	private String cityId; // 城市id
	private String city; // 城市名称
	private String father; // 城市对应省份id
	// 构造方法
	/**
	 * 空的构造方法
	 */
	public City() {
		super();
	}
	/**
	 * 包含五个参数的构造方法
	 * @param id 用户id
	 * @param cityId 城市id
	 * @param city 城市名称
	 * @param father 对应省份id
	 */
	public City(int id, String cityId, String city, String father) {
		super();
		this.id = id;
		this.cityId = cityId;
		this.city = city;
		this.father = father;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCityId() {
		return cityId;
	}
	public void setCityId(String cityId) {
		this.cityId = cityId;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getFather() {
		return father;
	}
	public void setFather(String father) {
		this.father = father;
	}
	
	
}
