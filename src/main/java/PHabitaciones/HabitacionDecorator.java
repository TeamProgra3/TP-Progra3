package PHabitaciones;

/**
 * Clase destinada a implementar el Patron Decorator aplicado a las habitaciones<br>
 * <b>Patron aplicado:</b> Decorator
 * @author Los cafeteros
 *
 */
public abstract class HabitacionDecorator implements IHabitacion {
    protected IHabitacion habitacion;

    public HabitacionDecorator(IHabitacion habitacion){
        this.habitacion=habitacion;
    }
}
