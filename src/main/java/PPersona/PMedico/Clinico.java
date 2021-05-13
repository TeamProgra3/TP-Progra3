package PPersona.PMedico;


public class Clinico extends Medico{
    public Clinico(String nombre,String apellido){
        this.nombre=nombre;
        this.apellido=apellido;
        iniciaMatricula();
    }

    @Override
    public String saludo() {
        return super.saludo()+" Clinico";
    }


    @Override
    public float getHonorario() {

        float bonificacion = (float) 1.05;
        return super.getHonorario()* bonificacion;
    }
}
