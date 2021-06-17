

import clinica.ClinicaSingleton;
import clinica.serializacion.BBDD;
import exception.EsperaVaciaException;
import exception.FactoryHabitacionException;
import exception.FactoryMedicoException;
import modulos.TEST;

import java.io.IOException;

public class MAIN {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ClinicaSingleton clinica =ClinicaSingleton.getInstance();
        BBDD bbdd=new BBDD();
        TEST test =new TEST();
        bbdd.levantarDatos();
        /*
      try {
        test.cargaDatos();

      } catch (FactoryMedicoException | FactoryHabitacionException | EsperaVaciaException e) {
        e.printStackTrace();
      }
        */
        test.muestraInformacion();
        //bbdd.persisteDatos();

    }
}
