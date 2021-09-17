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
    * Lee los programas provistos en el archivo de texto
    * @return Objetos de Programa, creados con la información del archivo
    */
    public ArrayList<Programas> leer() throws IOException{
        ArrayList<String> pString = new ArrayList<String>();
        ArrayList<Programas> programas = new ArrayList<Programas>();

        Scanner myReader = new Scanner(archivo);
        while (myReader.hasNextLine()) {
            String localData = myReader.nextLine();
            pString.add(localData);  // Una línte entera representa la información de un programa
        }
        myReader.close();

        for (int i = 0; i < pString.size(); i++) {
            ArrayList<String> linea = new ArrayList<String>(Arrays.asList(pString.get(i).split(",")));
            String nombre = linea.get(0);
            int tiempo = Integer.parseInt(linea.get(1));
            int memoria = Integer.parseInt(linea.get(2));
            Programas nuevoPrograma = new Programas(nombre, tiempo, memoria);
            programas.add(nuevoPrograma);
        }

        return programas;
    }
    
    
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
    
}
