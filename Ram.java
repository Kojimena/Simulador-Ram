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
        //*vista.mensaje(("####"));
           // for (int i=0; i<sdr.size(); i++){
          //  System.out.println(sdr.get(i));
          //  }
        //vista.mensaje(("##tamaño###"));
           // System.out.println(sdr.size());
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
            //for (int i=0; i<ddr.size(); i++){
            //System.out.println(ddr.get(i));
            //}
        //vista.mensaje(("#####"));
            //System.out.println(ddr.size());
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
            System.out.println("Espacio libre"+ " "+ bloqueslibres + " " + "bloques");
            System.out.println("Bloques programas"+" "+ bloquesnprograma + " " + "bloques");
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
                System.out.println("cola"+ cola);
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
            System.out.println("Espacio libre"+" " + bloqueslibres+ " " + "bloques");
            System.out.println("Bloques programas"+ " " + bloquesnprograma+ " " + "bloques");
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
            System.out.println("No tiene programas en cola");
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



}
