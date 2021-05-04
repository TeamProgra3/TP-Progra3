package PHabitaciones;

import java.util.Date;

public class DHabitacionPrivada extends HabitacionDecorator{
    float costoHabitacion=100;

    public DHabitacionPrivada(IHabitacion habitacion) {
        super(habitacion);
    }

    @Override
    public float getCosto(int dias) {
        float aux;
        if(dias==1)
            aux=this.costoHabitacion;
        else if((2 <= dias) &&(dias<=5))
            aux= (float) (dias*this.costoHabitacion*1.3);
            else
                aux= (dias*this.costoHabitacion*2);
        return habitacion.getCosto(dias)+aux;
    }
    @Override
    public int getId() {
        return habitacion.getId();
    }

    @Override
    public String getTipo() {
        return "Privada";
    }
}

