package PPersona.PMedico;



public class Pediatria extends Medico{
    private float bonificacion= (float) 1.07;
    public Pediatria(){
        iniciaMatricula();
    }

    @Override
    public void iniciaMatricula() {
        Medico.matriculaMedicos++;
        this.matricula=Medico.matriculaMedicos;
    }

    @Override
    public String saludo() {
        return super.saludo() + " Pediatra";
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
