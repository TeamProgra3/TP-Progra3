package PModulos;

import PClinica.ClinicaSingleton;
import PPersona.PMedico.Consulta;
import PPersona.PPacientes.Paciente;

import java.util.ArrayList;

public class ModuloFacturacion {
    ClinicaSingleton clinica;
    public ModuloFacturacion(){
        this.clinica=ClinicaSingleton.getInstance();
    }
    void creaFacturapaciente(Integer dni){
        Paciente paciente= clinica.buscaPaciente(dni);
        ArrayList<Consulta> consultas=paciente.getConsultas();
        ArrayList<Consulta> habitaciones=paciente.getConsultas();


    }

}
