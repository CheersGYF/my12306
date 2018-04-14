package com.neuedu.my12306.model;

public class CertType {
	// 属性
	private int id; // 用户id
	private String content; // 证件类型
	
	// 构造方法
	/**
	 * 空的构造方法
	 */
	public CertType() {
		//super();
	}
	/**
	 * 包含两个参数的构造方法
	 * @param id 用户id
	 * @param content 证件类型
	 */
	public CertType(int id, String content) {
		//super();
		this.id = id;
		this.content = content;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	
	
}
