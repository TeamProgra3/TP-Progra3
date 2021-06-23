package concurrencia;

import java.util.Random;

public class Operario extends Asociado {

	public Operario(String nombre) {
		super(nombre);

	}

	@Override
	public void run() {
		Random r=new Random();
			try {

				Ambulancia.getInstance().repararAmbulancia(this);
				Thread.sleep(r.nextInt(5000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		System.out.println("El operario termin� de ejecutar");
	}
}
