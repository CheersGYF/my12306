package com.neuedu.my12306.utils;

/**
 * 字符串操作工具类
 * 
 * @author chensw
 *
 */
public final class StringUtil {

	/**
	 * 字符串截取方法
	 * 
	 * @param data
	 * @param len
	 * @return
	 */
	public static String subString(String data, int len) {

		if (data == null) {
			return null;
		}

		if (data.length() >= len) {
			return data.substring(0, len - 1) + "...";
		}
		return data;

	}
}
