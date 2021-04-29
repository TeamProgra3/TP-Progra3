package PPersona.PMedico;

public class MedicoFactory {


    private Medico setprofecion(String profecion){
        if(profecion.equals("cirujano"))
            return new Cirugia();
        if(profecion.equals("clinico"))
            return  new Clinico();
        if (profecion.equals("pediatra"))
            return new Pediatria();
        return null;// hay que crear una clase con errores para tirar errores como haberme anotado a arquitectura :D
    }

    private Medico setTipo(String tipo,Medico loDecorado){
        if(tipo.equals("permanente"))
            return new DPermanente(loDecorado);
        if(tipo.equals("residente"))
            return new DResidente(loDecorado);
        return null;

    }

    private Medico setEstudio(String estudio,Medico loDecorado){
        if(estudio.equals("magister"))
            return new DMagister(loDecorado);
        if(estudio.equals("doctor"))
            return new DDoctor(loDecorado);
        return null;

    }
    public Medico getMedico(String profecion,String tipo,String estudio){
        Medico aux;
        aux= setprofecion(profecion);
        aux= setTipo(tipo,aux);
        return setEstudio(estudio,aux);
    }
}
