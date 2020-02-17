package gj.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 连接数据库类，包含一个对外提供获取数据库连接的方法
 */
public class DBUtil {
	
	// 数据库连接路径
	private static final String URL = "jdbc:mysql://localhost:3308/test"
			+ "?serverTimezone=UTC&characterEncoding=utf8";
//			"jdbc:mysql://127.0.0.1:3308/tsg"
//			+ "useUnicode = true & serverTimezone = GMT"
//			// MySQL在高版本需要指明是否进行SSL连接
//			+ "& characterEncoding = utf8 & useSSL = false";
	private static final String NAME = "root";
	private static final String PASSWORD = "root";
	private static Connection conn = null;
	 Connection con = null;
	 ResultSet res = null;
	// 静态代码块（将加载驱动、连接数据库放入静态块中）
	 static{
	        try {
	            // 加载驱动程序
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            // 获取数据库的连接
	            conn = DriverManager.getConnection(URL, NAME, PASSWORD);
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	 
	    // 查询
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

	    // 增删修改
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
	 
	 // 对外提供一个方法来获取数据库连接	    
	 public static Connection getConnection(){     
		 return conn;	   
	 }
	
	
}