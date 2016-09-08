package com.lxh.entity;

import java.sql.Timestamp;

@SuppressWarnings("serial")
public class Question implements java.io.Serializable {
	private Integer questionId;
	private User user;
	private String topic;
	private String matter;
	private Timestamp postTime;
	
	public Question() {
		
	}
public Question(Integer questionId) {
	this.questionId=questionId;
	
		
	}
	public Question(Integer questionId, User user, String topic, String matter, Timestamp postTime) {
		super();
		this.questionId = questionId;
		this.user = user;
		this.topic = topic;
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
	public String getTopic() {
		return this.topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
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
