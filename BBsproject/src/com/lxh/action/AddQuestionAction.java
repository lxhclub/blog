package com.lxh.action;

import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.lxh.dao.UserDao;
import com.lxh.dao.UserDaoImpl;
import com.lxh.entity.Question;
import com.lxh.entity.User;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class AddQuestionAction extends ActionSupport{

	private Question question;

	
	
	public Question getQuestion() {
		return question;
	}



	public void setQuestion(Question question) {
		this.question = question;
	}



	public String execute(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("loginUser");
		UserDao userDao = new UserDaoImpl();
		question.setPostTime(new Timestamp(new Date().getTime()));
		question.setUser(user);
		userDao.saveQuestion(question);
		user.setUserPoints(user.getUserPoints()+3);
		userDao.updateUser(user);
		return SUCCESS;
	} 
	
}
