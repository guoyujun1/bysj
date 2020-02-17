package gj.util;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import gj.model.Student;
import gj.view.ChangePasswordInformation;
import gj.view.StudentGradeInformation;
import gj.view.StudentInformationOutput;

public class StudentMenuBar {

	JMenuBar menuBar;
	JMenuItem menuItemGradeInformation;
	JMenuItem menuItemChangUser;
	JMenuItem menuItemOutput;
	JMenuItem menuItemExit;
	public StudentMenuBar(JFrame frame) {

		menuBar = new JMenuBar();

		// �ɼ������˵���
		menuItemGradeInformation = new JMenuItem();
		setMenuItemGradeInformation(frame);
		// �ɼ�����
		menuItemOutput = new JMenuItem();
		setMenuItemOutput();
		// �û���Ϣ���Ĳ˵���
		menuItemChangUser = new JMenuItem();
		setMenuItemChangeUser(frame);
		// �˳�ϵͳ�˵���
		menuItemExit = new JMenuItem();
		setMenuItemExit(frame);

		menuBar.add(menuItemGradeInformation);
		menuBar.add(menuItemOutput);
		menuBar.add(menuItemChangUser);
		menuBar.add(menuItemExit);

		frame.setJMenuBar(menuBar);
	}

	// �����Ϣ�˵�������
	private void setMenuItemOutput() {
		// TODO Auto-generated method stub
		menuItemOutput.setText("�������");
		menuItemOutput.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
//				new StudentInformationOutput();
			}
		});
	}

	// �˳��˵�������
	private void setMenuItemExit(JFrame frame) {

		menuItemExit.setText("�˳�ϵͳ");
		menuItemExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// �˳�ϵͳ
				System.exit(0);

			}
		});
	}

	// �ɼ������˵�������
	private void setMenuItemGradeInformation(JFrame frame) {

		menuItemGradeInformation.setText("�ɼ�����");
		menuItemGradeInformation.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// ʹ�����岻�ɼ�
				frame.setVisible(false);
				new StudentGradeInformation();
			}
		});
	}

	// ��������˵�������
	private void setMenuItemChangeUser(JFrame frame) {

		menuItemChangUser.setText("��������");
		menuItemChangUser.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// ʹ�����岻�ɼ�
				frame.setVisible(false);
				new ChangePasswordInformation();
			}
		});
	}
}
