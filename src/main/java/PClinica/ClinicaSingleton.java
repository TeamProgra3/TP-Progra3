package PClinica;

import java.util.ArrayList;

import PPersona.PPacientes.Paciente;

/**
 * @author Los Cafeteros <br>
 * Esta clase contiene en diferentes colecciones informacion (médicos, pacientes atendidos, habitaciones)
 * <b> Patrón aplicado: </b> Singleton
 *
 */

public class ClinicaSingleton { 
	private Paciente salaPrivada; //Un unico paciente
	public Paciente getSalaPrivada() {
		return salaPrivada;
	}

	public void setSalaPrivada(Paciente salaPrivada) {
		this.salaPrivada = salaPrivada;
	}

	public ArrayList<Paciente> getPatio() {
		return patio;
	}
	
	public void addPatio(Paciente p) {
		this.patio.add(p);
	}

	private ArrayList<Paciente> patio; //Muchos pacientes
	
    public String nombre;
    public String direccion;
    public String telefono; 
    public String ciudad;
    private static ClinicaSingleton instanciaClinica=null;
    private ClinicaSingleton(){
        this.nombre ="Clinica Facultad De Ingenieria";
        this.direccion="Av.Siempreviva 742";
        this.telefono="2231597536";
        this.ciudad="Mar Del Plata";
        this.salaPrivada = null;
        this.patio = new ArrayList<Paciente>();
    }

    public static ClinicaSingleton getInstance(){
        if(instanciaClinica==null)
            instanciaClinica=new ClinicaSingleton();
        return instanciaClinica;
    }

}
