package gj.model;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户模型类,包含数据库用户表各对应的字段get、set方法
 * 
 */
public class User {
	

	private int ID;
	// 用户名
	public static String Username;
	// 密码
	private String passwd;
	//新密码
	private String newpasswd;
	
	public static String table;
	public List<Student> studentList;
	/**
	 * 获取ID
	 */
	public int getID() {
		return ID;
	}
	/**
	 * 设置ID
	 */
	public void setID(int iD) {
		ID = iD;
	}
	
	
	/**
	 * 获取用户名
	 */
	public String getUser() {
		return Username;
	}
	/**
	 * 设置用户名
	 */
	public void setUser(String UserName) {
		this.Username = UserName;
	}
	
	/**
	 * 获取用户密码
	 */
	public String getPasswd() {
		return passwd;
	}
	/**
	 * 设置用户密码
	 */
	public void setPasswd(String Passwd) {
		this.passwd = Passwd;
	}

	/**
	 * 获取新密码
	 */
	public String getNewPasswd() {
		return newpasswd;
	}
	/**
	 * 设置新密码
	 */
	public void setNewPasswd(String Newpasswd) {
		this.newpasswd = Newpasswd;
	}
	
}