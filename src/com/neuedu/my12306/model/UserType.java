package com.neuedu.my12306.model;

public class UserType {
	private int id; // 用户id
	private String content; // 旅客类型
	// 构造方法
	/**
	 * 空的构造方法
	 */
	public UserType(){}
	/**
	 * 包含有两个参数的构造方法
	 * @param id 用户id
	 * @param content 旅客类型
	 */
	public UserType(int id,String content ){
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
