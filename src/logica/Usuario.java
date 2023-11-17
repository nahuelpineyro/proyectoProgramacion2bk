package logica;

import java.io.Serializable;

import logica.LstCambiosPass;
public class Usuario implements Serializable{

    private String id;
    private String Pass;
    private LstInicioSesiones lstInicios;
    private LstCambiosPass lstCambios;

    public Usuario() {
        lstInicios = new LstInicioSesiones();
        lstCambios = new LstCambiosPass();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPass() {
        return Pass;
    }

    public void setPass(String Pass) {
        this.Pass = Pass;
    }
    
    public String verCambios() {
        return lstCambios.toString();
    }

    public String verSesiones() {
        return lstInicios.toString();
    }

    public void setLstCambios(LstCambiosPass pass){
        this.lstCambios = pass;
    }

    public LstCambiosPass getLstCambios() {
        return lstCambios;
    }
    
    public String getUltima(){
        String Ultima = lstCambios.getLast().toString();
        System.out.println("Usuarioultima "+Ultima);
        return Ultima;
    }

    @Override
    public String toString() {
        return "Usuario:" + id + " Pass: "+ Pass + "\nInicios de sesion: " + verSesiones()
                + "\ncambios de pass: " + verCambios();
    }

}
