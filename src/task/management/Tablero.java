package task.management;

/**
 *
 * @author Oliver
 */
public class Tablero { 
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
} // clase tablero  
