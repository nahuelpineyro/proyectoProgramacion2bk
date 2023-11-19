package Fachada;

import logica.Usuario;
import logica.LstUsuarios;
import java.io.Serializable;
import persistencia.Archivo;
import logica.Instante;
import logica.Pass;

public class fachada implements Serializable {

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

        if (comprobacion(username)) {

            Usuario u = new Usuario(); // generamos el objeto usuario
            u.setId(username); // le asigno el nombre de usuario
            Pass p = new Pass(); // creamos el objeto contraseña para poder agregarle una pass al usuario
            u.setHabil(true);
            u.setPass(p.Gen()); // llamamos al metodo gen para generar una contraseña
            u.getLstCambios().AñadirPass(p); // añadimos la contraseña al listado historial
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
            if (lst.devolver(i).getId().equals(id)) {  // regresa null siempre ( problema en getID )

                return false; // False si encuentra un username similar
            }

        }
        return true; // True si noencuentra un username similar
    }

    public String ModificarPass(String viejaPass, String nuevaPass, String username){
        
        for (int i = 0; i <= this.lst.cantidad(); i++) {

            if (this.lst.devolver(i).getId().equals(username)) {
                Usuario u = this.lst.devolver(i);
                String TrueViejaPass = u.getPass();
                
                if (TrueViejaPass.equals(viejaPass)){   // revisa que la contraseña anterior este correcta
                
                    if(!TrueViejaPass.equals(nuevaPass)){ // Caso para que sean distintas

                        u.setPass(nuevaPass);  // setteamos la contraseña nueva al user
                        Pass p = new Pass();       // creamos un nuevo objeto pass para guardar en el historial 
                        p.setContrasenia(nuevaPass);
                        u.setHabil(true);
                        u.getLstInicios().IntentoFin();
                        u.getLstCambios().AñadirPass(p);
                        
                        Archivo.getInstancia().registrarUsuario(lst);
                        
                        return "Cambio de contraseña exitoso";
                    }else{
                        return "Las contraseñas son iguales";
                    }
                }else{
                    return "La contraseña anterior es incorrecta";
                }
                
            }
        }
        return "Error";
    }
    

    public String bajaUsuario(String username) {
        for (int i = 0; i <= this.lst.cantidad(); i++) {

            if (this.lst.devolver(i).getId().equals(username)) {

                Usuario u = this.lst.devolver(i);
                this.lst.eliminarUser(u);
                Archivo.getInstancia().registrarUsuario(this.lst);
                

                return "usuario eliminado";
            }
        }

        return "El usuario no existe";
    }

    public String inicioSesion(String username, String password) {  // Login
        
        for (int i = 0; i <= this.lst.cantidad(); i++) {

            if (this.lst.devolver(i).getId().equals(username)) { // verifica al usuario
                Usuario u = this.lst.devolver(i);


                if (u.isHabil()) {                                      // revisa si el user esta habilitado a logearse
                    while (true){
                        u.getLstInicios().IntentoPlus();
                        
                        if (u.getLstInicios().getIntentos()<= 3){                   // cuenta los intentos
                            if (UltimaPass(username).equals(password)) {        // verifica la contraseña
                                u.getLstInicios().IntentoFin();
                                Instante I = new Instante();
                                u.getLstInicios().AñadirInico(I);
                                Archivo.getInstancia().registrarUsuario(this.lst);
                                return "Login true";
                            }else{
                            Archivo.getInstancia().registrarUsuario(this.lst);
                            return "Contraseña incorrecta | "+u.getLstInicios().getIntentos()+" de 3 intentos";
                            }
                        }else{
                        u.setHabil(false);
                        Archivo.getInstancia().registrarUsuario(this.lst);
                        return "Login false";
                        }    
                    } // Cierre while
                }else{
                Archivo.getInstancia().registrarUsuario(this.lst);
                return "El usuario esta blockeado";
                }
            }else{
            }
        } // cierre for
        Archivo.getInstancia().registrarUsuario(this.lst); // Guarda todo en persis
        return "Error";
    }
    
    public String historialContraseñas(String username) {
        for (int i = 0; i <= this.lst.cantidad(); i++) {

            if (this.lst.devolver(i).getId().equals(username)) {
                Usuario u = this.lst.devolver(i);
                
                return u.getLstCambios().toString();
            }

        }
        return "No existe ese usuario en el sistema";
    }
    
    public String UltimaPass (String username){
        for (int i = 0; i <= this.lst.cantidad(); i++) {

            if (this.lst.devolver(i).getId().equals(username)) {
                Usuario u = this.lst.devolver(i);
                return u.getPass();
            }
        }
        return "No existe ese usuario en el sistema";
    }

}