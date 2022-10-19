
package task.management;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Vector;


/**
 * @author Oliver
 */
public class TaskManagement {

    public static void main(String[] args) {
        // Variables globales
        int opc1 = 0, i = 1;
        String error = "Error, ingrese una opcion valida";
        String nombre = "";
        // Entrada por teclado 
        Scanner tc = new Scanner(System.in);
        
        // Crear archivo
        File archivo = new File("C:\\Users\\Oliver\\OneDrive\\Escritorio\\Piwi\\Tableros\\Tablero.txt");
        
        // Crear la referencia del objeto de tipo tablero 
        
        Tablero tab;
        
        // Lugar donde almacenaremos las instancias de tipo tablero
        
        Vector tableros = new Vector();
        
        do{
            System.out.println("1. Crear Tablero");
            System.out.println("2. Ver lista de Tableros");
            System.out.println("3. Salir");
            opc1 = tc.nextInt();
            
            switch(opc1){ // switch1
                case 1:
                    System.out.println("\n \n Ingrese el nombre de su nuevo tablero");
                    nombre = tc.next();
                    
                    try{
                        // Crear la instancia de nuestro objeto Tablero
                        tab = new Tablero(nombre, i);
                        i++;
                        // Cada vez que cree una instancia la añada al vector
                        tableros.add(tab);
                        // Escribir en nuestro archivo de tableros
                        FileOutputStream flujo = new FileOutputStream(archivo);
                        
                        ObjectOutputStream write = new ObjectOutputStream(flujo);
                        
                        // Escribimos nuestro vector en nuestro archivo.txt
                        write.writeObject(tableros);
                        
                    }catch(FileNotFoundException e){
                        e.printStackTrace();
                    }catch(IOException e){
                        e.printStackTrace();
                    }
                    
                    System.out.println("Tablero creado exitosamente!\n ");
                    break;
                case 2:
                    
                    try{
                        
                        FileInputStream flujo2 = new FileInputStream(archivo);
                        
                        ObjectInputStream read = new ObjectInputStream(flujo2);
                        
                        tableros=(Vector)read.readObject();
                        
                        
                    }catch(FileNotFoundException e){
                        e.printStackTrace();
                    }catch(IOException e){
                        e.printStackTrace();
                    }catch(ClassNotFoundException e){
                        e.printStackTrace();
                    }
                    
                    Iterator it = tableros.iterator();
                    while(it.hasNext()){
                        tab=(Tablero)it.next();
                        System.out.println(tab.toString());
                    }
                    
                    
                    break;
                case 3:
                    System.out.println("Bye   :)");
                    opc1 = 2;
                    System.exit(0);
                    break;
                default:
                    System.out.println(error);
            } // switch1
            
        }while(opc1 != 3);
        
    }   
    
}
