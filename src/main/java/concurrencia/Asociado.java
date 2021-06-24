package concurrencia;

import java.io.Serializable;
import java.util.Objects;
import java.util.Random;
/**
 * Esta clase simula ser un asociado de la clinica, el cual le hace peticiones al objeto compartido<br>
 *
 *
 * @author Los Cafeteros
 */

public class Asociado extends Thread implements Serializable {
	private String nombre;
	private String apellido;
	private String domicilio;
	private String telefono;
	private String DNI;
	private String actividad;
	private String finalizado = "";

	public Asociado(String nombre) {
		this.nombre = nombre;
	}

	public Asociado(String nombre, String apellido, String domicilio, String telefono, String dNI, String actividad) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.domicilio = domicilio;
		this.telefono = telefono;
		this.actividad = actividad;
		DNI = dNI;
	}

	public String getNombre() {
		return nombre;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Asociado asociado = (Asociado) o;
		return DNI.equals(asociado.DNI);
	}

	@Override
	public int hashCode() {
		return Objects.hash(DNI);
	}

	@Override
	public String toString() {
		return nombre + " " + apellido + " " + finalizado;
	}

	public void setFinalizado() {
		this.finalizado = " [FINALIZADO]";
	}

	@Override
	public void run() {
		int accion;
		super.run();
		Random r = new Random();
		try {
			Thread.sleep(r.nextInt(4000));
			accion = r.nextInt() % 2;
			if (accion == 0)
				Ambulancia.getInstance().atenderPacienteDomicilio(this);
			else
				Ambulancia.getInstance().trasladarAClinica(this);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.setFinalizado();
	}

}
