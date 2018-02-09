package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import prct.Main;

public class REFUND implements ActionListener{

	public Gui window = null;
	REFUND(Gui w){
		window = w;}
	
	public static double money ; 
	/*
	 * Peniaze na úète
	 */
	public static double zisk = 0;
	
	public void actionPerformed(ActionEvent event) { 	
			JButton src = (JButton) event.getSource();

				if (src.equals(window.refund)){
					money +=zisk ;
					window.textarea.append("Peniaze na uète: "+money+"€\n\n");
					zisk = 0;
				}
	}
}
