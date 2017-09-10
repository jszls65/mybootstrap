package com.zls.service;

import org.apache.log4j.Logger;
import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCursor;
import com.zls.db.DBUtil;
import com.zls.pojo.MessageInfo;
import com.zls.pojo.UserInfo;

public class LoginService {
	
	/**
	 * 日志句柄
	 */
	private static final Logger LOG = Logger.getLogger(LoginService.class); 
	private MessageInfo msg = new MessageInfo();
	private UserInfo user = null;
	public LoginService(UserInfo user) {
		this.user = user;
	}

	/**
	 * 登录
	 * @return
	 */
	public MessageInfo login() {
		LOG.info("LoginService login user:");
		try {
			if(user == null || "".equals(user.getUserId())){
				return msg;
			}
			Document doc = new Document();
			doc.append("userid", user.getUserId()).append("password", user.getPassword());
			FindIterable<Document> userList = DBUtil.find("userinfo", doc );
			MongoCursor<Document> iter = userList.iterator();
			
			if(iter.hasNext()){
				msg.setMsgCode("200");
			}else{
				msg.setMsgCode("111");
			}
		} catch (Exception e) {
			LOG.error(e);
		}
		
		return msg;
	}
	
}
