package PPersona.PMedico;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Iterator;
import PPersona.PPacientes.Paciente;

public abstract class Medico implements IMedico{
    /*
    *   Esta es la "Master Class" que controla a todos los medicos con sus respectivos decorados.
    *
    *   **La variable "matriculaMedicos" es una variable de clase, es decir
    *       todas las instancias de la clase tienen el mismo valor independientemente de en que momento
    *       fue creada y con esta se determina la matricula de cada instancia para que sea unicos
    *
    *   **La variable "sueldo básico" es el sueldo base asignado a cada medico, el cual es modificado
    *       por cada decorado que se le haga a las clases hijas de medico
    *
    *
    *
    * */
    public static int matriculaMedicos=0;
    protected int matricula;
    protected String nombre;
    protected String apellido;
    protected String DNI;
    protected String domicilio;
    protected String ciudad;
    protected String telefono;
    protected ArrayList<Consulta> consultas = new ArrayList<Consulta>();



    private String tipo="medico";//esto se saca despues, solo es para pruebas
    @Override
    public String saludo(){// esta funcion se quita, es para probar el patron
        return this.tipo;
    }
    /*
    * para setear desde el main si cambia el basico para que nadie toque esta clase UwU
    *
    * */

    @Override
    public float getHonorario(){
        return sueldoBasico;
    }

    @Override
    public int getMatricula() {
        return this.matricula;
    }

    @Override
    public void iniciaMatricula() {
    }
    
	@Override
    public void atenderPaciente(GregorianCalendar fecha,int historiaClinica) {
			consultas.add( new Consulta(fecha,historiaClinica));
    }
		
}
