package gj.controller;

import java.io.File;
import java.util.List;


import gj.model.Student;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;


public class OutputExcel {
	public OutputExcel(String path,String name,String[][] value) {
		 try {
	            WritableWorkbook wwb = null;
	             
	               // ������д���Excel������
	               String fileName = path+name+".xls";
	               
	               
	              // ������ʵд��� Excel ����������
	               File file=new File(fileName);
	               if (!file.exists()) {
	                   file.createNewFile();
	               }
	               //��fileNameΪ�ļ���������һ��Workbook
	               wwb = Workbook.createWorkbook(file);
	               // ����������
	               WritableSheet ws = wwb.createSheet("Test Sheet 1", 0);
	               //��ѯ���ݿ������е�����

	               //Ҫ���뵽��Excel�����кţ�Ĭ�ϴ�0��ʼ
	               Label labelSno= new Label(0, 0, "ѧ��");
	               Label labelName= new Label(1, 0, "����");
	               Label labelMajor= new Label(2, 0, "רҵ");
	               Label labelCourse= new Label(3, 0, "�γ�");
	               Label labelRegulargrade= new Label(4, 0, "ƽʱ�ɼ�");
	               Label labelTestgrade= new Label(5, 0, "���Գɼ�");
	               Label labelGrade= new Label(6, 0, "�ܳɼ�");
	               
	               ws.addCell(labelSno);
	               ws.addCell(labelName);
	               ws.addCell(labelMajor);
	               ws.addCell(labelCourse);
	               ws.addCell(labelRegulargrade);
	               ws.addCell(labelTestgrade);
	               ws.addCell(labelGrade);


			 for(int i = 0; i < value[0].length; i++) {
				 for (int j = 0; j < value.length; j++) {
					 Label data = new Label(i,j+1,value[j][i]);
					 ws.addCell(data);
				 }
			 }
	              /* for (int i = 0; i < studentList.size(); i++) {
	            	   Student student = (Student)studentList.get(i);

	                   Label labelSno_i= new Label(0, i+1, student.getno()+"");
	                   Label labelName_i= new Label(1, i+1, student.getname());
	                   Label labelMajor_i= new Label(2, i+1, student.getmname());
	                   Label labelCourse_i= new Label(3, i+1, student.getcname()+"");
	                   Label labelRegulargrade_i= new Label(4, i+1, student.getregulargrade()+"");
	                   Label labelTestgrade_i= new Label(5, i+1, student.gettestgrade()+"");
	                   Label labelGrade_i= new Label(6, i+1, student.getgrade()+"");
	                   ws.addCell(labelSno_i);
		               ws.addCell(labelName_i);
		               ws.addCell(labelMajor_i);
		               ws.addCell(labelCourse_i);
		               ws.addCell(labelRegulargrade_i);
		               ws.addCell(labelTestgrade_i);
		               ws.addCell(labelGrade_i);
	               }*/

	              //д���ĵ�
	               wwb.write();
	              // �ر�Excel����������
	               wwb.close();

	        } catch (Exception e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        } 
	}
}
