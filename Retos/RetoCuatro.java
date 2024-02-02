package Retos;

import java.util.ArrayList;
import java.util.Scanner;

public class RetoCuatro {
    private static Scanner entrada = new Scanner(System.in);
    public static void exec(){
        RetoCuatro r = new RetoCuatro();
        ProgramaVentaBoletos programa = r.new ProgramaVentaBoletos();
        programa.start();
        entrada.close();
    }

    private class ProgramaVentaBoletos{
        private float totalVentas;
        private ArrayList<String[]> pasajeros = new ArrayList<String[]>();
        private ArrayList<String[]> ventas = new ArrayList<String[]>();
        
        /**
         * Estructura del array Ventas
         * { {pasPrin, ad1, ad2, ..., adx}{importe},
         *   {pasPrin, ad1, ad2, ..., adx}{importe} 
         * }
         */

        public ProgramaVentaBoletos(){
            this.totalVentas = 0.0f;
        }

        public void start(){

        }
    }
}
