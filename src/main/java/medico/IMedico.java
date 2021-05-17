package medico;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import paciente.Paciente;

/**
 * Interface que contiene los metodos a implementar por los medicos
 * @author Los cafeteros
 *
 */
public interface IMedico {
    public static float sueldoBasico=2000;

    @Deprecated
    String saludo();

    float getHonorario();

    int getMatricula();

    void iniciaMatricula();
    


    String getNombre();
    String getApellido();
    void setDNI(int DNI);
    int getDNI();
    void setDomicilio(String domicilio);
    String getDomicilio();
    void setCiudad(String ciudad);
    String getCiudad();
    void setTelefono(String telefono);
    String getTelefono();
	void atenderPaciente(GregorianCalendar fecha, int historiaClinica);

	ArrayList<Consulta> getConsultas();

}
