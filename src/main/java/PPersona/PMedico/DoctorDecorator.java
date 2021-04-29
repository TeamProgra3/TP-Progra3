package PPersona.PMedico;

public abstract class DoctorDecorator implements IMedico {


    protected IMedico medico;
    public DoctorDecorator(IMedico medico){
        this.medico=medico;

    }

    @Override
    public String saludo() {
        return this.medico.saludo();
    }
}
