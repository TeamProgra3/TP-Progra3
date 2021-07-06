package habitacion;

import java.io.Serializable;

/**
 * Interfaz que declara los metodos a implementar por las habitaciones
 * @author Los cafeteros
 *
 */
public interface IHabitacion extends Serializable {

    float getCosto(int dias);
    int getId();
    String getTipo();
}
