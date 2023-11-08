package logica;

import java.io.Serializable;
import java.util.ArrayList;
import logica.LstCambiosPass;

public class Historial implements Serializable{
    private ArrayList<String> ArrPass;
    
    private static Historial instancia;

    public static Historial getInstanciaFachada() {

        if (instancia == null) {
            instancia = new Historial();
        }
        return instancia;
    }
    LstCambiosPass LstPass = new LstCambiosPass();
    
    public Historial(){
        ArrPass = new ArrayList<>();
        //this.Intentos = 0;
    }

    public void AddPass (String Pass){ // Añade la contraseña al array
        ArrPass.add(Pass);
    }
    
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
    
    
    
    public boolean ChPass (String NewPass){  // Metodo para cambiar la contraseña
        String OldPass = LstPass.GetLst();
        if (NewPass.equals(OldPass)){
            System.out.println("Test misma pass en ChPass");
            return false;
        }else{
            this.AddPass(NewPass);
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

    
    
    
    /* Métodos específicos */
    
//***************************************************************************    
    @Override
    public String toString() {
        return ArrPass.toString();
    }
} // Fin
