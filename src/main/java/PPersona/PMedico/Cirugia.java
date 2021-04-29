package PPersona.PMedico;

public class Cirugia extends Medico{
    private float bonificacion= (float) 1.10;
    public Cirugia(){
        iniciaMatricula();
    }

    @Override
    public void iniciaMatricula() {
        Medico.matriculaMedicos++;
        this.matricula=Medico.matriculaMedicos;
    }

    @Override
    public String saludo() {
        return super.saludo() +" Cirujano";
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
