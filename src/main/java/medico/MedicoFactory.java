package medico;


import exception.FactoryMedicoException;

/**
 * 
 * Clase que aplica el patrón Factory para la creación de nuevas instancias de médicos<br>
 * <b>Patrón aplicado:</b> Factory<br>
 * 
 * @author Los Cafeteros 
 */
public class MedicoFactory {



    private IMedico setprofesion(String profesion, String nombre, String apellido) throws FactoryMedicoException {
        if(profesion.equals("cirujano"))return new Cirugia(nombre,apellido);
        if(profesion.equals("clinico"))return  new Clinico(nombre,apellido);
        if(profesion.equals("pediatra"))return new Pediatria(nombre,apellido);
        String aux="Profesion "+profesion+" no se reconoce como opcion valida";
        throw new FactoryMedicoException(aux);
    }

    private IMedico setTipo(String tipo,IMedico loDecorado) throws FactoryMedicoException{
        if(tipo.equals("permanente"))
            return new DPermanente(loDecorado);
        if(tipo.equals("residente"))
            return new DResidente(loDecorado);
        String aux="Tipo "+tipo+" no se reconoce como opcion valida";
        throw new FactoryMedicoException(aux);

    }

    private IMedico setEstudio(String estudio,IMedico loDecorado) throws  FactoryMedicoException{
        if(estudio.equals("magister"))
            return new DMagister(loDecorado);
        if(estudio.equals("doctor"))
            return new DDoctor(loDecorado);
        String aux="Nivel de estudio  "+estudio +" no se reconoce como opcion valida";
        throw new FactoryMedicoException(aux);

    }
    public IMedico getMedico(String nombre,String apellido, String profesion,String tipo,String estudio) throws FactoryMedicoException{
        IMedico aux;
        aux= setprofesion(profesion,nombre,apellido);
        aux= setTipo(tipo,aux);
        return setEstudio(estudio,aux);

    }
}
