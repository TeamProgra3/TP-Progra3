package persona.paciente;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import persona.Persona;
import persona.medico.Consulta;

/**
 * Clase que representa un persona.paciente
 * @author Los Cafeteros
 *
 */
public abstract class Paciente extends Persona {

    public static int historiasClinicasPacientes=0;
    private int historiaClinica;
    private int nroOrden;

    /**
     * Almacena las consultas hechas al persona.paciente
     * Cada consulta contiene fecha y matricula del m�dico que lo atendi�
     */
    private ArrayList<Consulta> consultas = new ArrayList<Consulta>();
    
    /**
     * Almacena todas las habitaciones por las que pas� el persona.paciente en su internaci�n
     */
    private ArrayList<Consulta> habitaciones= new ArrayList<Consulta>();

    public Paciente(int DNI, String nombre, String apellido) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.apellido = apellido;
        Paciente.historiasClinicasPacientes++;
        this.historiaClinica=Paciente.historiasClinicasPacientes;
    }


    public int getHistoriaClinica() {
        return historiaClinica;
    }

    /** Carga la consulta hecha al persona.paciente en un ArrayList de consultas (Atributo de la instancia)
     * @param fecha: La fecha de la consulta, (GregorianCalendar).
     * @param matricula La matricula del m�dico que lo atendi� en esta consulta.
     */
    public void agregaConsulta(GregorianCalendar fecha,int matricula) {
    	consultas.add(new Consulta(fecha,matricula));
    }

    public void agregaHabitacion(GregorianCalendar fecha,int idHabitacion,int dias) {
    	habitaciones.add(new Consulta(fecha,idHabitacion,dias));
    }
    
    public int getNroOrden() {
		return nroOrden;
	}

	public void setNroOrden(int nroOrden) {
		this.nroOrden = nroOrden;
	}

    public ArrayList<Consulta> getConsultas(){
        return this.consultas;
    }
    public ArrayList<Consulta> getHabitaciones(){
        return this.habitaciones;
    }


    /**Resuelve la prioridad en la sala privada usando Double Dispatch

     * @param p: Paciente que se quiere verificar si tiene prioridad sobre el actual
     * @return boolean: True si el parámetro tiene prioridad y debe ingresar
     */
    public abstract boolean tienePrioridad(Paciente p);

	protected abstract boolean prioridadMayor();
	protected abstract boolean prioridadJoven();
	protected abstract boolean prioridadNino();
	

}