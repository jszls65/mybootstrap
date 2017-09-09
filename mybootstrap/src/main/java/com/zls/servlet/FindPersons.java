package com.zls.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.zls.pojo.MessageInfo;
import com.zls.pojo.UserInfo;
import com.zls.service.LoginService;
import com.zls.util.JsonUtil;

import net.sf.json.JSONObject;

/**
 * 登录
 * Servlet implementation class FindPersons
 */
public class FindPersons extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MessageInfo msg = new MessageInfo();

	
	private static final Logger LOG = Logger.getLogger(FindPersons.class); 
    /**
     * Default constructor. 
     */
    public FindPersons() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String opcode = request.getParameter("opcode");
		System.out.println("opcode:"+opcode);
	    LOG.info(this.getClass().getName()+" doPost opcode"+JsonUtil.jsonToString(opcode));
	    
	    if("login".equals(opcode)){
	    	/*
	    	 * 封装用户信息
	    	 */
	    	UserInfo user = new UserInfo();
	    	String userId = request.getParameter("userId");
	    	String password = request.getParameter("password");
			user.setUserId(userId);
			user.setPassword(password);
			LoginService login = new LoginService(user);
			msg = login.login();
			
	    }
	    
	    
	    LOG.info(this.getClass().getName()+" doPost msg"+JsonUtil.jsonToString(msg));
	    //写法固化
	    response.setContentType("application/json; charset=utf-8");
	    PrintWriter out = response.getWriter();  
	    out.println(JsonUtil.jsonToString(msg));   
	    out.flush();   
	    out.close();   
	}
	
	
	

}
