package logica;

import java.io.Serializable;
import java.util.ArrayList;

public class Historial implements Serializable{
    private ArrayList<Pass> LstPass;
    
    
    public Historial(){
        LstPass = new ArrayList<>();
    }

    // getters para la herencia
    
    public void AñadirPass (Pass P){
        LstPass.add(P);
        System.out.println("Se ejecuta AñadirPass (Historial)");
    }

    public void EliminarPass (Pass P){
        LstPass.remove(P);
    }
    
    public int TamañoLstPass(){
        return LstPass.size();
    }
    
    public Pass devolver (int i){
        return LstPass.get(i);
    }
    
    public Pass getLast(){
        return LstPass.get(-1);
    }
    
    public String toStringlst(Pass P){
        return ""+LstPass;
    }

    
//***************************************************************************    
    @Override
    public String toString() {
        return LstPass.toString();
    }
} // Fin