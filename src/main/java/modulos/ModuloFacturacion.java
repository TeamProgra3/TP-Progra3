package modulos;

import clinica.ClinicaSingleton;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import habitacion.IHabitacion;
import persona.medico.Consulta;
import persona.medico.IMedico;
import persona.paciente.Paciente;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Clase dedicada a tomar los datos de un paciente de la clinica para generar su factura correspondiente<br>
 * Retira de la lista de atencion a los pacientes atendidos<br>
 * Para la segunda parte del Tp esta en vez de mostrar las facturas por consola crea un Pdf y los guarda en la carpeta facturas<br>
 * @author Los cafeteros
 */
public class ModuloFacturacion {
    ClinicaSingleton clinica;
    String ruta;
    File directorio;


    public ModuloFacturacion(){

        this.clinica=ClinicaSingleton.getInstance();
        this.ruta=System.getProperty("user.dir");
        this.ruta+="/facturas";
        this.directorio=new File(this.ruta);
        if(!directorio.exists()){
            if(directorio.mkdir())
                System.out.println("Directorio 'facturas' creado");
            else
                System.out.println("Error al crear el archivo");
        }
    }

    /**
     * Recorre el array del persona.paciente (consultas y habitacion) ,calcula el gasto de las mismas<br>
     * <b>Pre-condicion:</b> El DNI tiene que ser valido(mayor a 0,debe estar en la lista de atencion)<br>
     * @param dni DNI del persona.paciente
     */
    public void creaFacturapaciente(Integer dni){

        /**/
        String factura="";
        float aux,total=0;
        IMedico medico;
        IHabitacion habitacion;
        Paragraph parrafo;
        Consulta consulta=null;
        int dias=0;//hay que ver como resolver los dias que esta internado
        Paciente paciente= clinica.buscaPaciente(dni);
        ArrayList<Consulta> consultas=paciente.getConsultas();
        ArrayList<Consulta> habitaciones=paciente.getHabitaciones();
        Map<Integer, Long> map= consultas.stream().collect(Collectors.groupingBy(Consulta::getId,Collectors.counting()));

        Document document= new Document();


        try {
            PdfWriter.getInstance(document,new FileOutputStream(directorio.getAbsolutePath()+"\\"+paciente.getNombre()+"_"+paciente.getApellido()+".pdf"));
            document.open();
            
            parrafo = new Paragraph("Clinica Los Cafeteros: \"Lo importante es lucrar\" \nFactura del persona.paciente " + paciente.getNombre()+" "+paciente.getApellido()+"\n \n");
            document.add(parrafo);
            
            PdfPTable tabla =new PdfPTable(4);
            tabla.addCell("Medico");
            tabla.addCell("Honorario");
            tabla.addCell("Cantidad  de consultas");
            tabla.addCell("Costo total:");


            for (Map.Entry<Integer,Long> entry : map.entrySet()) {
                medico=clinica.buscaMedico(entry.getKey());
                total+=medico.getHonorario()*entry.getValue()*1.2;
                aux= (float) (medico.getHonorario()*entry.getValue()*1.2);
                tabla.addCell(medico.getNombre()+" "+medico.getApellido());
                tabla.addCell(String.valueOf(medico.getHonorario()));
                tabla.addCell(String.valueOf(entry.getValue()));
                tabla.addCell(String.valueOf(aux));
            }
            document.add(tabla);
            parrafo = new Paragraph("\n\n\n");
            document.add(parrafo);
           

            Iterator<Consulta> it =habitaciones.iterator();
            aux=0;
            if(habitaciones.size()!=0){
                PdfPTable tablaHabitaciones =new PdfPTable(4);
                tablaHabitaciones.addCell("Habitacion");
                tablaHabitaciones.addCell("Costo por estadia");
                tablaHabitaciones.addCell("dias internado");
                tablaHabitaciones.addCell("Sub total: ");
                while(it.hasNext()){
                    consulta=it.next();
                    dias=consulta.getDias();
                    habitacion=clinica.buscaHabitacion(consulta.getId());
                    total+=habitacion.getCosto(dias);
                    aux+=habitacion.getCosto(dias);
                    tablaHabitaciones.addCell(String.valueOf(habitacion.getId()));
                    tablaHabitaciones.addCell(String.valueOf(habitacion.getCosto(dias)));
                    tablaHabitaciones.addCell(String.valueOf(dias));
                    tablaHabitaciones.addCell(String.valueOf(aux));
                }
                tablaHabitaciones.addCell("El costo total es de: ");
                tablaHabitaciones.addCell(String.valueOf(total));
                tablaHabitaciones.addCell("");
                tablaHabitaciones.addCell("");

                document.add(tablaHabitaciones);

            }
            document.close();
            System.out.println("Factura creada");
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        System.out.println(factura);
        System.out.println("El costo total es de: "+ total);
        clinica.retiraPacienteListaAtencion(dni);
    }

}
