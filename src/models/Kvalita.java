package models;

import materials.*;
/**
 * Výpoèet kvality objednávky
 */
public class Kvalita {
	double leather = 5, suede = 3, syntetic = 2;
	double Air = 5, Jano = 4;
	
	public double hodnota ;
	int i;
	
	public Kvalita(Objednavka typ){
		
		if (typ instanceof Obj_Nike_Air_Max){
			if (typ.druh instanceof LEATHER) hodnota = (Air+leather)/2;
			else if (typ.druh instanceof SUEDE) hodnota = (Air+suede)/2;
			else if (typ.druh instanceof SYNTETIC) hodnota = (Air+syntetic)/2;	
		}
		else
			if (typ instanceof Obj_Nike_Janoski){
				if (typ.druh instanceof LEATHER) hodnota = (Jano+leather)/2;
				else if (typ.druh instanceof SUEDE) hodnota = (Jano+suede)/2;
				else if (typ.druh instanceof SYNTETIC) hodnota = (Jano+syntetic)/2;	
		}
	}
	
}
