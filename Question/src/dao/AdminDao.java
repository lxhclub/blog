package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import entity.Admin;
import util.JdbcUtil;
import util.MD5Util;

public class AdminDao {
	public Admin login(String username,String password) throws Exception {
	 JdbcUtil jdbcutil = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Admin admin=new Admin();
		String md5Psw = MD5Util.MD5Encrypt(password);
		String sql = "select * from admin where username =? and password =?";//·ÀÖ¹SQL×¢Èë
		try {
			jdbcutil=new JdbcUtil();
			con= JdbcUtil.getConnection();
			ps=con.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, md5Psw);
			rs = ps.executeQuery();
			 while(rs.next()){
			String uname=rs.getString("username");
			String pwd=rs.getString("password");
			admin.setPassword(pwd);
			admin.setUsername(uname);
		}
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
		jdbcutil.closeAll(con, ps, rs);
		}
		return admin;
	}
	public static String getOldPsw(String username){
		JdbcUtil jdbcutil = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String psw ="";
		String	sql = "select * from admin where username =?";
		try {
			jdbcutil=new JdbcUtil();
			con= JdbcUtil.getConnection();
			ps= con.prepareStatement(sql);
			ps.setString(1, username);
			rs = ps.executeQuery();
		    while(rs.next()){
		    	psw=rs.getString("password");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jdbcutil.closeAll(con, ps, rs);
		}
		return psw;
	}
	/**
	 * ÐÞ¸ÄÃÜÂë
	 * @param username
	 * @param newpsw
	 * @return
	 * @throws Exception 
	 */
	public static boolean updatePassword(String username,String newpsw) throws Exception{
		JdbcUtil jdbcutil = null;
		Connection con = null;
		java.sql.PreparedStatement ps = null;
		ResultSet rs = null;
		boolean flag = false;
		String md5Psw = MD5Util.MD5Encrypt(newpsw);
		String	sql = "update admin set password = ? where username = ?";
		System.out.println(sql);
		try {
			jdbcutil=new JdbcUtil();
			con= JdbcUtil.getConnection();
			ps=con.prepareStatement(sql);
			ps.setString(1, md5Psw);
			ps.setString(2, username);
			ps.executeUpdate();
			flag=true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jdbcutil.closeAll(con, ps, rs);
		}
		return flag;
	}

	
	
	
	
	/*
	public static void main(String[] args) throws Exception {
		AdminDao adminDao=new AdminDao();
		adminDao.updatePassword("admin", "123456");
			System.out.println(adminDao.getOldPsw("admin"));
		
	}
*/
}
