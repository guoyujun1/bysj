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
 * ��¼������
 * 
 */
@SuppressWarnings("serial")
public class Login extends JFrame {

	private final JFrame frame = new JFrame("���Ϲ���ѧԺѧ���ɼ�����ϵͳ ");
	private final Container container = frame.getContentPane();
	// �û�����
	private JLabel LabelUserName = new JLabel("�˺�");
	private JTextField textFieldtUserName = new JTextField();
	// �����
	private JLabel LabelPasswd = new JLabel("����");
	private JPasswordField textFieldPasswd = new JPasswordField();
	// ��֤���
	private JLabel LabelValidCode = new JLabel("��֤��");
	private JTextField CodeFieldPasswd = new JTextField();
	private ValidCode ValidCode = new ValidCode();
	// ���ð�ť
	private JButton buttonReset = new JButton();
	// ��¼��ť
	private JButton buttonLogin = new JButton();
	
	private String[] listData = new String[] { "��ʦ", "ѧ��" ,"����Ա"};
	private final JComboBox<String> ComboBoxPost = new JComboBox<String>(listData);
	User User = new User();
	private int users;

	public Login() {

		container.setLayout(null);

		// ���ô��ڴ�С��λ�á����ӡ�Ĭ�Ϲرշ�ʽ��
		setFrameOption();
		// ���ñ���ͼƬ
//		new BackgroundImage(frame,container,"login.jpg");

		// �����û������Լ������¼�
		setLabelUserName();
		setTextFieldUserName();

		// ����������Լ������¼�
		setLabelPasswd();
		setPasswdField();

		// ������֤����Լ������¼�
		setLabelValidCode();
		setCodeFieldPasswd();
		setValidCode();

		// ���õ�¼��ť�Լ���Ӽ����¼�
		setButtonLogin();

		// �������ð�ť�Լ���Ӽ����¼�
		setButtonReset();

		// ����ѡ����Լ������¼�
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

		// ���ð�ť���͸��
		new SetJButton(buttonLogin);
		new SetJButton(buttonReset);
	}

	/**
	 * �������ð�ť�Լ������¼�
	 */
	private void setButtonReset() {

		buttonReset.setText("����");
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

	// ���ô��ڴ�С��λ�á����ӡ�Ĭ�Ϲرշ�ʽ��
	private void setFrameOption() {
		frame.setVisible(true);
		// ���ڲ��ɵ�����С
		frame.setResizable(false);
		frame.setSize(450, 360);
		frame.setLocation(300, 150);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	/**
	 * ���õ�¼��ť�Լ������¼�
	 */
	private void setButtonLogin() {

		buttonLogin.setText("��¼");
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
						JOptionPane.showMessageDialog(null, "�û��������롢��֤�벻��Ϊ��", "����", JOptionPane.PLAIN_MESSAGE);
					} else {
						// ��֤�û���
						if (!userAction.isExist(User.table, username)) {
							JOptionPane.showMessageDialog(null, "�û�������", "����", JOptionPane.PLAIN_MESSAGE);
						} else {
							User.Username = username;
							List<User> userList = userAction.query(User.table, username);
							// ��֤�������֤��
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
									JOptionPane.showMessageDialog(null, "�������֤�����", "����", JOptionPane.PLAIN_MESSAGE);
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
	 * ����������Լ���Ӽ����¼�
	 */
	private void setPasswdField() {
		// TODO Auto-generated method stub
		// �����û����볤��
		textFieldPasswd.setDocument(new LimitTextLength(8));
		textFieldPasswd.setBounds(135, 140, 180, 30);
		// �����¼���������»س�����ת��������֤��
		new KeyListener(textFieldPasswd, CodeFieldPasswd);

	}

	private void setLabelPasswd() {
		// TODO Auto-generated method stub
		LabelPasswd.setBounds(100, 140, 180, 30);
	}

	/**
	 * �����û������Լ���Ӽ����¼�
	 */
	private void setTextFieldUserName() {
		// TODO Auto-generated method stub
		// �����û����볤��
		textFieldtUserName.setDocument(new LimitTextLength(12));
		textFieldtUserName.setBounds(135, 100, 180, 30);
		// �����¼���������»س�����ת����������
		new KeyListener(textFieldtUserName, textFieldPasswd);
	}

	private void setLabelUserName() {
		// TODO Auto-generated method stub
		LabelUserName.setBounds(100, 100, 180, 30);
	}

//	ѡ���
	private void setComboBoxPost() {
		ComboBoxPost.setBounds(135, 60, 180, 30);
		// �����Ŀѡ��״̬�ı�ļ�����
		ComboBoxPost.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				// ֻ����ѡ�е�״̬
				if (e.getStateChange() == ItemEvent.SELECTED) {
					users = ComboBoxPost.getSelectedIndex();

				}
			}
		});
	}

	// ������֤��������
	private void setCodeFieldPasswd() {
		// TODO Auto-generated method stub
		CodeFieldPasswd.setBounds(135, 180, 180, 30);
		// �����¼���������»س���ģ���������¼��ť
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

	// ��֤���ȷ��
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
