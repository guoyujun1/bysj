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

		// 成绩检索菜单项
		menuItemGradeInformation = new JMenuItem();
		setMenuItemGradeInformation(frame);
		// 成绩表导出
		menuItemOutput = new JMenuItem();
		setMenuItemOutput();
		// 用户信息更改菜单项
		menuItemChangUser = new JMenuItem();
		setMenuItemChangeUser(frame);
		// 退出系统菜单项
		menuItemExit = new JMenuItem();
		setMenuItemExit(frame);

		menuBar.add(menuItemGradeInformation);
		menuBar.add(menuItemOutput);
		menuBar.add(menuItemChangUser);
		menuBar.add(menuItemExit);

		frame.setJMenuBar(menuBar);
	}

	// 输出信息菜单项设置
	private void setMenuItemOutput() {
		// TODO Auto-generated method stub
		menuItemOutput.setText("导出表格");
		menuItemOutput.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
//				new StudentInformationOutput();
			}
		});
	}

	// 退出菜单项设置
	private void setMenuItemExit(JFrame frame) {

		menuItemExit.setText("退出系统");
		menuItemExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 退出系统
				System.exit(0);

			}
		});
	}

	// 成绩检索菜单项设置
	private void setMenuItemGradeInformation(JFrame frame) {

		menuItemGradeInformation.setText("成绩检索");
		menuItemGradeInformation.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 使父窗体不可见
				frame.setVisible(false);
				new StudentGradeInformation();
			}
		});
	}

	// 更改密码菜单项设置
	private void setMenuItemChangeUser(JFrame frame) {

		menuItemChangUser.setText("更改密码");
		menuItemChangUser.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 使父窗体不可见
				frame.setVisible(false);
				new ChangePasswordInformation();
			}
		});
	}
}
