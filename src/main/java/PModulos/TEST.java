package PModulos;

import PClinica.ClinicaSingleton;
import PException.FactoryHabitacionException;
import PException.FactoryMedicoException;
import PHabitaciones.HabitacionFactory;
import PHabitaciones.IHabitacion;
import PPersona.PMedico.IMedico;
import PPersona.PMedico.MedicoFactory;
import PPersona.PPacientes.Paciente;
import PPersona.PPacientes.PacienteFactory;

/**
 * Clase destinada a hacer pruebas con los modulos implementados
 * @author Los Cafeteros
 *
 */
public class TEST {
    ClinicaSingleton clinica;
    public TEST(){
        this.clinica= ClinicaSingleton.getInstance();
    }

    public void cargaDatos() throws FactoryMedicoException, FactoryHabitacionException {

        MedicoFactory medicoFactory=new MedicoFactory();
        PacienteFactory pacienteFactory=new PacienteFactory();
        MedicoFactory medicoFactory1=new MedicoFactory();
        HabitacionFactory habitacionFactory=new HabitacionFactory();
        IMedico medico=medicoFactory.getMedico("Jose","Perez","pediatra","permanente","doctor");
        clinica.addMedicos(medico);
        medico=medicoFactory.getMedico("Jose","Gomez","clinico","permanente","magister");
        clinica.addMedicos(medico);
        medico=medicoFactory.getMedico("Mario","Gimenez","cirujano","residente","doctor");
        clinica.addMedicos(medico);
        IHabitacion habitacion=habitacionFactory.getHabitacion("privada");
        clinica.addHabitacion(habitacion);
        habitacion=habitacionFactory.getHabitacion("compartida");
        clinica.addHabitacion(habitacion);
        habitacion=habitacionFactory.getHabitacion("privada");
        clinica.addHabitacion(habitacion);
        habitacion=habitacionFactory.getHabitacion("terapia intensiva");
        clinica.addHabitacion(habitacion);
        habitacion=habitacionFactory.getHabitacion("privada");
        clinica.addHabitacion(habitacion);
        habitacion=habitacionFactory.getHabitacion("terapia intensiva");
        clinica.addHabitacion(habitacion);
        habitacion=habitacionFactory.getHabitacion("privada");
        clinica.addHabitacion(habitacion);
        habitacion=habitacionFactory.getHabitacion("compartida");
        clinica.addHabitacion(habitacion);
        Paciente paciente=pacienteFactory.getPaciente("nicolas","casazola",221586156,"joven");
        clinica.addPacienteRegistrado(paciente);
        paciente=pacienteFactory.getPaciente("agusto","paleta",274266156,"joven");
        clinica.addPacienteRegistrado(paciente);
        paciente=pacienteFactory.getPaciente("franquito","delhalcon",321588956,"joven");
        clinica.addPacienteRegistrado(paciente);
        paciente=pacienteFactory.getPaciente("guan jabriel","rrodrriges",321588956,"joven");
        clinica.addPacienteRegistrado(paciente);


    }
    public void muestraInformacion(){
        Paciente paciente = clinica.buscaPaciente(221586156);
        System.out.println("Deberia mostrar al paciente nicolas "+paciente.getNombre());
        paciente=clinica.buscaPaciente(75421342);
        System.out.println("Deberia mostrar null "+paciente);
        IMedico medico =clinica.buscaMedico(1);
        System.out.println("Deberia mostrar al primer medico "+ medico.saludo());
        medico =clinica.buscaMedico(7);
        System.out.println("deberia mostrar null"+medico);
        IHabitacion habitacion=clinica.buscaHabitacion(1);
        System.out.println("deberia mostrar el tipo de la primera habitacion "+habitacion.getTipo());
        habitacion=clinica.buscaHabitacion(32);
        System.out.println("deberia mostrar null "+habitacion);
    }



}
