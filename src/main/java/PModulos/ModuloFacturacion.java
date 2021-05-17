package PModulos;

import PClinica.ClinicaSingleton;

import PHabitaciones.IHabitacion;
import PPersona.PMedico.Consulta;
import PPersona.PMedico.IMedico;
import PPersona.PPacientes.Paciente;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Clase dedicada a tomar los datos de un paciente de la clinica para generar su factura correspondiente<br>
 * Retira de la lista de atencion a los pacientes atendidos<br>
 * @author Los cafeteros
 */
public class ModuloFacturacion {
    ClinicaSingleton clinica;
    public ModuloFacturacion(){
        this.clinica=ClinicaSingleton.getInstance();
    }

    /**
     * Recorre el array del paciente (consultas y habitacion) ,calcula el gasto de las mismas<br>
     * <b>Pre-condicion:</b> El DNI tiene que ser valido(mayor a 0,debe estar en la lista de atencion)<br>
     * @param dni DNI del paciente
     */
    public void creaFacturapaciente(Integer dni){
        String factura="";
        float aux,total=0;
        IMedico medico;
        IHabitacion habitacion;
        Consulta consulta=null;
        int dias=0;//hay que ver como resolver los dias que esta internado
        Paciente paciente= clinica.buscaPaciente(dni);
        ArrayList<Consulta> consultas=paciente.getConsultas();
        ArrayList<Consulta> habitaciones=paciente.getHabitaciones();
        Map<Integer, Long> map= consultas.stream().collect(Collectors.groupingBy(Consulta::getId,Collectors.counting()));
        for (Map.Entry<Integer,Long> entry : map.entrySet()) {
            medico=clinica.buscaMedico(entry.getKey());
            total+=medico.getHonorario()*entry.getValue()*1.2;
            aux= (float) (medico.getHonorario()*entry.getValue()*1.2);
            factura+=medico.getNombre()+"            "+medico.getApellido()+"            "+medico.getHonorario()+"          "+entry.getValue()+"                        "+ aux +"\n";
        }
        System.out.println("Nombre medico | Apellido medico | Honorarios |cantidad  de consultas| costo total mas honorarios");
        System.out.println(factura);
        factura="";
        Iterator<Consulta> it =habitaciones.iterator();
        aux=0;
        while(it.hasNext()){
            consulta=it.next();
            dias=consulta.getDias();
            habitacion=clinica.buscaHabitacion(consulta.getId());
            total+=habitacion.getCosto(dias);
            aux+=habitacion.getCosto(dias);
            factura+=habitacion.getId()+"           "+ habitacion.getCosto(dias)+"        "+dias+ "      "+aux+"\n";
        }
        if(habitaciones.size()!=0)
            System.out.println("Habitacion |Costo por estadia| dias internado|Sub total");
        System.out.println(factura);
        System.out.println("El costo total es de: "+ total);
        clinica.retiraPacienteListaAtencion(dni);
    }
    

}
