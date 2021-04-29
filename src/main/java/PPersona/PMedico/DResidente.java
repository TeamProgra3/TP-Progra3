package PPersona.PMedico;

public class DResidente extends DoctorDecorator{
    private float bonificacion= (float) 1.05;
    public DResidente(Medico medico) {
        super(medico);
    }

    @Override
    public String saludo() {
        return super.saludo()+ " Residente";
    }

    @Override
    public int getMatricula() {
        return this.medico.getMatricula();

    }

    @Override
    public void iniciaMatricula() {

    }
    @Override
    public float getHonorario() {
        return medico.getHonorario()*bonificacion;
    }
}
