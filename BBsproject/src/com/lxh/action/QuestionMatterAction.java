package com.lxh.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.lxh.dao.UserDao;
import com.lxh.dao.UserDaoImpl;
import com.lxh.entity.Question;
import com.opensymphony.xwork2.ActionSupport;
@SuppressWarnings("serial")
public class QuestionMatterAction extends ActionSupport{
	private Question question;
	
	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}


	public String execute(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String questionIdStr = request.getParameter("questionId");
		int questionId = Integer.parseInt(questionIdStr);
		UserDao userDao = new UserDaoImpl();
		question = userDao.findQuestion(questionId);
		return SUCCESS;
	}
}
