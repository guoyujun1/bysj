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


// ͼ����Ϣ���������

@SuppressWarnings("serial")
public class StudentGradeInformation extends JFrame {
	
	JFrame frame = new JFrame("���Ϲ���ѧԺѧ���ɼ�����ϵͳ");
	Container container = frame.getContentPane();
	
	JTable table;
	// ��ʾ���Ĺ������
	JScrollPane scrollPane;
	StudentAction studentAction;
	public StudentGradeInformation () {

		frame.setLayout(null);
		
		// ���ñ���ͼƬ
//		new BackgroundImage(frame,container,"BookInformation.jpg");
		// ��ӹ������Լ�������ͼ����¼�
		new StudentMenuBar(frame);
		studentAction = new StudentAction();

		// ���ô�����
		setTable();
		

		container.add(scrollPane);

	// ���ô��ڴ�С��λ�á����ӡ�Ĭ�Ϲرշ�ʽ��
		new FrameOption(frame);
	}
	
	
	/**
	 * ���ñ��
	 */
	private void setTable() {
		String[] columnNames = {"ѧ��", "����","רҵ","�γ�","ƽʱ�ɼ�"
				,"���Գɼ�","�ܳɼ�"};	
		try {
			StudentAction studentAction = new StudentAction();
			Object[][] results = studentAction.initializTable(columnNames);
		
			table = new JTable(results,columnNames);
			// ���ñ���ֶξ���
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