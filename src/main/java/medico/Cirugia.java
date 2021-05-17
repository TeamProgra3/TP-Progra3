package medico;

/**
 * Clase que representa un cirujano
 * @author Los Cafeteros
 *
 */
public class Cirugia extends Medico{
    public Cirugia(String nombre,String apellido){
        this.nombre=nombre;
        this.apellido=apellido;
        iniciaMatricula();
    }

    @Override
    public String saludo() {
        return super.saludo() +" Cirujano";
    }

    @Override
    public float getHonorario() {
        float bonificacion = (float) 1.10;
        return super.getHonorario()* bonificacion;
    }

}
