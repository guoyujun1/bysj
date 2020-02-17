package gj.util;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;

/**
 *  按钮风格设置类
 */
public class SetJButton {
	
	//按钮透明
	public SetJButton(JButton button) {
		// TODO Auto-generated constructor stub
		button.setBackground(new Color(102, 0, 204));// 紫色 
		button.setFont(new Font("Dialog", Font.BOLD, 24));  
		button.setOpaque(false);  
		button.setBorder(BorderFactory.createEmptyBorder()); 
	}

}
