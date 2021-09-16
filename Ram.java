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
    private Programas[] bloquesmem;
    Vista vista = new Vista();


    Ram(int tamGB ){
        this.sisdr = true;
        this.bloques= (tamGB * 1024)/64;
        bloquesmem = new Programas[this.bloques];
        sdr = new ArrayList<Programas>(bloques);
        for(int i=0; i<this.bloques; i++){
            sdr.add(null);
        }
        vista.mensaje(("####"));
            for (int i=0; i<sdr.size(); i++){
            System.out.println(sdr.get(i));
            }
        vista.mensaje(("##tamaño###"));
            System.out.println(sdr.size());
    }

    Ram(){
        this.sisdr = false;
        this.bloques= 64;
        bloquesmem = new Programas[this.bloques];
        ddr = new ArrayList<Programas>(bloques);
        for(int i=0; i<this.bloques; i++){
            ddr.add(null);
        }
        //vista.mensaje(("####"));
            for (int i=0; i<ddr.size(); i++){
            System.out.println(ddr.get(i));
            }
        //vista.mensaje(("#####"));
            System.out.println(ddr.size());
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
            System.out.println("------------------SDR-------------------");

            for(int i= 0; i < sdr.size(); i++){
                if(sdr.get(i) == null)
                bloqueslibres++;
            }
            System.out.println("Espacio libre"+ bloqueslibres);
            System.out.println("Bloques programas"+ bloquesnprograma);
            if(bloquesnprograma<= bloqueslibres){
                for(int i= 0; i < sdr.size() && bloquesnprograma != 0; i++){
                    if (sdr.get(i) == null){
                        sdr.set(i, programs);
                        bloquesnprograma--;
                    
                    }
                }
                System.out.println(sdr);
            }else if (bloquesnprograma > bloqueslibres){
                cola.add(programs);
            }
            
        }else if ((sisdr) == false){
            
            int bloqueslibres = 0; 
            for(int i= 0; i < ddr.size(); i++){
                //System.out.println(sdr.get(i));
            }
            System.out.println("------------------DDR-------------------");

            for(int i= 0; i < ddr.size(); i++){
                if(ddr.get(i) == null)
                bloqueslibres++;
            }
            System.out.println("Espacio libre"+" " + bloqueslibres);
            System.out.println("Bloques programas"+ " " + bloquesnprograma);
            if(bloquesnprograma<= bloqueslibres){
                for(int i= 0; i < ddr.size() && bloquesnprograma != 0; i++){
                    if (ddr.get(i) == null){
                        ddr.set(i, programs);
                        bloquesnprograma--;
                    
                    }
                }
                System.out.println(ddr);
            }
        }
    }

    

}
