package exception;

/**
 * Lanzada cuando no se encontro persona.paciente atendido por un persona.medico en un tiempo determinado
 * @author Los Cafeteros
 *
 */
public class NoHayPacienteException extends Exception {

	public NoHayPacienteException(String mensajito) {
		super(mensajito);
	}
}
