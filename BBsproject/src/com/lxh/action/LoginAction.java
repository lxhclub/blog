package com.lxh.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.lxh.dao.UserDao;
import com.lxh.dao.UserDaoImpl;
import com.lxh.entity.User;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public String execute(){
		return SUCCESS;
	}
	@SuppressWarnings("deprecation")
	public void validate(){
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		UserDao userd=new UserDaoImpl();
		if(user!=null){
			User user2=userd.judgeUser(user);
			if(user2!=null){
				if(session.getAttribute("loginuser")!=null){
					session.removeAttribute("loginuser");
					
				}
				session.setAttribute("loginuser", user2);
			}else{
				addFieldError("user.username","用户名或密码错误");
			}
		}
	}
	

}
