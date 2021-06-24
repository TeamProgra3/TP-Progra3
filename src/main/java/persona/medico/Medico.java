package persona.medico;

import persona.Persona;

import java.util.ArrayList;
import java.util.GregorianCalendar;

/**
 	 * 
   	 * Esta es la "Master Class" que controla a todos los medicos con sus
	 * respectivos decorados.
	 *
	 * **La variable "matriculaMedicos" es una variable de clase, es decir todas las
	 * instancias de la clase tienen el mismo valor independientemente de en que
	 * momento fue creada y con esta se determina la matricula de cada instancia
	 * para que sea unicos
	 *
	 * **La variable "sueldo básico" es el sueldo base asignado a cada persona.medico, el
	 * cual es modificado por cada decorado que se le haga a las clases hijas de
	 * persona.medico
	 *
	 * @author Los Cafeteros
	 *
	 */
public abstract class Medico extends Persona implements IMedico {
	public static int matriculaMedicos = 0;
	protected int matricula;

	protected ArrayList<Consulta> consultas = new ArrayList<Consulta>();
	
	public String saludo() {// 
		String tipo = "persona/medico";
		return tipo;
	}


	@Override
	public float getHonorario() {
		return sueldoBasico;
	}

	@Override
	public int getMatricula() {
		return this.matricula;
	}

	public void iniciaMatricula() {
		Medico.matriculaMedicos++;
		this.matricula = Medico.matriculaMedicos;
	}

	/**
	 * Metodo que a�ade a su array de consultas, una fecha e historia clinica de persona.paciente a atender
	 *
	 */
	@Override
	public void atenderPaciente(GregorianCalendar fecha, int historiaClinica) {
		consultas.add(new Consulta(fecha, historiaClinica));
	}

	@Override
	public ArrayList<Consulta> getConsultas() {
		return this.consultas;
	}


}
