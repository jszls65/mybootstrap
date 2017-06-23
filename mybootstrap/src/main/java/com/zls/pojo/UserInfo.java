package com.zls.pojo;
/**
 * 用户信息
 * @author jszls
 * @tablename userinfo
 */
public class UserInfo {
	private String userId;
	private String userName;
	private String password;
	private String addr;
	private int age = 0;
	private RoleInfo[] roles;
	private Department depart;
	
	
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
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
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public RoleInfo[] getRoles() {
		return roles;
	}
	public void setRoles(RoleInfo[] roles) {
		this.roles = roles;
	}
	public Department getDepart() {
		return depart;
	}
	public void setDepart(Department depart) {
		this.depart = depart;
	}
	
	
	
	
}
