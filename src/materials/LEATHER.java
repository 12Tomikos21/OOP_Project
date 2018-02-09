package materials;

import models.Obj_Nike_Air_Max;
import models.Obj_Nike_Janoski;
import models.Objednavka;


public class LEATHER implements material{
	/*
	 * Vypoèet objednavky s materialom : koža
	 */
	private double l_t;
	private double l_r; 						
	public void hodnota(Obj_Nike_Air_Max air) {
		
		switch (air.size){
		case 40: air.cena_t = l_t; break;
		case 41: air.cena_t = l_t +0.05; break; 
		case 42: air.cena_t = l_t +0.15; break; 
		case 43: air.cena_t = l_t +0.25; break; 
		case 44: air.cena_t = l_t +0.30; break; 
		case 45: air.cena_t = l_t +0.35; break; 
		case 46: air.cena_t = l_t +0.40; break;
		case 47: air.cena_t = l_t +0.45; break; 
		case 48: air.cena_t = l_t +0.55; break; 
		}
		air.cena_r = l_r;
		air.cena_t *= air.count;
		air.cena_r *= air.count;
	}

	public void hodnota(Obj_Nike_Janoski jano) {
		
		switch (jano.size){
		case 40: jano.cena_t = l_t; break;
		case 41: jano.cena_t = l_t +0.05; break; 
		case 42: jano.cena_t = l_t +0.15; break; 
		case 43: jano.cena_t = l_t +0.25; break; 
		case 44: jano.cena_t = l_t +0.30; break; 
		case 45: jano.cena_t = l_t +0.35; break; 
		case 46: jano.cena_t = l_t +0.40; break;
		case 47: jano.cena_t = l_t +0.45; break; 
		case 48: jano.cena_t = l_t +0.55; break; 
		}
		jano.cena_r = l_r;
		jano.cena_t *= jano.count;
		jano.cena_r *= jano.count;
	}
	public void hodnota(Objednavka t) {
		
	}
	
	public double get_cena_t() {
		return l_t;}
	
	public void set_cena_t(double cena) {
		l_t = cena;}

	public double get_cena_r() {
		return l_r;}

	public void set_cena_r(double cena) {
		l_r = cena;}



	
}
