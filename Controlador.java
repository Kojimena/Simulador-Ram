/**
* @author: Karen Jimena Hernández Ortega
* @version: 17-sep-21
* Esta clase es el controlador principal del programa.
**/
import java.io.IOException;
//import java.lang.reflect.Array;
//import java.util.ArrayList;
import java.util.ArrayList;

public class Controlador {
/**
* Main del programa.
**/
private static Vista vista = new Vista();
    
public static void main(String[] args) throws IOException{
 
Ram ram = new Ram();
Programas program = new Programas();
//ArrayList<Programas> programas = new ArrayList<Programas>();


 int opcion;

 vista.mensaje("--------------Simulador de memoria RAM--------------");
 vista.mensaje("¿Qué desea hacer?");
 opcion = vista.menu();

    /**
	* Ciclo mientras la opcion no sea 8 que es salir, sigue corriendo.
	**/
	while(opcion != 8){
	    switch(opcion)
	    {
            case 1:
            //Elegir tipo
             if (vista.getTipo().equals("SDR")){
                 int tamGB = vista.getTamGB();
                 ram = new Ram(tamGB);
                 vista.mensaje("Ram creada con exito \n");
             }else{
                ram = new Ram();
                vista.mensaje("Ram creada con exito \n");
            }
            break;
        

            case 2:
            //Ingresar programas
            boolean terminar = false;
            while (terminar != true){

                String nombre = vista.getNombre();
                int tiempoejec = vista.getTiempo();
                int espaciopro = vista.getEspacio();
                program = new Programas(nombre, tiempoejec,espaciopro);
                ram.añadirPro(program);
            
            if (vista.getAnswer() == 1){
                terminar = false;
            }
            else {
                terminar = true;
                break;
            }
            }break;

            case 3:
            //Ram total, ram disponible, ram en uso
            ArrayList<String> datosRam = ram.getDatos();
            for(int i=0; i<datosRam.size(); i++){
                vista.mensaje(datosRam.get(i));
            }

            break;
            
            case 4:
            //programas en cola y en ejecución
            ArrayList<String> cBloques = ram.getColapro();
            for (int i=0; i<cBloques.size(); i++){
                vista.mensaje("Cola de programas...");
                vista.mensaje(cBloques.get(i));
            }
            break;

            case 5:
            //conocer espacios
            break;

            case 6:
            //estado memoria Ram
            break;

            case 7:
            //nuevo ciclo de reloj
            break;

            case 8:
            vista.mensaje("saliendo...");
                        System.exit(0);
            break; 

        default: vista.mensaje("-Opcion invalida, porfavor ingrese una opción valida-");   break;
        }
        opcion = vista.menu();
    }


}
    
}
