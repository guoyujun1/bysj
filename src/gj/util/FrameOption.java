package gj.util;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 * ���������࣬����ÿ���������������õĴ�С��λ�á�Ĭ�Ϲرշ�ʽ��
 * 
 */
public class FrameOption {
	
	
	public FrameOption(JFrame frame) {
		// ���ô��ڴ�С��λ�á����ӡ�Ĭ�Ϲرշ�ʽ��
		frame.setVisible(true);
		// ���ڲ��ɵ�����С
		frame.setResizable(false);
		frame.setSize(800, 508);
		frame.setLocation(200,100);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
