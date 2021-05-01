package PClinica;

import java.util.ArrayList;
import java.util.HashMap;

import PHabitaciones.Habitacion;
import PPersona.PMedico.IMedico;
import PPersona.PPacientes.Paciente;

/**
 * @author Los Cafeteros <br>
 * Esta clase contiene en diferentes colecciones informacion (m�dicos, pacientes atendidos, habitaciones)
 * <b> Patr�n aplicado: </b> Singleton
 *
 */
public class ClinicaSingleton { 
	private Paciente salaPrivada; //Un unico paciente
	private ArrayList<Paciente> patio; //Muchos pacientes
    private HashMap<Integer,Paciente> pacientesRegistrados =new HashMap<Integer, Paciente>();
    private HashMap<Integer, IMedico> medicos=new HashMap<Integer, IMedico>();
    private HashMap<Integer, Habitacion> habitaciones =new HashMap<Integer, Habitacion>();

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

    public Paciente buscaPaciente(Integer num){
        return this.pacientesRegistrados.get(num);
    }

    public IMedico buscaMedico(Integer num){
        return this.medicos.get(num);
    }

    public Habitacion buscaHabitacion(Integer num){
        return  this.habitaciones.get(num);
    }


}
