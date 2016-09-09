package com.lxh.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.lxh.dao.UserDao;
import com.lxh.dao.UserDaoImpl;
import com.lxh.entity.Question;
import com.lxh.entity.User;
import com.opensymphony.xwork2.ActionSupport;



@SuppressWarnings("serial")
public class DeleteMyQuestionAction extends ActionSupport{

	private String pageNumber;
	
	public String getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(String pageNumber) {
		this.pageNumber = pageNumber;
	}

	public String execute(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String questionIdStr = request.getParameter("questionId");
		pageNumber = request.getParameter("pageNumber");
		if(pageNumber == null || "".equals(pageNumber.trim())){
			pageNumber = "1";
		}
		int questionId = Integer.parseInt(questionIdStr);
		UserDao userDao = new UserDaoImpl();
		Question question = userDao.findQuestion(questionId);
		User user =question.getUser();
		user.setUserPoints(user.getUserPoints()-3);
		userDao.deleteQuestion(question);
		userDao.updateUser(user);
		return SUCCESS;
	}
}
