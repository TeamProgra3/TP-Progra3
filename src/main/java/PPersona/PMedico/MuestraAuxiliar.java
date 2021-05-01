package PPersona.PMedico;

import PPersona.PPacientes.Paciente;

/**
 * @author Los cafeteros <br>
 * Su funcion es segundear a la clase Muestra <b>uwu</b>
 */
public class MuestraAuxiliar {
	public Paciente paciente; 
    public int cont;
    
    
    
	public MuestraAuxiliar(Paciente paciente, int cont) {
		super();
		this.paciente = paciente;
		this.cont = cont;
	}

	public Paciente getPaciente() {
		return paciente;
	}
	
	
	
	public int getCont() {
		return cont;
	}

	public void incrementa() {
		this.cont++;
	}
    
}
