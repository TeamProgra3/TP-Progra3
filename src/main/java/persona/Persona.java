package persona;

public abstract class Persona {
    protected int DNI;
    protected String nombre;
    protected String apellido;
    protected String telefono;
    protected String direccion;
    protected String domicilio;
    protected String ciudad;


    public void setDomicilio(String domicilio) {
            this.domicilio=domicilio;
    }


    public String getDomicilio() {
        return this.domicilio;
    }


    public void setCiudad(String ciudad) {
        this.ciudad=ciudad;
    }


    public String getCiudad() {
        return this.ciudad;
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

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getDNI() {
        return DNI;
    }

    public void setDNI(int DNI) {
        this.DNI = DNI;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public String toString() {
        return this.getApellido() + " " +this.getNombre() + " "+ this.DNI;
    }
}
