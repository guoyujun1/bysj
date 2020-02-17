package gj.util;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * �����¼��࣬���»س���ģ���������¼��ȷ�ϰ�ť�����ڵ�¼����͸������봰�壩
 * 
 */
public class KeyListener {
	
	public KeyListener(JTextField text,JTextField textFieldPasswd) {
		
		text.addKeyListener(new KeyAdapter(){      //���ı��� ta1 �����һ�����̼����¼�
		    public void keyReleased(KeyEvent paramKeyEvent){
		        if(paramKeyEvent.getKeyChar()=='\n')    //�����⵽������Enter��
		        	textFieldPasswd.requestFocus();     // ta2ʹ��requestFocus()���������ȡ����
		    }
		});
	}
	public KeyListener(JTextField text,JButton button) {
		
		// �����¼���������»س���ģ���������¼��ť
		text.addKeyListener(new KeyAdapter() {
	        @Override
	        public void keyPressed(KeyEvent paramKeyEvent) {
	            if(paramKeyEvent.getKeyChar()=='\n'){
	            	button.doClick();
	            }
	        }
	    });
	}
	
	public KeyListener(JPasswordField passwd,JButton button) {
		// �����¼���������»س���ģ���������¼��ť
		passwd.addKeyListener(new KeyAdapter() {
	        @Override
	        public void keyPressed(KeyEvent paramKeyEvent) {
	            if(paramKeyEvent.getKeyChar()=='\n'){
	            	button.doClick();
	            }
	        }
	    });
	}
    //���ÿ�ݼ�
	public void KeyListener(JTextField text) {
		text.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent paramKeyEvent) {// ����������ʱ������
				var keyCode = paramKeyEvent.getKeyCode();// �������keyCode�ı�ǩ
				//���µ���Ӣ�Ļ��˸��ɾ������ִ��
				if(keyCode>=48&&keyCode<=57||keyCode >= 65 && keyCode <= 90 || keyCode==8 || keyCode ==46||keyCode==13||keyCode==32)
				{
					String gettext = text.getText();
				}
			}
		});
	}

}
