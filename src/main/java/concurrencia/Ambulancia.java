package concurrencia;

import controlador.Controlador;
import estados.EnClinicaState;
import estados.IState;


public class Ambulancia {
	private static Ambulancia instance=null;
	IState estado;
	
	private Ambulancia () {
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
	
	
	public synchronized void atenderPacienteDomicilio(Asociado asociado) {
		System.out.println(asociado.getNombre() +" solicita atención en su domicilio");
		Controlador.agregarSuceso(asociado.getNombre() +" solicita atención en su domicilio");

		IState estadoAnterior = this.estado;
		this.estado.solicitaAtencionDomicilio();
		Controlador.actualizarEstadoAmbulancia(this.estado.estadoActual());
		while(estadoAnterior == this.estado) {
			try {
				wait();
				System.out.println(asociado.getNombre() + " despertado");
				estadoAnterior = this.estado;
				this.estado.solicitaAtencionDomicilio();
				Controlador.actualizarEstadoAmbulancia(this.estado.estadoActual());

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		notifyAll();
		Controlador.agregarSuceso(asociado.getNombre() +" deja de esperar ");
		System.out.println(asociado.getNombre() +" deja de esperar ");
	}	
	
	
	public synchronized void volverAClinica(Asociado asociado) {
		System.out.println(asociado.getNombre() +" solicita que la ambulancia vuelva a clinica");
		Controlador.agregarSuceso(asociado.getNombre() +" solicita que la ambulancia vuelva a clinica");
		IState estadoAnterior = this.estado;
		this.estado.volverClinica();
		Controlador.actualizarEstadoAmbulancia(this.estado.estadoActual());
		while(estadoAnterior == this.estado) {
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
		Controlador.agregarSuceso("Ambulancia volvió a la clinica - pedido por: "+asociado.getNombre());
		System.out.println("Ambulancia volvió a la clinica - pedido por: "+asociado.getNombre());
	}

	public synchronized void trasladarAClinica(Asociado asociado) {
		System.out.println(asociado.getNombre() +" solicita traslado a la clinica");
		Controlador.agregarSuceso(asociado.getNombre() +" solicita traslado a la clinica");
		IState estadoAnterior = this.estado;
		this.estado.solicitaTrasladoClinica();
		Controlador.actualizarEstadoAmbulancia(this.estado.estadoActual());
		while(estadoAnterior == this.estado) {
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
		Controlador.agregarSuceso(asociado.getNombre()+" fue trasladado con éxito a la clínica");
		System.out.println(asociado.getNombre()+" fue trasladado con éxito a la clínica");
	}

	public synchronized void repararAmbulancia(Asociado asociado) {
		System.out.println(asociado.getNombre() +" solicita reparacion de la ambulancia en taller");
		Controlador.agregarSuceso(asociado.getNombre() +" solicita reparacion de la ambulancia en taller");
		IState estadoAnterior = this.estado;
		this.estado.repararAmbulancia();
		Controlador.actualizarEstadoAmbulancia(this.estado.estadoActual());
		while(estadoAnterior == this.estado) {
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
		Controlador.agregarSuceso("Ambulancia reparada con éxito - pedido por: "+asociado.getNombre());
		System.out.println("Ambulancia reparada con éxito - pedido por: "+asociado.getNombre());
	}



}
