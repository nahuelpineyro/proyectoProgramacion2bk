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
    String username;

    public String createUsername(String nombre, String apellido) { // Crea el ID del usuario
        lst = Archivo.getInstancia().usuariosRegistrados();
        altaUsuario.getInstanciaALTA();
        Usuario u = new Usuario();
        String name = nombre;
        String lastname = apellido;
        String username = name.charAt(0) + lastname;
        u.setId(username);

        if (comprobacion(u.getId())) {
            lst.agregar(u);
            Archivo.getInstancia().registrarUsuario(lst);
            return username;
        } else {
            String mensaje = "El usuario "+username+" ya existe";
            return mensaje;
        }
        
        

    }

    public boolean comprobacion(String id){ // Revisa si el usuario existe
        if (lst.sinRegistros()) { //True si esta la lista vacia
            return true;
        }
        

        for (int i = 0; i <= lst.cantidad(); i++) {
            if (lst.devolver(i).getId().equals(id)) {
                 
                return false; // False si encuentra un username similar
            }

        }
        return true; // True si noencuentra un username similar
    }
    
    public boolean PassCheck (String Pass1,String Pass2){
        return Pass1.equals(Pass2);
    }
        
    }
    

