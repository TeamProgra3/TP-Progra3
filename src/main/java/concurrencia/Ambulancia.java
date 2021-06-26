package concurrencia;

import controlador.Controlador;
import estados.EnClinicaState;
import estados.IState;

/**
 * La clase "Ambulancia" tiene la intencion de simular un recurso compartido
 * (una ambulancia) la cual recibe peticiones de varias personas (Hilos) <br>
 * <b> Patron aplicado: </b> Singleton
 *
 * @author Los Cafeteros
 */

public class Ambulancia {
	private static Ambulancia instance = null;
	IState estado;

	private Ambulancia() {
		estado = new EnClinicaState();
	}

	public static Ambulancia getInstance() {
		if (instance == null)
			instance = new Ambulancia();
		return instance;
	}

	public IState getEstado() {
		return estado;
	}

	public void setEstado(IState estado) {
		this.estado = estado;
	}

	/**
	 * Recibe un Asociado por parametro eh intenta cambiar el estado de la
	 * ambulancia
	 *
	 * @param asociado - id de persona.paciente <b>Pre-condicion:</b> asociado no
	 *                 NULL<br>
	 */
	public synchronized void atenderPacienteDomicilio(Asociado asociado) {
		Controlador.agregarSuceso(asociado.getNombre() + " solicita atencion en su domicilio");
		IState estadoAnterior = this.estado;
		this.estado.solicitaAtencionDomicilio();
		Controlador.actualizarEstadoAmbulancia(this.estado.estadoActual());

		while (estadoAnterior == this.estado) {
			try {
				wait();
				estadoAnterior = this.estado;
				this.estado.solicitaAtencionDomicilio();
				Controlador.actualizarEstadoAmbulancia(this.estado.estadoActual());

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		notifyAll();
		Controlador.agregarSuceso(asociado.getNombre() + " deja de esperar ");

		Controlador.actualizaAsociados();
	}

	/**
	 * Recibe un Asociado por parametro eh intenta cambiar el estado de la
	 * ambulancia
	 *
	 * @param asociado - id de persona.paciente <b>Pre-condicion:</b> asociado no
	 *                 NULL<br>
	 */
	public synchronized void volverAClinica(Asociado asociado) {
		Controlador.agregarSuceso(asociado.getNombre() + " solicita que la ambulancia vuelva a clinica");
		IState estadoAnterior = this.estado;
		this.estado.volverClinica();
		Controlador.actualizarEstadoAmbulancia(this.estado.estadoActual());
		while (estadoAnterior == this.estado) {
			try {
				wait();
				estadoAnterior = this.estado;
				this.estado.volverClinica();
				Controlador.actualizarEstadoAmbulancia(this.estado.estadoActual());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		notifyAll();
		Controlador.agregarSuceso("Ambulancia está llegando a la clinica - pedido por: " + asociado.getNombre());

		Controlador.actualizaAsociados();
	}

	/**
	 * Recibe un Asociado por parametro eh intenta cambiar el estado de la
	 * ambulancia
	 *
	 * @param asociado - id de persona.paciente <b>Pre-condicion:</b> asociado no
	 *                 NULL<br>
	 */

	public synchronized void trasladarAClinica(Asociado asociado) {
		Controlador.agregarSuceso(asociado.getNombre() + " solicita traslado a la clinica");
		IState estadoAnterior = this.estado;
		this.estado.solicitaTrasladoClinica();
		Controlador.actualizarEstadoAmbulancia(this.estado.estadoActual());
		while (estadoAnterior == this.estado) {
			try {
				wait();
				estadoAnterior = this.estado;
				this.estado.solicitaTrasladoClinica();
				Controlador.actualizarEstadoAmbulancia(this.estado.estadoActual());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		notifyAll();
		Controlador.agregarSuceso(asociado.getNombre() + " esta siendo trasladado a la clinica");
		Controlador.actualizaAsociados();
	}

	/**
	 * Recibe un Asociado por parametro eh intenta cambiar el estado de la
	 * ambulancia
	 *
	 * @param asociado - id de persona.paciente <b>Pre-condicion:</b> asociado no
	 *                 NULL<br>
	 */
	public synchronized void repararAmbulancia(Asociado asociado) {
		Controlador.agregarSuceso(asociado.getNombre() + " solicita reparacion de la ambulancia en taller");
		IState estadoAnterior = this.estado;
		this.estado.repararAmbulancia();
		Controlador.actualizarEstadoAmbulancia(this.estado.estadoActual());
		while (estadoAnterior == this.estado) {
			try {
				wait();
				estadoAnterior = this.estado;
				this.estado.repararAmbulancia();
				Controlador.actualizarEstadoAmbulancia(this.estado.estadoActual());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		notifyAll();
		Controlador.agregarSuceso("Ambulancia reparada con éxito - pedido por: " + asociado.getNombre());
		Controlador.actualizaAsociados();
	}

}
