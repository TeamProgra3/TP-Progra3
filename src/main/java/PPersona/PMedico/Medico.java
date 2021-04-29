package PPersona.PMedico;

public abstract class Medico {
    /*
    *   Esta es la "Master Class" que controla a todos los medicos con sus respectivos decorados.
    *
    *   **La variable "matriculaMedicos" es una variable de clase, es decir
    *       todas las instancias de la clase tienen el mismo valor independientemente de en que momento
    *       fue creada y con esta se determina la matricula de cada instancia para que sea unico
    *
    *   **La variable "sueldo basico" es el sueldo base asignado a cada medico, el cual es modificado
    *       por cada decorado que se le haga a las clases hijas de medico
    *
    *
    *
    *
    * */

    public static int matriculaMedicos=0;
    private static float sueldoBasico=2000;
    protected int matricula;
    private String tipo="medico";//esto se saca despues, solo es para pruebas
    public String saludo(){// esta funcion se quita, es para probar el patron
        return this.tipo;
    }
    /*
    * para setear desde el main si cambia el basico para que nadie toque esta clase UwU
    *
    * */

    public void setBasico(float sueldoBasico){
        Medico.sueldoBasico=sueldoBasico;
    }
    public float getHonorario(){
        return sueldoBasico;
    }

    public int getMatricula() {
        return this.matricula;
    }

    public void iniciaMatricula() {
    }

}
