package estados;

/**
 * En esta interface se encarga de modelar los estados de la ambulancia<br>
 * <b> Patron aplicado: </b> State
 *
 * @author Los Cafeteros
 */

public interface IState {

	
	void solicitaAtencionDomicilio();

	void solicitaTrasladoClinica();

	void volverClinica();

	void repararAmbulancia();
	
	String estadoActual();

	
}


