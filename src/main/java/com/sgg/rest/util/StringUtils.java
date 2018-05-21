package com.sgg.rest.util;

public class StringUtils {
	public static String upperCase( String content) {
		return content.toUpperCase();
	}
	
	public static String trim( String content) {
		return content.trim();
	}
	
	public static boolean IsNull(String content) {
		if(content!=null && !content.equals("")) {
			return true;
		}
		return false;
	}
	public static boolean IsNull(Integer content) {
		if(content!=null&& ""!=content+"") {
			return true;
		}
		return false;
	}
}
