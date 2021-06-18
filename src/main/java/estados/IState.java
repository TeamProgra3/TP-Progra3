package estados;

public interface IState {

	
	boolean solicitaAtencionDomicilio();

	boolean solicitaTrasladoClinica();
	
	boolean volverAClinica();
	
	boolean repararAmbulancia();
	
	String estadoActual();

	
}


