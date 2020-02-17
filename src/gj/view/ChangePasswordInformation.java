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
 * �����û���Ϣ������
 * 
 * @author 1651200111 ����־
 */
@SuppressWarnings("serial")
public class ChangePasswordInformation extends JFrame {
	
	JFrame frame = new JFrame("��������");
	Container container = frame.getContentPane();
	
	private JLabel LabelPasswd = new JLabel("ԭ����");
	private JTextField textFieldPasswd = new JTextField();
	private JLabel LabelNewPasswd = new JLabel("������");
	private JTextField textFieldNewPasswd = new JTextField();
	private JButton buttonYes = new JButton();
	private JButton buttonReset = new JButton();
	User User = new User();
	public ChangePasswordInformation() {

		frame.setLayout(null);
		
		// ���ñ���ͼƬ
//		new BackgroundImage(frame,container,"changeUser.jpg");
		// ��ӹ������Լ�������ͼ����¼�
		if(User.table.equals("teacher")) {
			new AdminMenuBar(frame);
		}else {
			new StudentMenuBar(frame);
		}
		
		
		// ԭ�����
		setLabelPasswd();
		setPasswordField();
		// �������
		setLabelNewPasswd();
		setNewPasswordField();
		// ȷ�ϰ�ť
		setButtonYes();
		// ���ð�ť
		setButtonReset();
		
		container.add(LabelPasswd);
		container.add(textFieldPasswd);
		container.add(LabelNewPasswd);
		container.add(textFieldNewPasswd);
		container.add(buttonReset);
		container.add(buttonYes);
		
		// ���ô��ڴ�С��λ�á����ӡ�Ĭ�Ϲرշ�ʽ��
		new FrameOption(frame);
	}



	/**
	 * �������ð�ť
	 */
	private void setButtonReset() {
		buttonReset.setText("����");
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
	 * ����ȷ�ϰ�ť����Ӳ������ݿ���������¼�
	 */
	public void setButtonYes(){
		buttonYes.setText("ȷ��");
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
			        		 JOptionPane.showMessageDialog(null,"�����޸ĳɹ�","�ɹ�"
							,JOptionPane.PLAIN_MESSAGE);
			        		 frame.setVisible(false);
			        		 if(User.table.equals("teacher")) {
			        			 new AdminInformation();
			        			 }else {
			        				 new StudentGradeInformation();
			        				 }
			        		 }
			        	 else {
			        		 JOptionPane.showMessageDialog(null,"������֤ʧ��","�����޸�ʧ��"
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
	 * ԭ�����
	 */
	private void setLabelPasswd() {
		// TODO Auto-generated method stub
		LabelPasswd.setBounds(320,145,200,30);
	}

	public void setPasswordField() {
		// �����û����볤��
		textFieldPasswd.setDocument(new LimitTextLength(8));
		textFieldPasswd.setBounds(380,145,200,30);
		// �����¼���������»س�����ת������������
		new KeyListener(textFieldPasswd,textFieldNewPasswd);
	}

	/**
	 * �������
	 */
	private void setLabelNewPasswd() {
		// TODO Auto-generated method stub
		LabelNewPasswd.setBounds(320,235,200,30);
	}

	public void setNewPasswordField() {
		// �����û����볤��
		textFieldNewPasswd.setDocument(new LimitTextLength(8));
		textFieldNewPasswd.setBounds(380,235,200,30);
		new KeyListener(textFieldNewPasswd,buttonYes);
	}


}