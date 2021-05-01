

import PException.FactoryMedicoException;
import PPersona.PMedico.IMedico;
import PPersona.PMedico.Medico;
import PPersona.PMedico.MedicoFactory;
import PPersona.PPacientes.Joven;
import PPersona.PPacientes.Paciente;

import java.util.GregorianCalendar;


public class MAIN {
    public static void main(String[] args) {
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

      
     
      

    }
}
