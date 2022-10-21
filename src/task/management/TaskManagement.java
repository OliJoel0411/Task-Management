
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
      // Objetos Lista Tareas
      ListaTareas listTarea;


      // Clase file para escribir Tableros
      File archivo = new File("C:\\Users\\Oliver\\OneDrive\\Escritorio\\Piwi\\Tableros\\Tableros.txt");
      // Clase file para escribir Lista Tareas
      File archivo2 = new File("C:\\Users\\Oliver\\OneDrive\\Escritorio\\Piwi\\ListTareas\\ListaTareas.txt");
              
      // Variables globales
      int pivote = 0,opc1 = 0, id = 1, opc3 = 0, opc4 = 0, rm = 0, id2 = 1;
      String nameTab = "", nombreListTareas = null, nuevoNombre = null; // variables para opciones
      boolean creat = false;


      // coleccion de tableros 
      Vector tableros = new Vector();
      Vector listaTareas = new Vector();
      
        do{
      // Menu
       int contador=1;
        System.out.println("   -- Bienvenido a Piwi --");
        System.out.println(" --------------------------------");
        System.out.println("| <- Tu Oganizador de tareas ->  |");
        System.out.println(" --------------------------------");
        
        System.out.println("\nOpciones Disponibles");
        System.out.println("1. Tableros Disponibles ");
        System.out.println("2. Crear Tablero de Tareas");
        System.out.println("3. Salir");
        opc1 = tc.nextInt();
        
        switch(opc1){ // swtich
            case 1:
                if(!archivo.isFile()){
                    System.out.println("\nNo hay tableros disponibles, cree un tablero\nCree un Tablero...\n\n");

                }else {
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

                    //Mostrando en pantalla el listado de tableros
                 /*   Iterator iterator = tableros.iterator();
                    while(iterator.hasNext()){
                        tab=(Tablero)iterator.next();
                        System.out.println(tab.toString());
                    }*/
                    for (int i = 0; i < tableros.size(); i++) {
                    tab=(Tablero)tableros.elementAt(i);
                    System.out.println( contador +" )"+tab.toString());
                    contador++;
                    }
                    contador = 1;
                    // Modificando Tableros

                    System.out.println("Desea visualizar algún tablero? \nS/n");
                    String opc = tc.next();
                    if(opc.equals("S")){

                        System.out.println("Ingrese el Id del tablero que desea visualizar");
                        opc3 = tc.nextInt();
                        if(opc3<= tableros.size()){
                            pivote = opc3 - 1;
                            do{
                                System.out.println("Ha ingresado al tablero No. " + opc3);
                                System.out.println("Opciones disponibles");
                                System.out.println("1. Agregar lista de Tareas");
                                System.out.println("2. Cambiar nombre de Tablero");
                                System.out.println("3. Borrar Tablero");
                                System.out.println("4. Regresar al menu principal");
                                opc4 = tc.nextInt();

                                switch(opc4){ // switch

                                    case 1:
                                        System.out.println("Creemos tu lista de tareas");
                                        System.out.println("Ingrese el nombre de su lista de tareas");
                                        nombreListTareas = tc.next();

                                        try{
                                            // Objeto tablero que sera el molde para almacer los "Tableros"
                                            if(id != listaTareas.size()){ // vector para lista de tareas
                                                id = listaTareas.size() + 1;
                                            }
                                            listTarea = new ListaTareas(nombreListTareas, id2);
                                            id2++;

                                            // Agrega a nuestro vector el objeto de tipo Tablero para luego ser leído
                                            listaTareas.add(listTarea);
                                            // Directorio donde se guardarán lo archivos.

                                            FileOutputStream flujo = new FileOutputStream(archivo2);

                                            ObjectOutputStream write = new ObjectOutputStream(flujo);

                                            write.writeObject(listaTareas);


                                        }catch(FileNotFoundException e){
                                            e.printStackTrace();
                                        }catch(IOException e){
                                            e.printStackTrace();
                                        }
                                        System.out.println("\n LISTA DE TAREAS CREADA EXITOSAMENTE! \n");

                                        break;
                                    case 2:
                                        System.out.println("El tablero especificado es: " + tableros.get(pivote));

                                        System.out.println("Ingrese el nuevo nombre");//*****************************************************************************************
                                        nuevoNombre = tc.next();

                                        break;
                                    case 3:
                                        System.out.println("Estas seguro de que deseas eliminar el tablero?");
                                        System.out.println("S/n");
                                        String seguro = tc.next();
                                        if(seguro.equals("S")){
                                            System.out.println("Borrando el Tablero...");
                                            rm = opc3;
                                            rm = rm - 1;
                                            tableros.remove(rm);

                                           //****
                                                System.out.println("Lista de Tableros actualizado");
                                               /* for (int i = 0; i < tableros.size(); i++) {
                                                    tab=(Tablero)tableros.elementAt(i);
                                                    System.out.println(tab.toString());
                                                }*/
                                         /*   for (int i = 0; i < tableros.size(); i++) {
                                                tab=(Tablero)tableros.elementAt(i);
                                                System.out.println( contador +" )"+tab.toString());
                                                contador++;
                                            }*/


                                                try{

                                                    // Agrega a nuestro vector el objeto de tipo Tablero para luego ser leído

                                                    // Directorio donde se guardarán lo archivos.

                                                    FileOutputStream flujo = new FileOutputStream(archivo);

                                                    ObjectOutputStream write = new ObjectOutputStream(flujo);

                                                    write.writeObject(tableros);

                                                }catch(FileNotFoundException e){
                                                    e.printStackTrace();
                                                }catch(IOException e){
                                                    e.printStackTrace();
                                                } // prueba
                                                /*tableros.iterator();
                                                while(iterator.hasNext()){
                                                    tab=(Tablero)iterator.next();
                                                    System.out.println(tab.toString());
                                                }*/
                                            for (int i = 0; i < tableros.size(); i++) {
                                                tab=(Tablero)tableros.elementAt(i);
                                                System.out.println( contador +" )"+tab.toString());
                                                contador++;
                                            }

                                                opc4 = 4;


                                        }else {
                                            System.out.println("Regresando al menú principal ");
                                            opc4 = 4;
                                        }
                                        break;
                                    case 4:
                                        opc4 = 4;
                                        break;
                                    default:
                                        System.out.println("Error ingrese una opcion correcta");


                                }// switch opc4
                            }while(opc4 != 4);
                        }else {
                            System.out.println("Id incorrecto");
                            System.out.println(":(");
                        }

                    }else{
                        System.out.println("Regresando al menu principal. . .\n");
                    }
                }
                break;
            case 2:
                System.out.println("Creemos tu tablero...");
                System.out.println("Ingrese el nombre para su Tablero");
                // Variable para almacenar el nombre del tablero.
                nameTab = tc.next();

                try{
                    // Objeto tablero que sera el molde para almacer los "Tableros"
                    if(id != tableros.size()){
                        id = tableros.size() + 1;
                    }
                    tab = new Tablero(nameTab, id);
                    id++;

                    // Agrega a nuestro vector el objeto de tipo Tablero para luego ser leído
                    tableros.add(tab);
                    // Directorio donde se guardarán lo archivos.

                    FileOutputStream flujo = new FileOutputStream(archivo);

                    ObjectOutputStream write = new ObjectOutputStream(flujo);

                    write.writeObject(tableros);
                    creat = true;

                }catch(FileNotFoundException e){
                    e.printStackTrace();
                }catch(IOException e){
                    e.printStackTrace();
                }
                System.out.println("\n TABLERO CREADO EXITOSAMENTE! \n");
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


