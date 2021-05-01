package PHabitaciones;



public class Habitacion implements IHabitacion{
    public static int numeroHabitaciones=0;
    /*
    *   Capacidad maxima???
    * */
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
