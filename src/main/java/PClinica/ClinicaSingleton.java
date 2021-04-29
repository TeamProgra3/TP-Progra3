package PClinica;

public class ClinicaSingleton {
    /** ACA HAY QUE PONER TODAS LAS VARIABLES DE LA CLINICA
     *
     */
    public String nombre;
    public String dirrecion;
    public String telefono;
    public String ciudad;
    private static ClinicaSingleton instanciaClinica=null;
    private ClinicaSingleton(){
        this.nombre ="Clinica Facultad De Ingenieria";
        this.dirrecion="Av.Siempreviva 742";
        this.telefono="2231597536";
        this.ciudad="Mar Del Plata";
    }

    public static ClinicaSingleton getInstance(){
        if(instanciaClinica==null)
            instanciaClinica=new ClinicaSingleton();
        return instanciaClinica;
    }

}
