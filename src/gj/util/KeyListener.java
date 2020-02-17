package gj.util;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * 键盘事件类，按下回车则模拟鼠标点击登录、确认按钮（用在登录窗体和更改密码窗体）
 * 
 */
public class KeyListener {
	
	public KeyListener(JTextField text,JTextField textFieldPasswd) {
		
		text.addKeyListener(new KeyAdapter(){      //在文本框 ta1 中添加一个键盘监听事件
		    public void keyReleased(KeyEvent paramKeyEvent){
		        if(paramKeyEvent.getKeyChar()=='\n')    //如果检测到输入了Enter键
		        	textFieldPasswd.requestFocus();     // ta2使用requestFocus()方法请求获取焦点
		    }
		});
	}
	public KeyListener(JTextField text,JButton button) {
		
		// 键盘事件，如果按下回车则模拟鼠标点击登录按钮
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
		// 键盘事件，如果按下回车则模拟鼠标点击登录按钮
		passwd.addKeyListener(new KeyAdapter() {
	        @Override
	        public void keyPressed(KeyEvent paramKeyEvent) {
	            if(paramKeyEvent.getKeyChar()=='\n'){
	            	button.doClick();
	            }
	        }
	    });
	}
    //设置快捷键
	public void KeyListener(JTextField text) {
		text.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent paramKeyEvent) {// 按键被按下时被触发
				var keyCode = paramKeyEvent.getKeyCode();// 获得描述keyCode的标签
				//按下的是英文或退格或删除键都执行
				if(keyCode>=48&&keyCode<=57||keyCode >= 65 && keyCode <= 90 || keyCode==8 || keyCode ==46||keyCode==13||keyCode==32)
				{
					String gettext = text.getText();
				}
			}
		});
	}

}
