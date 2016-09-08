package com.lxh.dao;

import java.util.List;

import com.lxh.entity.Question;
import com.lxh.entity.User;

public interface UserDao {
	public void saveUser(User user);
	 public void updateUser(User user);
	 public User findUser(int userId);
	 public List<Question> personalQuestion(User user,int pageNumber,int pageSize);
	 public int personalQuestionAmount(User user);
	 public User judgeUser(User user);

}
