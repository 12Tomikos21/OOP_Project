package gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Start extends JFrame{
	public JButton start;
	public JTextField ucet;
	public JLabel label;
	public JPanel back;
	public Font font = new Font("SansSerif", Font.PLAIN, 18);
	private String Peniaze;
	
	public Start(){
		super("Úèet");
		ucet = new JTextField();
		start = new JButton("Start");
		label = new JLabel("Zdajte mnostvo peòazí na úète");
		
		label.setBounds(85,5,330,20);
		ucet.setBounds(50,25,250,30);
		start.setBounds(125, 60, 100, 50);
		
		ucet.setFont(font);
		
		back = new JPanel();
		getContentPane().add(back);
		back.setLayout(null);
		
		back.add(label);
		back.add(ucet);
		back.add(start);
		
		Grapics g = new Grapics();
		
		start.addActionListener(g);
		
		setSize(350,150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(false);
		
	}
	private class Grapics implements ActionListener{
		public void actionPerformed(ActionEvent event){
			JButton src = (JButton) event.getSource();
			
			Peniaze = ucet.getText();
			if (src.equals(start)){
				
				if (isInt(Peniaze)){
					REFUND.money = Integer.parseInt(Peniaze);
					dispose();
					new Gui();
				}
				else
					Error_4();
			}
		
		}
			
	}
	public void Error_4(){
		JFrame frame = new JFrame();
		frame.pack();
		JOptionPane.showMessageDialog(frame,"Zle vyplnené pole");
	}
	private boolean isInt(String numbers) { 
		if(numbers != null && !numbers.isEmpty())
			return numbers.chars().allMatch(c -> (c == '.' || Character.isDigit(c)));
		else return false;}
	
}
