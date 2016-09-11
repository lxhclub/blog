package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;

import entity.Objects;
import util.JdbcUtil;

public class ObjectsDao {
	// 新建问卷
	@SuppressWarnings("null")
	public int intsertObjects(Objects object) throws SQLException  {
		 JdbcUtil jdbcutil=new JdbcUtil();
    Connection conn=null;
    PreparedStatement ps=null;
    ResultSet rs=null;
   
    Timestamp currentTime = new Timestamp(System.currentTimeMillis());
int id=0;
String sql="";

try{
	conn=JdbcUtil.getConnection();
	sql="insert into object(title,discribe,createtime,state,remark,anonymousFlag) values(?,?,?,?,?,?)";
	ps=conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
    ps.setString(1, object.getTitle());	
    ps.setString(2, object.getDiscribe());
    ps.setTimestamp(3, currentTime);
    ps.setInt(4, object.getState());
	ps.setString(5, object.getRemark());
	ps.setString(6, object.getAnonymousFlag());
	ps.executeUpdate();
	rs=ps.getGeneratedKeys();
	if(rs.next())
		{id=rs.getInt(1);
	
		}
}catch(Exception e){
	e.printStackTrace();
}finally{
	jdbcutil.closeAll(conn, ps, rs);
}	
		return id;
		
	}
	// 修改问卷
		public static int updateObjects(Objects bean) {
			 JdbcUtil jdbcutil=new JdbcUtil();
			String sql1 = "update object set title = '" + bean.getTitle()
					+ "',discribe = '" + bean.getDiscribe() + "',anonymousFlag = '" + bean.getAnonymousFlag() + "'" +
					" where oid="+ bean.getOid();
			try {
				int i =jdbcutil.update(sql1,JdbcUtil.getConnection());
				return i;
			} catch (Exception e) {
				e.printStackTrace();
				return 0;
			} finally {
				try {
					jdbcutil.closeAll(JdbcUtil.getConnection());
				} catch (Exception e) {
					e.printStackTrace();
				}

			}

		}
		
		// 删除问卷
		public static boolean delObjects(int oid) throws Exception {
			 JdbcUtil jdbcutil=new JdbcUtil();
			boolean flag = false;
			Connection conn =JdbcUtil.getConnection();
			conn.setAutoCommit(false);
			String sql1 = "delete from object where oid="+oid;
			String sql2 = "delete from question where oid="+oid;
			String sql3 = "delete from replay where oid="+oid;
			String sql4 = "delete from answer where oid="+oid;
			String sql5 = "delete from selecter where oid="+oid;
			try {
				jdbcutil.update(sql1, conn);
				jdbcutil.update(sql2, conn);
				jdbcutil.update(sql3, conn);
				jdbcutil.update(sql4, conn);
				jdbcutil.update(sql5, conn);
				conn.commit();
				flag = true;
			} catch (Exception e) {
				conn.rollback();
				e.printStackTrace();
			} finally {
				try {
					conn.setAutoCommit(true);
					jdbcutil.closeAll(conn);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			return flag;
		}

		public static Objects getObjects(int oid) {
			 JdbcUtil jdbcutil=new JdbcUtil();
			Connection con = null;
			Statement stm = null;
			ResultSet rs = null;
			Objects ob = null;
			int result = 0;
			try {
				con =JdbcUtil.getConnection();
				stm = con.createStatement();
				String sql = " select * from object where oid=" + oid;
				System.out.println(sql);
				rs = stm.executeQuery(sql);
				while (rs.next()) {
					String title = rs.getString("title");
					ob = new Objects();
					ob.setOid(oid);
					ob.setTitle(title);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				jdbcutil.closeAll(con, stm, rs);
			}
			return ob;
		}
//		 查看问卷;
		public static List ListObjects() {
			 JdbcUtil jdbcutil=new JdbcUtil();
			Connection con = null;
			Statement stm = null;
			ResultSet rs = null;
			List objList=new LinkedList();
			try {
				String sql = "select oid,title,createtime,state from object order by oid desc";
				con=JdbcUtil.getConnection();
				stm=con.createStatement();
				rs = stm.executeQuery(sql);
				while(rs.next()){
				Objects ob=new Objects();
					int oid=rs.getInt("oid");
					String title=rs.getString("title");
					java.sql.Timestamp createtime=rs.getTimestamp("createtime");
					int state=rs.getInt("state");
					ob.setOid(oid);
					ob.setTitle(title);
					ob.setCreateTime(createtime);
					ob.setState(state);
					
					objList.add(ob);
				}
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			} finally {
					jdbcutil.closeAll(con,stm,rs);
			}
			return objList;
		}

		// 根据编号查找标题和内容
		public static Objects findObjectsByID(int ID) {
			 JdbcUtil jdbcutil=new JdbcUtil();
			Connection con = null;
			Statement stm = null;
			ResultSet rs = null;
		Objects ob=new Objects();
			
			try {
				String sql = "select oid,title,discribe,state,anonymousFlag from object where oid='" + ID
				+ "'";
				con=jdbcutil.getConnection();
				stm=con.createStatement();
				 rs = stm.executeQuery(sql);
				 while(rs.next()){
			     int oid = rs.getInt("oid");
				 String title = rs.getString("title");
				 String discribe = rs.getString("discribe");
				 String anonymousFlag = rs.getString("anonymousFlag");
				 int state=rs.getInt("state");
				 ob.setOid(oid);
				 ob.setState(state);
				 ob.setTitle(title);
				 ob.setDiscribe(discribe);
				 ob.setAnonymousFlag(anonymousFlag);
				 }
				
				return ob;
			} catch (Exception e) {
			
				e.printStackTrace();
				return null;
			} finally {
				jdbcutil.closeAll(con,stm,rs);
			}

		}
		
		
		/**
		 * 查找发布后的问卷
		 * @param ID
		 * @return
		 */
		public static Objects findPublishedObjectBeanByID(int ID) {
			 JdbcUtil jdbcutil=new JdbcUtil();
			Connection con = null;
			Statement stm = null;
			ResultSet rs = null;
			Objects ob=new Objects();
			
			try {
				String sql = "select oid,title,discribe,state,anonymousFlag from object where oid='" + ID
				+ "' and state in(1,2)";
				System.out.println("查询发布后的主题： "+sql);
				con=jdbcutil.getConnection();
				stm=con.createStatement();
				 rs = stm.executeQuery(sql);
				 while(rs.next()){
			     int oid = rs.getInt("oid");
				 String title = rs.getString("title");
				 String discribe = rs.getString("discribe");
				 String anonymousFlag = rs.getString("anonymousFlag");
				 int state=rs.getInt("state");
				 ob.setOid(oid);
				 ob.setState(state);
				 ob.setTitle(title);
				 ob.setDiscribe(discribe);
				 ob.setAnonymousFlag(anonymousFlag);
				 }
				
				return ob;
			} catch (Exception e) {
			
				e.printStackTrace();
				return null;
			} finally {
				jdbcutil.closeAll(con,stm,rs);
			}

		}

		
	    //查找问卷一共几条数据
		public static int getCount(int oid) {
			 JdbcUtil jdbcutil=new JdbcUtil();
			Connection con = null;
			Statement stm = null;
			ResultSet rs = null;
			int count=0;
			String sql = "select count(*) from question where oid = '" + oid	+ "'";
			try {
				con=jdbcutil.getConnection();
				stm=con.createStatement();
				 rs = stm.executeQuery(sql);
				while(rs.next()){
					count=rs.getInt(1);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				jdbcutil.closeAll(con, stm, rs);
			}
			return count;
		}

	
public static void main(String[] args) throws Exception {
	ObjectsDao objectsDao=new ObjectsDao();
	//objectsDao.getObjects(2).getTitle();
	Objects objects=new Objects();
	objects.setOid(22);
	objects.setTitle("为何大学僧都那么复杂哦");
	objects.setState(1);
	objects.setDiscribe("恢复世界法师铠甲");
	objects.setRemark("jssjflsljk");
	/*objects.setCreateTime();*/
	objects.setAnonymousFlag("0");
	objectsDao.intsertObjects(objects);
    //objectsDao.delObjects(23);
   System.out.println(objectsDao.ListObjects()); 
	System.out.println(objectsDao.getObjects(21).getTitle());
}
}
