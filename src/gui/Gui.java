package gui;

import javax.swing.*;

import models.Objednavka;

import java.awt.*;
import java.awt.event.ActionListener;
//import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class Gui extends JFrame {
	
	public List<Objednavka> o;
	public JButton perform,add,delete,refund;
	private JPanel panel;
	public JTextField pairs;
	public JTextArea textarea;
	public JComboBox C1,C2,C3;
	public JScrollPane scroll;
	private JLabel l_Model,l_Size,l_Materials,l_Number; 
	public String[] Materials = { " ","Koûa","Syntetika","Semiö" };
	public String[] Size = { " ", "40" , "41" , "42" , "43" , "44" , "45" , "46" , "47" , "48"};
	public String[] Model = { " ","Nike Janoski" , "Nike Air Max"};
	public Font font1 = new Font("SansSerif", Font.BOLD, 20);
	
	public Gui(){
		super("Application");
		//setContentPane(new JLabel(background));
		textarea = new JTextArea();
		textarea.setEditable(true);
		
		l_Model = new JLabel("Model"); l_Size = new JLabel("Veækosù"); l_Materials = new JLabel("Materialy"); l_Number = new JLabel("PoËet p·rov");
		perform = new JButton("V˝poËet");
		add = new JButton("Pridaj");
		delete = new JButton("Vymazaù"); delete.setBackground(Color.RED);
		refund =  new JButton("ZAPLAç");
		C1 = new JComboBox(Model); C2 = new JComboBox(Size); C3 = new JComboBox(Materials);
		
		Font font2 = new Font("SansSerif", Font.PLAIN, 18);
		Font font3 = new Font("SansSerif", Font.PLAIN, 18);
		
		o = new ArrayList<Objednavka>();
		
		pairs = new JTextField();
		pairs.setBackground(UIManager.getColor("Button.background"));
		pairs.setEditable(true);
		pairs.setFont(font1);
		
		C1.setFont(font2); C2.setFont(font2); C3.setFont(font2);
		l_Model.setFont(font1); l_Size.setFont(font1); l_Materials.setFont(font1); l_Number.setFont(font1);
		
		C3.setBounds(125, 63, 124, 35);
		l_Materials.setBounds(12, 66, 100, 35);
		C2.setBounds(585, 18, 50, 35);
		l_Size.setBounds(434, 17, 90, 35);
		C1.setBounds(125, 18, 202, 35);
		l_Model.setBounds(15, 17, 80, 35);
		pairs.setBounds(555, 66, 80, 35);
		l_Number.setBounds(371, 66, 152, 35);
		add.setBounds(15, 111, 107, 35);
		delete.setBounds(336, 111, 107, 35);
		perform.setBounds(178, 111, 107, 35);
		refund.setBounds(528, 111, 107, 35);
		
		ADD pridaj = new ADD(this);
		PERFORM execute = new PERFORM(this);
		DELETE vymaz = new DELETE(this);
		REFUND zaplat = new REFUND(this);
				
		add.addActionListener(pridaj);
		perform.addActionListener(execute);
		delete.addActionListener(vymaz);
		refund.addActionListener(zaplat);
		
		
		panel = new JPanel();
		getContentPane().add(panel);
		
		scroll = new JScrollPane(textarea);
		scroll.setBounds(15, 159, 620, 656);
		panel.setBackground(Color.WHITE);
		
		panel.add(C1); panel.add(C2); panel.add(C3);
		panel.add(perform); panel.add(add); panel.add(delete); panel.add(refund);
		panel.add(l_Materials); panel.add(l_Size); panel.add(l_Model); panel.add(l_Number);
		
		panel.setLayout(null);
		panel.add(pairs);
		panel.add(scroll);
		
		textarea.setBorder(BorderFactory.createLineBorder(Color.black));
		textarea.setFont(font3);
		
		
		textarea.append("Objednavka\tModel\t\tVeækosù\tMaterial\tPoËet\n");
		
        setSize(670, 875);
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	setVisible(true);
    	setResizable(true);
    	
	}
	
	public void Error_1(){
		JFrame frame1 = new JFrame();
		frame1.pack();
		JOptionPane.showMessageDialog(frame1,"ProsÌm, zadajte spr·vne objdn·vku");}
	public void Error_2(){
		JFrame frame2 = new JFrame();
		frame2.pack();
		JOptionPane.showMessageDialog(frame2,"Nem·te ûiadne dostupnÈ objedn·vky");
	}
	public void Error_3(){
		JFrame frame3 = new JFrame();
		frame3.pack();
		JOptionPane.showMessageDialog(frame3,"Zle vyplnenÈ pole poËt˙ p·rov");
	}
}
