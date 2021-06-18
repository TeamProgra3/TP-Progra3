package medico;

import exception.FactoryMedicoException;

/**
 * 
 * Clase que aplica el patrón Factory para la creación de nuevas instancias de
 * médicos<br>
 * <b>Patrón aplicado:</b> Factory<br>
 * 
 * @author Los Cafeteros
 */
public class MedicoFactory {

	private IMedico setprofesion(String profesion, String nombre, String apellido) throws FactoryMedicoException {
		IMedico auxiliar = null;
		if (profesion.equals("cirujano"))
			auxiliar = new Cirugia(nombre, apellido);
		else if (profesion.equals("clinico"))
			auxiliar = new Clinico(nombre, apellido);
		else if (profesion.equals("pediatra"))
			auxiliar = new Pediatria(nombre, apellido);

		if (auxiliar != null)
			return auxiliar;
		else {
			String aux = "Profesion " + profesion + " no se reconoce como opcion valida";
			throw new FactoryMedicoException(aux);
		}
	}

	private IMedico setTipo(String tipo, IMedico loDecorado) throws FactoryMedicoException {
		IMedico auxiliar = null;
		if (tipo.equals("permanente"))
			auxiliar = new DPermanente(loDecorado);
		else if (tipo.equals("residente"))
			auxiliar = new DResidente(loDecorado);
		if (auxiliar != null)
			return auxiliar;
		else {
			String aux = "Tipo " + tipo + " no se reconoce como opcion valida";
			throw new FactoryMedicoException(aux);
		}
	}

	private IMedico setEstudio(String estudio, IMedico loDecorado) throws FactoryMedicoException {
		IMedico auxiliar = null;
		if (estudio.equals("magister"))
			auxiliar = new DMagister(loDecorado);
		else if (estudio.equals("doctor"))
			auxiliar = new DDoctor(loDecorado);
		if (auxiliar != null)
			return auxiliar;
		else {
			String aux = "Nivel de estudio  " + estudio + " no se reconoce como opcion valida";
			throw new FactoryMedicoException(aux);
		}

	}

	public IMedico getMedico(String nombre, String apellido, String profesion, String tipo, String estudio)
			throws FactoryMedicoException {
		IMedico aux;
		aux = setprofesion(profesion, nombre, apellido);
		aux = setTipo(tipo, aux);
		return setEstudio(estudio, aux);

	}
}
