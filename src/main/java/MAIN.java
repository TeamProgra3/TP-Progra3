

import PException.EsperaVaciaException;
import PException.FactoryHabitacionException;
import PException.FactoryMedicoException;
import PModulos.TEST;

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
