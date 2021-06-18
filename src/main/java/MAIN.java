

import clinica.ClinicaSingleton;
import clinica.serializacion.BBDD;
import exception.EsperaVaciaException;
import exception.FactoryHabitacionException;
import exception.FactoryMedicoException;
import modulos.TEST;
import vista.Ventana;

public class MAIN {
	public static void main(String[] args) {
		Ventana ventana;
		Controlador controlador;
    BBDD bbdd=new BBDD();
		TEST test = new TEST();
		try {
			test.cargaDatos();
		} catch (FactoryMedicoException | FactoryHabitacionException | EsperaVaciaException e) {
			e.printStackTrace();
		}
		test.muestraInformacion();
		controlador = new Controlador();
	}
}
