package gj.controller;

import java.sql.ResultSet;

import gj.dao.StudentDao;
import gj.model.Student;
import gj.model.User;

/**
* ѧ����Ϣ��Ϊ������
* 
*/
public class StudentAction {
	/**
	 * ��ʼ��������
	 *
	 * @return results
	 */
	@SuppressWarnings("rawtypes")
	public Object[][] initializTable(String[] columnNames) throws Exception {
		StudentDao studentDao = new StudentDao();
		String sql = new String("SELECT student.sno, sname, mname,cname, regulargrade,"
				+ "testgrade, grade FROM student,major,course,grade"
				+ " WHERE student.sno=grade.sno AND course.cno=grade.cno" + " AND student.mno=major.mno ");
		if (User.table.equals("student")) {
			sql = sql + "AND student.sno=" + User.Username;
		}
		Student student = new Student();
		ResultSet rs = studentDao.Search(sql, null);
		//���ResultSet������
		rs.last();
		int rowCount = rs.getRow();
		Object[][] results = new Object[rowCount][columnNames.length];
		//��ָ���ƶ�����һ��
		rs.absolute(0);
		// ��������������ݣ��ͻ�ѭ����ӡ����
		int i=0;
		while (rs.next()) {
			student = new Student();
			results[i][0] = rs.getLong("student.sno");
			results[i][1] = rs.getString("sname");
			results[i][2] = rs.getString("mname");
			results[i][3] = rs.getString("cname");
			results[i][4] = rs.getFloat("regulargrade");
			results[i][5] = rs.getFloat("testgrade");
			results[i][6] = rs.getFloat("grade");
			i++;
		}
		return results;
	}
}
