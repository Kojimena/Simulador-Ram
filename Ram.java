/**
 *
 * @author Karen Jimena Hernández Ortega
 * @file Ram.java
 * @version: 17-sep-21
 */

import java.util.ArrayList; // importar clases 
import java.lang.*;


public class Ram {
    //atributos privados 
    private ArrayList<Programas> ddr;
    private ArrayList<Programas> sdr;
    private ArrayList<Programas> cola = new ArrayList<Programas>();
    private boolean sisdr;
    private int bloques; 
    Vista vista = new Vista();


    /**
    * @param: int tamGb
    **/ 
    Ram(int tamGB ){
        this.sisdr = true;
        this.bloques= (tamGB * 1024)/64;
        sdr = new ArrayList<Programas>(bloques);
        for(int i=0; i<this.bloques; i++){
            sdr.add(null);
        }

    }

    Ram(){
        this.sisdr = false;
        this.bloques= 64;
        ddr = new ArrayList<Programas>(bloques);
        for(int i=0; i<this.bloques; i++){
            ddr.add(null);
        }

    }

    /**
    * @param: Programas
    * @throws: ArithmeticException
    * Método añadir programa
    **/ 
    public void añadirPro(Programas programs)throws ArithmeticException{
        int space = programs.getEspacio();
        float bloques = space/64;
        int bloquesnprograma = Math.round(bloques); //se vuelve entero con .round fuente: https://developer.mozilla.org/es/docs/Web/JavaScript/Reference/Global_Objects/Math/round
        
        // if para verificar si es sdr o ddr
        if ((sisdr) == true){
            int bloqueslibres = 0; 
            for(int i= 0; i < sdr.size(); i++){

            }


            for(int i= 0; i < sdr.size(); i++){
                if(sdr.get(i) == null)
                bloqueslibres++;
            }

            if(bloquesnprograma<= bloqueslibres){ //si los bloques son menores que los libres se hace un set para el programa.
                for(int i= 0; i < sdr.size() && bloquesnprograma != 0; i++){
                    if (sdr.get(i) == null){
                        sdr.set(i, programs);
                        bloquesnprograma--;
                    
                    }
                }
 
            }else if (bloquesnprograma > bloqueslibres){
                cola.add(programs); //sino se añade al array de cola

            }
            
        }else if ((sisdr) == false){ //si es ddr
            
            int bloqueslibres = 0; 
            for(int i= 0; i < ddr.size(); i++){

            }


            for(int i= 0; i < ddr.size(); i++){
                if(ddr.get(i) == null)
                bloqueslibres++;
            }

            if(bloquesnprograma<= bloqueslibres){ //si los bloques son menores que los libres se hace un set para el programa.
                for(int i= 0; i < ddr.size() && bloquesnprograma != 0; i++){
                    if (ddr.get(i) == null){
                        ddr.set(i, programs);
                        bloquesnprograma--;
                    
                    }
                }

            }else if (bloquesnprograma > bloqueslibres){
                cola.add(programs); //sino se añade al array de cola

            }
        }
    }

    /**
    * @return: ArrayList<String> Cola
    * Método obtener la cola
    **/ 
    public ArrayList<String>getColapro(){
        ArrayList<String>colaString = new ArrayList<String>();
        for (int i =0; i< cola.size(); i++){ //recorre
            Programas c_reciente = cola.get(i);
            if (c_reciente != null){ //si lo encuentra
                String c_String = "Programa número" + (i+1) + " N: " + c_reciente.getNombre() +" T: "+ c_reciente.getTiempo()+" E: "+c_reciente.getEspacio()+ "\n";
                colaString.add(c_String); // se añade al array
            }

        }

        if (colaString.size()<=0){ // si la cola no tiene nada aún 
            vista.mensaje("No tiene programas en cola"); //se muestra un mensaje
        }

        return colaString;
    }

    /**
    * @return: ArrayList<String>
    * Método obtener los datos de ram
    **/ 
    public ArrayList<String>getDatos(){
        ArrayList<String> datos = new ArrayList<String>();
        int ramEnuso = 0;
        int ramTotal = this.bloques*64;
        int ramdisponible;

        ArrayList<Programas> prog = new ArrayList<Programas>();
        if ((sisdr) == true){ //revisar si es sdr
            for(int i=0; i<sdr.size(); i++){ //recorre el array 
                Programas estePrograma = sdr.get(i);

                if(prog != null){
                    if(!(prog.contains(estePrograma))){ //https://www.w3schools.com/java/ref_string_contains.asp
                    prog.add(estePrograma);
                    ramEnuso = i;
                    }
                }
            }
        }else if((sisdr) == false) { // si es ddr
            for(int i=0; i<ddr.size(); i++){ //recorre el array 
                Programas estePrograma = ddr.get(i);
                if(prog != null){
                    if(!(prog.contains(estePrograma))){
                    prog.add(estePrograma);
                    ramEnuso = i;
                    }    
                }

            }
        }
    
        String ramuso = "RAM usada:"+ " " + ramEnuso + " " + "bloques";
        datos.add(ramuso);
        ramdisponible = ramTotal-ramEnuso; //Se resta la ram total - la que se usa 
        String ramdisp = "RAM disponible:"+ " " + ramdisponible+ " " + "bloques";
        datos.add(ramdisp);
        String ramtotal= "RAM total:"+ " " + ramTotal+ " " + "bloques";
        datos.add(ramtotal); //se añaden los Strings al Array de Strings

        return datos;

    }

     /**
    * @return: ArrayList<Programas>
    * Método obtener los espacios del programa
    **/ 
    public ArrayList<Programas>getEspacios(){

        ArrayList<Programas> prog = new ArrayList<Programas>();
        if ((sisdr) == true){
            for(int i=0; i<sdr.size(); i++){
                Programas estePrograma = sdr.get(i);
                //System.out.println(estePrograma);

                if(prog != null){
                    if(!(prog.contains(estePrograma))){
                    prog.add(estePrograma);
                    }
                }
            }
        }else if((sisdr) == false) {
            for(int i=0; i<ddr.size(); i++){
                Programas estePrograma = ddr.get(i);
                //System.out.println(estePrograma);
                if(prog != null){
                    if(!(prog.contains(estePrograma))){
                    prog.add(estePrograma);
                }    }
            }
        }

        return prog;

    }

    /**
    * @param: null
    * @return: ArrayList<String>
    * Obtener estado de la Ram
    **/ 
    public ArrayList<String> getEstado() {
        ArrayList<String> bloquesString = new ArrayList<String>();
        if ((sisdr) == true){ //verificar si es sdr 
            for(int i=0; i<sdr.size(); i++){ 
                Programas estePrograma = sdr.get(i);

                if(estePrograma != null){ //si contiene, se toman sus propiedades
                    String estado = "Bloque num" + (i+1) + ": " + estePrograma.getNombre() + "," + estePrograma.getEspacio() + "," + estePrograma.getTiempo();
                    bloquesString.add(estado);
                }else{ //si no contiene, se muestra vacio
                    String estadov = "Bloque num" + (i+1) + ": Vacio" ;
                    bloquesString.add(estadov);
                }

            }
        }else if((sisdr) == false) { //si ddr
            for(int i=0; i<ddr.size(); i++){
                Programas estePrograma = ddr.get(i);

                if(estePrograma != null){ //si contiene, se toman sus propiedades
                    String estado = "Bloque num" + (i+1) + ": " + estePrograma.getNombre() + "," + estePrograma.getEspacio() + "," + estePrograma.getTiempo();
                    bloquesString.add(estado);
                }else{ //si no contiene, se muestra vacio
                    String estadov = "Bloque num" + (i+1) + ": Vacio" ;
                    bloquesString.add(estadov);
                }
            }
        }
        return bloquesString;
    }

    /**
    * @param: Programas
    * @return: bloques Necesarios
    * Obtener estado de la Ram
    **/ 
    public int bloquesNecesarios(Programas programas){ 
        // cuantos bloques necesita un solo programa.       
        int sizeMB = programas.getEspacio();  // Tamaño del programa en memoria
        Double bloques = sizeMB / 64.0;
        int bloquesNecesarios = (int)(Math.ceil(bloques));
        
        return bloquesNecesarios;
    }

    /**
    * Ejecutar un ciclo nuevo
    **/ 
    public void ejecutarnuevoCiclo(){
        if ((sisdr) == true){ //chequear si es sdr 
        if (sdr.get(0) != null) { 
            boolean programEj = sdr.get(0).ejecutar();
            if (programEj){

                // Eliminar bloques de memoria
                Programas programaac = sdr.get(0);
                int bloquesUsados = bloquesNecesarios(programaac);
                for (int j = 0; j < bloquesUsados; j++) {
                    for (int i = 0; i < sdr.size(); i++) {
                        sdr.remove(i); //https://stackoverflow.com/questions/10940607/how-to-remove-a-specific-element-in-array-in-javascript
                    }
                }
                // Eliminación de la cola. Se eliminan todos los programas que tengan tiempo 0
                for (int i = 0; i < cola.size(); i++) {
                    if(cola.get(i).getTiempo() == 0){
                        cola.remove(i);
                    }
                }
            }    
        }
        // Adición de programas en cola a la memoria
        ArrayList<Programas> pTransfer = new ArrayList<Programas>();
        for (int i = 0; i < cola.size(); i++) {
            int bloquesLibres = 0;
            Programas pCola = cola.get(i);
    
            for (int j = 0; j < sdr.size(); j++) {
                if(sdr.get(j) == null){
                    bloquesLibres++;
                }
            }            

            if(bloquesLibres >= bloquesNecesarios(pCola)){
                añadirPro(pCola);
                pTransfer.add(pCola);
            }
        }
        for (int i = 0; i < pTransfer.size(); i++) {
            cola.remove(pTransfer.get(i));
        }
        }else if((sisdr) == false){
            if (ddr.get(0) != null) { 
                boolean programEj = ddr.get(0).ejecutar();
                if (programEj){

                    Programas programaac = ddr.get(0);
                    int bloquesUsados = bloquesNecesarios(programaac);
                    for (int j = 0; j < bloquesUsados; j++) {
                        for (int i = 0; i < ddr.size(); i++) {
                            ddr.remove(i);
                        }
                    }
                    // Eliminación de la cola. 
                    for (int i = 0; i < cola.size(); i++) {
                        if(cola.get(i).getTiempo() == 0){
                            cola.remove(i);
                        }
                    }
                }    
            }
            // Adición de programas 
            ArrayList<Programas> pTransfer = new ArrayList<Programas>();
            for (int i = 0; i < cola.size(); i++) {
                int bloquesLibres = 0;
                Programas pCola = cola.get(i);
        
                for (int j = 0; j < ddr.size(); j++) {
                    if(ddr.get(j) == null){
                        bloquesLibres++;
                    }
                }            
    
                if(bloquesLibres >= bloquesNecesarios(pCola)){
                    añadirPro(pCola);
                    pTransfer.add(pCola);
                }
            }
            for (int i = 0; i < pTransfer.size(); i++) {
                cola.remove(pTransfer.get(i));
            }
        }

    }




}
