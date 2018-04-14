package com.neuedu.my12306.model;

import java.util.Date;

/**
 * 设计数据结构
 * @author hp
 *
 */
public class User {
	// 属性
	private int id; // 用户id
	private String userName; // 用户昵称
	private String password; // 用户密码
	private String rule; // 用户权限
	private String sex; // 用户性别
	private int city; // 用户所在城市编号
	private String realName; // 用户真实姓名
	private int certType; // 证件号码
	private String cert; // 证件类型
	private Date birthday; // 用户生日
	private int userType; // 用户类型
	private String content; // 备注信息
	private String status; // 用户状态
	private String loginIp; // 用户登录ip
	private String imagePath; // 用户头像路径
	//
	/**
	 * 1.java语言会默认为每个类添加一个空参构造函数
	 * 2.如果显示定义了带参构造函数，则会屏蔽孔灿构造函数；如果需要使用空参构造函数，则必须显示定义
	 * 3.构造函数的重载，方法名相同，参数列表不同（参数个数不同，类型不同，或类型相同顺序不同）
	 * what： 方法名与类名相同，没有返回值类型（注意：不返回void类型）
	 * why: 用于程序执行时实例化对象时使用的（实例化过程会根据构造方法申请内存）
	 * when：
	 * how：
	 */
	
	/**
	 * 空的构造方法
	 */
	public User() {
		super();
	}
	
	/**
	 * 包含有15个参数的构造方法
	 * @param id  用户id
	 * @param userName  用户名
	 * @param password  用户密码
	 * @param rule  用户权限
	 * @param sex  用户性别
	 * @param city  用户所在城市
	 * @param realName  用户真实姓名
	 * @param certType 用户证件类型
	 * @param cert  用户证件编号
	 * @param birthday  用户生日
	 * @param userType  用户类型
	 * @param content  备注信息
	 * @param status  用户状态
	 * @param loginIp 用户登录ip
	 * @param imagePath  用户头像路径
	 */
	public User(int id, String userName, String password, String rule, String sex, int city, String realName,
			int certType, String cert, Date birthday, int userType, String content, String status, String loginIp,
			String imagePath) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.rule = rule;
		this.sex = sex;
		this.city = city;
		this.realName = realName;
		this.certType = certType;
		this.cert = cert;
		this.birthday = birthday;
		this.userType = userType;
		this.content = content;
		this.status = status;
		this.loginIp = loginIp;
		this.imagePath = imagePath;
	}
	
	//构造方法
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRule() {
		return rule;
	}
	public void setRule(String rule) {
		this.rule = rule;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getCity() {
		return city;
	}
	public void setCity(int city) {
		this.city = city;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public int getCertType() {
		return certType;
	}
	public void setCertType(int certType) {
		this.certType = certType;
	}
	public String getCert() {
		return cert;
	}
	public void setCert(String cert) {
		this.cert = cert;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public int getUserType() {
		return userType;
	}
	public void setUserType(int userType) {
		this.userType = userType;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getLoginIp() {
		return loginIp;
	}
	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	
	
}
