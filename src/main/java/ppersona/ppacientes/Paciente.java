package ppersona.ppacientes;

public class Paciente {
    public static int historiasClinicasPacientes=0;

    private String DNI;
    private int historiaClinica;
    private String nombre;
    private String apellido;
    private String telefono;
    private String direccion;
    private String rangoEtario;


    public Paciente(String DNI, String nombre, String apellido, String rangoEtario) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.apellido = apellido;
        this.rangoEtario = rangoEtario;
        Paciente.historiasClinicasPacientes++;
        this.historiaClinica=Paciente.historiasClinicasPacientes;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDNI() {
        return DNI;
    }

    public int getHistoriaClinica() {
        return historiaClinica;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getRangoEtario() {
        return rangoEtario;
    }
}
