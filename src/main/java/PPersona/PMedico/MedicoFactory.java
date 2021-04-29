package PPersona.PMedico;

public class MedicoFactory {


    private IMedico setprofesion(String profesion,String nombre,String apellido){
        if(profesion.equals("cirujano"))
            return new Cirugia(nombre,apellido);
        if(profesion.equals("clinico"))
            return  new Clinico(nombre,apellido);
        if (profesion.equals("pediatra"))
            return new Pediatria(nombre,apellido);
        return null;// hay que crear una clase con errores para tirar errores como haberme anotado a arquitectura :D
    }

    private IMedico setTipo(String tipo,IMedico loDecorado){
        if(tipo.equals("permanente"))
            return new DPermanente(loDecorado);
        if(tipo.equals("residente"))
            return new DResidente(loDecorado);
        return null;

    }

    private IMedico setEstudio(String estudio,IMedico loDecorado){
        if(estudio.equals("magister"))
            return new DMagister(loDecorado);
        if(estudio.equals("doctor"))
            return new DDoctor(loDecorado);
        return null;

    }
    public IMedico getMedico(String nombre,String apellido, String profesion,String tipo,String estudio){
        IMedico aux;
        aux= setprofesion(profesion,nombre,apellido);
        aux= setTipo(tipo,aux);
        return setEstudio(estudio,aux);
    }
}
