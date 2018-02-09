package gui;

import java.awt.event.*;
import java.text.DecimalFormat;

import javax.swing.JButton;

import materials.*;
import models.*;
import prct.Main;

public class PERFORM implements ActionListener {
	
	DecimalFormat df = new DecimalFormat("#.##");
	
	public static int pocet_p;
	public static double celkovacena = 0;
	public static double hodnota = 0;

	public double cenaobj_r = 0;
	public double cenaobj_t = 0;

	private double fix_naklady = 1100;
	/*
	 * Fixn� n�klady :cena za pren�jom, cena za energie ....
	 */
	public Gui window = null;
	PERFORM(Gui w){
		window = w;}
	public REFUND m = null;
	PERFORM(REFUND cash){
		m = cash;}
	
	/** V�po�et ceny jednej objedn�vky
	 * @param teniska 
	 */
	void vypocet1obj(Objednavka teniska){
		
		/*
		 * Nastavenie v�robn�ch n�kladov
		 */
		if (teniska.druh instanceof LEATHER){		
			teniska.druh.set_cena_r(3.5);
			if (teniska instanceof Obj_Nike_Air_Max)
				teniska.druh.set_cena_t(6.5);
			else 
				if (teniska instanceof Obj_Nike_Janoski)
					teniska.druh.set_cena_t(5.5);}
		
		if (teniska.druh instanceof SUEDE){
			teniska.druh.set_cena_r(2.2);
			if (teniska instanceof Obj_Nike_Air_Max)
				teniska.druh.set_cena_t(4.5);
			else 
				if (teniska instanceof Obj_Nike_Janoski)
					teniska.druh.set_cena_t(4);}
		
		if (teniska.druh instanceof SYNTETIC){
			teniska.druh.set_cena_r(1.5);
			teniska.druh.set_cena_t(2.5);}
		
		teniska.vypocet();
	}
	/** Vypo�et kvality objedn�vky
	 * @param teniska 
	 * @return
	 */
	double vypocetkvality(Objednavka teniska){
		return teniska.kvalita();
	}

	public void actionPerformed(ActionEvent event) { 	
		
		/* Vypo�et celkovej ceny (vyberanie objednavok,
		 * vypo�et ka�dej jednej objednavky, vypo�et kvality ...)
		 */
		JButton src = (JButton) event.getSource();
		
		if (src.equals(window.perform))
			pocet_p = 0;
			if (window.o.isEmpty() != true){
				for(Objednavka x: window.o){
					pocet_p += x.count;
					vypocet1obj(x);
					hodnota += vypocetkvality(x);		
					cenaobj_t = x.cena_t;
					cenaobj_r = x.cena_r;
					celkovacena += cenaobj_t;
					celkovacena -= cenaobj_r;
					}
				hodnota /= window.o.size();
				window.textarea.append("\nZisk z objedn�vky: "+celkovacena+"�\n"); 
				celkovacena -= fix_naklady;
				REFUND.zisk = celkovacena;
				if (celkovacena >= 0)
					window.textarea.append("Pocet p�rov "+pocet_p+" Celkov� zisk: "+df.format(celkovacena)+"�\n");
				else
					window.textarea.append("Pocet p�rov "+pocet_p+" Celkov� strata: "+df.format(celkovacena)+"�\n");
				window.textarea.append("Kvalita objedn�vok: "+df.format(hodnota)+" hviezdi�ky\n\n");
			}
			else{
				window.Error_2();}
	}

}
