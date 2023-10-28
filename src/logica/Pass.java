package logica;

import java.io.Serializable;
import java.util.Random;
import Fachada.fachada;

public class Pass implements Serializable{
    private Instante instante;  //Genera la fecha y hora al generarese
    private String contrasenia;
    private Random azar;
    
    public Pass() {
        azar = new Random();
        instante = new Instante();
    }
    
    fachada facha = new fachada();
    //Genrador de constraseña random
    public String Gen (){
        
        if (facha.comprobacion()==false){
        
        Random r = new Random();
        int cont=1;
        String contrasenia="";
        int x = (int)(Math.random()*(8-5))+5;
        int Random;
        
        do{
             if (contrasenia.length()<=x){   
                char Gen = (char) (97 + r.nextInt(25));
                contrasenia = contrasenia+Gen;       
            }else{              
                Random = (int)(Math.random()*(9-0)+1);
                contrasenia = contrasenia+Random;               
            }
            
        cont++;
        }while(cont<=12);
              
        int i=(int)(Math.random()*(9-3)+3);
            char Sp = (char)(58 + r.nextInt(7));
            contrasenia = contrasenia.substring(0,i)+ Sp + contrasenia.substring(i+1);
            
            int check = i;
            
            while (i==check){
                i=(int)(Math.random()*(x-0)+1);
            }
            
                Sp=contrasenia.charAt(i);
                Sp=Character.toUpperCase(Sp);
                contrasenia = contrasenia.substring(0,i)+ Sp + contrasenia.substring(i+1);
                
                return contrasenia;
        }
        else{ return null;}
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
    
    public String Politica (){
        int NivelSec=contrasenia.length();
        int NivelMultiplo=1;
        String Nivel="";

                
                for (int c=0 ;c<=contrasenia.length()-1 ; c++){
                    
                    
                    char Ch = contrasenia.charAt(c);
                    
                    System.out.println(Ch);
                    if (Ch >= ':' && Ch <= '@'){
                        NivelMultiplo++;
                    }
                    if (Ch >= 'A' && Ch <= 'Z'){
                        NivelMultiplo++;
                    }
                }
                NivelSec=NivelSec*NivelMultiplo;
                
                if (NivelSec<=24){
                    Nivel="Debil";
                }
                if (NivelSec>24 && NivelSec<=36){
                    Nivel="Buena";
                }
                if (NivelSec>36){
                    Nivel="Avanzada";
                }
                return Nivel;
    }
    
    @Override
    public String toString() {
        return "\n[" + contrasenia + "]" + "{" + instante + "}";
    }
}
