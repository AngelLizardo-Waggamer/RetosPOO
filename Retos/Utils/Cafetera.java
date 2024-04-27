package Retos.Utils;

import java.io.IOException;
import java.util.ArrayList;

import Retos.Utils.InputHandler.RangedTypes;
import Retos.Utils.InputHandler.Types;

public class Cafetera {
    // Atributos
    private int MaximaCantidadAgua, MaximaCantidadCafe, MaximaCantidadAzucar;
    private int CantidadDeAguaActual, CantidadDeCafeActual, CantidadDeAzucarActual;
    private ArrayList<VasoDeCafe> listaGeneralVasosVendidos = new ArrayList<VasoDeCafe>();
    private ArrayList<VasoDeCafe> compraActual = new ArrayList<VasoDeCafe>();

    // Categorias de vasos de cafe
    private VasoDeCafe[] VasosDeCafe = new VasoDeCafe[6];

    // Constructor
    public Cafetera(int MaximaCantidadAgua, int MaximaCantidadCafe, int MaximaCantidadAzucar) {
        VasosDeCafe[0] = new VasoDeCafe("Vaso de cafe pequeño sin azucar", 120, 30, false, 0, 10.5f);
        VasosDeCafe[1] = new VasoDeCafe("Vaso de cafe pequeño con azucar", 120, 30, true, 5, 14.5f);
        VasosDeCafe[2] = new VasoDeCafe("Vaso de cafe mediano sin azucar", 220, 50, false, 0, 24.5f);
        VasosDeCafe[3] = new VasoDeCafe("Vaso de cafe mediano con azucar", 220, 50, true, 10, 34.5f);
        VasosDeCafe[4] = new VasoDeCafe("Vaso de cafe grande sin azucar", 320, 80, false, 0, 39.5f);
        VasosDeCafe[5] = new VasoDeCafe("Vaso de cafe grande con azucar", 320, 80, true, 15, 34.5f);
        this.MaximaCantidadAgua = MaximaCantidadAgua;
        CantidadDeAguaActual = MaximaCantidadAgua;
        this.MaximaCantidadAzucar = MaximaCantidadAzucar;
        CantidadDeAzucarActual = MaximaCantidadAzucar;
        this.MaximaCantidadCafe = MaximaCantidadCafe;
        CantidadDeCafeActual = MaximaCantidadCafe;
    }

    //#region Main functions
    public void realizarVenta() throws IOException{
        int numeroVasos;
        float totalAPagar = 0.0f;
        System.out.println("----------- VENTA NORMAL -----------");
        numeroVasos = Integer.parseInt(InputHandler.input(InputHandler.Types.ENTERO_NO_NEGATIVO, "¿Cuantos vasos de cafe desea comprar?"));
        for(int i = 0; i < numeroVasos; i++){
            int opcionElegida;
            listarVasos();
            opcionElegida = Integer.parseInt(InputHandler.rangedInput(InputHandler.RangedTypes.ENTERO, 1, 6, "Opcion de vaso elegida: "));
            VasoDeCafe vasoElegido = VasosDeCafe[opcionElegida-1];
            if(sePuedePreparar(vasoElegido)){
                totalAPagar+= vasoElegido.getPrecio();
                ajustarInsumos(vasoElegido);
                compraActual.add(vasoElegido);
                listaGeneralVasosVendidos.add(vasoElegido);
            }else{
                System.out.println("No se tienen los suficientes insumos para preparar el vaso. Disculpe las molestias.");
                break;
            }
            
        }
        checkout(totalAPagar);
    }

    public void checarNiveles(){
        System.out.println("Los niveles actuales de la cafetera son: ");
        System.out.println("* Agua: " + this.CantidadDeAguaActual + "ml");
        System.out.println("* Cafe: " + this.CantidadDeCafeActual + "g");
        System.out.println("* Azucar: " + this.CantidadDeAzucarActual + "g");
    }

    public void agregarInsumos() throws IOException{
        int input;
        System.out.println("Insumos a agregar: \n1. Cafe\n2. Agua\n3. Azucar");
        input = Integer.parseInt(InputHandler.rangedInput(RangedTypes.ENTERO, 1, 3, "¿Que insumo desea agregar?"));
        switch(input){
            case 1->{ // Cafe
                input = Integer.parseInt(InputHandler.input(Types.ENTERO_NO_NEGATIVO, "Ingrese la cantidad de cafe a añadir: "));
                if((CantidadDeCafeActual + input) > MaximaCantidadCafe){
                    System.out.println("La cafetera estara rebosada si se agrega esa cantidad.");
                }else{
                    CantidadDeCafeActual+=input;
                }
            }
            case 2->{ // Agua
                input = Integer.parseInt(InputHandler.input(Types.ENTERO_NO_NEGATIVO, "Ingrese la cantidad de agua a añadir: "));
                if((CantidadDeAguaActual + input) > MaximaCantidadAgua){
                    System.out.println("La cafetera estara rebosada si se agrega esa cantidad.");
                }else{
                    CantidadDeAguaActual+= input;
                }
            } 
            case 3->{ // Azucar
                input = Integer.parseInt(InputHandler.input(Types.ENTERO_NO_NEGATIVO, "Ingrese la cantidad de azucar a añadir: "));
                if((CantidadDeAzucarActual + input) > MaximaCantidadAzucar){
                    System.out.println("La cafetera estara rebosada si se agrega esa cantidad.");
                }else{
                    CantidadDeAzucarActual+= input;
                }
            }
            default->{}
        }
    }

    public void vaciarCafetera(){
        CantidadDeAguaActual = 0;
        CantidadDeAzucarActual = 0;
        CantidadDeCafeActual = 0;
        System.out.println("*----------------------------------------*");
        System.out.println("*La cafetera se ha vaciado correctamente.*");
        System.out.println("*----------------------------------------*");
    }

    public void generarInforme(){
        System.out.println("----------------------- INFORME -----------------------");
        System.out.println("Total de dinero ganado: " + totalVendido());
        System.out.println("Total de tazas vendidas: " + listaGeneralVasosVendidos.size());
        System.out.println("Desglose de ventas individuales: ");
        for(VasoDeCafe vaso : listaGeneralVasosVendidos){
            System.out.println("* " + vaso.getnombre() + " (" + vaso.getCantidadAgua() + "ml) : " + NumberCurrencyFormatter.format(vaso.getPrecio(), "MXN"));
        }
    }
    //#endregion

    //#region Secondary Functions
    private void listarVasos(){
        System.out.println("---------------------------------------------------");
        System.out.println("Opciones disponibles: ");
        for(int i = 0; i < VasosDeCafe.length; i++){
            System.out.println((i+1) + ".- " + VasosDeCafe[i].getnombre() + ": " + NumberCurrencyFormatter.format(VasosDeCafe[i].getPrecio(), "MXN"));
        }
    }

    private boolean sePuedePreparar(VasoDeCafe vaso){
        if(this.CantidadDeAguaActual >= vaso.getCantidadAgua() && this.CantidadDeCafeActual >= vaso.getCantidadCafe() && this.CantidadDeAzucarActual >= vaso.getCantidadAzucar()){
            return true;
        }else{
            return false;
        }
    }
    
    private void ajustarInsumos(VasoDeCafe vaso){
        this.CantidadDeAguaActual -= vaso.getCantidadAgua();
        this.CantidadDeAzucarActual -= vaso.getCantidadAzucar();
        this.CantidadDeCafeActual -= vaso.getCantidadCafe();
    }

    private void checkout(float totalAPagar) throws IOException{
        System.out.println("----------- Checkout -----------");
        System.out.println("Total de vasos servidos: " + compraActual.size());
        System.out.println("Detalles: ");
        for(VasoDeCafe vaso : compraActual){
            System.out.println("* " + vaso.getnombre() + ": " + NumberCurrencyFormatter.format(vaso.getPrecio(), "MXN"));
        }
        System.out.println("Su total a pagar es: " + NumberCurrencyFormatter.format(totalAPagar, "MXN"));
        float pago = Float.parseFloat(InputHandler.input(InputHandler.Types.FLOTANTE_NO_NEGATIVO, "Ingrese la cantidad con la que se pagara: "));
        
        while(pago < totalAPagar){
            System.out.println("El pago recibido no es suficiente. Faltan " + NumberCurrencyFormatter.format((totalAPagar - pago), "MXN"));
            pago = Float.parseFloat(InputHandler.input(InputHandler.Types.FLOTANTE_NO_NEGATIVO, "Ingrese la cantidad con la que se pagara: "));
        }

        float Cambio = pago - totalAPagar;
        int mDiez = 0, mCinco = 0, mDos = 0, mUno = 0, mCincCent;
        if(Cambio != 0.0f){
            mDiez = (int)(Cambio / 10);
            Cambio = (float)(Cambio - (mDiez * 10));
            mCinco = (int)(Cambio / 5);
            Cambio-= (float)(mCinco * 5);
            mDos = (int)(Cambio / 2);
            Cambio -= (float)(mDos * 2);
            mUno = (int)(Cambio / 1);
            Cambio -= (float)mUno;
            mCincCent = (int)(Cambio / 0.5);
            Cambio -= (float)(mCincCent * 0.5);
            System.out.println("Se hace entrega su cambio con las siguientes monedas: ");
            System.out.println("$10  -> " + mDiez);
            System.out.println("$5   -> " + mCinco);
            System.out.println("$2   -> " + mDos);
            System.out.println("$1   -> " + mUno);
            System.out.println("$50c -> " + mCincCent);
            System.out.println("------------ Gracias por su compra! ------------");
        }else{
            System.out.println("------------ Gracias por su compra! ------------");
        }
        compraActual.clear();
    }

    private float totalVendido(){
        float total = 0.0f;
        for(VasoDeCafe vaso : listaGeneralVasosVendidos){
            total+= vaso.getPrecio();
        }
        return total;
    }
    //#endregion
}