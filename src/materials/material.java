package materials;

import models.Obj_Nike_Air_Max;
import models.Obj_Nike_Janoski;
import models.Objednavka;

public interface material {
	
	void hodnota(Obj_Nike_Air_Max air);
	void hodnota(Obj_Nike_Janoski jano);
	void hodnota(Objednavka t);
	
	double get_cena_t();
	void set_cena_t(double cena);
	
	double get_cena_r();
	void set_cena_r(double cena);
	 
}
