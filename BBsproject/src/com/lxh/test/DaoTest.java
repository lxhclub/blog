package com.lxh.test;

import java.sql.Timestamp;

import com.lxh.dao.ManagerDao;
import com.lxh.dao.ManagerDaoImpl;
import com.lxh.dao.UserDao;
import com.lxh.dao.UserDaoImpl;
import com.lxh.entity.Manager;
import com.lxh.entity.Question;
import com.lxh.entity.User;

public class DaoTest {
	

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		User user=new User();
	ManagerDao md=new ManagerDaoImpl();
     Question question=new Question(6);
    
	System.out.println();
	UserDao userd=new UserDaoImpl();
	
	//System.out.println(userd.personalQuestion(userd.findUser(2), 1, 3));
	/*user.setUserName("lisi");
	user.setUserPassword("123456");
	user.setUserEmail("54785245@qq.com");
	user.setUserNickname("lis");
	user.setSex(1);
	user.setUserBirthday(new Timestamp(System.currentTimeMillis()));
	user.setUserPoints(12);
	user.setUserId(6);
	//userd.saveUser(user);
	 question.setUser(user);
     question.setTopic("�������G20��ʲô�뷨");
     question.setPostTime(new Timestamp(System.currentTimeMillis()));
     question.setQuestionId(12);
     question.setMatter("g20�ǹ����ʼ��ë�µı�֤������������У�������Ҫ�Ĳ����������ö���������Ҫ�����ͷ�չһ��һ·��ս�ԣ������꿩ʱ���ﹲӮ");
    userd.deleteQuestion(question);*/
    Manager manager=new Manager("lxh","admin");
  /* manager.setManagerId(02);
   manager.setManagerName("lx");
   manager.setManagerPassword("123123");
   md.saveManager(manager);*/
   System.out.println(md.judgeManager(manager).getManagerName());
   md.QuestionAmount();
	 
	
	}

}
