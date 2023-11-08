package logica;

import java.util.ArrayList;

public class LstCambiosPass extends Historial {
        private ArrayList<String> listaPass;
        
        
    public LstCambiosPass() {
    listaPass = new ArrayList<>();
    }
        
     public void Add1stPass(String P){
         listaPass.add(P);
     }
     
    public String GetLst() {
        int tamaño=(listaPass.size());
        tamaño--;
        String Pass=listaPass.get(tamaño);
        return Pass;
    }
    public String GetAll(){
        String All="";
        for (int i=0;i<=listaPass.size()-1;i++){
            All=listaPass.get(i);
        }
        return All;
    }
      


    @Override
    public String toString() {
        return super.toString();
    }
 
}