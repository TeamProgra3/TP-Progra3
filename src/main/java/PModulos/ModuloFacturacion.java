package PModulos;

import PClinica.ClinicaSingleton;

import PHabitaciones.IHabitacion;
import PPersona.PMedico.Consulta;
import PPersona.PMedico.IMedico;
import PPersona.PPacientes.Paciente;

import java.util.*;
import java.util.stream.Collectors;

public class ModuloFacturacion {
    ClinicaSingleton clinica;
    public ModuloFacturacion(){
        this.clinica=ClinicaSingleton.getInstance();
    }

    void creaFacturapaciente(Integer dni){
        String factura="";
        float aux,total=0;
        IMedico medico;
        IHabitacion habitacion;
        int dias=0;//hay que ver como resolver los dias que esta internado
        Paciente paciente= clinica.buscaPaciente(dni);
        ArrayList<Consulta> consultas=paciente.getConsultas();
        ArrayList<Consulta> habitaciones=paciente.getHabitaciones();
        Map<Integer, Long> map= consultas.stream().collect(Collectors.groupingBy(Consulta::getId,Collectors.counting()));
        for (Map.Entry<Integer,Long> entry : map.entrySet()) {
            medico=clinica.buscaMedico(entry.getKey());
            total+=medico.getHonorario()+entry.getValue();
            aux=medico.getHonorario()+entry.getValue();
            factura+=medico.getNombre()+" "+medico.getApellido()+" "+medico.getHonorario()+" "+entry.getValue()+" "+ aux +"\n";
        }
        Iterator<Consulta> it =habitaciones.iterator();
        while(it.hasNext()){
            habitacion=clinica.buscaHabitacion(it.next().getId());
            total+=habitacion.getCosto(dias);
            factura+=habitacion.getId()+" "+ habitacion.getCosto(dias)+" "+dias+" "+habitacion.getCosto(dias) +"\n";
        }
        System.out.println(factura);
        System.out.println("El costo total es de: "+ total);
    }
}
