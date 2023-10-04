package logica;

import java.io.Serializable;
import java.util.Random;

public class Pass implements Serializable{
    private Instante instante;
    private String contrasenia;
    private Random azar;
    
    public Pass() {
        azar = new Random();
        instante = new Instante();
    }
    
    
    /* En esta clase se ubican las 
    politicas de contraseña */
    
    
    
    @Override
    public String toString() {
        return "\n[" + contrasenia + "]" + "{" + instante + "}";
    }
}
