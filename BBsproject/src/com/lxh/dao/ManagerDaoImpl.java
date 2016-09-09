package com.lxh.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.lxh.config.HibernateSessionFactory;
import com.lxh.entity.Manager;
import com.lxh.entity.Question;
import com.lxh.entity.User;

@SuppressWarnings("deprecation")
public class ManagerDaoImpl extends UserDaoImpl implements ManagerDao {
	private Session session;
	
	private Query query;

	private Transaction transaction;
	@SuppressWarnings("unchecked")
	@Override
	public Manager judgeManager(Manager manager) {
		Manager manager2 = null;
		session = HibernateSessionFactory.getSession();
		String hql = "from Manager as manager where manager.managerName = ? and manager.managerPassword = ?";
		query = session.createQuery(hql);
		query.setString(0, manager.getManagerName());
		query.setString(1, manager.getManagerPassword());
		Iterator<Manager> iterator = query.list().iterator();
		if(iterator.hasNext()){ 
			manager2 = iterator.next();
		}
		session.close();
		return manager2;
	}
	@Override
	public void saveManager(Manager manager) {
		session=HibernateSessionFactory.getSession();
		transaction=session.beginTransaction();
		session.save(manager);
		transaction.commit();
		session.close();
		
	}

	

	@Override
	public int QuestionAmount() {
		int questionAmount = 0;
		session = HibernateSessionFactory.getSession();
		String hql = "select count(*) from Question";
		query = session.createQuery(hql);
		long  l = (Long)query.uniqueResult();
		questionAmount = (int)l;
		session.close();
		return questionAmount;

		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Question> allQuestion(int pageNumber, int pageSize) {
		session = HibernateSessionFactory.getSession();
		List<Question> allQuestion = new ArrayList<Question>();
		String hql = "from Question as question order by question.postTime desc";
		query = session.createQuery(hql);
		query.setFirstResult((pageNumber - 1)*pageSize);
		query.setMaxResults(pageSize);
		allQuestion = query.list();
		session.close();
		return allQuestion;

	}
	@Override
	public User findUser(int userId) {
		
		session=HibernateSessionFactory.getSession();
		User user=(User)session.get("com.lxh.entity.User", userId);
		
		session.close();
		return user;
	}
	
	@Override
	public void deleteQuestion(Question question) {
		session = HibernateSessionFactory.getSession();
		transaction = session.beginTransaction();
		session.delete(question);
		transaction.commit();
		session.close();
	}
	
	
	/**分页,返回当前页数和总页数*/
	public int[] pageNumber(int questionAmount,String pageNumberStr,int pageSize){
		int[] paging = new int[2];
		int pageNumber = 1;
		pageNumber = Integer.parseInt(pageNumberStr);
		if(pageNumber <= 0){
			pageNumber = 1;
		}
		int totalPage = 1;
		if(questionAmount > 0){
			totalPage = questionAmount%pageSize==0?(questionAmount/pageSize):(questionAmount/pageSize+1);
		}
		if(pageNumber > totalPage){
			pageNumber = totalPage;
		}
		paging[0] = pageNumber;
		paging[1] = totalPage;
		return paging;
	}

	



}
