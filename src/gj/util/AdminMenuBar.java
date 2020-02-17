package gj.util;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.*;

import gj.controller.TeacherAction;
import gj.model.Student;
import gj.model.Teacher;
import gj.view.ChangePasswordInformation;
import gj.view.StudentInformationInput;
import gj.view.StudentInformationOutput;
import gj.view.AdminInformation;


public class AdminMenuBar {
	JMenuBar menuBar;
	JMenu menuFile,menuEdit;
	JMenuItem menuItemaddSyear,menuItemDelSyear, menuItemChangUser, menuItemExit, menuItemOutput, menuItemAdd;
	JMenuItem menuItemPassword;

	//	JMenuItem menuItemMajor,menuItemCourse,menuItemStudent;
	public AdminMenuBar(JFrame frame) {

		menuBar = new JMenuBar();

		//文件菜单
		menuFile = new JMenu();
		setMenuFile();

		//编辑菜单
		menuEdit = new JMenu();
		setMenuEdit();

		// 新增一个学年菜单项
		menuItemaddSyear = new JMenuItem();
		setMenuItemaddSyear();

		//删除最早的一个学年的相关信息
		menuItemDelSyear = new JMenuItem();
		setMenuDelSyear();

		//添加信息菜单项
		menuItemAdd = new JMenuItem();
		setMenuItemAdd(frame);

		//导出表单菜单项
		menuItemOutput = new JMenuItem();
		setMenuItemOutput();

		// 用户信息更改菜单项
		menuItemChangUser = new JMenuItem();
		setMenuItemChangeUser(frame);

		//查看密码菜单项
        menuItemPassword = new JMenuItem();
		setMenuItemPassword(frame);

		// 退出系统菜单项
		menuItemExit = new JMenuItem();
		setMenuItemExit(frame);


		menuBar.add(menuFile);
		menuBar.add(menuEdit);

		menuFile.add(menuItemAdd);
		menuFile.add(menuItemOutput);
		menuFile.add(menuItemExit);

		menuEdit.add(menuItemaddSyear);
		menuEdit.add(menuItemDelSyear);
		menuEdit.add(menuItemChangUser);
		menuEdit.add(menuItemPassword);

		frame.setJMenuBar(menuBar);
	}


	//文件菜单设置
	private void setMenuFile() {
		menuFile.setText("文件");
	}

	//编辑菜单设置
	private void setMenuEdit() {
		menuEdit.setText("编辑");
	}


	//导入表单菜单项
	private void setMenuItemAdd(JFrame frame) {
		// TODO Auto-generated method stub
		menuItemAdd.setText("导入表单");
		menuItemAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new StudentInformationInput();
			}
		});
	}

	//新增一个学年
	private void setMenuItemaddSyear() {
		menuItemaddSyear.setText("新增学年");
		menuItemaddSyear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//调用相应方法
				TeacherAction teacherAction = new TeacherAction();
				teacherAction.addSchoolYear();
			}
		});
	}

	//删除最早的一个学年的相关信息
	private void setMenuDelSyear() {
		menuItemDelSyear.setText("删除学年");
		menuItemDelSyear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//弹框确认操作
				int i = JOptionPane.showConfirmDialog(null,"是否删除，删除后将无法恢复","确认删除",JOptionPane.YES_NO_OPTION);
				//如果选择是，调用相应方法删除数据
				if(i==0) {
					TeacherAction teacherAction = new TeacherAction();
					teacherAction.delteteSchoolYear();
				}
			}
		});
	}

	//导出表单菜单项
	private void setMenuItemOutput() {
		// TODO Auto-generated method stub
		menuItemOutput.setText("导出表单");
		menuItemOutput.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
//				new StudentInformationOutput();
			}
		});
	}

	//更改用户密码菜单项
	private void setMenuItemChangeUser(JFrame frame) {
		// TODO Auto-generated method stub
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

    //查看密码菜单项设置
    private void setMenuItemPassword(JFrame frame) {
		menuItemPassword.setText("查看用户密码");
		menuItemPassword.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 使父窗体不可见
                frame.setVisible(false);
            }
        });
    }

	//退出菜单项
	private void setMenuItemExit(JFrame frame) {
		// TODO Auto-generated method stub
		menuItemExit.setText("退出系统");
		menuItemExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 退出程序
				System.exit(0);
			}
		});
	}
}
