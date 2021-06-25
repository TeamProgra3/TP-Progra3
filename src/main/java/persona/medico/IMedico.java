package persona.medico;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.GregorianCalendar;

/**
 * Interface que contiene los metodos a implementar por los medicos
 * @author Los cafeteros
 *
 */
public interface IMedico extends Serializable{
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
