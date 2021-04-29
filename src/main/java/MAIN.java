
import PPersona.PMedico.*;


public class MAIN {
    public static void main(String[] args) {
      MedicoFactory medicoFactory=new MedicoFactory();
      Medico m1= medicoFactory.getMedico("pediatra","permanente","doctor");
      System.out.println("Primer medico= "+m1.saludo());

      System.out.println("matriculas totales despues del primer medico="+ Medico.matriculaMedicos);

      Medico m2= medicoFactory.getMedico("clinico","residente","magister");

      System.out.println("Segundo medico= "+m2.saludo());
        System.out.println("matriculas totales despues del segundo medico="+ Medico.matriculaMedicos);

      System.out.println("Matricula primer medico: "+m1.getMatricula());
      System.out.println("Matricula segundo medico: "+m2.getMatricula());


        System.out.println(m1.getHonorario());

        System.out.println(m2.getHonorario());
    }
}
