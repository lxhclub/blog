package dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import dao.UserDao;
import entity.User;
import utils.JdbcUtils;

public class UserDaoImpl implements UserDao{

	@Override
	public void add(User user) {
		// TODO Auto-generated method stub
		try{
			QueryRunner runner=new QueryRunner(JdbcUtils.getDataSource());
		   String sql="insert into user(id,username,password,phone,cellphone,address,email)values(?,?,?,?,?,?,?)";
		   Object params[]={user.getId(),user.getUsername(),user.getPassword(),user.getPhone(),user.getCellphone(),user.getAddress(),user.getEmail()};
		   runner.update(sql,params);
		
		
		
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		
	}

	@Override
	public User find(String id) {
		// TODO Auto-generated method stub
		try{
			QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "select * from user where id=?";
			return (User)runner.query(sql, id, new BeanHandler(User.class));
		} catch(Exception e){
			throw new RuntimeException(e);
		}
	}

	@Override
	public User find(String username, String password) {
		// TODO Auto-generated method stub
		try{
			QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "select * from user where username=? and password=?";
			Object params[] = {username, password};
			return (User)runner.query(sql, params, new BeanHandler(User.class));
		} catch(Exception e){
			throw new RuntimeException(e);
		}
	}

}
