package PException;

/**
 * Lanzada cuando no se pudo crear el medico solicitado
 * @author Los Cafeteros
 *
 */
public class FactoryMedicoException extends Exception{

    public  FactoryMedicoException(String mensaje){
        super(mensaje);
    }
}
