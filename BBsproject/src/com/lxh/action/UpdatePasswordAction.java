package com.lxh.action;

import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.lxh.dao.UserDao;
import com.lxh.dao.UserDaoImpl;
import com.lxh.entity.User;
import com.opensymphony.xwork2.ActionSupport;



@SuppressWarnings("serial")
public class UpdatePasswordAction extends ActionSupport{

	private String userPassword;
	private String userNewPassword;
	private String userRePassword;
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserNewPassword() {
		return userNewPassword;
	}
	public void setUserNewPassword(String userNewPassword) {
		this.userNewPassword = userNewPassword;
	}
	public String getUserRePassword() {
		return userRePassword;
	}
	public void setUserRePassword(String userRePassword) {
		this.userRePassword = userRePassword;
	}
	public String execute(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("loginUser");
		user.setUserPassword(userNewPassword);
		UserDao userDao = new UserDaoImpl();
		userDao.updateUser(user);
		return SUCCESS;
	}
	public void validate(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("loginUser");
		if(!userPassword.equals(user.getUserPassword())){
			addFieldError("userPassword", "密码不正确！");
		}
		if(!Pattern.matches("\\w{6,12}", userNewPassword)){
			addFieldError("userNewPassword", "密码请使用6-12位字母或数字！");
		}
		if(!userRePassword.equals(userNewPassword)){
			addFieldError("userRePassword", "两次输入的密码不一致！");
		}
	}
}
