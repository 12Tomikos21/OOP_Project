package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import models.*;
import materials.*;

public class ADD implements ActionListener{
	
	public static int pocet = 0;
	int x,y;
	double cena_t , cena_r;
	String numbers;
	public Gui window = null;
	ADD(Gui w){
		window = w;
	}
	public void Leather(){
		switch (window.Model[window.C1.getSelectedIndex()]){
		case "Nike Janoski": window.o.add(new Obj_Nike_Janoski(x,y,cena_t,cena_r,new LEATHER())); break;
		case "Nike Air Max": window.o.add(new Obj_Nike_Air_Max(x,y,cena_t,cena_r,new LEATHER())); break;}
	}
	public void Suede(){
		switch (window.Model[window.C1.getSelectedIndex()]){
		case "Nike Janoski": window.o.add(new Obj_Nike_Janoski(x,y,cena_t,cena_r,new SUEDE())); break;
		case "Nike Air Max": window.o.add(new Obj_Nike_Air_Max(x,y,cena_t,cena_r,new SUEDE())); break;}
	}
	public void Syntetic(){
		switch (window.Model[window.C1.getSelectedIndex()]){
		case "Nike Janoski": window.o.add(new Obj_Nike_Janoski(x,y,cena_t,cena_r,new SYNTETIC())); break;
		case "Nike Air Max": window.o.add(new Obj_Nike_Air_Max(x,y,cena_t,cena_r,new SYNTETIC())); break;}
	}
	
	private boolean Podmienka1(){
		if (window.Model[window.C1.getSelectedIndex()].equals(" ")) return false;
		else return true;}
	private boolean Podmienka2(){
		if (window.Size[window.C2.getSelectedIndex()].equals(" ")) return false;
		else return true;}
	private boolean Podmienka3(){
		if (window.Materials[window.C3.getSelectedIndex()].equals(" ")) return false;
		else return true;}
	private boolean Podmienka4(){
		if (!isInt(window.pairs.getText())) return false;
		else return true;
	}
	/** Kontrola Ëi v Stringu su len ËÌsla
	 * @param numbers	String z textfield-u
	 * @return
	 */
	private boolean isInt(String numbers) { 
		if(numbers != null && !numbers.isEmpty())
			return numbers.chars().allMatch(c -> (c == '.' || Character.isDigit(c)));
		else return false;
	}
	/**
	 * @param numbers	String z textfield-u
	 * @return
	 * @throws MyException
	 */
	public int Pairs(String numbers) throws MyException{ 
		if (!(isInt(numbers))){
				throw new MyException();
			}
		return Integer.parseInt(numbers);
	}
	public void actionPerformed(ActionEvent event){ 
		/*
		 * Tvorba jednej objedn·vky
		 */
		JButton src = (JButton) event.getSource();
		
		numbers = window.pairs.getText();
		
		if (src.equals(window.add)){ 
			try {
				x = Pairs(numbers);
			} catch (MyException e) { 			
				window.Error_3();
			}
			if (Podmienka1() && Podmienka2() && Podmienka3() && Podmienka4()){ 
				/*
				 * Podmienky: musia byù zaplnenÈ vöetky polia (combobox & textfield)
				 */
				y = Integer.parseInt(window.Size[window.C2.getSelectedIndex()]);
				pocet++;
				window.textarea.append(pocet+". \t"+window.Model[window.C1.getSelectedIndex()]+"\t\t"+window.Size[window.C2.getSelectedIndex()]+"\t"+window.Materials[window.C3.getSelectedIndex()]+"\t"+window.pairs.getText()+"\n");
				
				switch(window.Materials[window.C3.getSelectedIndex()]){ 
				case"Koûa":	Leather(); break;
								
				case"Semiö": 	Suede(); break;
								
				case"Syntetika": Syntetic(); break;
				}
			}
			else{
				window.Error_1();
			}
		}
	}
}
