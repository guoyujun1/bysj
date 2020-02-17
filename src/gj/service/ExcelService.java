package gj.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import gj.model.*;
import jxl.Sheet;
import jxl.Workbook;

import javax.swing.*;

import gj.model.Student;

public class ExcelService {
    /**
     * 读取指定目录中电子表格中所有的数据，学生信息表
     * @param file 文件完整路径
     * @return
     */
    public static List<Student> getAllByExcelS(String file) {

        List<Student> list = new ArrayList<Student>();
        try {
            Workbook rwb = Workbook.getWorkbook(new File(file));
            Sheet rs = rwb.getSheet("Test Sheet 1");//或者rwb.getSheet(0)
            int clos = rs.getColumns();//得到所有的列
            int rows = rs.getRows();//得到所有的行

            for (int i = 1; i < rows; i++) {
                for (int j = 0; j < clos; j++) {
                    //第一个是列数，第二个是行数
                    String no = rs.getCell(j++, i).getContents();//默认最左边编号也算一列 所以这里得j++
                    String name = rs.getCell(j++, i).getContents();
                    String mname = rs.getCell(j++, i).getContents();
                    String clas = rs.getCell(j++, i).getContents();

                    list.add(new Student(Long.parseLong(no), name, mname, clas));
                }
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 读取指定目录中电子表格中所有的数据，教师信息表
     * @param file
     * @return
     */
    public static List<Teacher> getAllByExcelT(String file) {

            List<Teacher> list = new ArrayList<Teacher>();
            try {
                Workbook rwb = Workbook.getWorkbook(new File(file));
                Sheet rs = rwb.getSheet("Test Sheet 1");//或者rwb.getSheet(0)
                int clos = rs.getColumns();//得到所有的列
                int rows = rs.getRows();//得到所有的行

                for (int i = 1; i < rows; i++) {
                    for (int j = 0; j < clos; j++) {
                        //第一个是列数，第二个是行数
                        String tno = rs.getCell(j++, i).getContents();//默认最左边编号也算一列 所以这里得j++
                        String tname = rs.getCell(j++, i).getContents();

                        list.add(new Teacher(tno, tname));
                    }
                }
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            return list;
            }
    /**
     * 读取指定目录中电子表格中所有的数据，课程信息表
     * @param file
     * @return
     */
    public static List<Course> getAllByExcelC(String file) {

        List<Course> list = new ArrayList<Course>();
        try {
            Workbook rwb = Workbook.getWorkbook(new File(file));
            Sheet rs = rwb.getSheet("Test Sheet 1");//或者rwb.getSheet(0)
            int clos = rs.getColumns();//得到所有的列
            int rows = rs.getRows();//得到所有的行

            for (int i = 1; i < rows; i++) {
                for (int j = 0; j < clos; j++) {
                    //第一个是列数，第二个是行数
                    String cno = rs.getCell(j++, i).getContents();//默认最左边编号也算一列 所以这里得j++
                    String cname = rs.getCell(j++, i).getContents();
                    String mname = rs.getCell(j++, i).getContents();
                    String tname = rs.getCell(j++,i).getContents();

                    list.add(new Course(Integer.parseInt(cno), cname,mname,tname));
                }
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 读取指定目录中电子表格中所有的数据，专业信息表
     * @param file
     * @return
     */
    public static List<Major> getAllByExcelM(String file) {

        List<Major> list = new ArrayList<Major>();
        try {
            Workbook rwb = Workbook.getWorkbook(new File(file));
            Sheet rs = rwb.getSheet("Test Sheet 1");//或者rwb.getSheet(0)
            int clos = rs.getColumns();//得到所有的列
            int rows = rs.getRows();//得到所有的行

            for (int i = 1; i < rows; i++) {
                for (int j = 0; j < clos; j++) {
                    //第一个是列数，第二个是行数
                    String mno = rs.getCell(j++, i).getContents();//默认最左边编号也算一列 所以这里得j++
                    String mname = rs.getCell(j++, i).getContents();
                    String aname = rs.getCell(j++, i).getContents();

                    list.add(new Major(Integer.parseInt(mno),mname,aname));
                }
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 读取指定目录中电子表格中所有的数据，成绩表
     * @param file
     * @return
     */
    public static List<Grade> getAllByExcelG(String file) {

        List<Grade> list = new ArrayList<Grade>();
        try {
            Workbook rwb = Workbook.getWorkbook(new File(file));
            Sheet rs = rwb.getSheet("Test Sheet 1");//或者rwb.getSheet(0)
            int clos = rs.getColumns();//得到所有的列
            int rows = rs.getRows();//得到所有的行

            for (int i = 1; i < rows; i++) {
                for (int j = 0; j < clos; j++) {
                    //第一个是列数，第二个是行数
                    String sno = rs.getCell(j++, i).getContents();//默认最左边编号也算一列 所以这里得j++
                    String sname = rs.getCell(j++, i).getContents();
                    String cname = rs.getCell(j++, i).getContents();
                    String regulargrade = rs.getCell(j++, i).getContents();
                    String testgrade = rs.getCell(j++, i).getContents();
                    String grade = rs.getCell(j++, i).getContents();

                    list.add(new Grade(Long.parseLong(sno),cname,Float.parseFloat(regulargrade),Float.parseFloat(testgrade),Float.parseFloat(grade)));
                }
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 读取指定目录中电子表格中所有的数据，学院表表
     * @param file
     * @return
     */
    public static List<Academy> getAllByExcelA(String file) {

        List<Academy> list = new ArrayList<Academy>();
        try {
            Workbook rwb = Workbook.getWorkbook(new File(file));
            Sheet rs = rwb.getSheet("Test Sheet 1");//或者rwb.getSheet(0)
            int clos = rs.getColumns();//得到所有的列
            int rows = rs.getRows();//得到所有的行

            for (int i = 1; i < rows; i++) {
                for (int j = 0; j < clos; j++) {
                    //第一个是列数，第二个是行数
                    String ano = rs.getCell(j++, i).getContents();//默认最左边编号也算一列 所以这里得j++
                    String aname = rs.getCell(j++, i).getContents();

                    list.add(new Academy(Integer.parseInt(ano),aname));
                }
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list;
    }

    public String[][] setdata(JTable table) {
        String[][] value = new String[table.getRowCount()][table.getColumnCount()];
        for (int i = 0; i < table.getRowCount(); i++) {
                for (int j = 0; j < table.getColumnCount(); j++) {

                    if(table.getValueAt(i,j)==null){
                        value[i][j] = null;
                    }else {
                        value[i][j] = table.getValueAt(i, j).toString();
                    }
                }
        }
            return value;
    }

    public String[][] setData(JTable table,int row) {
        String[][] value = new String[1][table.getColumnCount()];
        for (int j = 0; j < table.getColumnCount(); j++) {
            value[0][j] = table.getValueAt(row, j).toString();
        }

        return value;
    }
   /* public List<Student> setData(JTable table){
        Student student;
        List<Student> studentList = new ArrayList<Student>();;
        for (int j = 0; j < table.getRowCount(); j++) {
            student = new Student();
            student.setno((long) table.getValueAt(j, 0));
            student.setname((String) table.getValueAt(j, 1));
            student.setmname((String) table.getValueAt(j, 2));
            student.setcname((String) table.getValueAt(j, 3));
            student.setregulargrade((float) table.getValueAt(j, 4));
            student.settestgrade(Float.parseFloat((String) table.getValueAt(j, 5)));
            student.setgrade((float) table.getValueAt(j, 6));
            studentList.add(student);
        }
        return studentList;
    }*/
}
