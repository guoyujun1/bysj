package gj.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import gj.model.Student;
import gj.model.User;
import gj.util.DBUtil;
import gj.view.Login;
import gj.dao.UserDao;


public class StudentDao {

//	/**
//	 * 通过学号判断学生信息是否存在
//	 * @param sno
//	 * @return
//	 */
//	public static boolean isExist(long sno){
//		// 首先拿到数据库的连接
//		Connection con = DBUtil.getConnection();
//		try {
//			Statement stmts = con.createStatement();
//			String sql ="select sno,passwd from student where sno="+sno+";";
//			PreparedStatement psmt ;
//			psmt = (PreparedStatement)con.prepareStatement(sql);
//			ResultSet rs = psmt.executeQuery();
//			// 如果对象中有数据,返回值为真
//			if ( rs.next()) {
//				return true;
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return false;
//	}

	// 增删修改
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

	// 查询
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



//	/**
//	 * 学生登陆自动查询学生成绩信息,教师登录查询显示所有学生信息
//	 * @return
//	 * @throws Exception
//	 */
//	public List<Student> query() throws Exception{
//		// 首先拿到数据库的连接
//		Connection con = DBUtil.getConnection();
//		Statement stmt = con.createStatement();
//		User user = new User();
//		String sql = new String("SELECT student.sno, sname, mname,cname, regulargrade,"
//				+ "testgrade, grade FROM student,major,course,grade"
//				+ " WHERE student.sno=grade.sno AND course.cno=grade.cno"
//				+ " AND student.mno=major.mno ");
//		if(User.table.equals("student")) {
//			sql=sql+"AND student.sno="+User.Username;
//		}
//		List<Student> studentList = new ArrayList<Student>();
//		PreparedStatement psmt;
//		Student student = new Student();
//		psmt = (PreparedStatement) con.prepareStatement(sql);
//		ResultSet rs = psmt.executeQuery();
//		// 如果对象中有数据，就会循环打印出来
//		while (rs.next()){
//			student = new Student();
//			student.setno(rs.getLong("student.sno"));
//			student.setname(rs.getString("sname"));
//			student.setmname(rs.getString("mname"));
//			student.setcname(rs.getString("cname"));
//			student.setregulargrade(rs.getFloat("regulargrade"));
//			student.settestgrade(rs.getFloat("testgrade"));
//			student.setgrade(rs.getFloat("grade"));
//			studentList.add(student);
//		}
//		return studentList;
//	}
//
//  /**
//	 * 根据输入信息对学生信息进行查找
//	 * @param student
//	 * @return
//	 * @throws Exception
//	 */
//	@SuppressWarnings("null")
//	public static List<Student> select(Student student) throws Exception {
//		// 首先拿到数据库的连接
//		Connection con = DBUtil.getConnection();
//		String sql = "SELECT student.sno, sname, mname,cname, regulargrade, "
//				+ "testgrade, grade FROM student,major,course,grade"
//				+ " WHERE student.sno=grade.sno AND course.cno=grade.cno"
//				+ " AND student.mno=major.mno ";
//		if(!student.getmname().equals("")) {
//			sql=sql+" AND major.mname = '"+student.getmname()+"' ";
//		}
//		if(!student.getclas().equals("")) {
//			sql = sql+" AND student.class = '"+student.getclas()+"' ";
//		}
//		if(!student.getcname().equals("")) {
//			sql = sql+" AND course.cname = '"+student.getcname()+"' ";
//		}
//		if(!student.getname().equals("")) {
//			sql = sql+" AND student.sname = '"+student.getname()+"' ";
//		}
//		sql = sql+" AND grade.grade <= "+student.getgrade()+";";
//		List<Student> selectList = new ArrayList<Student>();
//		PreparedStatement psmts = (PreparedStatement) con.prepareStatement(sql);
//		Student students = null;
//		ResultSet rs = psmts.executeQuery(sql);
//		// 如果对象中有数据，就会循环打印出来
//		while (rs.next()) {
//			students = new Student();
//			students.setno(rs.getLong("sno"));
//			students.setname(rs.getString("sname"));
//			students.setmname(rs.getString("mname"));
//			students.setcname(rs.getString("cname"));
//			students.setregulargrade(rs.getFloat("regulargrade"));
//			students.settestgrade(rs.getFloat("testgrade"));
//			students.setgrade(rs.getFloat("grade"));
//			selectList.add(students);
//		}
//		return selectList;
//	}
}
