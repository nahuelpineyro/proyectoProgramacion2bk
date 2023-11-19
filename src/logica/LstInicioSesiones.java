package logica;

import logica.Usuario;

public class LstInicioSesiones extends Historial {
    //private boolean habilitado;
    private int intentos;

    public LstInicioSesiones() {
        //this.habilitado = true;
        this.intentos = 0;
    }
    
    
    public void IntentoPlus (){
        this.intentos++;
    }
    public void IntentoFin(){
        this.intentos = 0;
    }

    public int getIntentos() {
        return intentos;
    }
    
    
    
    
    
//***************************************************************************    
    @Override
    public String toString() {
        return super.toString();
    }
}
