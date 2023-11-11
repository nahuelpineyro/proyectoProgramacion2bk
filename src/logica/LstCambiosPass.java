package logica;

import java.io.Serializable;
import java.util.ArrayList;

public class LstCambiosPass implements Serializable{          // extends Historial {  < Genera StackOverflow si se utiliza
        private ArrayList<String> listaPass;
       // private ArrayList<String> PassDate;
        private static LstCambiosPass single_instance = null;
        
        
  /*      public static LstCambiosPass getInstance()
    {
        if (single_instance == null)
            single_instance = new LstCambiosPass();
 
        return single_instance;
    }*/
        
        
    public LstCambiosPass() {
    this.listaPass = new ArrayList<>();
    System.out.println(listaPass+"sout lista pass");
    System.out.println(this.listaPass+"sout this lista pass");
    }
        
    public void AddPass(String P){
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
            System.out.println(All);
        }
        return All;
    }
    
 /*   public void AddDate (String D){
        PassDate.add(D);
    }
    public String GetAllDate(){
        String Date="";
        for (int i=0;i<=PassDate.size()-1;i++){
            Date=PassDate.get(i);
            System.out.println(Date);
        }
        return Date;
    } */


    @Override
    public String toString() {
        return super.toString();
    }
 
}