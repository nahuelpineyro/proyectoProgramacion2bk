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
     for (int i = 0; i< lista.size(); i++){
        if(lista.get(i).getId().equals(u)){
        return i;
              }
        }
        return -1;
    }
    
    
    public boolean sinRegistros() {
        return lista.isEmpty();
    }

    @Override
    public String toString() {
        return lista.toString();
    }
}
