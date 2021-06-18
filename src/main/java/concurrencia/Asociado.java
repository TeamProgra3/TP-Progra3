package concurrencia;

import java.util.Random;

public class Asociado extends Thread {
	private String nombre;
	private String apellido;
	private String domicilio;
	private String telefono;
	private String DNI;
	private String estadoActual;
	
	
	
	
	
	
	public Asociado(String nombre) {
		this.nombre = nombre;
	}






	public String getNombre() {
		return nombre;
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
