package logica;

import java.io.Serializable;
import java.util.ArrayList;

public class Historial implements Serializable{
    private ArrayList<Pass> LstPass;
    private ArrayList<Instante> LstInicios;
    
    
    public Historial(){
        LstPass = new ArrayList<>();
        LstInicios = new ArrayList<>();
    }

    
    public void AñadirPass (Pass P){
        LstPass.add(P);
    }
    public void EliminarPass (Pass P){
        LstPass.remove(P);
    }
    
    public void AñadirInico (Instante I){
        LstInicios.add(I);
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

    
//***************************************************************************   
    public String toStringIni(){
        return LstInicios.toString();
    }
    
    @Override
    public String toString() {
        return LstPass.toString();
    }
} // Fin