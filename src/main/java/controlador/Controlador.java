package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;

import javax.swing.JOptionPane;

import clinica.ClinicaSingleton;
import clinica.serializacion.Persistencia;
import concurrencia.Asociado;
import exception.AsociadoExistenteException;
import modulos.ModuloAmbulancia;
import persona.paciente.Paciente;
import vista.Ventana;

public class Controlador implements ActionListener, WindowListener {
	static Ventana ventana;

	public Controlador(Ventana v) {
		ventana = v;
		ventana.setVisible(true);
		ventana.setListenerBotones(this);
		ventana.actualizarPacientesAtencion(ClinicaSingleton.getInstance().getListaAtencion());
		ventana.actualizarAsociados(ClinicaSingleton.getInstance().getListaAsociados());
		ventana.setEstadoAmbulancia("En la clinica");

		ventana.setWindowListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();

		if (comando.equals("AGREGAR")) {
			if (!ventana.getDNI().isEmpty() && !ventana.getNombre().isEmpty()
					&& !ventana.getCantidadConsultas().isEmpty()) {
				Asociado aux = null;
				String nombre = ventana.getNombre();
				String apellido = ventana.getApellido();
				String DNI = ventana.getDNI();
				String telefono = ventana.getDNI();
				String domicilio = ventana.getDNI();
				String actividad = ventana.getActividad();
				Integer cantConsultas;
				try {
					cantConsultas = Integer.parseInt(ventana.getCantidadConsultas());
					if (cantConsultas <= 0)
						throw new NumberFormatException();

					aux = new Asociado(nombre, apellido, DNI, telefono, domicilio, actividad);
					try {
						ClinicaSingleton.getInstance().addAsociado(aux);
					} catch (AsociadoExistenteException asociadoExistenteException) {
						JOptionPane.showMessageDialog(null, "El asociado ya existe");
					}
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "La cantidad de consultas debe ser un entero positivo");
					cantConsultas = 1;
				}
			} else {
				JOptionPane.showMessageDialog(null,
						"Debe completar los datos del asociado! Nombre, DNI y Cantidad de consultas son obligatorios");
			}

		} else if (comando.equals("ELIMINAR")) {
			Asociado asoc = ventana.getAsociadoSeleccionado();
			if (asoc == null)
				JOptionPane.showMessageDialog(null, "Debe seleccionar un asociado para eliminarlo!");
			else {
				ClinicaSingleton.getInstance().eliminaAsociado(asoc);

			}

		} else if (comando.equals("GENERARFACTURA")) {
			Paciente auxiliar = ventana.getPacienteSeleccionado();
			if (auxiliar == null)
				JOptionPane.showMessageDialog(null, "Debe seleccionar un persona.paciente!");
			else {
				ClinicaSingleton.getInstance().creaFactura(auxiliar);
			}
		} else if (comando.equals("SERIALIZAR")) {
			try {
				Persistencia.persisteDatos();
			} catch (IOException e1) {
				JOptionPane.showMessageDialog(null, "Hubo un error, no se pudo persistir los datos! (IOException)");
				e1.printStackTrace();
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
		ventana.nuevoSuceso(suceso + "\n");
	}

	public static void actualizaAsociados() {
		ventana.actualizarAsociados(ClinicaSingleton.getInstance().getListaAsociados());
	}

	@Override
	public void windowOpened(WindowEvent e) {

	}

	@Override
	public void windowClosing(WindowEvent e) {
		try {
			Persistencia.persisteDatos();
			System.out.println("Se guardo los datos al cerrar");
		} catch (IOException e1) {
			JOptionPane.showMessageDialog(null, "Hubo un error, no se pudo persistir los datos! (IOException)");
			e1.printStackTrace();
		}
	}

	@Override
	public void windowClosed(WindowEvent e) {

	}

	@Override
	public void windowIconified(WindowEvent e) {

	}

	@Override
	public void windowDeiconified(WindowEvent e) {

	}

	@Override
	public void windowActivated(WindowEvent e) {

	}

	@Override
	public void windowDeactivated(WindowEvent e) {

	}
}