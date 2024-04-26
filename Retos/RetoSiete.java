package Retos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import Retos.Utils.Cafetera;

public class RetoSiete {
    private static BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

    public static void exec() throws IOException{
        // Inicialización de cafetera
        Cafetera maquina = new Cafetera();
        maquina.setMaximaCantidadAgua(3000);
        maquina.setMaximaCantidadAzucar(2000);
        maquina.setMaximaCantidadCafe(2000);

        int opt = 0;
        do{
            menu();
            opt = Integer.parseInt(entrada.readLine()); // 0 <= opt <= 5
            switch(opt){
                case 1->{
                    
                }
                default->{
                    System.out.println("Ingrese una opcion valida.");
                }
            }
        }while(opt!=5);
    }

    private static void menu(){
        System.out.println("----- Bienvenido al cafe Bauzesty -----");
        System.out.println("Ingrese una opcion: ");
        System.out.println("1. Venta normal");
        System.out.println("2. Consultar nivel de insumos de la cafetera");
        System.out.println("3. Agregar insumos a la cafetera");
        System.out.println("4. Vaciar cafetera");
    }
}
