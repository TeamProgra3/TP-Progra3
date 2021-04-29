package PException;

import sun.java2d.loops.CustomComponent;

public class FactoryException extends Exception{
    public static final long serialVersionUID=700L;

    public  FactoryException(String mensaje){
        super(mensaje);
    }
}
