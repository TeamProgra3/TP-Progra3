package PException;

/**
 * Lanzada cuando no hay pacientes para atender
 * @author Los Cafeteros
 *
 */
public class EsperaVaciaException extends Exception {
	
	public EsperaVaciaException(String mensajito)  {
		super(mensajito);
	}

}
