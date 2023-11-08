package logica;

import java.io.Serializable;
import java.util.ArrayList;

public class LstUsuarios implements Serializable {

    private ArrayList<Usuario> lista;

    public LstUsuarios() {
        lista = new ArrayList<>();
    }

    /* Métodos primitivos */
    public void agregar(Usuario u) {
        lista.add(u);    
    }
    public void eliminarUser(Usuario u) {
        lista.remove(u);
    }
    public void eliminarIndex(int i) {
        lista.remove(i);
    }
    public int cantidad() {
        int cantidad = lista.size() - 1;
        return cantidad;
    }
    public Usuario devolver(int i) {
        return lista.get(i);
    }
    
    public int devolverIndexUsr(String u){
        return lista.indexOf(u);
    }
    public boolean sinRegistros() {
        return lista.isEmpty();
    }
    
    /* Métodos específicos */
    
    /*
    Métodos específicos sobre la lista de usuarios (sugerencias):
    - Devolver id de un usuario según su posición.
    - Devolver boolean si existe un usuario en la lista con un id proporcionado
    - Devolver un Usuario de la lista según su id.
    - Otras
    */
    

    @Override
    public String toString() {
        return lista.toString();
    }
}
