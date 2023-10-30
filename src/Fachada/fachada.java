package Fachada;

import logica.Usuario;
import logica.LstUsuarios;
import grafica.altaUsuario;
import persistencia.Archivo;

public class fachada {
        
    private static fachada instancia;

    public static fachada getInstanciaFachada() {

        if (instancia == null) {
            instancia = new fachada();
        }

        return instancia;

    }
    LstUsuarios lst = new LstUsuarios();
    public String username;

    public String createUsername(String nombre, String apellido) {
        lst = Archivo.getInstancia().usuariosRegistrados();
        altaUsuario.getInstanciaALTA();
        Usuario u = new Usuario();
        String name = nombre;
        String lastname = apellido;
        String username = name.charAt(0) + lastname;
        this.username = username;
        if(this.comprobacion() == true){
            Archivo.getInstancia().registrarUsuario(lst);
        }else{
            System.out.println("El usuario "+username+" ya existe comprobacion");
        }
        return username;

    }

    public Boolean comprobacion() {
        for (int i = 0; i < lst.cantidad(); i++) {
            //System.out.println(lst.toString());
            //System.out.println(lst.cantidad());
            if (lst.devolver(i).getId().equals(username)) {
                System.out.println(lst.devolver(i).toString());
                System.out.println("true test");
                return true;
            }

        }
    return false;
    }
}