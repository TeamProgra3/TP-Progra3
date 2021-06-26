package modulos;

import clinica.ClinicaSingleton;
import concurrencia.Asociado;
import exception.EsperaVaciaException;
import exception.FactoryHabitacionException;
import exception.FactoryMedicoException;
import exception.NoHayPacienteException;
import habitacion.HabitacionFactory;
import habitacion.IHabitacion;
import persona.medico.IMedico;
import persona.medico.MedicoFactory;
import persona.medico.Muestra;
import persona.paciente.Paciente;
import persona.paciente.PacienteFactory;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;

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
    ModuloAtencion moduloAtencion=new ModuloAtencion();
    ModuloIngreso moduloIngreso=new ModuloIngreso();
    public void cargaDatos() throws FactoryMedicoException, FactoryHabitacionException, EsperaVaciaException {

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
        moduloIngreso.ingresarPaciente("Nicolas","Casazola",221586156,"joven");
        moduloAtencion.retiraPaciente();
        moduloIngreso.ingresarPaciente("Agusto","Paleta",274266156,"joven");
        moduloAtencion.retiraPaciente();
        moduloIngreso.ingresarPaciente("Franquito","Del'Halcon",321588956,"joven");
        moduloAtencion.retiraPaciente();
        moduloIngreso.ingresarPaciente("Guan Jabriel","Rrodrriges",377588956,"joven");
        moduloAtencion.retiraPaciente();
      


    }
    public void muestraInformacion(){

        /*
        * Paciente es atendidido por varios medicos
        *
        * ¿Por que se llama muchas veces a buscapaciente y a busquedamedico?
        *   para poder comprobar que funcionen bien las funciones
        * */

        clinica.buscaMedico(3).atenderPaciente(new GregorianCalendar(2021, Calendar.MARCH,4), clinica.buscaPaciente(221586156).getHistoriaClinica());
        clinica.buscaPaciente(221586156).agregaConsulta(new GregorianCalendar(2021, Calendar.MARCH,4),3);

        clinica.buscaMedico(3).atenderPaciente(new GregorianCalendar(2021,Calendar.AUGUST,2), clinica.buscaPaciente(221586156).getHistoriaClinica());
        clinica.buscaPaciente(221586156).agregaConsulta(new GregorianCalendar(2021,Calendar.AUGUST,2),3);

        clinica.buscaMedico(2).atenderPaciente(new GregorianCalendar(2021, Calendar.MARCH,4), clinica.buscaPaciente(221586156).getHistoriaClinica());
        clinica.buscaPaciente(221586156).agregaConsulta(new GregorianCalendar(2021,Calendar.AUGUST,2),2);

        clinica.buscaMedico(2).atenderPaciente(new GregorianCalendar(2021, Calendar.MARCH,4), clinica.buscaPaciente(221586156).getHistoriaClinica());
        clinica.buscaPaciente(221586156).agregaConsulta(new GregorianCalendar(2021,Calendar.AUGUST,2),2);

        clinica.buscaMedico(3).atenderPaciente(new GregorianCalendar(2021, Calendar.MARCH,4), clinica.buscaPaciente(221586156).getHistoriaClinica());
        clinica.buscaPaciente(221586156).agregaConsulta(new GregorianCalendar(2021, Calendar.MARCH,4),3);

        clinica.buscaMedico(1).atenderPaciente(new GregorianCalendar(2021, Calendar.MARCH,4), clinica.buscaPaciente(221586156).getHistoriaClinica());
        clinica.buscaPaciente(221586156).agregaConsulta(new GregorianCalendar(2021,Calendar.AUGUST,2),1);

        clinica.buscaMedico(1).atenderPaciente(new GregorianCalendar(2021, Calendar.MARCH,4), clinica.buscaPaciente(221586156).getHistoriaClinica());
        clinica.buscaPaciente(221586156).agregaConsulta(new GregorianCalendar(2021,Calendar.AUGUST,2),1);

        clinica.buscaMedico(3).atenderPaciente(new GregorianCalendar(2021, Calendar.MARCH,4), clinica.buscaPaciente(221586156).getHistoriaClinica());
        clinica.buscaPaciente(221586156).agregaConsulta(new GregorianCalendar(2021, Calendar.MARCH,4),3);
        /*********************************/

        clinica.buscaPaciente(221586156).agregaHabitacion(new GregorianCalendar(2021,Calendar.AUGUST,2),1,3);

        clinica.buscaPaciente(221586156).agregaHabitacion(new GregorianCalendar(2021,Calendar.AUGUST,2),2,4);

        clinica.buscaPaciente(221586156).agregaHabitacion(new GregorianCalendar(2021,Calendar.AUGUST,2),5,1);

        clinica.buscaPaciente(221586156).agregaHabitacion(new GregorianCalendar(2021,Calendar.AUGUST,2),3,3);
        clinica.buscaPaciente(221586156).agregaHabitacion(new GregorianCalendar(2021,Calendar.AUGUST,2),1,3);
        clinica.buscaPaciente(221586156).agregaHabitacion(new GregorianCalendar(2021,Calendar.AUGUST,2),2,4);


        /*
        *
        *
        * */

        clinica.buscaMedico(1).atenderPaciente(new GregorianCalendar(2021,Calendar.FEBRUARY,3), clinica.buscaPaciente(274266156).getHistoriaClinica());
        clinica.buscaPaciente(274266156).agregaConsulta(new GregorianCalendar(2021,Calendar.FEBRUARY,3),1);

        clinica.buscaMedico(2).atenderPaciente(new GregorianCalendar(2021,Calendar.FEBRUARY,3), clinica.buscaPaciente(274266156).getHistoriaClinica());
        clinica.buscaPaciente(274266156).agregaConsulta(new GregorianCalendar(2021,Calendar.FEBRUARY,3),2);

        clinica.buscaMedico(1).atenderPaciente(new GregorianCalendar(2021,Calendar.FEBRUARY,3), clinica.buscaPaciente(274266156).getHistoriaClinica());
        clinica.buscaPaciente(274266156).agregaConsulta(new GregorianCalendar(2021,Calendar.FEBRUARY,3),1);

        clinica.buscaMedico(2).atenderPaciente(new GregorianCalendar(2021,Calendar.FEBRUARY,3), clinica.buscaPaciente(274266156).getHistoriaClinica());
        clinica.buscaPaciente(274266156).agregaConsulta(new GregorianCalendar(2021,Calendar.FEBRUARY,3),2);

        clinica.buscaMedico(2).atenderPaciente(new GregorianCalendar(2021,Calendar.FEBRUARY,3), clinica.buscaPaciente(274266156).getHistoriaClinica());
        clinica.buscaPaciente(274266156).agregaConsulta(new GregorianCalendar(2021,Calendar.FEBRUARY,3),2);
        /***********************************************************************/

        clinica.buscaPaciente(274266156).agregaHabitacion(new GregorianCalendar(2021,Calendar.AUGUST,2),3,1);

        clinica.buscaPaciente(274266156).agregaHabitacion(new GregorianCalendar(2021,Calendar.AUGUST,2),2,1);

        clinica.buscaPaciente(274266156).agregaHabitacion(new GregorianCalendar(2021,Calendar.AUGUST,2),1,5);

        clinica.buscaPaciente(274266156).agregaHabitacion(new GregorianCalendar(2021,Calendar.AUGUST,2),1,3);
        /*
       *
       *
       * */


        Muestra prueba=new Muestra();
        
        try {
			prueba.reporteActividadDiaria2(3, new GregorianCalendar(2020,Calendar.FEBRUARY,3), new GregorianCalendar(2021,Calendar.DECEMBER,5));
            System.out.println("\n\n\n");
            prueba.reporteActividadDiaria2(2,new GregorianCalendar(2020,Calendar.FEBRUARY,3), new GregorianCalendar(2021,Calendar.DECEMBER,5));
            System.out.println("\n\n\n");

        } catch (NoHayPacienteException e) {
			System.out.println(e.getMessage());
		}
        /*
        //CREACION DE FACTURAS, DESCOMENTAR SI SE QUIERE MOSTRAR POR CONSOLA
        System.out.println(clinica.buscaPaciente(221586156).toString());
        ClinicaSingleton.getInstance().creaFactura(clinica.buscaPaciente(221586156));
        System.out.println("\n \n \n \n");
        System.out.println(clinica.buscaPaciente(274266156).toString());
        ClinicaSingleton.getInstance().creaFactura(clinica.buscaPaciente(274266156));
        */
    }


}
