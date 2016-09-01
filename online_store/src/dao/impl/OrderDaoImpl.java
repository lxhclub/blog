package dao.impl;

import java.awt.print.Book;
import java.util.List;
import java.util.Set;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import dao.OrderDao;
import entity.Goods;
import entity.Order;
import entity.OrderItem;
import entity.User;
import utils.JdbcUtils;

public class OrderDaoImpl implements OrderDao {

	@Override
	public void add(Order order) {
		try{QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
		//1. 把order的基本信息保存到order表
		String sql = "insert into orders(id,ordertime,price,state,user_id) values(?,?,?,?,?)";
		Object params[] = {order.getId(), order.getOrdertime(), order.getPrice(), order.isState(), order.getUser().getId()};
        runner.update(sql, params);
        Set<OrderItem>set=order.getOrderitems();
        for(OrderItem item:set){
        	sql="insert into orderitem(id,quantity,price,order_id,goods_id)values(?,?,?,?,?)";
        	params = new Object[]{item.getId(), item.getQuantity(), item.getPrice(), order.getId(), item.getGoods().getId()};
			runner.update(sql, params);
        }
        }catch(Exception e){
        	e.printStackTrace();
        	throw new RuntimeException(e);
        }
	}

	@Override
	public Order find(String id) {
		// TODO Auto-generated method stub
		try{
			QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
			//1.找出订单的基本信息
			String sql = "select * from orders where id=?";
			Order order = (Order) runner.query(sql, id, new BeanHandler(Order.class));
			//2.找出订单中所有的订单项
			sql = "select * from orderitem where order_id=?";
			List<OrderItem> list = (List<OrderItem>) runner.query(sql, id, new BeanListHandler(OrderItem.class));
			for(OrderItem item : list){
				sql = "select book.* from orderitem,goods where orderitem.id=? and orderitem.goods_id=goods.id";
				Goods goods = (Goods) runner.query(sql, item.getId(), new BeanHandler(Goods.class));
				item.setGoods(goods);
			}
			//把找出的订单项放进order
			order.getOrderitems().addAll(list);
			//3.找出订单属于哪个用户
			sql = "select * from orders,user where orders.id=? and orders.user_id=user.id";
			User user = (User) runner.query(sql, order.getId(), new BeanHandler(User.class));
			order.setUser(user);
			return order;
			
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	

	@Override
	public List<Order> getAll(boolean state) {
		try{
			QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "select * from orders where state=?";
			List<Order> list = (List<Order>) runner.query(sql, state, new BeanListHandler(Order.class));
			for(Order order : list){				
				//找出当前订单属于哪个用户
				sql = "select user.* from orders,user where orders.id=? and orders.user_id=user.id";
				User user = (User) runner.query(sql, order.getId(), new BeanHandler(User.class));
				order.setUser(user);
			} 
			return list;
		} catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public void update(Order order) {
		try{
			QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "update orders set state=? where id=?";
			Object params[] = {order.isState(), order.getId()};
			runner.update(sql, params);
		} catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	

	@Override
	public List<Order> getAll(boolean state, String userid) {
		// TODO Auto-generated method stub
		try{
			QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "select * from orders where state=? and orders.user_id=?";
			Object params[] = {state, userid};
			List<Order> list = (List<Order>) runner.query(sql, params, new BeanListHandler(Order.class));
			//将所有该user加到list中
			for(Order order : list){
				sql = "select * from user where user.id=?";
				User user = (User) runner.query(sql, userid, new BeanHandler(User.class));
				order.setUser(user);
			}
			return list;
		} catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<Order> getAllOrder(String userid) {
		// TODO Auto-generated method stub
		try{
			QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "select * from orders where user_id=?";
			List<Order> list = (List<Order>) runner.query(sql, userid, new BeanListHandler(Order.class));
			//将所有该user加到List中去
			for(Order order : list){
				sql = "select * from user where id=?";
				User user = (User) runner.query(sql, userid, new BeanHandler(User.class));
				order.setUser(user);
			}
			return list;
		} catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

}
