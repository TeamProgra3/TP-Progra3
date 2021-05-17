package modulos;

import java.util.Calendar;
import java.util.GregorianCalendar;

import clinica.ClinicaSingleton;
import exception.EsperaVaciaException;
import exception.FactoryHabitacionException;
import exception.FactoryMedicoException;
import exception.NoHayPacienteException;
import habitacion.HabitacionFactory;
import habitacion.IHabitacion;
import medico.IMedico;
import medico.MedicoFactory;
import medico.Muestra;
import paciente.Paciente;
import paciente.PacienteFactory;

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
        moduloIngreso.ingresarPaciente("franquito","delhalcon",321588956,"joven");
        moduloAtencion.retiraPaciente();
        moduloIngreso.ingresarPaciente("guan jabriel","rrodrriges",321588956,"joven");
        moduloAtencion.retiraPaciente();


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
        System.out.println(clinica.buscaPaciente(221586156).toString());
        this.creaFactura(clinica.buscaPaciente(221586156));
        System.out.println("\n \n \n \n");
        System.out.println(clinica.buscaPaciente(274266156).toString());
        this.creaFactura(clinica.buscaPaciente(274266156));
    }


    public void creaFactura(Paciente paciente){
        ModuloFacturacion maduloFacturacion=new ModuloFacturacion();
        maduloFacturacion.creaFacturapaciente(paciente.getDNI());

    }



}
