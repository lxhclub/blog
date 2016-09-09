package com.lxh.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.lxh.dao.UserDao;
import com.lxh.dao.UserDaoImpl;
import com.lxh.entity.Question;
import com.lxh.entity.User;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class PersonalQuestionAction extends ActionSupport{

	private List<Question> personalQuestion;
	private int totalPage;
	private int pageNumber;
	private int pageSize;
	
	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	

	public List<Question> getPersonalQuestion() {
		return personalQuestion;
	}

	public void setPersonalQuestion(List<Question> personalQuestion) {
		this.personalQuestion = personalQuestion;
	}

	public String execute(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("loginUser");
		String pageNumberStr = request.getParameter("pageNumber");
		if(pageNumberStr == null || "".equals(pageNumberStr.trim())){
			pageNumberStr = "1";
		}
		UserDao userDao = new UserDaoImpl();
		pageSize = 10;
		int questionAmount = userDao.personalQuestionAmount(user);
		int[] paging = new int[2];
		paging = ((UserDaoImpl) userDao).pageNumber(questionAmount, pageNumberStr, pageSize);
		pageNumber = paging[0];
		totalPage = paging[1];
		personalQuestion = userDao.personalQuestion(user,pageNumber,pageSize);
		return SUCCESS;
	}
		
}
