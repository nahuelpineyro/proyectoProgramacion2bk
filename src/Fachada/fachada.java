package Fachada;

import logica.Usuario;
import logica.LstUsuarios;
import grafica.altaUsuario;
import persistencia.Archivo;

public class fachada implements Serializable{

    private static fachada instancia;

    private LstUsuarios lst;
    public static fachada getInstanciaFachada() {

        if (instancia == null) {
            instancia = new fachada();
        }

        return instancia;

    }
    
    private fachada() {
        LstUsuarios lst = new LstUsuarios();
        lst = Archivo.getInstancia().usuariosRegistrados();
    }
    
    
    
    String username;

    public String createUsername(String nombre, String apellido) { // Crea el ID del usuario
        
        altaUsuario.getInstanciaALTA();
        Usuario u = new Usuario();
        String name = nombre;
        String lastname = apellido;
<<<<<<< Updated upstream
        String username = name.charAt(0) + lastname;
        u.setId(username);

        if (comprobacion(u.getId())) {
            lst.agregar(u);
            Archivo.getInstancia().registrarUsuario(lst);
=======
        username = name.charAt(0) + lastname;

         // generamos el objeto usuario
        System.out.println(lst);
        if (comprobacion(username)) {
            System.out.println("el codigo entreo al if true");
            Usuario u = new Usuario();
            u.setId(username);
            Pass p = new Pass(); // creamos el objeto contraseña para poder agregarle una pass al usuario
            p.Gen();  // llamamos al metodo gen para generar una contraseña
            u.getLstCambios().AñadirPass(p); // a
            lst.agregar(u);
            
            Archivo.getInstancia().registrarUsuario(lst);
             // le asigno el nombre de usuario
            //Añadimos la contraseña al listado historial
            System.out.println("La lista" + lst);
            System.out.println("");
>>>>>>> Stashed changes
            return username;
        } else {
            String mensaje = "El usuario " + username + " ya existe";
            return mensaje;
        }

    }

    public boolean comprobacion(String id) { // Revisa si el usuario existe
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

    public boolean PassCheck(String Pass1, String Pass2) {
        return Pass1.equals(Pass2);
    }
    
    
    public String bajaUsuario(String username, String password){
        
        if(comprobacion(username)){
            
            lst.eliminarIndex(lst.devolverIndexUsr(username));
        }
        
        
        return null;
    }
    
    
}
