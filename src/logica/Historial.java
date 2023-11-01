package logica;

import java.io.Serializable;
import java.util.ArrayList;

public class Historial implements Serializable{
    private ArrayList<Pass> lista;
    private int Intentos=0;
    
    
    
    public Historial(){
        lista = new ArrayList<>();
        this.Intentos = 0;
    }

    /* 
    En esta clase se ubican las operaciones comúnes a:
    - Lista de cambios de contraseña
    - Lista de inicios de sesión
    */
    
    /* Métodos primitivos */
    
    /*public void Cont (){
        this.Intentos++;
    }                           */ //Capas que metodo util, IDK en este momento, queda por las dudas

    
    
    
    /* Métodos específicos */
    
//***************************************************************************    
    @Override
    public String toString() {
        return lista.toString();
    }
} // Fin