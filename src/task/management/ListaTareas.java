package task.management;

import java.io.Serializable;

public class ListaTareas implements Serializable {
    //Atributos
    private String nombreLista;
    private int idList;
    // Constructor
    public ListaTareas( String nombreLista, int idList) {
        this.idList = idList;
        this.nombreLista = nombreLista;
    }

    public String getNombreLista() {
        return nombreLista;
    }

    public void setNombreLista(String nombreLista) {
        this.nombreLista = nombreLista;
    }

    public int getIdList() {
        return idList;
    }

    public void setIdList(int idList) {
        this.idList = idList;
    }

    public String mostrarListas(){
        return "-> " +this.idList + ")" + " Nombre de Lista: " + "-- "+this.nombreLista + " --";
    }
}
