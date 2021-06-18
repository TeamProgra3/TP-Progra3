package concurrencia;

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
		IState estadoAnterior = this.estado;
		this.estado.solicitaAtencionDomicilio();
		while(estadoAnterior == this.estado) {
			try {
				wait();
				System.out.println(asociado.getName() + "despertado");
				estadoAnterior = this.estado;
				this.estado.solicitaAtencionDomicilio();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		notifyAll();
		System.out.println("asociado deja de esperar "+ asociado.getNombre());
	}	
	
	
	public synchronized void volverAClinica(Asociado asociado) {
		IState estadoAnterior = this.estado;
		this.estado.volverClinica();
		while(estadoAnterior == this.estado) {
			try {
				wait();
				estadoAnterior = this.estado;
				this.estado.volverClinica();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		notifyAll();
		System.out.println("volvio a la clinica - pedido por: "+asociado.getNombre());
	}

	public synchronized void trasladarAClinica(Asociado asociado) {
		IState estadoAnterior = this.estado;
		this.estado.solicitaTrasladoClinica();
		while(estadoAnterior == this.estado) {
			try {
				wait();
				estadoAnterior = this.estado;
				this.estado.solicitaTrasladoClinica();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		notifyAll();
		System.out.println("volvio a la clinica - pedido por: "+asociado.getNombre());
	}

	public synchronized void repararAmbulancia(Asociado asociado) {
		IState estadoAnterior = this.estado;
		this.estado.repararAmbulancia();
		while(estadoAnterior == this.estado) {
			try {
				wait();
				estadoAnterior = this.estado;
				this.estado.repararAmbulancia();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		notifyAll();
		System.out.println("volvio a la clinica - pedido por: "+asociado.getNombre());
	}



}
