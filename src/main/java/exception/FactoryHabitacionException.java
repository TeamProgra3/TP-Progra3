package exception;

/**
 * Lanzada cuando no se pudo crear la habitacion solicitada
 * @author Los Cafeteros
 *
 */
public class FactoryHabitacionException extends  Exception{

	public FactoryHabitacionException(String mensajito){
		super(mensajito);
	}
}
