/**
 *
 * @author Karen Jimena Hernández Ortega
 * @file Programas.java
 * @version: 15-sep-21
 */

public class Programas {
    //atributos privados 
    private String nombre;
    private int tiempoejecucion;
    private int espacio;

    //Constructor para la creación de nuevos programas
    /**
    * @params nombre programa, tiempo de ejecución del programa y espacio del programa
    */
    public Programas(String nombre,int tiempoejecucion, int espacio){
		this.nombre= nombre;
        this.tiempoejecucion = tiempoejecucion;
        this.espacio = espacio;
    }

    //Constructor vacío
    public Programas(){
        nombre = "";
        tiempoejecucion= 0;
        espacio= 0;
    }

    //método para usar en nuevos ciclos
    public boolean ejecutar(){
        boolean resultado;

        tiempoejecucion--;
        if(tiempoejecucion == 0){
            resultado = true;  // finalizó su ejecución correctamente
        } else{
            resultado = false;// no finalizó su ejecución correctamente
        }

        return resultado;
    }

    /**
    * @return nombre
    */
    public String getNombre() {
        return nombre;
    }

    /**
    * @return tiempo
    */
    public int getTiempo() {
        return tiempoejecucion;
    }
    
     /**
    * @return espacio
    */
    public int getEspacio() {
        return espacio;
    }


    @Override
    public String toString() {
        return   " " + nombre + " " + tiempoejecucion+ " " + espacio;
    }


    
}
