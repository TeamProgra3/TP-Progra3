package vista;

import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JList;

import concurrencia.Asociado;
import paciente.Paciente;

interface IVista {

	void setListenerBotones(ActionListener controlador);

	void actualizarPacientesAtencion(ArrayList<Paciente> arrayList);

	void actualizarAsociados(ArrayList<Asociado> arrayList);

	Paciente getPacienteSeleccionado();

	Asociado getAsociadoSeleccionado();

	String getNombre();

	String getApellido();

	String getDNI();

	String getTelefono();

	String getDomicilio();

	void setEstadoAmbulancia(String texto) ;

	void nuevoSuceso(String suceso);

	String getActividad();
}
