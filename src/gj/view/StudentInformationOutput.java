package gj.view;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import gj.dao.UserDao;
import gj.model.Student;
import gj.model.User;
import gj.util.KeyListener;
import gj.controller.OutputExcel;;

public class StudentInformationOutput {
	private final JFrame frame = new JFrame("������Excel ");
	private final Container container = frame.getContentPane();
	//�����ļ��ļ�·��
	private JLabel LabelFilePath = new JLabel("�ļ�·��");
	private JTextField textFieldFilePath  = new JTextField("F:\\Excel\\");
	//�����ļ��ļ���
	private JLabel LabelFileaName = new JLabel("�ļ���");
	private JTextField textFieldFileName  = new JTextField();
	
	// ���ð�ť
	private JButton buttonReset = new JButton();
	// ��¼��ť
	private JButton buttonConfirm = new JButton();
	
	public StudentInformationOutput(String[][] value) {
		
		container.setLayout(null);
		
		// ���ô��ڴ�С��λ�á����ӡ�Ĭ�Ϲرշ�ʽ��
		setFrameOption();
		// �����ļ�·�����Լ������¼�
		setLabelFilePath();
		setTextFieldFilePath();
		// �����ļ������Լ������¼�
		setLabelFileName();
		setTextFieldFileName();
		//���õ�¼��ť�����ð�ť�¼�
		setButtonConfirm(value);
		setButtonReset();
		
		container.add(LabelFilePath);
		container.add(textFieldFilePath);
		container.add(LabelFileaName);
		container.add(textFieldFileName);
		container.add(buttonConfirm);
		container.add(buttonReset);
	}

	// ���ô��ڴ�С��λ�á����ӡ�Ĭ�Ϲرշ�ʽ��
	private void setFrameOption() {
		// TODO Auto-generated method stub
		frame.setVisible(true);
		// ���ڲ��ɵ�����С
		frame.setResizable(false);
		frame.setSize(450, 360);
		frame.setLocation(300, 150);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	private void setLabelFilePath() {
		// TODO Auto-generated method stub
		LabelFilePath.setBounds(80, 100, 180, 30);
	}

	private void setTextFieldFilePath() {
		// TODO Auto-generated method stub
		textFieldFilePath.setBounds(135, 100, 180, 30);
		// �����¼���������»س�����ת�������ļ���
		new KeyListener(textFieldFilePath, textFieldFileName);
	}

	private void setLabelFileName() {
		// TODO Auto-generated method stub
		LabelFileaName.setBounds(80, 140, 180, 30);
	}

	private void setTextFieldFileName() {
		// TODO Auto-generated method stub
		textFieldFileName.setBounds(135, 140, 180, 30);
		// �����¼���������»س���ģ����������ť
		new KeyListener(textFieldFileName, buttonConfirm);
	}
	
	//�������ð�ť��������¼�
	private void setButtonReset() {
		// TODO Auto-generated method stub
		buttonReset.setText("����");
		buttonReset.setBounds(220, 260, 90, 30);
		buttonReset.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				textFieldFilePath.setText("F:\\Excel\\");
				textFieldFileName.setText("");
			}
		});
	}
	
	//���õ�����ť��������¼�
	private void setButtonConfirm(String[][] value) {
		// TODO Auto-generated method stub
		buttonConfirm.setText("����");
		buttonConfirm.setBounds(100, 260, 90, 30);
		buttonConfirm.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent paramActionEvent) {
				// TODO Auto-generated method stub
				String filepath = new String(textFieldFilePath.getText());
				String filename = new String(textFieldFileName.getText());
				try {
					if (filepath.equals("") || filename.equals("")) {
						JOptionPane.showMessageDialog(null, "�ļ�·�����ļ�������Ϊ��", "����ʧ��", JOptionPane.PLAIN_MESSAGE);
					} else {
						new OutputExcel(filepath,filename,value);
						JOptionPane.showMessageDialog(null, "�ļ�������"+filepath,"�����ɹ�", JOptionPane.PLAIN_MESSAGE);
						frame.setVisible(false);
					}
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
	}
}
