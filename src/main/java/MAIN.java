

import java.io.IOException;
import java.time.Period;

import javax.swing.JOptionPane;

import clinica.ClinicaSingleton;
import clinica.serializacion.Persistencia;
import concurrencia.Asociado;
import controlador.Controlador;
import exception.EsperaVaciaException;
import exception.FactoryHabitacionException;
import exception.FactoryMedicoException;
import modulos.ModuloAmbulancia;
import modulos.TEST;
import vista.Ventana;

public class MAIN {
	public static void main(String[] args) {
		Ventana ventana;
		Controlador controlador;

		TEST test = new TEST();
		
		/*try {
			test.cargaDatos();
		} catch (FactoryMedicoException | FactoryHabitacionException | EsperaVaciaException e) {
			e.printStackTrace();
		}*/
		
		
		try {
			Persistencia.levantarDatos();
			System.out.println("levanto de ARCHIVO");
		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Datos incorrectos ClassNotFoundException "+e.getMessage());
		} catch (IOException ex) {
			try {
				JOptionPane.showMessageDialog(null, "Advertencia: Los datos no se cargaron del archivo "+ex.getMessage());
				test.cargaDatos();
				System.out.println("Levanto de test");
			} catch (FactoryMedicoException | FactoryHabitacionException | EsperaVaciaException e) {
				System.out.println("No se pudo cargar archivos iniciales "+e.getMessage());
				e.printStackTrace();
			}
		}
		
		
		test.muestraInformacion();
		controlador = new Controlador();
		
		ModuloAmbulancia moduloam = new ModuloAmbulancia();
	
	}
}
