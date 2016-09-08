package com.lxh.entity;

import java.sql.Timestamp;

public class Question implements java.io.Serializable {
	private Integer questionId;
	private User user;
	private String totic;
	private String matter;
	private Timestamp postTime;
	public Question(Integer questionId, User user, String totic, String matter, Timestamp postTime) {
		super();
		this.questionId = questionId;
		this.user = user;
		this.totic = totic;
		this.matter = matter;
		this.postTime = postTime;
	}
	public Integer getQuestionId() {
		return questionId;
	}
	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getTotic() {
		return this.totic;
	}
	public void setTotic(String totic) {
		this.totic = totic;
	}
	public String getMatter() {
		return this.matter;
	}
	public void setMatter(String matter) {
		this.matter = matter;
	}
	public Timestamp getPostTime() {
		return this.postTime;
	}
	public void setPostTime(Timestamp postTime) {
		this.postTime = postTime;
	}

}
