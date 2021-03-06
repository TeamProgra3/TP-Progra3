package persona.medico;

import java.util.ArrayList;
import java.util.GregorianCalendar;

/**
 * Clase que representa un residente
 * @author Los Cafeteros
 *
 */
public class DResidente extends DoctorDecorator{
    public DResidente(IMedico medico) {
        super(medico);
    }

    @Override
    public String getNombre() {
        return medico.getNombre();
    }

    @Override
    public String getApellido() {
        return medico.getApellido();
    }

    @Override
    public void setDNI(int DNI) {
        medico.setDNI(DNI);
    }

    @Override
    public int getDNI() {
        return medico.getDNI();
    }

    @Override
    public void setDomicilio(String domicilio) {
        medico.setDomicilio(domicilio);
    }

    @Override
    public String getDomicilio() {
        return medico.getDomicilio();
    }

    @Override
    public void setCiudad(String ciudad) {
        medico.setCiudad(ciudad);
    }

    @Override
    public String getCiudad() {
        return medico.getCiudad();
    }

    @Override
    public void setTelefono(String telefono) {
        medico.setTelefono(telefono);
    }

    @Override
    public String getTelefono() {
        return medico.getTelefono();
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
        float bonificacion = (float) 1.05;
        return medico.getHonorario()* bonificacion;
    }
    /**
     *Metodo que a�ade al array de consultas del persona.medico, un fecha y una historia clinica de un persona.paciente a atender
     */
    @Override
    public void atenderPaciente(GregorianCalendar fecha, int historiaClinica) {
        this.medico.atenderPaciente(fecha, historiaClinica);
    }


    @Override
    public ArrayList<Consulta> getConsultas() {
        return medico.getConsultas();
    }
}
