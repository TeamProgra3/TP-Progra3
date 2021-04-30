package ppersona.pmedico;

public interface IMedico {
    public static float sueldoBasico=2000;

    String saludo();

    float getHonorario();

    int getMatricula();

    void iniciaMatricula();


    String getNombre();
    String getApellido();
    void setDNI(String DNI);
    String getDNI();
    void setDomicilio(String domicilio);
    String getDomicilio();
    void setCiudad(String ciudad);
    String getCiudad();
    void setTelefono(String telefono);
    String getTelefono();

}
