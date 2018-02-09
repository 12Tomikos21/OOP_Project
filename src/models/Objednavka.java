package models;

import materials.*;

public class Objednavka{
	
	public double cena_t,cena_r;
	public int size;
	public int count;
	public material druh;
	public Kvalita hodnota_kvality = new Kvalita(this);/* Agregácia */
	public Objednavka(int count,int size,double cena_t,double cena_r, material druh){
		this.count = count;
		this.size = size;
		this.druh = druh;
		this.cena_t = cena_t;
		this.cena_r = cena_r;
	}
	
	public double kvalita(){
		return new Kvalita(this).hodnota;
	}
	
	public void vypocet(){
		druh.hodnota(this);
		}
	}