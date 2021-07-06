package clinica.serializacion;

import clinica.ClinicaSingleton;

import java.io.IOException;
import java.io.Serializable;
/**
 * La clase Persistencia se encarga de persistir los datos en disco como tambien levantar la los datos del mismo<br>
 *
 * @author Los Cafeteros
 */
public class Persistencia {

    public static void persisteDatos() throws IOException {
        ClinicaDTO clinicaDTO=new ClinicaDTO();
        IPersistencia<Serializable> persistenciaBinaria= new PersistenciaBinaria();
        clinicaDTO.setCiudad(ClinicaSingleton.getInstance().getCiudad());
        clinicaDTO.setDireccion(ClinicaSingleton.getInstance().getDireccion());
        clinicaDTO.setNombre(ClinicaSingleton.getInstance().getNombre());
        clinicaDTO.setTelefono(ClinicaSingleton.getInstance().getTelefono());

        clinicaDTO.setHabitaciones(ClinicaSingleton.getInstance().getHabitaciones());
        clinicaDTO.setMedicos(ClinicaSingleton.getInstance().getMedicos());
        clinicaDTO.setListaAtencion(ClinicaSingleton.getInstance().getListaAtencion());
        clinicaDTO.setPacientesRegistrados(ClinicaSingleton.getInstance().getPacientesRegistrados());

        clinicaDTO.setPatio(ClinicaSingleton.getInstance().getPatio());
        clinicaDTO.setSalaPrivada(ClinicaSingleton.getInstance().getSalaPrivada());
        clinicaDTO.setListaAsociados(ClinicaSingleton.getInstance().getListaAsociados());

        persistenciaBinaria.abrirOutput("clinica.bin");
        persistenciaBinaria.escribir(clinicaDTO);
        persistenciaBinaria.cerrarOutput();

    }
    public static void levantarDatos() throws IOException, ClassNotFoundException {
        ClinicaDTO clinicaDTO=new ClinicaDTO();
        IPersistencia<Serializable> persistenciaBinaria= new PersistenciaBinaria();

        persistenciaBinaria.abrirInput("clinica.bin");
        clinicaDTO= (ClinicaDTO) persistenciaBinaria.leer();
        persistenciaBinaria.cerrarInput();
        System.out.println("Levanto datos de archivo");

        ClinicaSingleton.getInstance().setCiudad(clinicaDTO.getCiudad());

        ClinicaSingleton.getInstance().setDireccion(clinicaDTO.getDireccion());
        ClinicaSingleton.getInstance().setNombre(clinicaDTO.getNombre());
        ClinicaSingleton.getInstance().setTelefono(clinicaDTO.getTelefono());

        ClinicaSingleton.getInstance().setHabitaciones(clinicaDTO.getHabitaciones());
        ClinicaSingleton.getInstance().setMedicos(clinicaDTO.getMedicos());
        ClinicaSingleton.getInstance().setListaAtencion(clinicaDTO.getListaAtencion());
        ClinicaSingleton.getInstance().setPacientesRegistrados(clinicaDTO.getPacientesRegistrados());
        ClinicaSingleton.getInstance().setPatio(clinicaDTO.getPatio());
        ClinicaSingleton.getInstance().setSalaPrivada(clinicaDTO.getSalaPrivada());
        ClinicaSingleton.getInstance().setListaAsociados(clinicaDTO.getListaAsociados());


    }


}
