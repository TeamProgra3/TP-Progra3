package persona.medico;

/**
 * Clase padre destinada a aplicar el Patron Decorator a los distintos medicos
 * @author Los Cafeteros
 *
 */
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
