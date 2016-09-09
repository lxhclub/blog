package com.lxh.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.lxh.dao.UserDao;
import com.lxh.dao.UserDaoImpl;
import com.lxh.entity.User;
import com.opensymphony.xwork2.ActionSupport;



@SuppressWarnings("serial")
public class PersonalManageAction extends ActionSupport{

	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	public String execute(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		UserDao userDao = new UserDaoImpl();
		User user2 = (User)session.getAttribute("loginUser");
		user2.setUserNickname(user.getUserNickname());
		user2.setUserBirthday(user.getUserBirthday());
		user2.setUserEmail(user.getUserEmail());
		user2.setUserRemark(user.getUserRemark());
		user2.setSex(user.getSex());
		userDao.updateUser(user2);
		return SUCCESS;
	}

}
