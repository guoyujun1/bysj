package gj.util;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;

/**
 *  ��ť���������
 */
public class SetJButton {
	
	//��ť͸��
	public SetJButton(JButton button) {
		// TODO Auto-generated constructor stub
		button.setBackground(new Color(102, 0, 204));// ��ɫ 
		button.setFont(new Font("Dialog", Font.BOLD, 24));  
		button.setOpaque(false);  
		button.setBorder(BorderFactory.createEmptyBorder()); 
	}

}
