package gj.model;

import java.util.ArrayList;
import java.util.List;

/**
 * �û�ģ����,�������ݿ��û������Ӧ���ֶ�get��set����
 * 
 */
public class User {
	

	private int ID;
	// �û���
	public static String Username;
	// ����
	private String passwd;
	//������
	private String newpasswd;
	
	public static String table;
	public List<Student> studentList;
	/**
	 * ��ȡID
	 */
	public int getID() {
		return ID;
	}
	/**
	 * ����ID
	 */
	public void setID(int iD) {
		ID = iD;
	}
	
	
	/**
	 * ��ȡ�û���
	 */
	public String getUser() {
		return Username;
	}
	/**
	 * �����û���
	 */
	public void setUser(String UserName) {
		this.Username = UserName;
	}
	
	/**
	 * ��ȡ�û�����
	 */
	public String getPasswd() {
		return passwd;
	}
	/**
	 * �����û�����
	 */
	public void setPasswd(String Passwd) {
		this.passwd = Passwd;
	}

	/**
	 * ��ȡ������
	 */
	public String getNewPasswd() {
		return newpasswd;
	}
	/**
	 * ����������
	 */
	public void setNewPasswd(String Newpasswd) {
		this.newpasswd = Newpasswd;
	}
	
}