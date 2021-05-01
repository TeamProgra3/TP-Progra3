package PPersona.PPacientes;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import PPersona.PMedico.Consulta;
import PPersona.PMedico.ConsultaPaciente;
import PPersona.PMedico.Medico;

public abstract class Paciente {
    public static int historiasClinicasPacientes=0;

    private String DNI;
    private int historiaClinica;
    private String nombre;
    private String apellido;
    private String telefono;
    private String direccion;
    private ArrayList<Consulta> consultas = new ArrayList<Consulta>();

    public Paciente(String DNI, String nombre, String apellido) {
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

    public String getDNI() {
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

    public abstract boolean tienePrioridad(Paciente p);

	protected abstract boolean prioridadMayor();
	protected abstract boolean prioridadJoven();
	protected abstract boolean prioridadNino();

}