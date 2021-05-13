package PPersona.PMedico;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Iterator;
import PPersona.PPacientes.Paciente;

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
	 * **La variable "sueldo bÃ¡sico" es el sueldo base asignado a cada medico, el
	 * cual es modificado por cada decorado que se le haga a las clases hijas de
	 * medico
	 *
	 * @author Los Cafeteros
	 *
	 */
public abstract class Medico implements IMedico {
	public static int matriculaMedicos = 0;
	protected int matricula;
	protected String nombre;
	protected String apellido;
	protected int DNI;
	protected String domicilio;
	protected String ciudad;
	protected String telefono;
	protected ArrayList<Consulta> consultas = new ArrayList<Consulta>();
	
	public String saludo() {// 
		String tipo = "medico";
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
	 * Metodo que añade a su array de consultas, una fecha e historia clinica de paciente a atender
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

	@Override
	public String getNombre() {
		return this.nombre;
	}

	@Override
	public String getApellido() {
		return this.apellido;
	}

	@Override
	public void setDNI(int DNI) {
		this.DNI = DNI;
	}

	@Override
	public int getDNI() {
		return this.DNI;
	}

	@Override
	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;

	}

	@Override
	public String getDomicilio() {
		return this.domicilio;
	}

	@Override
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	@Override
	public String getCiudad() {
		return this.ciudad;
	}

	@Override
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Override
	public String getTelefono() {
		return this.telefono;
	}

}
