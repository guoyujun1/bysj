package gj.controller;


import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import gj.dao.StudentDao;
import gj.model.Student;
import gj.model.User;

import javax.swing.*;

/**
 * ��ʦ��Ϊ������
 */
public class TeacherAction {
    /**
     * ��ʼ��������
     * @param columnNames
     * @return
     * @throws Exception
     */
    @SuppressWarnings("rawtypes")
    public Object[][] initializTable(String[] columnNames) throws Exception {
        StudentDao studentDao = new StudentDao();
        String sql = new String("SELECT student.sno, sname, mname,cname, regulargrade,"
                + "testgrade, grade,schoolyear,semester FROM student,major,course,grade,time"
                + " WHERE student.sno=grade.sno AND course.cno=grade.cno AND grade.id=time.id"
                + " AND student.mno=major.mno ");
        if (User.table.equals("student")) {
            sql = sql + "AND student.sno=" + User.Username;
        }
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
            results[i][0] = rs.getLong("student.sno");
            results[i][1] = rs.getString("sname");
            results[i][2] = rs.getString("mname");
            results[i][3] = rs.getString("cname");
            results[i][4] = rs.getFloat("regulargrade");
            results[i][5] = rs.getFloat("testgrade");
            results[i][6] = rs.getFloat("grade");
            String schoolyear = rs.getString("schoolyear");
            String semester = rs.getString("semester");
            results[i][7] = schoolyear+semester;
            i++;
        }
        return results;
    }

    /**
     * ͨ��ѧ���ж���Ϣ�Ƿ����
     * @param table
     * @param username
     * @return
     */
//    public static boolean isExist(String table,String username){
//        try {
//            StudentDao studentDao=new StudentDao();
//            String no = null;
//            if(table.equals("student")){
//                no = "sno";
//            }else if(table.equals("teacher")){
//                no = "tno";
//            }else if(table.equals("major")){
//                no="mno";
//            }else if(table.equals("academy")){
//                no="ano";
//            }else{
//                no="cno";
//            }
//            String sql ="select "+no+" from "+table+" where "+no+" = ? ";
//            String[] str = new String[]{username + ""};
//            ResultSet rs = studentDao.Search(sql, str);
//            // ���������������,����ֵΪ��
//            if ( rs.next()) {
//                return true;
//            }
//        } catch (SQLException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//        return false;
//    }

    /**
     * ͨ����������ж����ݿ����Ƿ���ڸ���Ϣ
     * @param table
     * @param no
     * @return
     */
    public static boolean isExistTwo(String table,String no,String name){
        try {
            StudentDao studentDao=new StudentDao();

            String sql ="select sno,cno from grade where sno = ? and cno =(select cno from course where cname = ?);";
            String[] str = new String[]{no,name + ""};
            ResultSet rs = studentDao.Search(sql, str);
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
     * �����������Ϣ��ѧ����Ϣ����ɸѡ����������ѯ
     * @param columnNames
     * @param str
     * @param grade
     * @return
     * @throws Exception
     */
    public Object[][] selectInformation(String[] columnNames,String[] str, float grade) throws Exception {
        StudentDao studentDao = new StudentDao();
        Student student = new Student();

        String sql = "SELECT student.sno, sname, mname,cname, regulargrade, "
                + "testgrade, grade,schoolyear,semester FROM student,major,course,grade,academy,time"
                + " WHERE academy.ano=major.ano AND student.sno=grade.sno AND course.cno=grade.cno"
                + " AND student.mno=major.mno AND grade.id = time.id ";
        if(!str[0].equals("null")){
            sql = sql+" AND time.schoolyear = '"+str[0]+"'";
        }
        if(!str[1].equals("null")){
            sql = sql+" AND time.semester = '"+str[1]+"'";
        }
        if(!str[2].equals("null")){
            sql = sql+"AND academy.aname = '"+str[2]+"'";
        }
        if(!str[3].equals("null")) {
            sql=sql+" AND major.mname = '"+str[3]+"' ";
        }
        if(!str[4].equals("null")) {
            sql = sql+" AND student.class = '"+str[4]+"' ";
        }
        if(!str[5].equals("null")) {
            sql = sql+" AND course.cname = '"+str[5]+"' ";
        }
        if(!str[6].equals("")) {
            sql = sql+" AND student.sname = '"+str[6]+"' ";
        }
        sql = sql+" AND grade.grade <= "+grade+";";
        //ִ������
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
            String schoolyear = rs.getString("schoolyear");
            String semester = rs.getString("semester");
            results[i][7] = schoolyear+semester;
            i++;
        }
        return results;
    }

    /**
     * ��ѯָ�����е�ָ������
     * @return
     */
    public  List<String> SelectbyDB(String table,String name){
        List<String> list=new ArrayList<String>();
        StudentDao studentDao = new StudentDao();
        try {
            String sql;
            if(table.equals("time")){
                sql = "select distinct schoolyear from time ;";
                ResultSet rs= studentDao.Search(sql, null);
                while (rs.next()) {
                    String schoolyear = rs.getString("schoolyear");
                    list.add(schoolyear);
                }
            }else if(table.equals("course")){
                if(name == null) {
                    sql = "select distinct cname from course; ";
                }else{
                    sql = "select cname from major,course where major.mno = course.mno and major.mno = (select mno from major where mname = '" + name + "') ;";
                }
                ResultSet rs= studentDao.Search(sql, null);
                while (rs.next()) {
                    String cname = rs.getString("cname");
                    list.add(cname);
                }
            } else if(table.equals("major")) {
                if(name == null) {
                    sql = "select mname from major;";
                }else{
                    sql = "select mname from major,academy where major.ano = academy.ano and academy.ano = (select ano from academy where aname = '" + name + "') ;";
                }
            ResultSet rs= studentDao.Search(sql, null);
                while (rs.next()) {
                    String mname = rs.getString("mname");
                    list.add(mname);
                }
            }else if(table.equals("class")) {
                if(name == null) {
                    sql = "select distinct class from student;";
                }else{
                    sql = "select distinct class from student,major where student.mno = major.mno and major.mno = (select mno from major where mname = '" + name + "') ;";
                }
                ResultSet rs= studentDao.Search(sql, null);
                while (rs.next()) {
                    String clas = rs.getString("class");
                    list.add(clas);
                }
            }else{
                sql ="select aname from academy ;";
                ResultSet rs= studentDao.Search(sql, null);
                while (rs.next()) {
                    String aname = rs.getString("aname");
                    list.add(aname);
                }
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list;
    }


    /**
     * �޸�ѧ���ɼ���Ϣ
     * @throws Exception
     */
    public void updateInformation(String[][] value)  {
        StudentDao studentDao = new StudentDao();
        for (int i=0; i<value.length;i++) {
            String sno = value[i][0];
            String cname = value[i][3];
            if (!isExistTwo("student",sno,cname)) {
                //�����ھ����
                String sql="insert into grade (sno,cno,regulargrade,testgrade,grade) values(?,(select cno from course where cname = ?),?,?,?)";
                String[] str=new String[]{sno,cname,value[i][4],value[i][5],value[i][6]+""};
                studentDao.AddU(sql, str);
            }else {
                //���ھ͸���
                String sql="update grade set sno=?,cno=(select cno from course where cname = ?),regulargrade=? ,testgrade=? ,grade = ? where sno = ? and cno=(select cno from course where cname = ?)";
                String[] str=new String[]{sno,cname,value[i][4],value[i][5],value[i][6],sno,cname+""};
                studentDao.AddU(sql, str);
            }
        }

    }

    /**
     * ɾ��ѧ����Ϣ
     * @param value
     */
    public void deleteInformation(String[][] value){
        StudentDao studentDao = new StudentDao();
        String sno = value[0][0];
        String cname = value[0][3];
        String sql = "delete from grade where sno = ? and cno = (select cno from course where cname = ?) ;";
        String[] str = new String[]{sno, cname + ""};
        studentDao.AddU(sql, str);

    }

    /**
     * ����һ��ѧ��
     */
    public void addSchoolYear(){
        StudentDao studentDao = new StudentDao();
        try {
            //�����ݿ��в�ѯid����ѧ��
            String sql0 = "select id,schoolyear from time order by id desc limit 1;";
            ResultSet rs= studentDao.Search(sql0, null);
            String schoolyear = null;
            String id = null;
            while (rs.next()) {
                id =rs.getString("id");
                schoolyear = rs.getString("schoolyear");
            }
            //�������н�ȡ���������
            int year = Integer.parseInt(schoolyear.substring(5));
            //ƴ����Ҫд���ѧ��
            String schoolyear1 = schoolyear.substring(5)+"-"+Integer.toString(year+1);
            //д�����ݿ⣬id���������ģ����ù�
            String sql = "insert into time (schoolyear,semester) values (?,'��һ��'),(?,'�ڶ���');";
            String[] str = new String[]{schoolyear1, schoolyear1 + ""};
            studentDao.AddU(sql, str);
            //��ʾ�û������ɹ�
            JOptionPane.showMessageDialog(null, "�����ɹ�", "�ɹ�", JOptionPane.PLAIN_MESSAGE);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delteteSchoolYear(){
        StudentDao studentDao = new StudentDao();
        try {
            //������ǰ������id����Ϊid���������ģ���ǰ����������������һ��ѧ�������ѧ��
            String sql0 = "select id from time limit 2;";
            ResultSet rs= studentDao.Search(sql0, null);
            //�ѳɼ����д�ѧ��ĳɼ���Ϣɾ��
            while (rs.next()) {
                String id = rs.getString("id");
                String sql1 = "delete from grade where id = ? ;";
                String[] str = new String[]{id +" "};
                studentDao.AddU(sql1, str);
            }
            //ɾ�������һ��ѧ��
            String sql = "delete from time limit 2 ;";
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
