package Retos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import Retos.Utils.Cafetera;

public class RetoSiete {
    private static BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

    public static void exec() throws IOException{
        // Inicialización de cafetera
        Cafetera maquina = new Cafetera(3000,2000,2000);
        int opt = 0;
        System.out.println("----- Bienvenido al cafe Bauzesty -----");
        do{
            menu();
            opt = Integer.parseInt(entrada.readLine()); // 0 <= opt <= 5
            switch(opt){
                case 1->{ // Venta normal
                    maquina.realizarVenta();
                }
                case 2->{ // Niveles de insumos
                    maquina.checarNiveles();
                }
                case 3->{ // Agregar insumos
                    maquina.agregarInsumos();
                }
                case 4->{ // Vaciar cafetera
                    maquina.vaciarCafetera();
                }
                case 5->{ // salir
                    maquina.generarInforme();
                    System.out.println("------------ Gracias por comprar en el cafe Bauzesty ------------");
                }
                default->{
                    System.out.println("Ingrese una opcion valida.");
                }
            }
        }while(opt!=5);
    }

    private static void menu(){
        System.out.println("Ingrese una opcion: ");
        System.out.println("1. Venta normal");
        System.out.println("2. Consultar nivel de insumos de la cafetera");
        System.out.println("3. Agregar insumos a la cafetera");
        System.out.println("4. Vaciar cafetera");
        System.out.println("5. Salir");
    }
}
