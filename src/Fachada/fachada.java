package Fachada;

import logica.Usuario;
import logica.LstUsuarios;
import java.io.Serializable;
import persistencia.Archivo;
import logica.Instante;
import logica.Pass;

public class fachada implements Serializable {

    private static fachada instancia;
    private int Intentos;
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

        System.out.println(lst);
        if (comprobacion(username)) {

            Usuario u = new Usuario(); // generamos el objeto usuario
            u.setId(username); // le asigno el nombre de usuario
            Pass p = new Pass(); // creamos el objeto contraseña para poder agregarle una pass al usuario
            //p.Gen();  
            u.setHabil(true);
            u.setPass(p.Gen()); // llamamos al metodo gen para generar una contraseña
            u.getLstCambios().AñadirPass(p); // añadimos la contraseña al listado historial
            lst.agregar(u);
            Archivo.getInstancia().registrarUsuario(lst);

            System.out.println("La lista\n" + lst);

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
                        u.getLstCambios().AñadirPass(p); 
                        System.out.println("Test Cambio Pass\n"+lst);
                        
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
        System.out.println("\nlista al principio" + this.lst);
        for (int i = 0; i <= this.lst.cantidad(); i++) {

            if (this.lst.devolver(i).getId().equals(username)) {

                Usuario u = this.lst.devolver(i);
                this.lst.eliminarUser(u);
                Archivo.getInstancia().registrarUsuario(this.lst);
                

                return "usuario eliminado";
            }
        }

        System.out.println("sout al final de baja usuario" + lst);
        return "El usuario no existe";
    }

    public String inicioSesion(String username, String password) {

        for (int i = 0; i <= this.lst.cantidad(); i++) {

            if (this.lst.devolver(i).getId().equals(username)) { // verifica al usuario
                Usuario u = this.lst.devolver(i);

                System.out.println("ingresa al primer if si el usuario coincide");

                if (u.isHabil()) {                                      // revisa si el user esta habilitado a logearse
                    while (true){
                        u.getLstInicios().IntentoPlus();
                        
                        System.out.println("Cantidad de intentos "+u.getLstInicios().getIntentos());
                        if (u.getLstInicios().getIntentos()<= 3){                   // cuenta los intentos
                            if (UltimaPass(username).equals(password)) {        // verifica la contraseña
                                u.getLstInicios().IntentoFin();
                                System.out.println("ingresa al segundo if si la password coincide");
                                System.out.println("\nlista al principio" + this.lst);
                                Instante I = new Instante();
                                u.getLstInicios().AñadirInico(I);
                                return "Login true";
                            }else{
                            return "Contraseña incorrecta | "+u.getLstInicios().getIntentos()+" de 3 intentos";
                            }
                        }else{
                        System.out.println("\nlista al principio" + this.lst);
                        u.setHabil(false);
                        return "Login false";
                        }    
                    } // Cierre while
                }else{
                System.out.println("\nlista al principio" + this.lst);
                return "El usuario esta blockeado";
                }
            }else{
                return "El usuario no se encontro";
            }
        } // cierre for
        Archivo.getInstancia().registrarUsuario(lst); // Guarda todo en persis
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