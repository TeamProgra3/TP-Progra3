package persona.medico;

/**
 * Clase que representa un pediatra
 * @author Los Cafeteros
 *
 */
public class Pediatria extends Medico{

    public Pediatria(String nombre,String apellido){
        this.nombre=nombre;
        this.apellido=apellido;
        iniciaMatricula();
    }

    @Override
    public String saludo() {
        return super.saludo() + " Pediatra";
    }

    @Override
    public float getHonorario() {

        float bonificacion = (float) 1.07;
        return super.getHonorario()* bonificacion;
    }
}
