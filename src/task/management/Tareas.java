package task.management;

import java.io.Serializable;

public class Tareas implements Serializable {
    // Atributos
    private String nombre;
    private int idTarea;

    public Tareas(String nombre, int idTarea) {
        this.nombre = nombre;
        this.idTarea = idTarea;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdTarea() {
        return idTarea;
    }

    public void setIdTarea(int idTarea) {
        this.idTarea = idTarea;
    }

    public String mostrarDatos(){
        return "--> " + " Nombre de Tarea: " + "-- "+this.nombre + " --";
    }
}
