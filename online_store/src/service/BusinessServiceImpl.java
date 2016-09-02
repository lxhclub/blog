package service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import dao.CategoryDao;
import dao.GoodsDao;
import dao.OrderDao;
import dao.UserDao;
import entity.Cart;
import entity.CartItem;
import entity.Category;
import entity.Goods;
import entity.Order;
import entity.OrderItem;
import entity.Page;
import entity.User;
import utils.DaoFactory;
import utils.WebUtils;

public class BusinessServiceImpl implements BusinessService {
private CategoryDao categoryDao=DaoFactory.getInstance().createDao("dao.impl.CategoryDaoImpl", CategoryDao.class);
private GoodsDao goodsDao=DaoFactory.getInstance().createDao("dao.impl.GoodsDaoImpl", GoodsDao.class);
private UserDao userDao=DaoFactory.getInstance().createDao("dao.impl.UserDaoImpl", UserDao.class);
private OrderDao  orderDao=DaoFactory.getInstance().createDao("dao.impl.OrderDaoImpl", OrderDao.class);

	@Override
	public void addCategory(Category category) {
		categoryDao.add(category);

	}
@Override
	public Category findCategory(String id) {
		
		return categoryDao.find(id);
	}

	@Override
	public List<Category> getAllCategory() {
		// TODO Auto-generated method stub
		return  categoryDao.getAll();
	}
	public void addGoods(Goods goods){
		goodsDao.add(goods);
		
	}
	public Goods findGoods(String id){
		return goodsDao.find(id);
	}
	
public  Page getGoodsPageData(String pagenum){
	int totalrecord=goodsDao.getTotalRecord();
	Page page=null;
	if(pagenum==null){
		page=new Page(1,totalrecord);
	}else{
		page=new Page(Integer.parseInt(pagenum),totalrecord);
		
	}
	List<Goods> list=goodsDao.getPageData(page.getStartindex(), page.getPagesize());
	page.setList(list);
	return page;
	
}
public  Page getGoodsPageData(String pagenum,String category_id){
	int totalrecord=goodsDao.getTotalRecord(category_id);
	Page page=null;
	if(pagenum==null){
		page=new Page(1,totalrecord);
	}else{
		page=new Page(Integer.parseInt(pagenum),totalrecord);
		
	}
	List<Goods> list=goodsDao.getPageData(page.getStartindex(), page.getPagesize(),category_id);
	page.setList(list);
	
	
	return page;
	
}
public void buyGoods(Cart cart,Goods goods){
	cart.add(goods);
}
public void registerUser(User user){
	userDao.add(user);
}
public  User findUser(String id){
	return userDao.find(id);
}
public User userLogin(String username,String password){
	return userDao.find(username,password);
	
}
public void createOrder(Cart cart,User user){
	if(cart==null){
		throw new RuntimeException("对不起。你没有购买任何商品");
		
	}
	Order order =new Order();
	order.setId(WebUtils.makeID());
	order.setOrdertime(new Date());
	order.setPrice(cart.getPrice());
    order.setState(false);
    order.setUser(user);
    for(Map.Entry<String, CartItem>me:cart.getMap().entrySet()){
    	CartItem citem=me.getValue();
    	OrderItem oitem=new OrderItem();
    	oitem.setGoods(citem.getGoods());
    	oitem.setPrice(citem.getPrice());
        oitem.setId(WebUtils.makeID());
        oitem.setQuantity(citem.getQuantity());
        order.getOrderitems().add(oitem);
    }
    orderDao.add(order);
}
public List<Order> listOrder(String state) {
	return orderDao.getAll(Boolean.parseBoolean(state));	
}

//列出订单明细
public Order findOrder(String orderid) {		
	return orderDao.find(orderid);
}

//把订单置为发货状态
public void confirmOrder(String orderid) {
	Order order = orderDao.find(orderid);
	order.setState(true);
	orderDao.update(order);
}

//获得某个用户的订单信息
public List<Order> listOrder(String state, String userid) {
	return orderDao.getAll(Boolean.parseBoolean(state), userid);
}

//获取某个用户的订单信息
public List<Order> clientListOrder(String userid) {	
	return orderDao.getAllOrder(userid);
}
}
