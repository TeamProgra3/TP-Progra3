package phabitaciones;

import java.util.Date;

public class DHabitacionCompartida extends HabitacionDecorator{
    private float costoHabitacion=120;
    public DHabitacionCompartida(IHabitacion habitacion){
        super(habitacion);
    }


    @Override
    public float getCosto(int dias) {
        return habitacion.getCosto(dias)+costoHabitacion*dias;
    }
}
