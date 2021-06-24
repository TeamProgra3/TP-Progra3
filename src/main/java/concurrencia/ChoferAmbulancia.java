package concurrencia;

import java.util.Random;

public class ChoferAmbulancia extends Asociado {
    private int cantidadSolicitudes ;
    public ChoferAmbulancia(String nombre,int cant) {

        super(nombre);
        this.cantidadSolicitudes = cant;
    }

    public ChoferAmbulancia(String nombre, String apellido, String domicilio, String telefono, String dNI,int cant) {
        super(nombre, apellido, domicilio, telefono, dNI,"");
        this.cantidadSolicitudes = cant;
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
