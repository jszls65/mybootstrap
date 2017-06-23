package com.zls.util;

import net.sf.json.JSONObject;

public class JsonUtil {

	
	
	/**
	 * 将对象转换成json字符串
	 * @param obj
	 * @return
	 */
	public static String jsonToString(Object obj){
		JSONObject resultJSON = JSONObject.fromObject(obj);   
		return resultJSON.toString();
	}

	
}
