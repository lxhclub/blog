package dao;

import java.util.List;

import entity.Goods;

public interface GoodsDao {
	void add(Goods goods);
	Goods find(String id);
	public List<Goods> getPageData(int startindex,int pagesize);
   public int getTotalRecord();
   public List<Goods>getPageData(int startindex,int pagesize,String category_id);
   public int getTotalRecord(String category_id);
}
