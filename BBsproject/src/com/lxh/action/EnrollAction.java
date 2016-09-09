package com.lxh.action;

import com.lxh.dao.UserDao;
import com.lxh.dao.UserDaoImpl;
import com.lxh.entity.User;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class EnrollAction extends ActionSupport{

	private User user;
	private String userRePassword;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public String getUserRePassword() {
		return userRePassword;
	}

	public void setUserRePassword(String userRePassword) {
		this.userRePassword = userRePassword;
	}

	public String execute(){
		if(user != null){
			user.setUserPoints(0);
			UserDao userDao = new UserDaoImpl();
			userDao.saveUser(user);
		}
		return SUCCESS;
	}
	
	public void validate(){
		UserDao userDao = new UserDaoImpl();
		boolean flag = userDao.judgeUserName(user.getUserName());
		if(flag){
			addFieldError("user.userName", "用户名已经存在！");
		}
		if(!userRePassword.equals(user.getUserPassword()) ){
			addFieldError("userRePassword", "两次输入的密码不一致！");
		}
	}
}
