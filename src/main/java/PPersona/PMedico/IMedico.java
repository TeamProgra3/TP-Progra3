package PPersona.PMedico;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import PPersona.PPacientes.Paciente;

public interface IMedico {
    public static float sueldoBasico=2000;

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
