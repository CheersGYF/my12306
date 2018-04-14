package com.neuedu.my12306.utils;

public class DBUtilStrTo {
	
	/**
	 * 字符串转int类
	 * @param string 需要转换的字符串
	 * @return integer值
	 */
	public static int strToInt(String string){
		if(string==null ||string.trim().length()==0){
			return 0;
		}else{
			return Integer.parseInt(string);
		}
	}
}
