

import java.io.IOException;
import java.time.Period;
import java.util.ArrayList;
import java.util.Vector;

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
		ClinicaSingleton clinica=ClinicaSingleton.getInstance();

		TEST test = new TEST();
		/*
		try {
			test.cargaDatos();
		} catch (FactoryMedicoException | FactoryHabitacionException | EsperaVaciaException e) {
			e.printStackTrace();
		}
		*/

		

		try {
			Persistencia.levantarDatos();
			System.out.println("levanto de ARCHIVO");
		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Datos incorrectos ClassNotFoundException "+e.getMessage());
		} catch (IOException ex) {
			try {
				JOptionPane.showMessageDialog(null, "Advertencia: Los datos no se cargaron del archivo, se cargan datos por defecto");
				test.cargaDatos();
				System.out.println("Levanto de test");
			} catch (FactoryMedicoException | FactoryHabitacionException | EsperaVaciaException e) {
				System.out.println("No se pudo cargar archivos iniciales "+e.getMessage());
				e.printStackTrace();
			}
		}

		//test.muestra_datos_clinica();
		
		test.muestraInformacion();
		Ventana vista=new Ventana();
		controlador = new Controlador(vista);
		
		ArrayList<Asociado> lista = ClinicaSingleton.getInstance().getListaAsociados();
		for (int j=0;j<lista.size();j++) {
			lista.get(j).setFinalizado(false);
		}
			
		ModuloAmbulancia moduloam = new ModuloAmbulancia();
	
	}
}
