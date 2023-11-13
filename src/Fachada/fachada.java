package Fachada;

import logica.Usuario;
import logica.LstUsuarios;
import grafica.altaUsuario;
import persistencia.Archivo;

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
        LstUsuarios lst = new LstUsuarios();
        this.lst = Archivo.getInstancia().usuariosRegistrados();
    }

    String username;

    public String createUsername(String nombre, String apellido) { // Crea el ID del usuario

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

    public boolean PassCheck(String Pass1, String Pass2) { // revisa que las contraseñas sean iguales a la hora de modificar
        return Pass1.equals(Pass2);
    }

    public String bajaUsuario(String username) {
        System.out.println("");
        System.out.println("lista al principio" + this.lst);
        System.out.println("");
        for (int i = 0; i <= this.lst.cantidad(); i++) {
            System.out.println("");
            System.out.println("Esto imprime this.lst.devolver(i).getId() antes del if" + this.lst.devolver(i).getId());
            System.out.println("");
            if (this.lst.devolver(i).getId().equals(username)) {
                System.out.println("");
                System.out.println("Esto imprime lst.devolver(i)" + this.lst.devolver(i));
                System.out.println("");
                Usuario u = this.lst.devolver(i);
                this.lst.eliminarUser(u);
                Archivo.getInstancia().registrarUsuario(this.lst);
                String mensaje = "usuario eliminado";
                System.out.println("");
                System.out.println("sout si el usuario fue borrado"  + lst);
                return mensaje;
            }
        }
        // If the loop completes without finding the user
        String mensajeOpuesto = "El usuario no existe";
        System.out.println("");
        System.out.println("sout al final de baja usuario"  + lst);
        System.out.println("");
        return mensajeOpuesto;
    }

}
