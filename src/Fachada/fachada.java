package Fachada;

import logica.Usuario;
import logica.LstUsuarios;
import grafica.altaUsuario;
import java.io.Serializable;
import persistencia.Archivo;
import logica.LstCambiosPass;
import logica.Pass;

public class fachada {

    private static fachada instancia;

    private LstUsuarios lst;

    public static fachada getInstanciaFachada() {

        if (instancia == null) {
            instancia = new fachada();
        }

        return instancia;

    }

    private fachada() {
        this.lst = Archivo.getInstancia().usuariosRegistrados();
    }

    String username;

    

    public String createUsername(String nombre, String apellido) { // Crea el ID del usuario

        String name = nombre;
        String lastname = apellido;
        String username = name.charAt(0) + lastname;

        Usuario u = new Usuario(); // generamos el objeto usuario
        System.out.println(lst);
        if (comprobacion(username)) {
            
            /******************* Esto vas a hacerlo en un metodo aparte */ // queda aqui para testeo only
            lst.agregar(u);
            Archivo.getInstancia().registrarUsuario(lst);
            u.setId(username); // le asigno el nombre de usuario
            Pass p = new Pass(); // creamos el objeto contraseña para poder agregarle una pass al usuario
            p.Gen();  // llamamos al metodo gen para generar una contraseña
            u.getLstCambios().AñadirPass(p); // añadimos la contraseña al listado historial
            System.out.println("La lista" + lst);
            /**************************************************************/
            
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
            if (lst.devolver(i).getId().equals(id)) {  // regresa null siempre ( problema en getID )

                return false; // False si encuentra un username similar
            }

        }
        return true; // True si noencuentra un username similar
    }

    public boolean PassCheck(String Pass1, String Pass2) { // revisa que las contraseñas sean iguales a la hora de modificar
        return Pass1.equals(Pass2);
    }

    public String bajaUsuario(String username) {
        System.out.println("");
        System.out.println("lista al principio" + this.lst);
        System.out.println("");
        for (int i = 0; i <= this.lst.cantidad(); i++) {

            if (this.lst.devolver(i).getId().equals(username)) {

                Usuario u = this.lst.devolver(i);
                this.lst.eliminarUser(u);
                Archivo.getInstancia().registrarUsuario(this.lst);
                String mensaje = "usuario eliminado";

                return mensaje;
            }
        }
        // If the loop completes without finding the user
        String mensajeOpuesto = "El usuario no existe";
        System.out.println("");
        System.out.println("sout al final de baja usuario" + lst);
        System.out.println("");
        return mensajeOpuesto;
    }

}
