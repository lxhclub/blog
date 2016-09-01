package dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import dao.GoodsDao;
import entity.Goods;
import utils.JdbcUtils;

public class GoodsDaoImpl implements GoodsDao {

	@Override
	public void add(Goods goods) {
	try{
		QueryRunner runner=new QueryRunner(JdbcUtils.getDataSource());
		String sql="insert into goods(id,name,field,price,image,description,category_id)values(?,?,?,?,?,?,?)";
	    Object params[]={goods.getId(),goods.getName(),goods.getField(),goods.getPrice(),goods.getImage(),goods.getDescription(),goods.getCategory_id()};
	    runner.update(sql,params);
	}catch(SQLException e){
		e.printStackTrace();
		throw new RuntimeException(e);
	}
		
	}

	@Override
	public Goods find(String id) {
		// TODO Auto-generated method stub
		try {
			QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "select * from goods where id=?";
			return (Goods)runner.query(sql, id, new BeanHandler(Goods.class));
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<Goods> getPageData(int startindex, int pagesize) {
		// TODO Auto-generated method stub
		try {
			QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "select * from goods limit ?,?";
			Object params[] = {startindex, pagesize};
			return (List<Goods>)runner.query(sql, params, new BeanListHandler(Goods.class));
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}

	@Override
	public int getTotalRecord() {
		// TODO Auto-generated method stub
		try {
			QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "select count(*) from goods";
			long totalrecord = (Long)runner.query(sql, new ScalarHandler());
			return (int)totalrecord;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<Goods> getPageData(int startindex, int pagesize, String category_id) {
		// TODO Auto-generated method stub
		try{
			QueryRunner runner=new QueryRunner(JdbcUtils.getDataSource());
			String sql="select * from goods where category=? limit ?£¬?";
			Object params[]={category_id,startindex,pagesize};
			return (List<Goods>)runner.query(sql, params, new BeanListHandler(Goods.class));
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public int getTotalRecord(String category_id) {
		// TODO Auto-generated method stub
		try {
			QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "select count(*) from goods where category_id=?";
			long totalrecord = (Long)runner.query(sql, category_id, new ScalarHandler());
			return (int)totalrecord;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

}
