package PPersona.PMedico;

public class DMagister extends DoctorDecorator{
    private float bonificacion= (float) 1.05;

    public DMagister(Medico medico) {
        super(medico);
    }

    @Override
    public String saludo() {
        return super.saludo()+" Magister";
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
