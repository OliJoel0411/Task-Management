package task.management;

import java.io.Serializable;

public class ListaActividades implements Serializable {

    private String nombre;
    private int id;

    public ListaActividades(String nombre, int id) {
        this.id = id;
        this.nombre = nombre;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String mostrarDatos(){
        return "--> " + " Nombre de Tarea: " + "-- "+this.nombre + " --";
    }
}
