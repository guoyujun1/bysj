package gj.util;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 * 窗口设置类，包含每个窗口所必须设置的大小、位置、默认关闭方式等
 * 
 */
public class FrameOption {
	
	
	public FrameOption(JFrame frame) {
		// 设置窗口大小、位置、可视、默认关闭方式等
		frame.setVisible(true);
		// 窗口不可调整大小
		frame.setResizable(false);
		frame.setSize(800, 508);
		frame.setLocation(200,100);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
