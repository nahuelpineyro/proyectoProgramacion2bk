package logica;

import java.io.Serializable;
import java.util.ArrayList;
import logica.LstCambiosPass;
import grafica.modificarContraseña;

public class Historial implements Serializable{
    private ArrayList<String> ArrPass;
    private static Historial single_instance = null;

    public static Historial getInstanciaHistorial() {

        if (single_instance == null) {
            single_instance = new Historial();
        }
        return single_instance;
    }
  //  LstCambiosPass LstPass = LstCambiosPass.getInstance();
    LstCambiosPass LstPass = new LstCambiosPass();
    Fecha Date = new Fecha();
    
    
    public Historial(){
        ArrPass = new ArrayList<>();
        //this.Intentos = 0;
    }

    public void AñadirPass (String Pass){ // Añade la contraseña al array
        //ArrPass.add(Pass);
        LstPass.AddPass(Pass);
    }

    
    public boolean ChPass (String NewPass){  // Metodo para cambiar la contraseña
        
    modificarContraseña.getInstanciaMC();
        String OldPass = LstPass.GetLst();
        if (NewPass.equals(OldPass)){
            return false;
        }else{
            this.AñadirPass(NewPass);
           // LstPass.AddDate(Date.toString());
            return true;
        }
    }
    /*
    public String GetAllPassSout (){ // METODO DE TESTEO ( anda )
        String All="";
        for (int i=0;i<=ArrPass.size()-1;i++){
            All=ArrPass.get(i);
            System.out.println(All);
        }
        return All;
    }*/
    
    // Posible metodo para que la contraseña sea distinta a 3 anteriores
    
    /* 
    En esta clase se ubican las operaciones comúnes a:
    - Lista de cambios de contraseña
    */
    
    /* Métodos primitivos */
    
    /*public void Cont (){
        this.Intentos++;
    }                           */ //Capas que metodo util, IDK en este momento, queda por las dudas

    /*    public String GetLastPass (){ // Regresa la ultima contraseña
        int tamaño=(ArrPass.size());
        tamaño--;
        String Pass=ArrPass.get(tamaño);
        return Pass;
    } */
    
/*    public String GetAllPass (){ // Regresa TODAS las contraseñas del usr
        String All="";
        for (int i=0;i<=ArrPass.size()-1;i++){
            All=ArrPass.get(i);
        }
        return All;
    } */
    
    
    /* Métodos específicos */
    
//***************************************************************************    
    @Override
    public String toString() {
        return ArrPass.toString();
    }
} // Fin
