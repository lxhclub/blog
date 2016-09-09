package com.lxh.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.lxh.dao.ManagerDao;
import com.lxh.dao.ManagerDaoImpl;
import com.lxh.dao.UserDaoImpl;
import com.lxh.entity.Question;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class AllQuestionAction extends ActionSupport{

	private List<Question> allQuestion;
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

	

	public List<Question> getAllQuestion() {
		return allQuestion;
	}

	public void setAllQuestion(List<Question> allQuestion) {
		this.allQuestion = allQuestion;
	}

	public String execute(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String pageNumberStr = request.getParameter("pageNumber");
		if(pageNumberStr == null || "".equals(pageNumberStr.trim())){
			pageNumberStr = "1";
		}
		ManagerDao managerDao = new ManagerDaoImpl();
		pageSize = 10;
		int questionAmount = managerDao.QuestionAmount();
		int[] paging = new int[2];
		paging = ((ManagerDaoImpl) managerDao).pageNumber(questionAmount, pageNumberStr, pageSize);
		pageNumber = paging[0];
		totalPage = paging[1];
		allQuestion = managerDao.allQuestion(pageNumber, pageSize);
		return SUCCESS;
	}
		
}
