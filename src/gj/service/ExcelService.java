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
     * ��ȡָ��Ŀ¼�е��ӱ�������е����ݣ�ѧ����Ϣ��
     * @param file �ļ�����·��
     * @return
     */
    public static List<Student> getAllByExcelS(String file) {

        List<Student> list = new ArrayList<Student>();
        try {
            Workbook rwb = Workbook.getWorkbook(new File(file));
            Sheet rs = rwb.getSheet("Test Sheet 1");//����rwb.getSheet(0)
            int clos = rs.getColumns();//�õ����е���
            int rows = rs.getRows();//�õ����е���

            for (int i = 1; i < rows; i++) {
                for (int j = 0; j < clos; j++) {
                    //��һ�����������ڶ���������
                    String no = rs.getCell(j++, i).getContents();//Ĭ������߱��Ҳ��һ�� ���������j++
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
     * ��ȡָ��Ŀ¼�е��ӱ�������е����ݣ���ʦ��Ϣ��
     * @param file
     * @return
     */
    public static List<Teacher> getAllByExcelT(String file) {

            List<Teacher> list = new ArrayList<Teacher>();
            try {
                Workbook rwb = Workbook.getWorkbook(new File(file));
                Sheet rs = rwb.getSheet("Test Sheet 1");//����rwb.getSheet(0)
                int clos = rs.getColumns();//�õ����е���
                int rows = rs.getRows();//�õ����е���

                for (int i = 1; i < rows; i++) {
                    for (int j = 0; j < clos; j++) {
                        //��һ�����������ڶ���������
                        String tno = rs.getCell(j++, i).getContents();//Ĭ������߱��Ҳ��һ�� ���������j++
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
     * ��ȡָ��Ŀ¼�е��ӱ�������е����ݣ��γ���Ϣ��
     * @param file
     * @return
     */
    public static List<Course> getAllByExcelC(String file) {

        List<Course> list = new ArrayList<Course>();
        try {
            Workbook rwb = Workbook.getWorkbook(new File(file));
            Sheet rs = rwb.getSheet("Test Sheet 1");//����rwb.getSheet(0)
            int clos = rs.getColumns();//�õ����е���
            int rows = rs.getRows();//�õ����е���

            for (int i = 1; i < rows; i++) {
                for (int j = 0; j < clos; j++) {
                    //��һ�����������ڶ���������
                    String cno = rs.getCell(j++, i).getContents();//Ĭ������߱��Ҳ��һ�� ���������j++
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
     * ��ȡָ��Ŀ¼�е��ӱ�������е����ݣ�רҵ��Ϣ��
     * @param file
     * @return
     */
    public static List<Major> getAllByExcelM(String file) {

        List<Major> list = new ArrayList<Major>();
        try {
            Workbook rwb = Workbook.getWorkbook(new File(file));
            Sheet rs = rwb.getSheet("Test Sheet 1");//����rwb.getSheet(0)
            int clos = rs.getColumns();//�õ����е���
            int rows = rs.getRows();//�õ����е���

            for (int i = 1; i < rows; i++) {
                for (int j = 0; j < clos; j++) {
                    //��һ�����������ڶ���������
                    String mno = rs.getCell(j++, i).getContents();//Ĭ������߱��Ҳ��һ�� ���������j++
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
     * ��ȡָ��Ŀ¼�е��ӱ�������е����ݣ��ɼ���
     * @param file
     * @return
     */
    public static List<Grade> getAllByExcelG(String file) {

        List<Grade> list = new ArrayList<Grade>();
        try {
            Workbook rwb = Workbook.getWorkbook(new File(file));
            Sheet rs = rwb.getSheet("Test Sheet 1");//����rwb.getSheet(0)
            int clos = rs.getColumns();//�õ����е���
            int rows = rs.getRows();//�õ����е���

            for (int i = 1; i < rows; i++) {
                for (int j = 0; j < clos; j++) {
                    //��һ�����������ڶ���������
                    String sno = rs.getCell(j++, i).getContents();//Ĭ������߱��Ҳ��һ�� ���������j++
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
     * ��ȡָ��Ŀ¼�е��ӱ�������е����ݣ�ѧԺ���
     * @param file
     * @return
     */
    public static List<Academy> getAllByExcelA(String file) {

        List<Academy> list = new ArrayList<Academy>();
        try {
            Workbook rwb = Workbook.getWorkbook(new File(file));
            Sheet rs = rwb.getSheet("Test Sheet 1");//����rwb.getSheet(0)
            int clos = rs.getColumns();//�õ����е���
            int rows = rs.getRows();//�õ����е���

            for (int i = 1; i < rows; i++) {
                for (int j = 0; j < clos; j++) {
                    //��һ�����������ڶ���������
                    String ano = rs.getCell(j++, i).getContents();//Ĭ������߱��Ҳ��һ�� ���������j++
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
