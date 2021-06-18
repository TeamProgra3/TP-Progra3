package clinica.serializacion;

import clinica.ClinicaSingleton;

import java.io.IOException;
import java.io.Serializable;

public class Persistencia {
    ClinicaSingleton clinica=ClinicaSingleton.getInstance();
    private IPersistencia<Serializable> persistencia= new PersistenciaBinaria();
    ClinicaDTO clinicaDTO=new ClinicaDTO();
    public void persisteDatos() throws IOException {


        clinicaDTO.setCiudad(clinica.getCiudad());
        clinicaDTO.setDireccion(clinica.getDireccion());
        clinicaDTO.setNombre(clinica.getNombre());
        clinicaDTO.setTelefono(clinica.getTelefono());

        clinicaDTO.setHabitaciones(clinica.getHabitaciones());
        clinicaDTO.setMedicos(clinica.getMedicos());
        clinicaDTO.setListaAtencion(clinica.getListaAtencion());
        clinicaDTO.setPacientesRegistrados(clinica.getPacientesRegistrados());

        clinicaDTO.setPatio(clinica.getPatio());
        clinicaDTO.setSalaPrivada(clinica.getSalaPrivada());

        persistencia.abrirOutput("clinica.bin");
        persistencia.escribir(clinicaDTO);
        persistencia.cerrarOutput();

    }
    public void levantarDatos() throws IOException, ClassNotFoundException {
        persistencia.abrirInput("clinica.bin");
        this.clinicaDTO= (ClinicaDTO) persistencia.leer();
        persistencia.cerrarInput();


        clinica.setCiudad(clinicaDTO.getCiudad());
        clinica.setDireccion(clinicaDTO.getDireccion());
        clinica.setNombre(clinicaDTO.getNombre());
        clinica.setTelefono(clinicaDTO.getTelefono());

        clinica.setHabitaciones(clinicaDTO.getHabitaciones());
        clinica.setMedicos(clinicaDTO.getMedicos());
        clinica.setListaAtencion(clinicaDTO.getListaAtencion());
        clinica.setPacientesRegistrados(clinicaDTO.getPacientesRegistrados());

        clinica.setPatio(clinicaDTO.getPatio());
        clinica.setSalaPrivada(clinicaDTO.getSalaPrivada());


    }


}
