package com.zls.util;

import net.sf.json.JSONObject;

public class JsonUtil {

	
	
	/**
	 * 将对象转换成json字符串
	 * @param obj
	 * @return
	 */
	public static String jsonToString(Object obj){
		if(obj == null)
			return null;
		JSONObject resultJSON = null ;
		try {
			resultJSON = JSONObject.fromObject(obj);
		} catch (Exception e) {
			
			return (String) obj;
		}   
		return resultJSON.toString();
	}
	
	
	
	public static void main(String[] args) {
		System.out.println(jsonToString("{123}"));
	}

	
}
