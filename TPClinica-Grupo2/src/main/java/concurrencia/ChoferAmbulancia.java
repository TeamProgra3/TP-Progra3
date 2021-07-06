package concurrencia;

import java.util.Random;
/**
 * Esta clase simula ser el chofer de la ambulancia, el cual le hace peticiones al objeto compartido
 * de regresar a la clinica<br>
 *
 *
 * @author Los Cafeteros
 */

public class ChoferAmbulancia extends Asociado {

    public ChoferAmbulancia(String nombre, String apellido, String domicilio, String telefono, String dNI) {
        super(nombre, apellido, domicilio, telefono, dNI,"",1);
    }

    @Override
    public void run() {
        Random r=new Random();
        try {
			Thread.sleep(r.nextInt(6000)); 
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
        while(true){
            try {
                Ambulancia.getInstance().volverAClinica(this);
                Thread.sleep(r.nextInt(5000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
