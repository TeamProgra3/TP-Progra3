package exception;

/**
 * Lanzada cuando no se encontro paciente atendido por un medico en un tiempo determinado
 * @author Los Cafeteros
 *
 */
public class NoHayPacienteException extends Exception {

	public NoHayPacienteException(String mensajito) {
		super(mensajito);
	}
}
