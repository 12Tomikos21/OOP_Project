package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class DELETE implements ActionListener{
	
	public Gui window = null;
	DELETE(Gui w){
		window = w;
	}

	public void actionPerformed(ActionEvent event) {
		/*
		 * Vymazanie objedn·vok
		 */
		JButton src = (JButton) event.getSource();
		if (src.equals(window.delete)){
			window.o.clear();
			ADD.pocet = 0;
			PERFORM.pocet_p = 0;
			PERFORM.celkovacena = 0;
			PERFORM.hodnota = 0;
			window.textarea.setText("");
			window.textarea.append("Objednavka\tModel\t\tVeækosù\tMaterial\tPoËet\n");
		}
	}
}
