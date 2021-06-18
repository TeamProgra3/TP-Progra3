

import java.io.IOException;

import javax.swing.JOptionPane;

import clinica.ClinicaSingleton;
import clinica.serializacion.Persistencia;
import controlador.Controlador;
import exception.EsperaVaciaException;
import exception.FactoryHabitacionException;
import exception.FactoryMedicoException;
import modulos.TEST;
import vista.Ventana;

public class MAIN {
	public static void main(String[] args) {
		Ventana ventana;
		Controlador controlador;
		Persistencia bbdd=new Persistencia();
		TEST test = new TEST();
		
		/*try {
			test.cargaDatos();
		} catch (FactoryMedicoException | FactoryHabitacionException | EsperaVaciaException e) {
			e.printStackTrace();
		}*/
		
		
		try {
			bbdd.levantarDatos();
			System.out.println("levanto de ARCHIVO");
		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Error al cargar datos! "+e.getMessage());;
		} catch (IOException ex) {
			try {
				test.cargaDatos();
				System.out.println("Levanto de test");
			} catch (FactoryMedicoException | FactoryHabitacionException | EsperaVaciaException e) {
				System.out.println("No se pudo cargar archivos iniciales "+e.getMessage());
				e.printStackTrace();
			}
		}
		
		try {
			bbdd.persisteDatos();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		test.muestraInformacion();
		controlador = new Controlador();
		
	
	}
}
