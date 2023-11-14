package logica;

import java.io.Serializable;
import java.util.ArrayList;
import grafica.modificarContraseña;

public class Historial implements Serializable{
    private ArrayList<Pass> LstPass;
    
    
    public Historial(){
        LstPass = new ArrayList<>();
    }

    // getters para la herencia
    
    public void AñadirPass (Pass P){ // Añade la contraseña al array
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
    
    public String GetPass (int i){
        return LstPass.get(i) // .getContraseña(); ( revisar metodo ) 
    }
    
    
    
   /* public boolean ChPass (String NewPass){  // Metodo para cambiar la contraseña
        String OldPass = ArrPass.getLast();
        if (NewPass.equals(OldPass)){
            return false;
        }else{
            ArrPass.add(NewPass);
            return true;
        }
    }*/
    
    /*
    public String GetAllPass(){ 
        String All="";
        for (int i=0;i<=LstPass.size()-1;i++){
            All=LstPass.get(i);
            System.out.println(All);
        }
        return All;
    }
    
    */
    
    public Pass GetLst(){
        return LstPass.getLast();
    }
    
//***************************************************************************    
    @Override
    public String toString() {
        return LstPass.toString();
    }
} // Fin