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
 * @deprecated 使用最基本的连接方式去做数据持久化
 *
 */
public class UserDaoImpl implements UserDao {
private Session session;
private Query query;
private Transaction transaction;
	
	
	
	/**
 * @category 保存用户
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
 * 更新用户
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
	 * 查找用户
	 */

	
/**
 * 例句个人用户的问题
 * 
 */
	@SuppressWarnings("unchecked")
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
	 * 检查用户
	 */

	@SuppressWarnings("unchecked")
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
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean judgeUserName(String userName) {
		boolean flag = true;
		session = HibernateSessionFactory.getSession();
		String hql = "from User as user where user.userName = ?";
		query = session.createQuery(hql);
		query.setString(0, userName);
		Iterator<User> iterator = query.list().iterator();
		if(!iterator.hasNext()){
			flag = false;
		}
		session.close();
		return flag;
	}
	
	public Question findQuestion(int questionId){
		session = HibernateSessionFactory.getSession();
		Question question = (Question) session.get("com.lxh.entity.Question", questionId);
		session.close();
		return question;
	}

	

	@Override
	public void saveQuestion(Question question) {
		session = HibernateSessionFactory.getSession();
		transaction = session.beginTransaction();
		session.save(question);
		transaction.commit();
		session.close();
		
	}

	@Override
	public void deleteQuestion(Question question) {
		session = HibernateSessionFactory.getSession();
		transaction = session.beginTransaction();
		session.delete(question);
		transaction.commit();
		session.close();
	}
	
	
	
	/**
	 * 分页,返回当前页数和总页数
	 * 
	 * */
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
