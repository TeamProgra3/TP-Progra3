package PPersona.PMedico;

public abstract class DoctorDecorator extends Medico {




    protected Medico medico;
    public DoctorDecorator(Medico medico){
        this.medico=medico;

    }

    @Override
    public String saludo() {
        return this.medico.saludo();
    }
}
