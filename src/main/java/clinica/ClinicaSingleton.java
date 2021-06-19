package clinica;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;


import clinica.serializacion.IPersistencia;
import clinica.serializacion.PersistenciaBinaria;
import concurrencia.Asociado;
import exception.NoHayPacienteException;
import habitacion.IHabitacion;
import medico.IMedico;
import modulos.ModuloAmbulancia;
import modulos.ModuloFacturacion;
import paciente.Paciente;

/**
 * Esta clase contiene en diferentes colecciones informacion (médicos, pacientes atendidos, habitaciones)<br>
 * <b> Patrón aplicado: </b> Singleton
 *
 * @author Los Cafeteros
 */
public class ClinicaSingleton {



    private Paciente salaPrivada; //Un unico paciente   --------------------------------------
    private ArrayList<Paciente> patio; //Muchos pacientes------------------------------------

    private ArrayList<Paciente> listaAtencion = new ArrayList<Paciente>();
    private HashMap<Integer, Paciente> pacientesRegistrados = new HashMap<Integer, Paciente>();
    private HashMap<Integer, IMedico> medicos = new HashMap<Integer, IMedico>();
    private HashMap<Integer, IHabitacion> habitaciones = new HashMap<Integer, IHabitacion>();
    
    private ArrayList<Asociado> listaAsociados = new ArrayList<Asociado>();
    

    public String nombre;
    public String direccion;
    public String telefono;
    public String ciudad;

    private static ClinicaSingleton instanciaClinica = null;

    private ClinicaSingleton() {
        this.nombre = "Clinica Facultad De Ingenieria";
        this.direccion = "Av.Siempreviva 742";
        this.telefono = "2231597536";
        this.ciudad = "Mar Del Plata";
        this.salaPrivada = null;
        this.patio = new ArrayList<Paciente>();
    }


    public static ClinicaSingleton getInstance() {
        if (instanciaClinica == null)
            instanciaClinica = new ClinicaSingleton();
        return instanciaClinica;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void setListaAtencion(ArrayList<Paciente> listaAtencion) {
        this.listaAtencion = listaAtencion;
    }

    public HashMap<Integer, Paciente> getPacientesRegistrados() {
        return pacientesRegistrados;
    }

    public void setPacientesRegistrados(HashMap<Integer, Paciente> pacientesRegistrados) {
        this.pacientesRegistrados = pacientesRegistrados;
    }

    public HashMap<Integer, IMedico> getMedicos() {
        return medicos;
    }

    public void setMedicos(HashMap<Integer, IMedico> medicos) {
        this.medicos = medicos;
    }

    public HashMap<Integer, IHabitacion> getHabitaciones() {
        return habitaciones;
    }

    public void setHabitaciones(HashMap<Integer, IHabitacion> habitaciones) {
        this.habitaciones = habitaciones;
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

    public void setPatio(ArrayList<Paciente> patio) {
        this.patio = patio;
    }

    public void addPacienteRegistrado(Paciente paciente) {
        this.pacientesRegistrados.put(paciente.getDNI(), paciente);
    }

    public Paciente buscaPaciente(int DNI) {
        return this.pacientesRegistrados.get(DNI);
    }

    /**
     * Recibe un id de paciente como paramentro, y devuelve el paciente
     *
     * @param id - id de paciente
     * @return Paciente
     * @throws NoHayPacienteException
     */
    public Paciente buscaPacienteID(int id) throws NoHayPacienteException {
    	Iterator<Paciente> it = null;
		Paciente aux=null;

		if (!this.pacientesRegistrados.isEmpty()) {
			it = this.pacientesRegistrados.values().iterator();
			aux = it.next();
			while (it.hasNext() && aux.getHistoriaClinica() != id)
				aux = it.next();

		}
		if (!this.pacientesRegistrados.isEmpty() && aux.getHistoriaClinica() == id) // Fue encontrado?
			return aux;
		else
			throw new NoHayPacienteException("Paciente no encontrado: " + id);
    }


    public IMedico buscaMedico(Integer num) {
        return this.medicos.get(num);
    }

    public void addMedicos(IMedico medico) {
        this.medicos.put(medico.getMatricula(), medico);

    }

    public IHabitacion buscaHabitacion(Integer num) {
        return this.habitaciones.get(num);
    }

    public void addHabitacion(IHabitacion habitacion) {
        this.habitaciones.put(habitacion.getId(), habitacion);
    }
    
    public void addAsociado(Asociado a) {
    	this.listaAsociados.add(a);
    }


    public ArrayList<Paciente> getListaAtencion() {
        return listaAtencion;
    }

    public void agregarPacienteListaAtencion(Paciente paciente) {
        this.listaAtencion.add(paciente);
    }
    
    public void eliminaAsociado(Asociado as) {
        this.listaAsociados.remove(as);
    }

    public ArrayList<Asociado> getListaAsociados() {
		return listaAsociados;
	}


	/**
     * Retira paciente de lista de atencion
     *
     * @param dni dni del paciente
     */
    public void retiraPacienteListaAtencion(int dni) {
        int index = -1;
        int i = 0;
        while (i < this.listaAtencion.size() && this.listaAtencion.get(i).getDNI() != dni) i++;
        if (i < this.listaAtencion.size()) {
            index = i;
            this.listaAtencion.remove(index);
        }

    }

    
    public void creaFactura(Paciente paciente){
        ModuloFacturacion maduloFacturacion=new ModuloFacturacion();
        maduloFacturacion.creaFacturapaciente(paciente.getDNI());
    }
    
    public void iniciarSimulacion() {
    	ModuloAmbulancia.iniciarSimulacion();
    }

}
    
    
