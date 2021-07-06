package concurrencia;

import java.util.Random;
/**
 * Esta clase simula ser el operario de la ambulancia, el cual le hace peticiones al objeto compartido
 * de ir al taller<br>
 *
 *
 * @author Los Cafeteros
 */


public class Operario extends Asociado {

	public Operario(String nombre) {
		super(nombre);

	}

	@Override
	public void run() {
		Random r=new Random();
			try {
				Thread.sleep(r.nextInt(6000));
				Ambulancia.getInstance().repararAmbulancia(this);
				Thread.sleep(r.nextInt(5000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

	}
}
