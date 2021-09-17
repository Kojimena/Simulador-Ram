
/**
* @author: Karen Jimena Hernández Ortega
* @version: 17-sep-21
* @file: Vista.java 
* Esta clase es la vista del programa.Imprime resultados y pide datos.
**/

import java.util.ArrayList;
import java.util.InputMismatchException; //se importan clases a usar
import java.util.Scanner;

public class Vista {
    Scanner scan = new Scanner(System.in); 

    /**
    * @param: null
    * @return: opcion
    * @throws: InputMissmatchException
    * menú del programa
    **/ 
    public int menu(){
		int opcion;
                System.out.println("0. Inicializar con archivo .txt");
                System.out.println("1. Inicializar");
                System.out.println("2. Ingresar Programas");
                System.out.println("3. Cantidad de memoria RAM");
                System.out.println("4. Mostrar Programas");
                System.out.println("5. Conocer espacios de programas");
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

    /**
    * @param: String
    * imprime mensajes
    **/ 
    public void mensaje(String mensaje){
        System.out.println(mensaje);
    }

    /**
    * @param: Arraylist<String>
    * imprime mensajes en Arraylist de cadena
    **/ 
    public void mensaje(ArrayList<String> mensajearray){
        for (int i = 0; i<mensajearray.size(); i++){
            System.out.println(mensajearray.get(i));
        }
        
    }

    /**
    * @return: nombre del programa
    **/ 
    public String getNombre(){
        System.out.printf("\nIngrese el nombre del programa ");

        String nombre = scan.nextLine();

        return nombre;
    }

    /**
    * @return: espacio del programa
    **/ 
    public int getEspacio(){

        System.out.printf("\nIngrese el espacio del programa ");
        
        int espacio = scan.nextInt();

        return espacio;
        
    }

    /**
    * @return: Tiempo del programa
    **/ 
    public int getTiempo(){

        System.out.printf("\nIngrese el tiempo del programa ");

        int tiempo = scan.nextInt();

        return tiempo;
    }

    /**
    * @return: Tipo del programa
    **/ 
    public String getTipo(){

        System.out.printf("\nIngrese el tipo de memoria RAM (SDR O DDR)");

        String tipo = scan.nextLine().toUpperCase();

        return tipo;
    }

    /**
    * @return: Tamaño GB de memoria
    **/ 
    public int getTamGB(){

        System.out.printf("\nIngrese el tamaño de su memoria SDR en GB, opciones:(4, 8, 12, 16, 32, 64)");

        int tamgb = scan.nextInt();

        return tamgb;
    }

    /**
    * @return: seguir
    **/ 
    public int getAnswer(){

        System.out.printf("\n¿Quiere agregar más programas?\n 1.Si \n 2.No\n");

        int seguir = scan.nextInt();
        scan.nextLine();

        return seguir;
    }

    /**
    * @return: name
    **/ 
    public String getPro(){

        System.out.printf("\nIngrese el nombre del programa que buscar");

        String name = scan.nextLine();

        return name;
    }

    


}
