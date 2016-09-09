package com.lxh.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.lxh.dao.ManagerDao;
import com.lxh.dao.ManagerDaoImpl;
import com.lxh.entity.User;
import com.opensymphony.xwork2.ActionSupport;


@SuppressWarnings("serial")
public class UserInformationAction extends ActionSupport{

	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public String execute(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String userIdStr = request.getParameter("userId");
		int userId = Integer.parseInt(userIdStr);
		ManagerDao managerDao = new ManagerDaoImpl();
		user = managerDao.findUser(userId);
		return SUCCESS;
	}
}
