package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.Ventana;

public class Controlador implements ActionListener {
	Ventana ventana;

	public Controlador() {
		ventana = new Ventana();
		ventana.setVisible(true);
		ventana.setListenerBotones(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand());

		if (e.getActionCommand().equals("AGREGAR")) {
			// Codigo a hacer al agregar asociado
			// Verificar que los cmapos esten completos

		} else if (e.getActionCommand().equals("ELIMINAR")) {
			// Codigo a hacer al eliminar asociado
			// Verificar todo

		} else if (e.getActionCommand().equals("GENERAR")) {
			// Codigo a hacer al generar una factura
		}

	}
}