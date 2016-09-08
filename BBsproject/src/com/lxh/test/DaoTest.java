package com.lxh.test;

import com.lxh.dao.UserDaoImpl;

public class DaoTest {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
	UserDaoImpl ud=new UserDaoImpl();
	ud.findUser(2);
	
	}

}
