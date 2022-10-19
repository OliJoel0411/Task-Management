
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
public class TaskManagement { //task

    public static void main(String[] args) {
      Scanner tc = new Scanner(System.in);
      // Objeto donde iran alojados los tablero  
      
      // Objetos tableros
      Tablero tab;
      // Clase file para escribir Tableros
      File archivo = new File("C:\\Users\\Oliver\\OneDrive\\Escritorio\\Piwi\\Tableros\\tab.txt");
              
      // Variables globales
      int opc1 = 0, id = 1;
      String nameTab = ""; // variables para opciones 
      
      // coleccion de tableros 
      Vector tableros = new Vector();
      
        do{
      // Menu
        System.out.println("   -- Bienvenido a Piwi --");
        System.out.println(" --------------------------------");
        System.out.println("| <- Tu Oganizador de tareas ->  |");
        System.out.println(" --------------------------------");
        
        System.out.println("\nOpciones Disponibles");
        System.out.println("1. Crear Tablero de Tareas ");
        System.out.println("2. Tableros Disponibles");
        System.out.println("3. Salir");
        opc1 = tc.nextInt();
        
        switch(opc1){ // swtich
            case 1:
                System.out.println("Creemos tu tablero...");
                System.out.println("Ingrese el nombre para su Tablero");
                // Variable para almacenar el nombre del tablero. 
                nameTab = tc.next();
                
                        try{
                        // Objeto tablero que sera el molde para almacer los "Tableros"    
                        tab = new Tablero(nameTab, id);
                        id++;
                        // Agrega a nuestro vector el objeto de tipo Tablero para luego ser leído
                        tableros.add(tab);
                        // Directorio donde se guardarán lo archivos. 
                       
                        FileOutputStream flujo = new FileOutputStream(archivo);

                        ObjectOutputStream write = new ObjectOutputStream(flujo);
                        
                        write.writeObject(tableros);

                }catch(FileNotFoundException e){
                    e.printStackTrace();
                }catch(IOException e){
                    e.printStackTrace();
                }

               
                
                break;
            case 2:
                     try{
                            // El archivo2 es quien contiene los objetos dentro del archivo de texto
                            FileInputStream fis = new FileInputStream(archivo);
                            ObjectInputStream ois = new ObjectInputStream(fis);
                            tableros=(Vector)ois.readObject();
                          //  System.out.println(tableros=(Vector)ois.readObject());
                            }catch (FileNotFoundException e) {
                                  e.printStackTrace();
                            } catch (IOException e) {
                                  e.printStackTrace();
                            } catch (ClassNotFoundException e) {
                                  e.printStackTrace();
                            }

                    
                    Iterator iterator = tableros.iterator();
                    while(iterator.hasNext()){
                    tab=(Tablero)iterator.next();
                    System.out.println(tab.toString());
                    }
                
                break;
            case 3: 
                opc1 = 3;
                System.exit(0);
                break;
            default:
                System.out.println("Error, ingrese una opcion correcta. ");
        }//switch
        }while(opc1!= 3);
    }//main
    
} //task


