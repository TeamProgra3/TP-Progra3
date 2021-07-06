package exception;

/**
 * Lanzada cuando no se pudo crear el persona.medico solicitado
 * @author Los Cafeteros
 *
 */
public class FactoryMedicoException extends Exception{

    public  FactoryMedicoException(String mensaje){
        super(mensaje);
    }
}
