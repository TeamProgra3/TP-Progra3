

import clinica.ClinicaSingleton;
import exception.EsperaVaciaException;
import exception.FactoryHabitacionException;
import exception.FactoryMedicoException;
import modulos.TEST;

import java.io.IOException;

public class MAIN {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ClinicaSingleton clinica =ClinicaSingleton.getInstance();
    TEST test =new TEST();
       clinica.levantarDatos();
      /*try {
        test.cargaDatos();

      } catch (FactoryMedicoException | FactoryHabitacionException | EsperaVaciaException e) {
        e.printStackTrace();
      }
      */
      test.muestraInformacion();
     // clinica.persisteDatos();

    }
}
