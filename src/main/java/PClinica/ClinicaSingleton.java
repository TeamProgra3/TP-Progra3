package PClinica;

import java.util.ArrayList;

import PPersona.PPacientes.Paciente;

public class ClinicaSingleton {
    /** ACA HAY QUE PONER TODAS LAS VARIABLES DE LA CLINICA
     *
     */
	
	public Paciente salaPrivada; //Una unico paciente
	public ArrayList<Paciente> patio; //Muchos pacientes
	
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

    public void ingresarPaciente(Paciente ingresante) {
    	if (salaPrivada == null)
    		salaPrivada = ingresante;
    	else { //Resolver conflicto Double Dispatch
    		if (salaPrivada.tienePrioridad(ingresante)) { 
    		//Verifica si el ingresante tiene prioridad frente a quien ya estaba de antes
    		this.patio.add(salaPrivada);
    		salaPrivada = ingresante;
    		}
    		else {
    			this.patio.add(ingresante);
    		}
    	}
    }
}
