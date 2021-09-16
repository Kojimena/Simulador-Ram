/**
* @author: Karen Jimena Hernández Ortega
* @version: 17-sep-21
* Esta clase es el controlador principal del programa.
**/
import java.io.IOException;
//import java.util.ArrayList;

public class Controlador {
/**
* Main del programa.
**/
private static Vista vista = new Vista();
    
public static void main(String[] args) throws IOException{
 
Ram ram = new Ram();
Programas program = new Programas();
//ArrayList<Programas> programas = new ArrayList<Programas>();
boolean terminar = false;

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
             if (vista.getTipo().equals("SDR")){
                 int tamGB = vista.getTamGB();
                 ram = new Ram(tamGB);
             }else{
                ram = new Ram();
            }
            break;
        

            case 2:
            while (terminar != true){

                String nombre = vista.getNombre();
                int tiempoejec = vista.getTiempo();
                int espaciopro = vista.getEspacio();
                program = new Programas(nombre, tiempoejec,espaciopro);
                ram.añadirPro(program);
                //programas.add(program);
                //System.out.println(programas);
            
            if (vista.getAnswer() == 1){
                terminar = false;
            }
            else {
                terminar = true;
                break;
            }
            }break;

            case 3:
            System.out.println("hola");
            break;
            


        }
        opcion = vista.menu();
    }
    

}
    
}
