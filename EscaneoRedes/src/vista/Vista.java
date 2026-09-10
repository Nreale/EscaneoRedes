package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Vista extends JFrame implements ActionListener{
	
	public Vista() {
		setSize(750, 450);
		setVisible(true);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args) {
	    new Vista();
	}		 
	
}
