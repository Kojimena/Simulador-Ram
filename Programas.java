/**
 *
 * @author Karen Jimena Hernández Ortega
 * @file Vehiculo.java
 * @version: 15-sep-21
 */

public class Programas {
    //atributos privados 
    private String nombre;
    private int tiempoejecucion;
    private int espacio;

    public Programas(String nombre,int tiempoejecucion, int espacio){
		this.nombre= nombre;
        this.tiempoejecucion = tiempoejecucion;
        this.espacio = espacio;
    }

    /**
    * @param null
    * @return nombre
    */
    public String getNombre() {
        return nombre;
    }

    /**
    * @param null
    * @return tiempo
    */
    public int getTiempo() {
        return tiempoejecucion;
    }
    
     /**
    * @param null
    * @return espacio
    */
    public int getEspacio() {
        return espacio;
    }





    
}
