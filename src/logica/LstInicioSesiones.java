package logica;

public class LstInicioSesiones extends Historial {
    private boolean habilitado;
    private int intentos;

    public LstInicioSesiones() {
        this.habilitado = true;
        this.intentos = 0;
    }
    
    public String Habil(String Entrada){
        
        //String Contraseña;
        String test="Abc123";
        String Habil_Salida="";
        
        while (true){
            this.intentos++;
            
        if (intentos<=3 && Entrada.equals(test)){
            habilitado=true;
            Habil_Salida="Inicio logrado";
            this.intentos=0;
        }
        if (intentos<=3 && !Entrada.equals(test)){
            habilitado=true;
            Habil_Salida="No se inicio secion";
            System.out.println(this.intentos);
            
        }
        if (intentos>3){
            habilitado=false;
            Habil_Salida="Blockeado";
            System.out.println(this.intentos);
        }
        return Habil_Salida;
    }
    }
    
    
//***************************************************************************    
    @Override
    public String toString() {
        return super.toString();
    }
}
