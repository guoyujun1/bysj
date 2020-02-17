package gj.run;

import javax.swing.JFrame;

import gj.view.Login;
import gj.view.StudentInformationInput;


// Ö÷³ÌÐòÀà
 
@SuppressWarnings("serial")
public class Manage extends JFrame {
	

	public Manage() {
		
		new Login();

	}
	
	
	public static void main(String[] args) {
		
		new Manage();
		
	}

}
