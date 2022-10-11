
package task.management;

import java.util.Scanner;

/**
 * @author Oliver
 */
public class TaskManagement {

    public static void main(String[] args) {
      // Variables globales
      String opc = " ",nombre = " ";
      int id = 0;
      Scanner tc = new Scanner(System.in);
      // Creando un objeto de tipo Tablero
      Tablero tab1 = new Tablero(nombre, id);
            
      
      
        System.out.println("Desea crear un Tablero");
        System.out.println("s/n: ");
        opc = tc.next();
        
        if(opc.equals("s")){
            System.out.print("Escibar el nombre del Tablero: ");
            nombre = tc.next();
            tab1.setNombre(nombre);
            
            id = 1;   
            tab1.setId(id);
        }
        
        System.out.println("Identificacin del tablero creado");
        System.out.println("Nombre: " + tab1.getNombre());
        System.out.println("Id: " + tab1.getId());
        
      
      
    }
    
}
