package PPersona.PMedico;

public class DPermanente extends DoctorDecorator{
    private float bonificacion= (float) 1.10;
    public DPermanente(Medico medico) {
        super(medico);
    }

    @Override
    public String saludo() {
        return super.saludo()+" Permanente";
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
