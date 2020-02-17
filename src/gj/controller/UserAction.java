package gj.controller;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import gj.dao.UserDao;
import gj.model.User;
import gj.util.DBUtil;

/**
 * 用户行为控制类，用于修改密码
 * 
 */
public class UserAction {

	/**
	 * 通过用户名判断数据库中是否存在该用户
	 * @param table
	 * @param username
	 * @return
	 */
	public static boolean isExist(String table,String username){
		try {
			UserDao userDao=new UserDao();
			String no = null;
			if(table.equals("student")){
				no = "sno";
			}else if(table.equals("teacher")){
				no = "tno";
			}else{
				no="mno";
			}
			String sql ="select "+no+" from "+table+" where "+no+" = ? ";
			String[] str = new String[]{username + ""};
			ResultSet rs = userDao.Search(sql, str);
			// 如果对象中有数据,返回值为真
			if ( rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}


	/**
	 * 根据用户名查询用户密码
	 * @return
	 * 		userList
	 */
	public List<User> query(String table,String username) throws Exception{
		UserDao userDao=new UserDao();
		User User = new User();
		String no = null;
		if(table.equals("student")){
			no = "sno";
		}else{
			no = "tno";
		}
		User.table=table;
		String sql  ="select "+no+",passwd from "+table+" where "+no+" = ? ";
		String[] str = new String[]{username + ""};
		ResultSet rs = userDao.Search(sql, str);
		List<User> userList = new ArrayList<User>();
		User user = null;

		// 如果对象中有数据，就会循环打印出来
		while (rs.next()){
			user = new User();
			user.setUser(Long.toString(rs.getLong(no)));
			user.setPasswd(rs.getString("passwd"));
			userList.add(user);
		}
		return userList;
	}



	   /**
	    * 修改密码
	    */
	    public void edit(String newpasswd) throws Exception{
	    	User User = new User();
	        UserDao userDao=new UserDao();
			String no = null;
			if(User.table.equals("student")){
				no = "sno";
			}else{
				no = "tno";
			}
			// 参数用?表示，相当于占位符
			String sql="UPDATE "+ User.table+" SET passwd = ? WHERE "+no+" = ?";
			String[] str = new String[]{newpasswd,User.Username + ""};
			userDao.AddU(sql, str);
	    }
	        

}