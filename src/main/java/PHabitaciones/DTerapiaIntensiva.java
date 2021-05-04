package PHabitaciones;

import java.util.Date;

public class DTerapiaIntensiva  extends  HabitacionDecorator{
    float costoHabitacion=100;
    public  DTerapiaIntensiva(IHabitacion habitacion){
        super(habitacion);
    }
    @Override
    public float getCosto(int dias){
        return (float) (habitacion.getCosto(dias)+ (habitacion.getCosto(dias)+Math.pow(this.costoHabitacion,dias)));
    }

    @Override
    public int getId() {
        return habitacion.getId();
    }

    @Override
    public String getTipo() {
        return "Terapia intensiva";
    }
}
