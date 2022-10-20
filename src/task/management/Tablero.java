package task.management;

import java.io.Serializable;

/**
 *
 * @author Oliver
 */
public class Tablero implements Serializable{ 
    // Atributos de cada tablero
    private String nombre;
    private int id;
    
    // Constructo
    public Tablero(String nombre, int id) {
        this.nombre = nombre;
        this.id = id;
    }
    
    // Método consultor
    public String getNombre() {
        return nombre;
    }
    //Método modificador
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    // Método consultor
    public int getId() {
        return id;
    }
    // Método modificador
    public void setId(int id) {
        this.id = id;
    } 
    
    @Override
     public String toString(){

        return "-> " +this.id + ")" + " Nombre de Tablero: " + "-- "+this.nombre + " --";
    }
} // clase tablero  
