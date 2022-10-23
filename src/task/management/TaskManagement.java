
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
 * @author Oliver_Intecap/Edutek
 */
public class TaskManagement { //task

    public static void main(String[] args) {
      Scanner tc = new Scanner(System.in);
      // Objeto donde iran alojados los tablero  
      
      // Objetos tableros
      Tablero tab;
      // Objetos Lista Tareas
      ListaTareas listTareass;
      // Objetos de Tare
      Tareas tarea;
      // Objeto de Lista de actividades
      ListaActividades listAct;



      // Clase file para escribir Tableros
      File archivo = new File("C:\\Users\\Oliver\\OneDrive\\Escritorio\\Piwi\\Tableros\\Tablero.txt");
      // Clase file para escribir Lista Tareas
      File archivo2 = new File("C:\\Users\\Oliver\\OneDrive\\Escritorio\\Piwi\\ListTareas\\ListaTareas.txt");
      // Clase file para escribir las Tareas
      File archivo3 = new File("C:\\Users\\Oliver\\OneDrive\\Escritorio\\Piwi\\ListTareas\\Tareas\\Tareas.txt");
      // Clase file para escribir lista de actividades
      File archivo4 = new File("C:\\Users\\Oliver\\OneDrive\\Escritorio\\Piwi\\ListTareas\\Tareas\\ListaActividades\\ListaActividades.txt");


      // desktop C:\Users\Oliver\OneDrive\Escritorio\Piwi\ListTareas
      // Variables globales
      int pivote = 0,opc1 = 0, id = 1, opc3 = 0, opc4 = 0, rm = 0, id2 = 1, opc6 = 0, pivote2 = 0, opc7 = 0, id3 = 0, opc10= 0, id4 = 0;
      String nameTab = "", nombreListTareas = null, nuevoNombre = null, opc5 = null, nombreTarea = null , nuevoNombreTarea = null, opc8 = null, nombreTareasOn3 = null, nuevoNombreListaAtc = null; // variables para opciones
      boolean creat = false;


      // colecciones
      Vector tableros = new Vector();
      Vector listaTareasV = new Vector();
      Vector tareasV = new Vector();
      Vector ListaActividadesV = new Vector();
      
        do{
      // Menu
       int contador=1;
       int contador2=1;
       int contador3=1;
       int contador4=1;
        System.out.println("   -- Bienvenido a Piwi --");
        System.out.println(" --------------------------------");
        System.out.println("| <- Tu Oganizador de tareas ->  |");
        System.out.println(" --------------------------------");
        
        System.out.println("\nOpciones Disponibles");
        System.out.println("1. Tableros Disponibles ");
        System.out.println("2. Crear Tablero de Tareas");
        System.out.println("3. Salir\n");
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

                    System.out.println("\nDesea visualizar algún tablero? \nS/n");
                    String opc = tc.next();
                    if(opc.equals("S")){

                        System.out.println("\nIngrese el Id del tablero que desea visualizar\n");
                        opc3 = tc.nextInt();
                        if(opc3<= tableros.size()){
                            pivote = opc3 - 1;
                            do{
                                System.out.println("\nHa ingresado al tablero No. " + opc3);
                                System.out.println("Opciones disponibles");
                                System.out.println("1. ver listas de Tareas");
                                System.out.println("2. Agregar lista de Tareas");
                                System.out.println("3. Cambiar nombre de Tablero");
                                System.out.println("4. Borrar Tablero");
                                System.out.println("5. Regresar al menu principal");
                                opc4 = tc.nextInt();

                                switch(opc4){ // switch

                                    case 1:
                                        System.out.println("\nLas listas de Tareas disponibles son:\n");
                                        if(!archivo2.isFile()){
                                            System.out.println("\nNo hay Listas de tareas\nCree una Lista de Tareas...\n\n");

                                        }else{
                                            try{

                                                // El archivo2 es quien contiene los objetos dentro del archivo de texto
                                                FileInputStream fis2 = new FileInputStream(archivo2);
                                                ObjectInputStream ois2 = new ObjectInputStream(fis2);
                                                listaTareasV=(Vector)ois2.readObject();
                                                //  System.out.println(listaTareas=(Vector)ois2.readObject());
                                            }catch (FileNotFoundException e) {
                                                e.printStackTrace();
                                            } catch (IOException e) {
                                                e.printStackTrace();
                                            } catch (ClassNotFoundException e) {
                                                e.printStackTrace();
                                            }
                                            for (int j = 0; j < listaTareasV.size(); j++) {
                                                listTareass=(ListaTareas)listaTareasV.elementAt(j);
                                                System.out.println( contador2 +" )"+listTareass.mostrarListas());
                                                contador2++;
                                            }
                                            contador2 = 1;

                                            System.out.println("Desea visualizar alguna Lista de Tareas? \nS/n");
                                            opc5 = tc.next();
                                            if(opc5.equals("S")){
                                                System.out.println("Ingrese el Id del la lista que desea visualizar");
                                                opc6 = tc.nextInt();
                                                pivote2 = opc6 - 1;
                                                    do {
                                                        System.out.println("\nHa ingresado al Lista de Tareas No. " + opc6);
                                                        System.out.println("Opciones disponibles");
                                                        System.out.println("1. ver  Tareas");
                                                        System.out.println("2. Agregar  Tareas");
                                                        System.out.println("3. Cambiar nombre Tareas");
                                                        System.out.println("4. Borrar  Tareas");
                                                        System.out.println("5. Regresar al menu principal");
                                                        opc7 = tc.nextInt();
                                                        switch(opc7){
                                                            case 1:
                                                                System.out.println("\nLas de Tareas disponibles son:");
                                                                if(!archivo3.isFile()){
                                                                    System.out.println("\nNo hay tareas\nCree una Tareas...\n\n");

                                                                }else{
                                                                    try{

                                                                        // El archivo3 es quien contiene los objetos dentro del archivo de texto
                                                                        FileInputStream fis3 = new FileInputStream(archivo3);
                                                                        ObjectInputStream ois3 = new ObjectInputStream(fis3);
                                                                        tareasV=(Vector)ois3.readObject();

                                                                    }catch (FileNotFoundException e) {
                                                                        e.printStackTrace();
                                                                    } catch (IOException e) {
                                                                        e.printStackTrace();
                                                                    } catch (ClassNotFoundException e) {
                                                                        e.printStackTrace();
                                                                    }
                                                                    for (int y = 0; y < tareasV.size(); y++) {
                                                                        tarea=(Tareas)tareasV.elementAt(y);
                                                                        System.out.println( contador3 +" )"+tarea.mostrarDatos());
                                                                        contador3++;
                                                                    }
                                                                    contador3 = 1;
                                                                }
                                                                System.out.println("Desea visualizar alguna Tareas? \nS/n");
                                                                opc8 = tc.next();
                                                                if(opc8.equals("S")){
                                                                    System.out.println("Ingrese el Id de la Tarea que desea visualizar");
                                                                    int opc9 = tc.nextInt();
                                                                    pivote2 = opc9 - 1;
                                                                    do {
                                                                        System.out.println("\nHa ingresado al la Tareas");
                                                                        System.out.println("Opciones disponibles");
                                                                        System.out.println("1. ver  lista de activiades");
                                                                        System.out.println("2. Agregar  lista de actividades");
                                                                        System.out.println("3. Cambiar nombre lista de actividades");
                                                                        System.out.println("4. Borrar  lista de actividades ");
                                                                        System.out.println("5. Regresar al menu principal");
                                                                        opc10 = tc.nextInt();
                                                                        switch (opc10){
                                                                            case 1:
                                                                                System.out.println("\nLas listas de Tareas disponibles son:\n");
                                                                                if(!archivo3.isFile()){
                                                                                    System.out.println("\nNo hay Listas de actividades \n Cree una Lista de actividades...\n\n");

                                                                                }else {
                                                                                    try {
                                                                                        FileInputStream fis3 = new FileInputStream(archivo3);
                                                                                        ObjectInputStream ois3 = new ObjectInputStream(fis3);
                                                                                        ListaActividadesV = (Vector) ois3.readObject();

                                                                                    } catch (FileNotFoundException e) {
                                                                                        e.printStackTrace();
                                                                                    } catch (IOException e) {
                                                                                        e.printStackTrace();
                                                                                    } catch (ClassNotFoundException e) {
                                                                                        e.printStackTrace();
                                                                                    }
                                                                                    for (int j = 0; j < listaTareasV.size(); j++) {
                                                                                        listAct = (ListaActividades) ListaActividadesV.elementAt(j);
                                                                                        System.out.println(contador2 + " )" + listAct.mostrarDatos());
                                                                                        contador4++;
                                                                                    }
                                                                                }
                                                                                break;

                                                                            case 2:
                                                                                System.out.println("Creemos tu tareas");
                                                                                System.out.println("Ingrese el nombre de su tareas");
                                                                                nombreTareasOn3 = tc.next();
                                                                                try{
                                                                                if(id != ListaActividadesV.size()){
                                                                                    id = ListaActividadesV.size() + 1;
                                                                                }
                                                                                listAct = new ListaActividades(nombreTareasOn3, id4);
                                                                                id3++;


                                                                                ListaActividadesV.add(listAct);


                                                                                FileOutputStream flujo3 = new FileOutputStream(archivo4);

                                                                                ObjectOutputStream write3 = new ObjectOutputStream(flujo3);

                                                                                write3.writeObject(ListaActividadesV);


                                                                        }catch(FileNotFoundException e){
                                                                            e.printStackTrace();
                                                                        }catch(IOException e){
                                                                            e.printStackTrace();
                                                                        }
                                                                        System.out.println("\n LISTA DE ACTIVIDADES CREADA EXITOSAMENTE! \n");
                                                                                break;
                                                                            case 3:
                                                                                System.out.println("\nLa Lista de actividades especificado es: " + ListaActividadesV.get(pivote2));

                                                                                System.out.println("Ingrese el nuevo nombre");
                                                                                nuevoNombreListaAtc = tc.next();


                                                                                tareasV.remove(pivote2);

                                                                                listAct = new ListaActividades(nuevoNombreListaAtc, pivote2);
                                                                                try{

                                                                                    FileOutputStream fos3 = new FileOutputStream(archivo4);

                                                                                    ObjectOutputStream oos3 = new ObjectOutputStream(fos3);


                                                                                    ListaActividadesV.add(pivote2, listAct);
                                                                                    oos3.writeObject(tareasV);

                                                                                }catch (FileNotFoundException e) {
                                                                                    e.printStackTrace();
                                                                                } catch (IOException e) {
                                                                                    e.printStackTrace();
                                                                                }
                                                                                System.out.println("\n NOMBRE CAMBIADO EXITOSAMENTE!! \n\n");
                                                                                break;
                                                                            case 4:
                                                                                //-----------------------------------
                                                                                System.out.println("\nEstas seguro de que deseas eliminarlo?");
                                                                                System.out.println("S/n");
                                                                                String seguro3 = tc.next();
                                                                                if(seguro3.equals("S")) {
                                                                                    System.out.println("Borrando ...");
                                                                                    rm = opc10;
                                                                                    rm = rm - 1;
                                                                                    ListaActividadesV.remove(rm);


                                                                                    try {


                                                                                        FileOutputStream flujo3 = new FileOutputStream(archivo4);

                                                                                        ObjectOutputStream write3 = new ObjectOutputStream(flujo3);

                                                                                        write3.writeObject(ListaActividadesV);

                                                                                    } catch (FileNotFoundException e) {
                                                                                        e.printStackTrace();
                                                                                    } catch (IOException e) {
                                                                                        e.printStackTrace();
                                                                                    }

                                                                                    for (int i = 0; i < ListaActividadesV.size(); i++) {
                                                                                        listAct = (ListaActividades) ListaActividadesV.elementAt(i);
                                                                                        System.out.println(contador3 + " )" + listAct.mostrarDatos());
                                                                                        contador3++;
                                                                                    }
                                                                                }else {
                                                                                    System.out.println("\n Regresando al menu principal...\n");
                                                                                }
                                                                                //-----------------------------------
                                                                                break;
                                                                            case 5:
                                                                                break;
                                                                            default:
                                                                                System.out.println("ingrese una opcion correcta");
                                                                                break;
                                                                        }
                                                                    }while (opc10 != 5);

                                                                }else {

                                                                }
                                                                break;
                                                            case 2:

                                                                System.out.println("Creemos tu tareas");
                                                                System.out.println("Ingrese el nombre de su tareas");
                                                                nombreTarea = tc.next();
                                                                String nombreTareasOn = nombreTarea + "  -- ("+"    de ->tablero No " + opc3 + " )--  " + "de -> Lista de Tareas No. " + opc6;


                                                                try{

                                                                    if(id != tareasV.size()){
                                                                        id = tareasV.size() + 1;
                                                                    }
                                                                    tarea = new Tareas(nombreTareasOn, id3);
                                                                    id3++;


                                                                    tareasV.add(tarea);


                                                                    FileOutputStream flujo3 = new FileOutputStream(archivo3);

                                                                    ObjectOutputStream write3 = new ObjectOutputStream(flujo3);

                                                                    write3.writeObject(tareasV);


                                                                }catch(FileNotFoundException e){
                                                                    e.printStackTrace();
                                                                }catch(IOException e){
                                                                    e.printStackTrace();
                                                                }
                                                                System.out.println("\n TAREAS CREADA EXITOSAMENTE! \n");

                                                                break;
                                                            case 3:

                                                                System.out.println("\nLa tareas especificado es: " + tareasV.get(pivote2));

                                                                System.out.println("Ingrese el nuevo nombre");
                                                                nuevoNombreTarea = tc.next();
                                                                String nombreTareasOn2 = nuevoNombreTarea + "  -- ("+"    de ->tablero No " + opc3 + " )--  " + "de -> Lista de Tareas No. " + opc6;

                                                                tareasV.remove(pivote2);

                                                                tarea = new Tareas(nombreTareasOn2, pivote2);
                                                                try{

                                                                    FileOutputStream fos3 = new FileOutputStream(archivo3);

                                                                    ObjectOutputStream oos3 = new ObjectOutputStream(fos3);


                                                                    tareasV.add(pivote2, tarea);
                                                                    oos3.writeObject(tareasV);

                                                                }catch (FileNotFoundException e) {
                                                                    e.printStackTrace();
                                                                } catch (IOException e) {
                                                                    e.printStackTrace();
                                                                }
                                                                System.out.println("\n NOMBRE CAMBIADO EXITOSAMENTE!! \n\n");

                                                                break;
                                                            case 4:

                                                                System.out.println("\nEstas seguro de que deseas eliminar el tablero?");
                                                                System.out.println("S/n");
                                                                String seguro2 = tc.next();
                                                                if(seguro2.equals("S")) {
                                                                    System.out.println("Borrando Tarea...");
                                                                    rm = opc6;
                                                                    rm = rm - 1;
                                                                    tareasV.remove(rm);


                                                                    try {


                                                                        FileOutputStream flujo3 = new FileOutputStream(archivo3);

                                                                        ObjectOutputStream write3 = new ObjectOutputStream(flujo3);

                                                                        write3.writeObject(tareasV);

                                                                    } catch (FileNotFoundException e) {
                                                                        e.printStackTrace();
                                                                    } catch (IOException e) {
                                                                        e.printStackTrace();
                                                                    } // prueba

                                                                    for (int i = 0; i < tareasV.size(); i++) {
                                                                        tarea = (Tareas) tareasV.elementAt(i);
                                                                        System.out.println(contador3 + " )" + tarea.mostrarDatos());
                                                                        contador3++;
                                                                    }
                                                                }else {
                                                                    System.out.println("\n Regresando al menu principal...\n");
                                                                }

                                                                break;
                                                            case 5:
                                                                opc6 = 5;
                                                                break;
                                                        }
                                                    }while (opc6 != 5);
                                            }else {
                                                System.out.println("Regresando . . . ");
                                            }
                                        }

                                        break;
                                    case 2:
                                        System.out.println("\nCreemos tu lista de tareas");
                                        System.out.println("Ingrese el nombre de su lista de tareas");
                                        nombreListTareas = tc.next();
                                        String nombreListTareasOn = nombreListTareas + "  ---> ("+"    de ->tablero No " + opc3 + " ) <---";

                                        // List1 ( tablero No 4 )
                                        try{
                                            // Objeto tablero que sera el molde para almacer los "Tableros"
                                            if(id != listaTareasV.size()){ // vector para lista de tareas
                                                id = listaTareasV.size() + 1;
                                            }
                                            listTareass = new ListaTareas(nombreListTareasOn, id2);
                                            id2++;

                                            // Agrega a nuestro vector el objeto de tipo Tablero para luego ser leído
                                            listaTareasV.add(listTareass);
                                            // Directorio donde se guardarán lo archivos.

                                            FileOutputStream flujo = new FileOutputStream(archivo2);

                                            ObjectOutputStream write = new ObjectOutputStream(flujo);

                                            write.writeObject(listaTareasV);


                                        }catch(FileNotFoundException e){
                                            e.printStackTrace();
                                        }catch(IOException e){
                                            e.printStackTrace();
                                        }
                                        System.out.println("\n LISTA DE TAREAS CREADA EXITOSAMENTE! \n");


                                        break;
                                    case 3:

                                        System.out.println("El tablero especificado es: " + tableros.get(pivote));

                                        System.out.println("Ingrese el nuevo nombre");
                                        nuevoNombre = tc.next();

                                        // Remueve el tablero para crear uno nuevo con el nombre siguiente
                                        tableros.remove(pivote);
                                        // creamos un nuevo tablero
                                        tab = new Tablero(nuevoNombre, pivote);
                                        try{

                                            FileOutputStream fos = new FileOutputStream(archivo);
                                            // escribe tipos de datos primitivos y gráficos de objetos Java en un OutputStream
                                            ObjectOutputStream oos = new ObjectOutputStream(fos);
                                            // Creamos la instancia de nuestro objeto Persona

                                            //Escribimos en el archivo
                                            oos.writeObject(tableros);

                                            // El archivo2 es quien contiene los objetos dentro del archivo de texto
                                            FileOutputStream flujo = new FileOutputStream(archivo);

                                            ObjectOutputStream write = new ObjectOutputStream(flujo);
                                            tableros.add(pivote, tab);
                                            write.writeObject(tableros);

                                        }catch (FileNotFoundException e) {
                                            e.printStackTrace();
                                        } catch (IOException e) {
                                            e.printStackTrace();
                                        }

                                        break;
                                    case 4:
                                        System.out.println("\nEstas seguro de que deseas eliminar el tablero?");
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
                                    case 5:
                                        opc4 = 5;
                                        break;
                                    default:
                                        System.out.println("Error ingrese una opcion correcta");


                                }// switch opc4
                            }while(opc4 != 5);
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
                System.out.println("\nCreemos tu tablero...");
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


