package logica;

public class LstInicioSesiones extends Historial {
    private boolean habilitado;
    private int intentos;

    public LstInicioSesiones() {
        this.habilitado = true;
        this.intentos = 0;
    }
    
    /*public void Habil(){
        
        String Contraseña;
        int Cont=0;
        
        while (true){
            System.out.println("Inicio de secion");
            Cont++;
            
        if (Cont<=3 && Entrada.equals(test)){
            habilitado=true;
            System.out.println("Inicio logrado");
            Cont=0;
        }
        if (Cont<=3 && !Entrada.equals(test)){
            habilitado=true;
            System.out.println("No se inicio secion");
            
        }
        if (Cont>3){
            habilitado=false;
            System.out.println("Blockeado");
        }
    }*/
    
    
//***************************************************************************    
    @Override
    public String toString() {
        return super.toString();
    }
}
