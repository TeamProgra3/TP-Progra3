package concurrencia;

public class ChoferAmbulancia extends Asociado {
    private int cantidadSolicitudes ;
    public ChoferAmbulancia(String nombre,int cant) {

        super(nombre);
        this.cantidadSolicitudes = cant;
    }

    public ChoferAmbulancia(String nombre, String apellido, String domicilio, String telefono, String dNI,int cant) {
        super(nombre, apellido, domicilio, telefono, dNI);
        this.cantidadSolicitudes = cant;
    }

    @Override
    public void run() {


        while(true){
            try {

                Ambulancia.getInstance().volverAClinica(this);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
