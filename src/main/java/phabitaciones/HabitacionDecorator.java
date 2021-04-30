package phabitaciones;

public abstract class HabitacionDecorator implements IHabitacion {
    protected IHabitacion habitacion;

    public HabitacionDecorator(IHabitacion habitacion){
        this.habitacion=habitacion;
    }
}
