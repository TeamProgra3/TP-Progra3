package ppersona.pmedico;

public class Clinico extends Medico{
    public Clinico(String nombre,String apellido){
        this.nombre=nombre;
        this.apellido=apellido;
        iniciaMatricula();
    }
    @Override
    public void iniciaMatricula() {
        Medico.matriculaMedicos++;
        this.matricula=Medico.matriculaMedicos;
    }


    @Override
    public String getNombre() {
        return this.nombre;
    }



    @Override
    public String getApellido() {
        return this.apellido;
    }

    @Override
    public void setDNI(String DNI) {
        this.DNI=DNI;
    }

    @Override
    public String getDNI() {
        return this.DNI;
    }

    @Override
    public void setDomicilio(String domicilio) {
        this.domicilio=domicilio;
    }

    @Override
    public String getDomicilio() {
        return this.domicilio;
    }

    @Override
    public void setCiudad(String ciudad) {
        this.ciudad=ciudad;
    }

    @Override
    public String getCiudad() {
        return this.ciudad;
    }

    @Override
    public void setTelefono(String telefono) {
        this.telefono=telefono;
    }

    @Override
    public String getTelefono() {
        return this.telefono;
    }




    @Override
    public String saludo() {
        return super.saludo()+" Clinico";
    }

    @Override
    public int getMatricula() {
        return this.matricula;
    }


    @Override
    public float getHonorario() {

        float bonificacion = (float) 1.05;
        return super.getHonorario()* bonificacion;
    }
}
