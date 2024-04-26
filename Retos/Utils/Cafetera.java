package Retos.Utils;

import java.util.ArrayList;

public class Cafetera {
    // Atributos
    private int MaximaCantidadAgua, MaximaCantidadCafe, MaximaCantidadAzucar;
    private ArrayList<VasoDeCafe> listaGeneralVasosVendidos = new ArrayList<VasoDeCafe>();
    private ArrayList<VasoDeCafe> compraActual = new ArrayList<VasoDeCafe>();

    // Categorias de vasos de cafe
    public VasoDeCafe VasosDeCafe[] = new VasoDeCafe[6];

    // Constructor
    public Cafetera() {
        
    }

    // Functions
    public void realizarVenta(){

    }

    // Getters & setters
    //#region Get-Set
    public int getMaximaCantidadAzucar() {
        return MaximaCantidadAzucar;
    }

    public void setMaximaCantidadAzucar(int maximaCantidadAzucar) {
        MaximaCantidadAzucar = maximaCantidadAzucar;
    }

    public int getMaximaCantidadCafe() {
        return MaximaCantidadCafe;
    }

    public void setMaximaCantidadCafe(int maximaCantidadCafe) {
        MaximaCantidadCafe = maximaCantidadCafe;
    }

    public int getMaximaCantidadAgua() {
        return MaximaCantidadAgua;
    }

    public void setMaximaCantidadAgua(int maximaCantidadAgua) {
        MaximaCantidadAgua = maximaCantidadAgua;
    }
    
    //#endregion
}
