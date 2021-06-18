package modulos;

import concurrencia.Asociado;

public class ModuloAmbulancia {
	Asociado a1,a2,a3;
	
	
	public ModuloAmbulancia() {
		a1 = new Asociado("Juan");
		a2 = new Asociado("PEPE");
		a3 = new Asociado("roberto");
		
		a1.start();
		a2.start();
		a3.start();
	}
}
