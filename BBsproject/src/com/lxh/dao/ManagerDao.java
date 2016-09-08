package com.lxh.dao;

import java.util.List;

import com.lxh.entity.Manager;
import com.lxh.entity.Question;
import com.lxh.entity.User;

public interface ManagerDao {
	 public Manager judgeManager(Manager manager);
	 public int QuestionAmount();
	 public List<Question> allQuestion(int pageNumber ,int pageSize);
	 public User findUser(int userId);
	 public void deleteQuestion(Question question);
	 
}
