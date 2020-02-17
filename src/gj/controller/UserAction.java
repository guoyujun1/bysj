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
 * �û���Ϊ�����࣬�����޸�����
 * 
 */
public class UserAction {

	/**
	 * ͨ���û����ж����ݿ����Ƿ���ڸ��û�
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
			// ���������������,����ֵΪ��
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
	 * �����û�����ѯ�û�����
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

		// ��������������ݣ��ͻ�ѭ����ӡ����
		while (rs.next()){
			user = new User();
			user.setUser(Long.toString(rs.getLong(no)));
			user.setPasswd(rs.getString("passwd"));
			userList.add(user);
		}
		return userList;
	}



	   /**
	    * �޸�����
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
			// ������?��ʾ���൱��ռλ��
			String sql="UPDATE "+ User.table+" SET passwd = ? WHERE "+no+" = ?";
			String[] str = new String[]{newpasswd,User.Username + ""};
			userDao.AddU(sql, str);
	    }
	        

}