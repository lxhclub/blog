package com.lxh.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.lxh.dao.ManagerDao;
import com.lxh.dao.ManagerDaoImpl;
import com.lxh.entity.Manager;
import com.opensymphony.xwork2.ActionSupport;
@SuppressWarnings("serial")
public class ManagerLoginAction extends ActionSupport{

	private Manager manager;
	
	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	public String execute(){
			return SUCCESS;
	}
	
	public void validate(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		ManagerDao managerDao = new ManagerDaoImpl();
		Manager manager2 = managerDao.judgeManager(manager);
		if(manager2 != null){
			if(session.getAttribute("loginUser") != null){
				session.removeAttribute("loginUser");
			}
			if(session.getAttribute("loginManager") != null){
				session.removeAttribute("loginManager");
			}
			session.setAttribute("loginManager", manager2);
		}else{
			addFieldError("manager2.managerName", "用户名或密码有误！");
		}
	}
	
}
