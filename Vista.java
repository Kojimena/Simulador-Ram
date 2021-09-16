
/**
* @author: Karen Jimena Hernández Ortega
* @version: 17-sep-21
* Esta clase es la vista del programa.Imprime resultados y pide datos.
**/

import java.util.InputMismatchException;
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
                System.out.println("6. Estado memoria Ram");
                System.out.println("7. Nuevo ciclo de reloj");
                System.out.println("8. Salir");
                System.out.print("Seleccion: ");
            try {
                opcion = scan.nextInt();
            
            } catch (InputMismatchException e) {
                mensaje("Porfavor, ingrese una opción válida");
                Scanner scan = new Scanner(System.in);
                opcion = scan.nextInt();
            
            }
        
		scan.nextLine();
		return opcion;
    }

    public void mensaje(String mensaje){
        System.out.println(mensaje);
    }

    public String getNombre(){
        System.out.printf("\nIngrese el nombre del programa ");

        String nombre = scan.nextLine();

        return nombre;
    }

    public int getEspacio(){

        System.out.printf("\nIngrese el espacio del programa ");
        
        int espacio = scan.nextInt();

        return espacio;
        
    }

    public int getTiempo(){

        System.out.printf("\nIngrese el tiempo del programa ");

        int tiempo = scan.nextInt();

        return tiempo;
    }

    public String getTipo(){

        System.out.printf("\nIngrese el tipo de memoria RAM (SDR O DDR)");

        String tipo = scan.nextLine().toUpperCase();

        return tipo;
    }

    public int getTamGB(){

        System.out.printf("\nIngrese el tamaño de su memoria SDR: (4, 8, 12, 16, 32, 64)");

        int tamgb = scan.nextInt();

        return tamgb;
    }

    public int getAnswer(){

        System.out.printf("\n¿Quiere agregar más programas?\n 1.Si \n 2.No\n");

        int seguir = scan.nextInt();
        scan.nextLine();

        return seguir;
    }


}
