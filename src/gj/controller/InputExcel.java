package gj.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import gj.model.*;
import gj.service.ExcelService;
import gj.dao.StudentDao;

public class InputExcel {
    public InputExcel(int id,String filepath,String filename){
        TeacherAction teacherAction = new TeacherAction();
        StudentDao studentDao = new StudentDao();

        if(id == 0) {
            //学生表
            //得到表格中所有的数据
            List<Student> listExcel=ExcelService.getAllByExcelS(filepath+filename+".xls");
            for (Student stuEntity : listExcel) {
                String sno = Long.toString(stuEntity.getno());
                //学生账号的初始密码取学号的后6位
                String passwd = Long.toString(stuEntity.getno()).substring(6);
                //不存在就添加,存在就更新
                String sql = "insert into student (sno,sname,mno,class,passwd) values(?,?,?,?,?) on duplicate key update sname=?,mno=?,class=?";
                String[] str = new String[]{sno, stuEntity.getname(), stuEntity.getmname(), stuEntity.getclas(), passwd ,stuEntity.getname(), stuEntity.getmname(), stuEntity.getclas()  + " "};
                studentDao.AddU(sql, str);
            }
        }else if(id==1){
            //教师表
            List<Teacher> listExcel=ExcelService.getAllByExcelT(filepath+filename+".xls");
            for (Teacher teacher : listExcel) {
                String tno = teacher.getTno();
                //账号的默认密码取工号的后6位
                String passwd1 = tno.substring(6);
                //不存在就添加,存在就更新
                String sql = "insert into teacher (tno,tname,passwd)values(?,?,?) on duplicate key update tname=? ; ";
                String[] str = new String[]{teacher.getTno(), teacher.getTname(), passwd1, teacher.getTname() + ""};
                studentDao.AddU(sql, str);
            }
        }else if(id==2){
            //专业表
            List<Major> listExcel=ExcelService.getAllByExcelM(filepath+filename+".xls");
            for (Major major : listExcel) {
                try {
                    String mno = Integer.toString(major.getMno());
                    //不存在就添加，存在就更新
                    //查询学院代码
                    String sql0 = "select ano from academy where aname = ? ;";
                    String[] str0 = new String[]{major.getAname() + ""};
                    ResultSet rs= studentDao.Search(sql0, str0);
                    String ano = null;
                    while (rs.next()) {
                        ano = rs.getString("ano");
                    }
                    //更新数据
                    String sql = "insert into major (mno,mname,ano)values(?,?,?) on duplicate key update mname=?,ano=  ? ;";
                    String[] str = new String[]{mno, major.getMname(),ano, major.getMname(),ano + ""};
                    studentDao.AddU(sql, str);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }else if(id==3){
            //课程表
            List<Course> listExcel=ExcelService.getAllByExcelC(filepath+filename+".xls");
            for (Course course : listExcel) {
                try {
                    String cno = Integer.toString(course.getCno());
                    //查询专业代号和教师代号
                    String sql0 = "select mno,tno from major,teacher where mname= ? and tname = ? ;";
                    String[] str0 = new String[]{ course.getMname(),course.getTname() + ""};
                    ResultSet rs= studentDao.Search(sql0, str0);
                    String mno = null;
                    String tno = null;
                    while (rs.next()) {
                        mno = rs.getString("mno");
                        tno = rs.getString("tno");
                    }
                    //更新数据，不存在就添加，存在就更新
                    String sql = "insert into course (cno,cname,mno,tno)values(?,?,?,?) on duplicate key update cname=?,mno=?,tno=? ;";
                    String[] str = new String[]{cno,course.getCname(), mno,tno,course.getCname(),mno,tno + ""};
                    studentDao.AddU(sql, str);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }else if(id == 4){
            //成绩表
            List<Grade> listExcel=ExcelService.getAllByExcelG(filepath+filename+".xls");
            for (Grade grade : listExcel) {
                String sno = Long.toString(grade.getSno());
                String cname = grade.getCname();
                if (!teacherAction.isExistTwo("grade", sno,cname)) {
                    //不存在就添加
                    String sql = "insert into grade (sno,cno,regulargrade,testgrade,grade)values(?,(select cno from course where cname=?),?,?,?) ";
                    String[] str = new String[]{Long.toString(grade.getSno()), grade.getCname(),Float.toString(grade.getRegulargrade()),Float.toString(grade.getTestgrade()),Float.toString(grade.getGrade()) + ""};
                    studentDao.AddU(sql, str);
                } else {
                    //存在就更新
                    String sql = "update grade set sno=?,cno=(select cno from course where cname= ?),regulargrade=?,testgrade=?,grade=? where sno=?";
                    String[] str = new String[]{Long.toString(grade.getSno()), grade.getCname(),Float.toString(grade.getRegulargrade()),Float.toString(grade.getTestgrade()),Float.toString(grade.getGrade()),Long.toString(grade.getSno()) + ""};
                    studentDao.AddU(sql, str);
                }
            }
        }else if(id == 5){
            //学院表
            List<Academy> listExcel = ExcelService.getAllByExcelA(filepath+filename+".xls");
            for (Academy academy : listExcel) {
                String ano = Long.toString(academy.getAno());
                //不存在就添加,存在就更新
                String sql = "insert into academy (ano,aname)values(?,?) on duplicate key update aname=?";
                String[] str = new String[]{ano, academy.getAname(), academy.getAname() + ""};
                studentDao.AddU(sql, str);
            }
        }
    }
}
