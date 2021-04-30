package ppersona.pmedico;

import pexception.FactoryException;

public class MedicoFactory {


    private IMedico setprofesion(String profesion,String nombre,String apellido) throws FactoryException {
        if(profesion.equals("cirujano"))
            return new Cirugia(nombre,apellido);
        if(profesion.equals("clinico"))
            return  new Clinico(nombre,apellido);
        if (profesion.equals("pediatra"))
            return new Pediatria(nombre,apellido);
        String aux="Profecion "+profesion+" no se reconoce como opcion valida";
        throw new FactoryException(aux);// hay que crear una clase con errores para tirar errores como haberme anotado a arquitectura :D
    }

    private IMedico setTipo(String tipo,IMedico loDecorado) throws FactoryException{
        if(tipo.equals("permanente"))
            return new DPermanente(loDecorado);
        if(tipo.equals("residente"))
            return new DResidente(loDecorado);
        String aux="Tipo "+tipo+" no se reconoce como opcion valida";
        throw new FactoryException(aux);

    }

    private IMedico setEstudio(String estudio,IMedico loDecorado) throws  FactoryException{
        if(estudio.equals("magister"))
            return new DMagister(loDecorado);
        if(estudio.equals("doctor"))
            return new DDoctor(loDecorado);
        String aux="Nivel de estudio  "+estudio +" no se reconoce como opcion valida";
        throw new FactoryException(aux);

    }
    public IMedico getMedico(String nombre,String apellido, String profesion,String tipo,String estudio) throws FactoryException{
        IMedico aux;
        aux= setprofesion(profesion,nombre,apellido);
        aux= setTipo(tipo,aux);
        return setEstudio(estudio,aux);

    }
}
