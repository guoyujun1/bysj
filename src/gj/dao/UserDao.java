package gj.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import gj.model.User;
import gj.util.DBUtil;


/**
 * 用户表信息数据访问对象类，包含更改用户信息
 */
public class UserDao {

	/**
	 * 增删修改
	 * @param sql
	 * @param str
	 * @return
	 */
	public int AddU(String sql, String str[]) {

		// 首先拿到数据库的连接
		Connection con = DBUtil.getConnection();
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

	/**
	 * 查询
	 * @param sql
	 * @param str
	 * @return
	 */
	public ResultSet  Search(String sql, String str[]) {
		Connection con = DBUtil.getConnection();
		ResultSet res = null;
		try {
			PreparedStatement pst =con.prepareStatement(sql,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
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

}