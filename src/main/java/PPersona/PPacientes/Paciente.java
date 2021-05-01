package PPersona.PPacientes;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import PPersona.PMedico.Consulta;
import PPersona.PMedico.Medico;

public abstract class Paciente {
    public static int historiasClinicasPacientes=0;

    private int DNI;
    private int historiaClinica;
    private int nroOrden;
    private String nombre;
    private String apellido;
    private String telefono;
    private String direccion;

    private ArrayList<Consulta> consultas = new ArrayList<Consulta>();
    private ArrayList<Consulta> habitaciones= new ArrayList<Consulta>();

    public Paciente(int DNI, String nombre, String apellido) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.apellido = apellido;
        Paciente.historiasClinicasPacientes++;
        this.historiaClinica=Paciente.historiasClinicasPacientes;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getDNI() {
        return DNI;
    }

    public int getHistoriaClinica() {
        return historiaClinica;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getDireccion() {
        return direccion;
    }
    
    public void agregaConsulta(GregorianCalendar fecha,Medico medico) {
    	//consultas.add(new ConsultaPaciente(fecha,medico));
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