import java.util.ArrayList;
import java.lang.*;

/**
 *
 * @author Karen Jimena Hernández Ortega
 * @file Ram.java
 * @version: 17-sep-21
 */
public class Ram {
    private ArrayList<Programas> ddr;
    private ArrayList<Programas> sdr;
    private ArrayList<Programas> cola = new ArrayList<Programas>();
    private boolean sisdr;
    private int bloques; 
    Vista vista = new Vista();


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

    public void añadirPro(Programas programs)throws ArithmeticException{
        int space = programs.getEspacio();
        float bloques = space/64;
        int bloquesnprograma = Math.round(bloques);
        

        if ((sisdr) == true){
            int bloqueslibres = 0; 
            for(int i= 0; i < sdr.size(); i++){
                //System.out.println(sdr.get(i));
            }
            //System.out.println("------------------SDR-------------------");

            for(int i= 0; i < sdr.size(); i++){
                if(sdr.get(i) == null)
                bloqueslibres++;
            }
            //System.out.println("Espacio libre"+ " "+ bloqueslibres + " " + "bloques");
            //System.out.println("Bloques programas"+" "+ bloquesnprograma + " " + "bloques");
            if(bloquesnprograma<= bloqueslibres){
                for(int i= 0; i < sdr.size() && bloquesnprograma != 0; i++){
                    if (sdr.get(i) == null){
                        sdr.set(i, programs);
                        bloquesnprograma--;
                    
                    }
                }
                //System.out.println(sdr);
            }else if (bloquesnprograma > bloqueslibres){
                cola.add(programs);
                //System.out.println("cola"+ cola);
            }
            
        }else if ((sisdr) == false){
            
            int bloqueslibres = 0; 
            for(int i= 0; i < ddr.size(); i++){
                //System.out.println(sdr.get(i));
            }
            //System.out.println("------------------DDR-------------------");

            for(int i= 0; i < ddr.size(); i++){
                if(ddr.get(i) == null)
                bloqueslibres++;
            }
            //System.out.println("Espacio libre"+" " + bloqueslibres+ " " + "bloques");
            //System.out.println("Bloques programas"+ " " + bloquesnprograma+ " " + "bloques");
            if(bloquesnprograma<= bloqueslibres){
                for(int i= 0; i < ddr.size() && bloquesnprograma != 0; i++){
                    if (ddr.get(i) == null){
                        ddr.set(i, programs);
                        bloquesnprograma--;
                    
                    }
                }
                //System.out.println(ddr);
            }else if (bloquesnprograma > bloqueslibres){
                cola.add(programs);
                //System.out.println("cola"+ cola);
            }
        }
    }

    public ArrayList<String>getColapro(){
        ArrayList<String>colaString = new ArrayList<String>();
        for (int i =0; i< cola.size(); i++){
            Programas c_reciente = cola.get(i);
            if (c_reciente != null){
                String c_String = "Programa número" + (i+1) + " N: " + c_reciente.getNombre() +" T: "+ c_reciente.getTiempo()+" E: "+c_reciente.getEspacio()+ "\n";
                colaString.add(c_String);
            }

        }

        if (colaString.size()<=0){
            vista.mensaje("No tiene programas en cola");
        }

        return colaString;
    }

    public ArrayList<String>getDatos(){
        ArrayList<String> datos = new ArrayList<String>();
        int ramEnuso = 0;
        int ramTotal = this.bloques*64;
        int ramdisponible;

        ArrayList<Programas> prog = new ArrayList<Programas>();
        if ((sisdr) == true){
            for(int i=0; i<sdr.size(); i++){
                Programas estePrograma = sdr.get(i);

                if(prog != null){
                    if(!(prog.contains(estePrograma))){
                    prog.add(estePrograma);
                    ramEnuso = i;
                    }
                }
            }
        }else if((sisdr) == false) {
            for(int i=0; i<ddr.size(); i++){
                Programas estePrograma = ddr.get(i);
                if(prog != null){
                    if(!(prog.contains(estePrograma))){
                    prog.add(estePrograma);
                    ramEnuso = i;
                }    }
            }
        }
        ramdisponible = ramTotal-ramEnuso;

        String ramuso = "RAM usada:"+ " " + ramEnuso + " " + "bloques";
        String ramdisp = "RAM disponible:"+ " " + ramdisponible+ " " + "bloques";
        String ramtotal= "RAM total:"+ " " + ramTotal+ " " + "bloques";

        datos.add(ramuso);
        datos.add(ramdisp);
        datos.add(ramtotal);

        return datos;

    }

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

    public ArrayList<String> getEstado() {
        ArrayList<String> bloquesString = new ArrayList<String>();
        if ((sisdr) == true){
            for(int i=0; i<sdr.size(); i++){
                Programas estePrograma = sdr.get(i);

                if(estePrograma != null){
                    String info = "Bloque num" + i + ": " + estePrograma.getNombre() + ", " + estePrograma.getEspacio() + ", " + estePrograma.getTiempo();
                    bloquesString.add(info);
                }else{
                    String info = "Bloque num" + i + ": Vacio" ;
                    bloquesString.add(info);
                }

            }
        }else if((sisdr) == false) {
            for(int i=0; i<ddr.size(); i++){
                Programas estePrograma = ddr.get(i);

                if(estePrograma != null){
                    String info = "Bloque num" + i + ": " + estePrograma.getNombre() + ", " + estePrograma.getEspacio() + ", " + estePrograma.getTiempo();
                    bloquesString.add(info);
                }else{
                    String info = "Bloque num" + i + ": Vacio" ;
                    bloquesString.add(info);
                }
            }
        }
        return bloquesString;
    }

    public int bloquesNecesarios(Programas programas){ 
        // cuantos bloques necesita un solo programa.       
        int sizeMB = programas.getEspacio();  // Tamaño del programa en memoria
        Double bloques = sizeMB / 64.0;
        int bloquesNecesarios = (int)(Math.ceil(bloques));
        
        return bloquesNecesarios;
    }

    public void ejecutarnuevoCiclo(){
        if ((sisdr) == true){
        if (sdr.get(0) != null) { 
            boolean programEj = sdr.get(0).ejecutar();
            if (programEj){
                // El programa ya finalizó su ejecución.

                // Eliminación de los bloques de memoria
                //ArrayList<Programas> prog = new ArrayList<Programas>();
                Programas programaac = sdr.get(0);
                int bloquesUsados = bloquesNecesarios(programaac);
                for (int j = 0; j < bloquesUsados; j++) {
                    for (int i = 0; i < sdr.size(); i++) {
                        sdr.remove(i);
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
                    // El programa ya finalizó su ejecución.
    
                    // Eliminación de los bloques de memoria
                    //ArrayList<Programas> prog = new ArrayList<Programas>();
                    Programas programaac = ddr.get(0);
                    int bloquesUsados = bloquesNecesarios(programaac);
                    for (int j = 0; j < bloquesUsados; j++) {
                        for (int i = 0; i < ddr.size(); i++) {
                            ddr.remove(i);
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
                Programas programaEnCola = cola.get(i);
        
                for (int j = 0; j < ddr.size(); j++) {
                    if(ddr.get(j) == null){
                        bloquesLibres++;
                    }
                }            
    
                if(bloquesLibres >= bloquesNecesarios(programaEnCola)){
                    añadirPro(programaEnCola);
                    pTransfer.add(programaEnCola);
                }
            }
            for (int i = 0; i < pTransfer.size(); i++) {
                cola.remove(pTransfer.get(i));
            }
        }

    }

}
