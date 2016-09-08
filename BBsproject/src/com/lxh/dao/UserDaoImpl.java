package com.lxh.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.lxh.config.HibernateSessionFactory;
import com.lxh.entity.Question;
import com.lxh.entity.User;
/**
 * 
 * @author lxh
 * @deprecated ʹ������������ӷ�ʽȥ�����ݳ־û�
 *
 */
public class UserDaoImpl implements UserDao {
private Session session;
@SuppressWarnings("unused")
private Query query;
private Transaction transaction;
	
	
	
	/**
 * @category �����û�
 * 
 */
	
	@Override
	public void saveUser(User user) {
		session=HibernateSessionFactory.getSession();
		transaction=session.beginTransaction();
		session.save(user);
		transaction.commit();
		session.close();
		
	}
/**
 * �����û�
 * 
 */
	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		session=HibernateSessionFactory.getSession();
		transaction=session.beginTransaction();
		session.update(user);
		transaction.commit();
		session.close();
	}
	/**
	 * �����û�
	 */

	@Override
	public User findUser(int userId) {
		// TODO Auto-generated method stub
		session=HibernateSessionFactory.getSession();
		User user=(User)session.get("com.lxh.entity.User", userId);
		
		session.close();
		return user;
	}
/**
 * ��������û�������
 * 
 */
	@Override
	public List<Question> personalQuestion(User user, int pageNumber, int pageSize) {
		List<Question> personalQuestion = new ArrayList<Question>();
		session = HibernateSessionFactory.getSession();
		String hql = "from Question as question where question.user.userId = ? order by question.postTime desc";
		query = session.createQuery(hql);
		query.setInteger(0, user.getUserId());
		query.setFirstResult((pageNumber - 1)*pageSize);
		query.setMaxResults(pageSize);
		personalQuestion = query.list();
		session.close();
		return personalQuestion;
	}

	

	@Override
	public int personalQuestionAmount(User user) {
		int personalQuestionAmount = 0;
		session = HibernateSessionFactory.getSession();
		String hql = "select count(*) from Question as question where question.user.userId = ?";
		query = session.createQuery(hql);
		query.setInteger(0, user.getUserId());
		long  l = (Long)query.uniqueResult();
		personalQuestionAmount = (int)l;
		session.close();
		return personalQuestionAmount;

	}
	/**
	 * ����û�
	 */

	@Override
	public User judgeUser(User user) {
		User user2 = null;
		session = HibernateSessionFactory.getSession();
		String hql = "from User as user where user.userName = ? and user.userPassword = ?";
		query = session.createQuery(hql);
		query.setString(0, user.getUserName());
		query.setString(1, user.getUserPassword());
		Iterator<User> iterator = query.list().iterator();
		if(iterator.hasNext()){
			user2 = iterator.next();
		}
		session.close();
		return user2;

	}
	/**
	 * ��ҳ,���ص�ǰҳ������ҳ��
	 * 
	 * */
	public int[] pageNumber(int postAmount,String pageNumberStr,int pageSize){
		int[] paging = new int[2];
		int pageNumber = 1;
		pageNumber = Integer.parseInt(pageNumberStr);
		if(pageNumber <= 0){
			pageNumber = 1;
		}
		int totalPage = 1;
		if(postAmount > 0){
			totalPage = postAmount%pageSize==0?(postAmount/pageSize):(postAmount/pageSize+1);
		}
		if(pageNumber > totalPage){
			pageNumber = totalPage;
		}
		paging[0] = pageNumber;
		paging[1] = totalPage;
		return paging;
	}

}
