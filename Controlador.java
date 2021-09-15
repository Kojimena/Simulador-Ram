/**
* @author: Karen Jimena Hernández Ortega
* @version: 17-sep-21
* Esta clase es el controlador principal del programa.
**/
import java.io.IOException;

public class Controlador {
/**
* Main del programa.
**/

public static void main(String[] args) throws IOException{
 Vista vista = new Vista();

 int opcion;

 System.out.println("Simulador de memoria RAM");
 System.out.println("¿Qué desea hacer?");
 opcion = vista.menu();

    /**
	  * Ciclo mientras la opcion no sea 0 que es salir, sigue corriendo.
	  **/
	  while(opcion != 7){
	    switch(opcion)
	    {
            case 1: 
            break;
            case 2:
            break;
        }
    }

}
    
}
