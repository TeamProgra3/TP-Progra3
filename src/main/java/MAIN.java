

import exception.EsperaVaciaException;
import exception.FactoryHabitacionException;
import exception.FactoryMedicoException;
import modulos.TEST;

public class MAIN {
    public static void main(String[] args)  {

    TEST test =new TEST();
      try {
        test.cargaDatos();
      } catch (FactoryMedicoException | FactoryHabitacionException | EsperaVaciaException e) {
        e.printStackTrace();
      }
      test.muestraInformacion();

    }
}
