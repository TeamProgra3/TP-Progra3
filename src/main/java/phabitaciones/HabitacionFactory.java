package phabitaciones;

import pexception.FactoryHabitacionException;

public class HabitacionFactory {

    public IHabitacion getHabitacion(String tipo) throws FactoryHabitacionException {
        if(tipo.equals("compartida"))
            return new DHabitacionCompartida(new Habitacion());
        if(tipo.equals("privada"))
            return  new DHabitacionPrivada(new Habitacion());
        if(tipo.equals("terapia intensiva"))
            return  new DTerapiaIntensiva(new Habitacion());
        throw new FactoryHabitacionException("Tipo de habitacion no valida, no exite: "+tipo);
    }

}
