package gui;

aspect Action {
	pointcut Error1() : call (* Gui.Error_1*());
	pointcut Error2() : call (* Gui.Error_2*());
	pointcut Error3() : call (* Gui.Error_3*());
	pointcut Error4() : call (* Start.Error_4*());
	pointcut Error(): Error1() || Error2() || Error3() || Error4();
	
	before():  Error() {
		System.out.println("Error");
	}
	
	pointcut Add_leather() : call (* ADD.Leather*());
	pointcut Add_suede() : call (* ADD.Suede*());
	pointcut Add_syntetic() : call (* ADD.Syntetic*());
	pointcut Add() : Add_leather() || Add_suede() || Add_syntetic();
	
	before(): Add(){
		System.out.println("Order added");
	}
}
