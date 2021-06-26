package clinica.serializacion;

import concurrencia.Asociado;
import habitacion.IHabitacion;
import persona.medico.IMedico;
import persona.paciente.Paciente;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Esta clase contiene se encarga de transformar los datos para poder serializar y para levantarlos de archivo <br>
 * <b> Patron aplicado: </b> DTO
 *
 * @author Los Cafeteros
 */
public class ClinicaDTO implements Serializable {
    private Paciente salaPrivada; //Un unico persona.paciente   --------------------------------------
    private ArrayList<Paciente> patio; //Muchos pacientes------------------------------------
    private ArrayList<Paciente> listaAtencion = new ArrayList<Paciente>();
    private HashMap<Integer, Paciente> pacientesRegistrados = new HashMap<Integer, Paciente>();
    private HashMap<Integer, IMedico> medicos = new HashMap<Integer, IMedico>();
    private HashMap<Integer, IHabitacion> habitaciones = new HashMap<Integer, IHabitacion>();
    private ArrayList<Asociado> listaAsociados = new ArrayList<Asociado>();
    private String nombre;
    private String direccion;
    private String telefono;
    private String ciudad;

    public ClinicaDTO(Paciente salaPrivada, ArrayList<Paciente> patio, ArrayList<Paciente> listaAtencion, HashMap<Integer, Paciente> pacientesRegistrados, HashMap<Integer, IMedico> medicos, HashMap<Integer, IHabitacion> habitaciones, String nombre, String direccion, String telefono, String ciudad) {
        this.salaPrivada = salaPrivada;
        this.patio = patio;
        this.listaAtencion = listaAtencion;
        this.pacientesRegistrados = pacientesRegistrados;
        this.medicos = medicos;
        this.habitaciones = habitaciones;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.ciudad = ciudad;
    }

    public ClinicaDTO() {
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

    public void setPatio(ArrayList<Paciente> patio) {
        this.patio = patio;
    }

    public ArrayList<Paciente> getListaAtencion() {
        return listaAtencion;
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

    public ArrayList<Asociado> getListaAsociados() {
        return listaAsociados;
    }

    public void setListaAsociados(ArrayList<Asociado> listaAsociados) {
        this.listaAsociados = listaAsociados;
    }
}
