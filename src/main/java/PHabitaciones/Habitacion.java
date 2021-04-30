package PHabitaciones;

import java.util.Date;

public class Habitacion implements IHabitacion{
    public static int numeroHabitaciones=0;
    protected int numeroHabitacion;
    protected float costoHabitacion=100;
    public Habitacion(){
        Habitacion.numeroHabitaciones++;
        this.numeroHabitacion=Habitacion.numeroHabitaciones;
    }
    @Override
    public float getCosto(int dias) {
        return this.costoHabitacion;
    }
}
