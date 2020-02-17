package gj.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * �������ݿ��࣬����һ�������ṩ��ȡ���ݿ����ӵķ���
 */
public class DBUtil {
	
	// ���ݿ�����·��
	private static final String URL = "jdbc:mysql://localhost:3308/test"
			+ "?serverTimezone=UTC&characterEncoding=utf8";
//			"jdbc:mysql://127.0.0.1:3308/tsg"
//			+ "useUnicode = true & serverTimezone = GMT"
//			// MySQL�ڸ߰汾��Ҫָ���Ƿ����SSL����
//			+ "& characterEncoding = utf8 & useSSL = false";
	private static final String NAME = "root";
	private static final String PASSWORD = "root";
	private static Connection conn = null;
	 Connection con = null;
	 ResultSet res = null;
	// ��̬����飨�������������������ݿ���뾲̬���У�
	 static{
	        try {
	            // ������������
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            // ��ȡ���ݿ������
	            conn = DriverManager.getConnection(URL, NAME, PASSWORD);
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	 
	    // ��ѯ
	    public ResultSet  Search(String sql, String str[]) {
	        try {
	            PreparedStatement pst =con.prepareStatement(sql);
	            if (str != null) {
	                for (int i = 0; i < str.length; i++) {
	                    pst.setString(i + 1, str[i]);
	                }
	            }
	            res = pst.executeQuery();

	        } catch (Exception e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	        return res;
	    }

	    // ��ɾ�޸�
	    public int AddU(String sql, String str[]) {
	        int a = 0;
	        try {
	            PreparedStatement pst = con.prepareStatement(sql);
	            if (str != null) {
	                for (int i = 0; i < str.length; i++) {
	                    pst.setString(i + 1, str[i]);
	                }
	            }
	            a = pst.executeUpdate();
	        } catch (Exception e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	        return a;
	    }
	 
	 // �����ṩһ����������ȡ���ݿ�����	    
	 public static Connection getConnection(){     
		 return conn;	   
	 }
	
	
}