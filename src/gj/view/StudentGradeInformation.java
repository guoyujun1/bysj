package gj.view;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import gj.controller.StudentAction;
import gj.model.Student;
import gj.util.LimitTextLength;
import gj.util.StudentMenuBar;
import gj.util.FrameOption;
import gj.util.SetTableColumnCenter;


// 图书信息管理界面类

@SuppressWarnings("serial")
public class StudentGradeInformation extends JFrame {
	
	JFrame frame = new JFrame("湖南工程学院学生成绩管理系统");
	Container container = frame.getContentPane();
	
	JTable table;
	// 显示表格的滚动面板
	JScrollPane scrollPane;
	StudentAction studentAction;
	public StudentGradeInformation () {

		frame.setLayout(null);
		
		// 设置背景图片
//		new BackgroundImage(frame,container,"BookInformation.jpg");
		// 添加工具栏以及各组件和监听事件
		new StudentMenuBar(frame);
		studentAction = new StudentAction();

		// 设置窗体表格
		setTable();
		

		container.add(scrollPane);

	// 设置窗口大小、位置、可视、默认关闭方式等
		new FrameOption(frame);
	}
	
	
	/**
	 * 设置表格
	 */
	private void setTable() {
		String[] columnNames = {"学号", "姓名","专业","课程","平时成绩"
				,"考试成绩","总成绩"};	
		try {
			StudentAction studentAction = new StudentAction();
			Object[][] results = studentAction.initializTable(columnNames);
		
			table = new JTable(results,columnNames);
			// 设置表格字段居中
			new SetTableColumnCenter(table);
			scrollPane = new JScrollPane(table);
			scrollPane.setViewportView(table);
			scrollPane.setBounds(20,80,760,190);
			Student student = new Student();
			List<Student> studentList = new ArrayList<Student>();
			for (int j = 0; j < table.getRowCount(); j++) {
				student = new Student();
				student.setno((long) table.getValueAt(j, 0));
				student.setname((String) table.getValueAt(j, 1));
				student.setmname((String) table.getValueAt(j, 2));
				student.setcname((String) table.getValueAt(j, 3));
				student.setregulargrade((float) table.getValueAt(j, 4));
				student.settestgrade((float) table.getValueAt(j, 5));
				student.setgrade((float) table.getValueAt(j, 6));
				studentList.add(student);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}