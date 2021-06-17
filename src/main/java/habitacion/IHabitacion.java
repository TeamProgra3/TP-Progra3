package habitacion;

import java.io.Serializable;

/**
 * Interfaz que declara los metodos a implementar por las habitaciones
 * @author Los cafeteros
 *
 */
public interface IHabitacion extends Serializable {

    public float getCosto(int dias);
    public int getId();
    public String getTipo();
}
