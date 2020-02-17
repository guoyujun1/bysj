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
	private final JFrame frame = new JFrame("导出到Excel ");
	private final Container container = frame.getContentPane();
	//导出文件文件路径
	private JLabel LabelFilePath = new JLabel("文件路径");
	private JTextField textFieldFilePath  = new JTextField("F:\\Excel\\");
	//导出文件文件名
	private JLabel LabelFileaName = new JLabel("文件名");
	private JTextField textFieldFileName  = new JTextField();
	
	// 重置按钮
	private JButton buttonReset = new JButton();
	// 登录按钮
	private JButton buttonConfirm = new JButton();
	
	public StudentInformationOutput(String[][] value) {
		
		container.setLayout(null);
		
		// 设置窗口大小、位置、可视、默认关闭方式等
		setFrameOption();
		// 设置文件路径框以及监听事件
		setLabelFilePath();
		setTextFieldFilePath();
		// 设置文件名框以及监听事件
		setLabelFileName();
		setTextFieldFileName();
		//设置登录按钮和重置按钮事件
		setButtonConfirm(value);
		setButtonReset();
		
		container.add(LabelFilePath);
		container.add(textFieldFilePath);
		container.add(LabelFileaName);
		container.add(textFieldFileName);
		container.add(buttonConfirm);
		container.add(buttonReset);
	}

	// 设置窗口大小、位置、可视、默认关闭方式等
	private void setFrameOption() {
		// TODO Auto-generated method stub
		frame.setVisible(true);
		// 窗口不可调整大小
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
		// 键盘事件，如果按下回车则跳转到输入文件名
		new KeyListener(textFieldFilePath, textFieldFileName);
	}

	private void setLabelFileName() {
		// TODO Auto-generated method stub
		LabelFileaName.setBounds(80, 140, 180, 30);
	}

	private void setTextFieldFileName() {
		// TODO Auto-generated method stub
		textFieldFileName.setBounds(135, 140, 180, 30);
		// 键盘事件，如果按下回车则模拟点击导出按钮
		new KeyListener(textFieldFileName, buttonConfirm);
	}
	
	//设置重置按钮及其监听事件
	private void setButtonReset() {
		// TODO Auto-generated method stub
		buttonReset.setText("重置");
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
	
	//设置导出按钮及其监听事件
	private void setButtonConfirm(String[][] value) {
		// TODO Auto-generated method stub
		buttonConfirm.setText("导出");
		buttonConfirm.setBounds(100, 260, 90, 30);
		buttonConfirm.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent paramActionEvent) {
				// TODO Auto-generated method stub
				String filepath = new String(textFieldFilePath.getText());
				String filename = new String(textFieldFileName.getText());
				try {
					if (filepath.equals("") || filename.equals("")) {
						JOptionPane.showMessageDialog(null, "文件路径和文件名不能为空", "导出失败", JOptionPane.PLAIN_MESSAGE);
					} else {
						new OutputExcel(filepath,filename,value);
						JOptionPane.showMessageDialog(null, "文件保存在"+filepath,"导出成功", JOptionPane.PLAIN_MESSAGE);
						frame.setVisible(false);
					}
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
	}
}
