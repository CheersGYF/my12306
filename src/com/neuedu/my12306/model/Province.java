package com.neuedu.my12306.model;

public class Province {
	// 属性
	private int id; // 用户id
	private String provinceId; // 省份id
	private String province; // 省份名称
	
	// 构造方法
	/**
	 *  空的构造方法
	 */
	public Province() {
		super();
	}
	/**
	 * 包含三个参数的构造方法
	 * @param id 用户id
	 * @param provinceId 省份id
	 * @param province 省份名称
	 */
	public Province(int id, String provinceId, String province) {
		super();
		this.id = id;
		this.provinceId = provinceId;
		this.province = province;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProvinceId() {
		return provinceId;
	}
	public void setProvinceId(String provinceId) {
		this.provinceId = provinceId;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	
}
