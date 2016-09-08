package com.lxh.entity;

import java.sql.Timestamp;

public class User implements java.io.Serializable {
	private Integer userId;
	private String userName;
	private String userPassword;
	private String userEmail;
	private String userNikename;
	private Timestamp userBirthday;
	private Integer sex;
	private Integer userPoints;
	private String userRemark;
	public User(String userName, String userPassword, String userEmail, String userNikename, Timestamp userBirthday,
			Integer sex, Integer userPoints) {
		super();
		this.userName = userName;
		this.userPassword = userPassword;
		this.userEmail = userEmail;
		this.userNikename = userNikename;
		this.userBirthday = userBirthday;
		this.sex = sex;
		this.userPoints = userPoints;
	}
	public User(String userName, String userPassword, String userEmail, String userNikename, Timestamp userBirthday,
			Integer sex, Integer userPoints, String userRemark) {
		super();
		this.userName = userName;
		this.userPassword = userPassword;
		this.userEmail = userEmail;
		this.userNikename = userNikename;
		this.userBirthday = userBirthday;
		this.sex = sex;
		this.userPoints = userPoints;
		this.userRemark = userRemark;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserNikename() {
		return userNikename;
	}
	public void setUserNikename(String userNikename) {
		this.userNikename = userNikename;
	}
	public Timestamp getUserBirthday() {
		return userBirthday;
	}
	public void setUserBirthday(Timestamp userBirthday) {
		this.userBirthday = userBirthday;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public Integer getUserPoints() {
		return userPoints;
	}
	public void setUserPoints(Integer userPoints) {
		this.userPoints = userPoints;
	}
	public String getUserRemark() {
		return userRemark;
	}
	public void setUserRemark(String userRemark) {
		this.userRemark = userRemark;
	}

}
