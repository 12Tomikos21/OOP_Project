package models;

import materials.*;

public class Obj_Nike_Air_Max extends Objednavka{
	public Obj_Nike_Air_Max(int count,int size,double cena_t,double cena_r,material druh){
		/* Dedenie */
		super(count,size,cena_t,cena_r,druh); 
	}
	/**
	 * Polymorfizmus - prekonanie metódy
	 */
	public void vypocet(){
		druh.hodnota(this);
	}
}
