package gj.view;


import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import gj.controller.UserAction;
import gj.model.User;
//import gj.util.BackgroundImage;
import gj.util.*;

/**
 * 登录界面类
 * 
 */
@SuppressWarnings("serial")
public class Login extends JFrame {

	private final JFrame frame = new JFrame("湖南工程学院学生成绩管理系统 ");
	private final Container container = frame.getContentPane();
	// 用户名框
	private JLabel LabelUserName = new JLabel("账号");
	private JTextField textFieldtUserName = new JTextField();
	// 密码框
	private JLabel LabelPasswd = new JLabel("密码");
	private JPasswordField textFieldPasswd = new JPasswordField();
	// 验证码框
	private JLabel LabelValidCode = new JLabel("验证码");
	private JTextField CodeFieldPasswd = new JTextField();
	private ValidCode ValidCode = new ValidCode();
	// 重置按钮
	private JButton buttonReset = new JButton();
	// 登录按钮
	private JButton buttonLogin = new JButton();
	
	private String[] listData = new String[] { "教师", "学生" ,"管理员"};
	private final JComboBox<String> ComboBoxPost = new JComboBox<String>(listData);
	User User = new User();
	private int users;

	public Login() {

		container.setLayout(null);

		// 设置窗口大小、位置、可视、默认关闭方式等
		setFrameOption();
		// 设置背景图片
//		new BackgroundImage(frame,container,"login.jpg");

		// 设置用户名框以及监听事件
		setLabelUserName();
		setTextFieldUserName();

		// 设置密码框以及监听事件
		setLabelPasswd();
		setPasswdField();

		// 设置验证码框以及监听事件
		setLabelValidCode();
		setCodeFieldPasswd();
		setValidCode();

		// 设置登录按钮以及添加监听事件
		setButtonLogin();

		// 设置重置按钮以及添加监听事件
		setButtonReset();

		// 设置选择框以及监听事件
		setComboBoxPost();

		container.add(LabelUserName);
		container.add(textFieldtUserName);
		container.add(LabelPasswd);
		container.add(textFieldPasswd);
		container.add(buttonLogin);
		container.add(buttonReset);
		container.add(ComboBoxPost);
		container.add(LabelValidCode);
		container.add(CodeFieldPasswd);
		container.add(ValidCode);

		// 设置按钮风格：透明
		new SetJButton(buttonLogin);
		new SetJButton(buttonReset);
	}

	/**
	 * 设置重置按钮以及监听事件
	 */
	private void setButtonReset() {

		buttonReset.setText("重置");
		buttonReset.setBounds(220, 260, 90, 30);
		buttonReset.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				textFieldtUserName.setText("201610010213");
				textFieldPasswd.setText("gj123231");
				CodeFieldPasswd.setText("");
			}
		});
	}

	// 设置窗口大小、位置、可视、默认关闭方式等
	private void setFrameOption() {
		frame.setVisible(true);
		// 窗口不可调整大小
		frame.setResizable(false);
		frame.setSize(450, 360);
		frame.setLocation(300, 150);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	/**
	 * 设置登录按钮以及监听事件
	 */
	private void setButtonLogin() {

		buttonLogin.setText("登录");
//		buttonLogin.setIcon(new ImageIcon("res/button_login.jpg"));
		buttonLogin.setBounds(100, 260, 90, 30);
		buttonLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent paramActionEvent) {
				// TODO Auto-generated method stub
				String username = new String(textFieldtUserName.getText());
				String passwd = new String(textFieldPasswd.getPassword());
				String vcode = new String(CodeFieldPasswd.getText());
				UserAction userAction = new UserAction();

				if (users == 0) {
					User.table = "teacher";
				} else {
					User.table = "student";
				}
				try {
					if (username.equals("") || passwd.equals("")/* || vcode.equals("") */) {
						JOptionPane.showMessageDialog(null, "用户名、密码、验证码不能为空", "错误", JOptionPane.PLAIN_MESSAGE);
					} else {
						// 验证用户名
						if (!userAction.isExist(User.table, username)) {
							JOptionPane.showMessageDialog(null, "用户名错误", "错误", JOptionPane.PLAIN_MESSAGE);
						} else {
							User.Username = username;
							List<User> userList = userAction.query(User.table, username);
							// 验证密码和验证码
							for (User user : userList) {
								if (user.getPasswd().equals(passwd)/* &&isValidCodeRight() */) {
									frame.setVisible(false);
									if(users==0) {
										new AdminMenuBar(frame);
									}
									else if(users==1) {
										new StudentMenuBar(frame);
									}
									new AdminInformation();
								} else {
									JOptionPane.showMessageDialog(null, "密码或验证码错误", "错误", JOptionPane.PLAIN_MESSAGE);
								}
							}
						}
					}
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});

	}

	/**
	 * 设置密码框以及添加监听事件
	 */
	private void setPasswdField() {
		// TODO Auto-generated method stub
		// 限制用户输入长度
		textFieldPasswd.setDocument(new LimitTextLength(8));
		textFieldPasswd.setBounds(135, 140, 180, 30);
		// 键盘事件，如果按下回车则跳转到输入验证码
		new KeyListener(textFieldPasswd, CodeFieldPasswd);

	}

	private void setLabelPasswd() {
		// TODO Auto-generated method stub
		LabelPasswd.setBounds(100, 140, 180, 30);
	}

	/**
	 * 设置用户名框以及添加监听事件
	 */
	private void setTextFieldUserName() {
		// TODO Auto-generated method stub
		// 限制用户输入长度
		textFieldtUserName.setDocument(new LimitTextLength(12));
		textFieldtUserName.setBounds(135, 100, 180, 30);
		// 键盘事件，如果按下回车则跳转到输入密码
		new KeyListener(textFieldtUserName, textFieldPasswd);
	}

	private void setLabelUserName() {
		// TODO Auto-generated method stub
		LabelUserName.setBounds(100, 100, 180, 30);
	}

//	选择框
	private void setComboBoxPost() {
		ComboBoxPost.setBounds(135, 60, 180, 30);
		// 添加条目选中状态改变的监听器
		ComboBoxPost.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				// 只处理选中的状态
				if (e.getStateChange() == ItemEvent.SELECTED) {
					users = ComboBoxPost.getSelectedIndex();

				}
			}
		});
	}

	// 设置验证码框及其组件
	private void setCodeFieldPasswd() {
		// TODO Auto-generated method stub
		CodeFieldPasswd.setBounds(135, 180, 180, 30);
		// 键盘事件，如果按下回车则模拟鼠标点击登录按钮
		new KeyListener(CodeFieldPasswd, buttonLogin);
	}

	private void setLabelValidCode() {
		// TODO Auto-generated method stub
		LabelValidCode.setBounds(90, 180, 180, 30);
	}

	private void setValidCode() {
		// TODO Auto-generated method stub
		ValidCode.setBounds(330, 170, 180, 30);
	}

	// 验证码的确认
	public boolean isValidCodeRight() {
		if (CodeFieldPasswd == null) {
			return false;
		} else if (ValidCode == null) {
			return true;
		} else if (ValidCode.getCode().equals(CodeFieldPasswd.getText())) {
			return true;
		} else
			return false;
	}

}
