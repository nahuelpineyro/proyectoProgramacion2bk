package logica;

import java.io.Serializable;
import java.util.ArrayList;
import grafica.modificarContraseña;

public class Historial implements Serializable{
    private ArrayList<String> ArrPass;
    //private String HstPass;
    private static Historial single_instance = null;

    public static Historial getInstanciaHistorial() {

        if (single_instance == null) {
            single_instance = new Historial();
        }
        return single_instance;
    }
    Fecha Date = new Fecha();
    
    
    public Historial(){
        ArrPass = new ArrayList<>();
        //String HstPass = this.HstPass;
    }

    public void AñadirPass (String Pass){ // Añade la contraseña al array
        ArrPass.add(Pass);
        System.out.println("Se ejecuta AñadirPass (Historial)");
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
    
    public String GetAllPass(){ 
        String All="";
        for (int i=0;i<=ArrPass.size()-1;i++){
            All=ArrPass.get(i);
            System.out.println(All);
        }
        return All;
    }
    
    
    /*public String GetLastPass (){ // Regresa la ultima contraseña
        return ArrPass.getLast();
    } */
    
        // Posible metodo para que la contraseña sea distinta a 3 anteriores
    
//***************************************************************************    
    @Override
    public String toString() {
        return ArrPass.toString();
    }
} // Fin