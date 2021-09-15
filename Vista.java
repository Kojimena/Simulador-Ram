
/**
* @author: Karen Jimena Hernández Ortega
* @version: 17-sep-21
* Esta clase es la vista del programa.Imprime resultados y pide datos.
**/

import java.util.Scanner;

public class Vista {
    Scanner scan = new Scanner(System.in);

    public int menu(){
		int opcion;

                System.out.println("1. Inicializar");
                System.out.println("2. Ingresar Programas");
                System.out.println("3. Cantidad de memoria RAM");
                System.out.println("4. Mostrar Programas");
                System.out.println("5. Conocer espacios de algún programa");
                System.out.println("6. Nuevo ciclo de reloj");
                System.out.println("7. Salir");
                System.out.print("Seleccion: ");
		opcion = scan.nextInt();
		scan.nextLine();
		return opcion;
    	}
        
}
