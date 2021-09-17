import java.io.*;
import java.util.*;

/**
* Clase encargada de la manipulacion de archivos.
* @author: Jimena Hernández
* @version: 15-sep-21
*/
public class ManipulacionArchivo {
    String cadena;
    File archivo;
    FileReader leer;
    FileWriter escribir;
    PrintWriter linea;
    BufferedReader almacenamiento;
    String texto;
    Ram ram = new Ram();
    Programas program = new Programas();
    
    public ManipulacionArchivo(String miArchivo){
        /**
        * Constructor para objetos de la clase manipulacionArchivo
        * @param miArchivo
        */
        archivo = new File(miArchivo);
        if(!archivo.exists()){
            try{
                archivo.createNewFile();
            }catch (Exception e){
                e.printStackTrace();
            }
        }else{
            try{
                leer = new FileReader(archivo);
                almacenamiento = new BufferedReader(leer);
                cadena = "";
                while(cadena!=null){
                    try{
                        cadena = almacenamiento.readLine();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
                almacenamiento.close();
                leer.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

 
    /**
    * @return: String
    * @throws: FileNotFoundException
    **/ 
    public String leerarch(){
        /**
         * Funcion que permite leer el contenido del archivo
         */
        texto = "";
        try {
            Scanner myReader = new Scanner(archivo);
            while (myReader.hasNextLine()) {
                texto += myReader.nextLine() + "\n";
            }
            myReader.close();
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return texto;
    }
    
    public void escribir(String texto){
        /**
         * Funcion que permite escribir en el archivo
         */
        if(archivo.exists()){
            try{
                escribir = new FileWriter(archivo,true);
                linea = new PrintWriter(escribir);
                linea.println(texto);
                linea.close();
                escribir.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    /**
    * @return: programsArrayList
    * @param: String
    **/ 
    public ArrayList<Programas>manipulacion(String texto){
        ArrayList<Programas> programsArrayList = new ArrayList<Programas>();
        String[] parts = texto.split(",");
        String name = parts[0]; 
        int time = Integer.parseInt(parts[1]);  
        int space= Integer.parseInt(parts[2]);
        Programas eProgramas = new Programas(name, time, space);
        programsArrayList.add(eProgramas);
        return programsArrayList;

    }
    
}
