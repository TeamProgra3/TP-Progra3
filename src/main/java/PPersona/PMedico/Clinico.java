package PPersona.PMedico;

public class Clinico extends Medico{
    private float bonificacion= (float) 1.05;
    public Clinico(){
        iniciaMatricula();
    }

    @Override
    public void iniciaMatricula() {
        Medico.matriculaMedicos++;
        this.matricula=Medico.matriculaMedicos;
    }

    @Override
    public String saludo() {
        return super.saludo()+" Clinico";
    }

    @Override
    public int getMatricula() {
        return this.matricula;
    }


    @Override
    public float getHonorario() {

        return super.getHonorario()*bonificacion;
    }
}
