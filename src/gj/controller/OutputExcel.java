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
	             
	               // 创建可写入的Excel工作簿
	               String fileName = path+name+".xls";
	               
	               
	              // 创建真实写入的 Excel 工作薄对象
	               File file=new File(fileName);
	               if (!file.exists()) {
	                   file.createNewFile();
	               }
	               //以fileName为文件名来创建一个Workbook
	               wwb = Workbook.createWorkbook(file);
	               // 创建工作表
	               WritableSheet ws = wwb.createSheet("Test Sheet 1", 0);
	               //查询数据库中所有的数据

	               //要插入到的Excel表格的列号，默认从0开始
	               Label labelSno= new Label(0, 0, "学号");
	               Label labelName= new Label(1, 0, "姓名");
	               Label labelMajor= new Label(2, 0, "专业");
	               Label labelCourse= new Label(3, 0, "课程");
	               Label labelRegulargrade= new Label(4, 0, "平时成绩");
	               Label labelTestgrade= new Label(5, 0, "考试成绩");
	               Label labelGrade= new Label(6, 0, "总成绩");
	               
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

	              //写进文档
	               wwb.write();
	              // 关闭Excel工作簿对象
	               wwb.close();

	        } catch (Exception e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        } 
	}
}
