package gj.view;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import gj.controller.UserAction;
import gj.model.User;
//import gj.util.BackgroundImage;
import gj.util.FrameOption;
import gj.util.KeyListener;
import gj.util.LimitTextLength;
import gj.util.StudentMenuBar;
import gj.util.AdminMenuBar;

/**
 * 更改用户信息界面类
 * 
 * @author 1651200111 陈彦志
 */
@SuppressWarnings("serial")
public class ChangePasswordInformation extends JFrame {
	
	JFrame frame = new JFrame("更改密码");
	Container container = frame.getContentPane();
	
	private JLabel LabelPasswd = new JLabel("原密码");
	private JTextField textFieldPasswd = new JTextField();
	private JLabel LabelNewPasswd = new JLabel("新密码");
	private JTextField textFieldNewPasswd = new JTextField();
	private JButton buttonYes = new JButton();
	private JButton buttonReset = new JButton();
	User User = new User();
	public ChangePasswordInformation() {

		frame.setLayout(null);
		
		// 设置背景图片
//		new BackgroundImage(frame,container,"changeUser.jpg");
		// 添加工具栏以及各组件和监听事件
		if(User.table.equals("teacher")) {
			new AdminMenuBar(frame);
		}else {
			new StudentMenuBar(frame);
		}
		
		
		// 原密码框
		setLabelPasswd();
		setPasswordField();
		// 新密码框
		setLabelNewPasswd();
		setNewPasswordField();
		// 确认按钮
		setButtonYes();
		// 重置按钮
		setButtonReset();
		
		container.add(LabelPasswd);
		container.add(textFieldPasswd);
		container.add(LabelNewPasswd);
		container.add(textFieldNewPasswd);
		container.add(buttonReset);
		container.add(buttonYes);
		
		// 设置窗口大小、位置、可视、默认关闭方式等
		new FrameOption(frame);
	}



	/**
	 * 设置重置按钮
	 */
	private void setButtonReset() {
		buttonReset.setText("重置");
		buttonReset.setBounds(420,325,90,30);
		buttonReset.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				textFieldPasswd.setText("");
				textFieldNewPasswd.setText("");
			}
		});
	}

	
	/**
	 * 设置确认按钮，添加操作数据库更改密码事件
	 */
	public void setButtonYes(){
		buttonYes.setText("确认");
		buttonYes.setBounds(200,325,90,30);
		buttonYes.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String passwd = new String(textFieldPasswd.getText());
				String newpasswd = new String(textFieldNewPasswd.getText());
				UserAction userAction = new UserAction();
				try {
					List<User> userList = userAction.query(User.table,User.Username);
					for (User user : userList) {
			        	 if (user.getPasswd().equals(passwd))  {
			        		 userAction.edit(newpasswd);
			        		 JOptionPane.showMessageDialog(null,"密码修改成功","成功"
							,JOptionPane.PLAIN_MESSAGE);
			        		 frame.setVisible(false);
			        		 if(User.table.equals("teacher")) {
			        			 new AdminInformation();
			        			 }else {
			        				 new StudentGradeInformation();
			        				 }
			        		 }
			        	 else {
			        		 JOptionPane.showMessageDialog(null,"密码验证失败","密码修改失败"
										,JOptionPane.PLAIN_MESSAGE);
							}
					}
				}catch(Exception e1) {
					e1.printStackTrace();
				}		
			}
		});
	}

	/**
	 * 原密码框
	 */
	private void setLabelPasswd() {
		// TODO Auto-generated method stub
		LabelPasswd.setBounds(320,145,200,30);
	}

	public void setPasswordField() {
		// 限制用户输入长度
		textFieldPasswd.setDocument(new LimitTextLength(8));
		textFieldPasswd.setBounds(380,145,200,30);
		// 键盘事件，如果按下回车则跳转到输入新密码
		new KeyListener(textFieldPasswd,textFieldNewPasswd);
	}

	/**
	 * 新密码框
	 */
	private void setLabelNewPasswd() {
		// TODO Auto-generated method stub
		LabelNewPasswd.setBounds(320,235,200,30);
	}

	public void setNewPasswordField() {
		// 限制用户输入长度
		textFieldNewPasswd.setDocument(new LimitTextLength(8));
		textFieldNewPasswd.setBounds(380,235,200,30);
		new KeyListener(textFieldNewPasswd,buttonYes);
	}


}