package exception;

/**
 * Lanzada cuando no se pudo ingresar el persona.paciente a la habitacion
 * @author Los Cafeteros
 *
 */
public class IngresoPacienteHabitacionException extends Exception{
	
	public IngresoPacienteHabitacionException(String mensajito) {
		super(mensajito);
	}
	
}
