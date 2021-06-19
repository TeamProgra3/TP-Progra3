package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import clinica.ClinicaSingleton;
import concurrencia.Asociado;
import modulos.ModuloAmbulancia;
import paciente.Paciente;
import vista.Ventana;

public class Controlador implements ActionListener {
	static Ventana ventana;

	public Controlador() {
		ventana = new Ventana();
		ventana.setVisible(true);
		ventana.setListenerBotones(this);
		ventana.actualizarPacientesAtencion(ClinicaSingleton.getInstance().getListaAtencion());
		ventana.setEstadoAmbulancia("Hola!");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();

		if (comando.equals("AGREGAR")) {
			if (!ventana.getDNI().isBlank() && !ventana.getNombre().isBlank()) {
				String nombre = ventana.getNombre();
				String apellido = ventana.getApellido();
				String DNI = ventana.getDNI();
				String telefono = ventana.getDNI();
				String domicilio = ventana.getDNI();
				ClinicaSingleton.getInstance().addAsociado(new Asociado(nombre,apellido,DNI,telefono,domicilio));
			} else {
				JOptionPane.showMessageDialog(null, "Debe completar los datos del asociado! DNI y Nombre son obligatorios");
			}
				

		} else if (comando.equals("ELIMINAR")) {
			Asociado asoc = ventana.getAsociadoSeleccionado();
			if(asoc == null)
				JOptionPane.showMessageDialog(null, "Debe seleccionar un asociado para eliminarlo!");
			else {
				ClinicaSingleton.getInstance().eliminaAsociado(asoc);;
			}

		} else if (comando.equals("GENERARFACTURA")) {
			Paciente auxiliar = ventana.getPacienteSeleccionado();
			if(auxiliar == null)
				JOptionPane.showMessageDialog(null, "Debe seleccionar un paciente!");
			else {
				ClinicaSingleton.getInstance().creaFactura(auxiliar);
			}
				
		} else if (comando.equals("INICIARSIMULACION")) {
			if (ClinicaSingleton.getInstance().getListaAsociados().isEmpty())
				ModuloAmbulancia.cargaRapida();
			ClinicaSingleton.getInstance().iniciarSimulacion();
		}
		ventana.actualizarPacientesAtencion(ClinicaSingleton.getInstance().getListaAtencion());
		ventana.actualizarAsociados(ClinicaSingleton.getInstance().getListaAsociados());
	}
	
	public static void actualizarEstadoAmbulancia(String estadoActual) {
		ventana.setEstadoAmbulancia(estadoActual);
	}
	
	public static void agregarSuceso(String suceso) {
		ventana.nuevoSuceso(suceso);
		ventana.nuevoSuceso("\n");
	}
}