package PPersona.PMedico;

import java.util.ArrayList;

public class Cirugia extends Medico{
    public Cirugia(String nombre,String apellido){
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
    public void setDNI(int DNI) {
        this.DNI=DNI;
    }

    @Override
    public int getDNI() {
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
    public ArrayList<Consulta> getConsultas() {
        return this.consultas;
    }

    @Override
    public String saludo() {
        return super.saludo() +" Cirujano";
    }

    @Override
    public int getMatricula() {
        return this.matricula;
    }


    @Override
    public float getHonorario() {
        float bonificacion = (float) 1.10;
        return super.getHonorario()* bonificacion;
    }

}
