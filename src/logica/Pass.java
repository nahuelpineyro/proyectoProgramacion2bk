package logica;

import java.io.Serializable;
import java.util.Random;
import Fachada.fachada;
import logica.Historial;
import logica.LstCambiosPass;

public class Pass implements Serializable{
    private Instante instante;  //Genera la fecha y hora al generarese
    private Pass contrasenia;
    private Random azar;
    
    public Pass() {
        azar = new Random();
        instante = new Instante();
    }
    
    fachada facha = fachada.getInstanciaFachada();
    Fecha Date = new Fecha();
    
    
    public void setContrasenia(Pass contrasenia) {
        this.contrasenia = contrasenia;
    }

    public Pass getContrasenia() {
        return contrasenia;
    }
    
    
    public String Gen (){ //Generador random de contraseña
        
        Historial Historia = new Historial();  
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
                
                //this.setContrasenia(contrasenia);
                //Historia.AñadirPass(contrasenia);
                
                //this.setContrasenia(contrasenia);  // Not working so far
                
                Historia.AñadirPass(this.contrasenia);
                
                System.out.println("Pass: " + contrasenia);
                
                return contrasenia;
        }


                                
    public String Politica (){ // Politica del nivel de la  contraseña
        
        String Entrada = this.toStringPass();
        
        int NivelSec=Entrada.length();
        int NivelMultiplo=1;
        String Nivel="";

                
                for (int c=0 ;c<=Entrada.length()-1 ; c++){
                    
                    
                    char Ch = Entrada.charAt(c);
                    
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
    public String toStringPass(){
        return ""+contrasenia;
    }
}
