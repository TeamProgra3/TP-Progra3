package habitacion;

/**
 * Clase que representa una habitacion compartida por los pacientes
 * @author Los cafeteros
 *
 */
public class DHabitacionCompartida extends HabitacionDecorator{
    private float costoHabitacion=120;
    public DHabitacionCompartida(IHabitacion habitacion){
        super(habitacion);
    }


    @Override
    public float getCosto(int dias) {
        return habitacion.getCosto(dias)+costoHabitacion*dias;
    }
    @Override
    public int getId() {
        return habitacion.getId();
    }

    @Override
    public String getTipo() {
        return "Compartida";
    }
}

