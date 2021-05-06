

import PException.FactoryHabitacionException;
import PException.FactoryMedicoException;
import PModulos.TEST;
import PPersona.PMedico.IMedico;
import PPersona.PMedico.Medico;
import PPersona.PMedico.MedicoFactory;
import PPersona.PMedico.Muestra;
import PPersona.PPacientes.Paciente;
import PPersona.PPacientes.PacienteFactory;

import java.util.Calendar;
import java.util.GregorianCalendar;

import PClinica.ClinicaSingleton;


public class MAIN {
    public static void main(String[] args)  {

    TEST test =new TEST();
      try {
        test.cargaDatos();
      } catch (FactoryMedicoException | FactoryHabitacionException e) {
        e.printStackTrace();
      }
      test.muestraInformacion();

     /* ClinicaSingleton clinica=ClinicaSingleton.getInstance();
      MedicoFactory medicoFactory=new MedicoFactory();
      IMedico m1= null;
      try {
        m1 = medicoFactory.getMedico("juan","garcia","pediatra","permanente","doctor");
        System.out.println("Primer medico= "+m1.saludo());
        System.out.println("Matricula primer medico: "+m1.getMatricula());
        System.out.println(m1.getHonorario());
        System.out.println("el medico 1 se llama: "+m1.getNombre()+" "+m1.getApellido());


      } catch (FactoryMedicoException e) {
        e.printStackTrace();
      }


      System.out.println("matriculas totales despues del primer medico="+ Medico.matriculaMedicos);

      IMedico m2= null;
      try {
        m2 = medicoFactory.getMedico("pedro","alvarez","clinico","residente","magister");
        System.out.println("Segundo medico= "+m2.saludo());
        System.out.println("Matricula segundo medico: "+m2.getMatricula());
        System.out.println(m2.getHonorario());
        System.out.println("el medico 2 se llama: "+m2.getNombre()+" "+m2.getApellido());

      } catch (FactoryMedicoException e) {
        e.printStackTrace();
      }

      System.out.println("matriculas totales despues del segundo medico="+ Medico.matriculaMedicos);

      
      //Muestra test
      PacienteFactory pacienteFactory=new PacienteFactory();
      Paciente p1=pacienteFactory.getPaciente("Jamon", "Maletta", 42987432, "Joven");
      Paciente p2=pacienteFactory.getPaciente("Guillermo", "Lazurri", 20987432, "Mayor");
      Paciente p3=pacienteFactory.getPaciente("Pablo", "Montini", 1, "Mayor");
      assert m1 != null;
      m1.atenderPaciente(new GregorianCalendar(2021, Calendar.MARCH,4), 1);
      m1.atenderPaciente(new GregorianCalendar(2021,Calendar.FEBRUARY,3), 2);
      m1.atenderPaciente(new GregorianCalendar(2021,Calendar.AUGUST,2), 1);
      clinica.addMedicos(m1);
      Muestra prueba=new Muestra();
      prueba.reporteActividadDiaria2(1, new GregorianCalendar(2020,Calendar.FEBRUARY,3), new GregorianCalendar(2021,Calendar.DECEMBER,5));
     */


    }
}
