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
		Random r=new Random();
		try {
			Thread.sleep(r.nextInt(3000));
			if (nombre.equals("PEPE"))
				for(int i=0;i<=1;i++) {
					Ambulancia.getInstance().volverAClinica(this);
					Thread.sleep(r.nextInt(4000));
				}
			else
				Ambulancia.getInstance().atenderPacienteDomicilio(this);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Termino de ejecutar: "+ nombre);
		super.run();
	}

}
