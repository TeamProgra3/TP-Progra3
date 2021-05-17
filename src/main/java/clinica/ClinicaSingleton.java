package clinica;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import exception.NoHayPacienteException;
import habitacion.IHabitacion;
import medico.IMedico;
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
        Set<Integer> keys = this.pacientesRegistrados.keySet();

        for (Integer key : keys) {
            Paciente paciente = this.pacientesRegistrados.get(key);
            if (paciente.getHistoriaClinica() == id)
                return paciente;
        }
        throw new NoHayPacienteException("Paciente no encontrado");
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


    public ArrayList<Paciente> getListaAtencion() {
        return listaAtencion;
    }

    public void agregarPacienteListaAtencion(Paciente paciente) {
        this.listaAtencion.add(paciente);
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


}
    
    