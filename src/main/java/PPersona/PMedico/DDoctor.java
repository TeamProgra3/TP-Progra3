package PPersona.PMedico;

public class DDoctor extends DoctorDecorator{

    public DDoctor(Medico medico) {
        super(medico);
    }

    @Override
    public String saludo() {
        return super.saludo()+" Doctor";
    }

    @Override
    public int getMatricula() {
        return this.medico.getMatricula();
    }

    @Override
    public void iniciaMatricula() {

    }

    @Override
    public void setNombre(String nombre) {
        medico.setNombre(nombre);
    }

    @Override
    public String getNombre() {
        return medico.getNombre();
    }

    @Override
    public void setApellido(String apellido) {
        medico.setApellido(apellido);
    }

    @Override
    public String getApellido() {
        return medico.getApellido();
    }

    @Override
    public void setDNI(String DNI) {
        medico.setDNI(DNI);
    }

    @Override
    public String getDNI() {
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
    public float getHonorario() {
        float bonificacion = (float) 1.10;
        return medico.getHonorario()* bonificacion;
    }
}
