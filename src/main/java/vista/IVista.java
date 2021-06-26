package vista;

import concurrencia.Asociado;
import persona.paciente.Paciente;

import java.awt.event.ActionListener;
import java.awt.event.WindowListener;
import java.util.ArrayList;
/**
 * Interface que determina el comportamineto de la ventana<br>
 *
 * @author Los Cafeteros
 */

interface IVista {

	void setListenerBotones(ActionListener controlador);

	void setWindowListener(WindowListener windowListener);

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
	
	String getCantidadConsultas();
}
