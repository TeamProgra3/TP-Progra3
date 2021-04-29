package PPersona.PMedico;

public interface IMedico {
    public static float sueldoBasico=2000;

    String saludo();

    float getHonorario();

    int getMatricula();

    void iniciaMatricula();

    void setNombre(String nombre);
    String getNombre();
    void setApellido(String apellido);
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
