package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import clinica.ClinicaSingleton;
import paciente.Paciente;
import vista.Ventana;

public class Controlador implements ActionListener {
	Ventana ventana;

	public Controlador() {
		ventana = new Ventana();
		ventana.setVisible(true);
		ventana.setListenerBotones(this);
		ventana.actualizarPacientesAtencion(ClinicaSingleton.getInstance().getListaAtencion());
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

		} else if (e.getActionCommand().equals("GENERARFACTURA")) {
			Paciente auxiliar = ventana.getPacienteSeleccionado();
			if(auxiliar == null)
				JOptionPane.showMessageDialog(null, "Debe seleccionar un paciente!");
			else {
				ClinicaSingleton.getInstance().creaFactura(auxiliar);
			}
				
		}
		ventana.actualizarPacientesAtencion(ClinicaSingleton.getInstance().getListaAtencion());
	}
}