package concurrencia;

import java.util.Random;

public class Operario extends Asociado {
	int cantidadSolicitudes;

	public Operario(String nombre, int cant) {
		super(nombre);
		this.cantidadSolicitudes = cant;
	}

	@Override
	public void run() {
		int accion;
		Random r = new Random();
		//for (int i = 0; i < cantidadSolicitudes; i++) {
		while(true) { //TODO Preguntar como resolver esto, necesitamos que el operario pida volver a clinica constantemente
			try {
				Thread.sleep(r.nextInt(8000));
				Ambulancia.getInstance().volverAClinica(this);
				accion = r.nextInt()%5;
				if (accion == 0)
					Ambulancia.getInstance().repararAmbulancia(this);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		//System.out.println("El operario terminó de ejecutar");
	}
}
