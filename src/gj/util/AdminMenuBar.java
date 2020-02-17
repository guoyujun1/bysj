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

		//�ļ��˵�
		menuFile = new JMenu();
		setMenuFile();

		//�༭�˵�
		menuEdit = new JMenu();
		setMenuEdit();

		// ����һ��ѧ��˵���
		menuItemaddSyear = new JMenuItem();
		setMenuItemaddSyear();

		//ɾ�������һ��ѧ��������Ϣ
		menuItemDelSyear = new JMenuItem();
		setMenuDelSyear();

		//�����Ϣ�˵���
		menuItemAdd = new JMenuItem();
		setMenuItemAdd(frame);

		//�������˵���
		menuItemOutput = new JMenuItem();
		setMenuItemOutput();

		// �û���Ϣ���Ĳ˵���
		menuItemChangUser = new JMenuItem();
		setMenuItemChangeUser(frame);

		//�鿴����˵���
        menuItemPassword = new JMenuItem();
		setMenuItemPassword(frame);

		// �˳�ϵͳ�˵���
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


	//�ļ��˵�����
	private void setMenuFile() {
		menuFile.setText("�ļ�");
	}

	//�༭�˵�����
	private void setMenuEdit() {
		menuEdit.setText("�༭");
	}


	//������˵���
	private void setMenuItemAdd(JFrame frame) {
		// TODO Auto-generated method stub
		menuItemAdd.setText("�����");
		menuItemAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new StudentInformationInput();
			}
		});
	}

	//����һ��ѧ��
	private void setMenuItemaddSyear() {
		menuItemaddSyear.setText("����ѧ��");
		menuItemaddSyear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//������Ӧ����
				TeacherAction teacherAction = new TeacherAction();
				teacherAction.addSchoolYear();
			}
		});
	}

	//ɾ�������һ��ѧ��������Ϣ
	private void setMenuDelSyear() {
		menuItemDelSyear.setText("ɾ��ѧ��");
		menuItemDelSyear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//����ȷ�ϲ���
				int i = JOptionPane.showConfirmDialog(null,"�Ƿ�ɾ����ɾ�����޷��ָ�","ȷ��ɾ��",JOptionPane.YES_NO_OPTION);
				//���ѡ���ǣ�������Ӧ����ɾ������
				if(i==0) {
					TeacherAction teacherAction = new TeacherAction();
					teacherAction.delteteSchoolYear();
				}
			}
		});
	}

	//�������˵���
	private void setMenuItemOutput() {
		// TODO Auto-generated method stub
		menuItemOutput.setText("������");
		menuItemOutput.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
//				new StudentInformationOutput();
			}
		});
	}

	//�����û�����˵���
	private void setMenuItemChangeUser(JFrame frame) {
		// TODO Auto-generated method stub
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

    //�鿴����˵�������
    private void setMenuItemPassword(JFrame frame) {
		menuItemPassword.setText("�鿴�û�����");
		menuItemPassword.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // ʹ�����岻�ɼ�
                frame.setVisible(false);
            }
        });
    }

	//�˳��˵���
	private void setMenuItemExit(JFrame frame) {
		// TODO Auto-generated method stub
		menuItemExit.setText("�˳�ϵͳ");
		menuItemExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// �˳�����
				System.exit(0);
			}
		});
	}
}
