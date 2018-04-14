package com.neuedu.my12306.dao;

import java.sql.Connection;

/**
 * 
 * 设计一个baseDao 用于设置jdbc的connection连接
 * @author hp
 *
 */
public interface IBaseDao {
	
	/**
	 * 接口方法默认是public，接口的方法没有方法体（注意：在jdk1.8后可以有默认的方法）
	 * 接口的方法都是抽象方法abstract
	 * 方法名前面的一定是返回值类型，返回值前面的是修饰符号，如果修饰符号有多个修饰符号的顺序可以互相颠倒
	 * @param conn jdbc连接
	 */
	abstract public void setConnection(Connection conn);
	 
}
