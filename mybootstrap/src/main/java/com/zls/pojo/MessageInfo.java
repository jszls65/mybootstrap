package com.zls.pojo;
/**
 * 信息实体
 * @author jszls
 *
 */
public class MessageInfo {
	String msgCode = "500";
	String msgDesc = "服务器端异常。";
	public String getMsgCode() {
		return msgCode;
	}
	public void setMsgCode(String msgCode) {
		this.msgCode = msgCode;
	}
	public String getMsgDesc() {
		return msgDesc;
	}
	public void setMsgDesc(String msgDesc) {
		this.msgDesc = msgDesc;
	}
	
	
	
}
