package Retos.Utils;

public class VasoDeCafe {
    // Atributos
    private String nombre;
    private int cantidadCafe, cantidadAgua, cantidadAzucar;
    private Boolean tieneAzucar;
    private float precio;
    
    public VasoDeCafe(String nombre, int cantidadAgua, int cantidadCafe,  boolean tieneAzucar, int cantidadAzucar, float precio){
        this.nombre = nombre;
        this.cantidadAgua = cantidadAgua;
        this.cantidadCafe = cantidadCafe;
        this.tieneAzucar = tieneAzucar;
        this.cantidadAzucar = cantidadAzucar;
        this.precio = precio;
    }
    
    // Getters
    public float getPrecio() {
        return precio;
    }
    public Boolean getTieneAzucar() {
        return tieneAzucar;
    }
    public int getCantidadCafe() {
        return cantidadCafe;
    }
    public String getnombre() {
        return nombre;
    }
    public int getCantidadAzucar() {
        return cantidadAzucar;
    }

    public int getCantidadAgua() {
        return cantidadAgua;
    }
}
