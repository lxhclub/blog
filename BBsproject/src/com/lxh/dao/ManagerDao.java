package com.lxh.dao;

import java.util.List;

import com.lxh.entity.Manager;
import com.lxh.entity.Question;

public interface ManagerDao {
	 public Manager judgeManager(Manager manager);
	 public boolean judgeUserName(String userName);
	 public void saveQuestion(Question question);
	 public void deleteQuestion(Question question);
	 public int QuestionAmount();
	 public List<Question> allQuestion(int pageNumber ,int pageSize);
}
