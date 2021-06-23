package concurrencia;

import java.util.Random;



public class Asociado extends Thread {
	private String nombre;
	private String apellido;
	private String domicilio;
	private String telefono;
	private String DNI;
	
	
	
	public Asociado(String nombre) {
		this.nombre = nombre;
	}

	


	public Asociado(String nombre, String apellido, String domicilio, String telefono, String dNI) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.domicilio = domicilio;
		this.telefono = telefono;
		DNI = dNI;
	}
	public String getNombre() {
		return nombre;
	}



	@Override
	public String toString() {
		return nombre+ " "+ apellido+" " +  DNI;
	}




	@Override
	public void run() {
		int accion;
		super.run();
		Random r=new Random();
		try {
			Thread.sleep(r.nextInt(400));
			accion = r.nextInt()%2;
			if (accion == 0)
				Ambulancia.getInstance().atenderPacienteDomicilio(this);
			else 
				Ambulancia.getInstance().trasladarAClinica(this);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Termin� de ejecutar: "+ nombre);
	}

}
