package estados;

public interface IState {

	
	void solicitaAtencionDomicilio();

	void solicitaTrasladoClinica();
	
	void volverClinica();
	
	void repararAmbulancia();
	
	String estadoActual();
}


