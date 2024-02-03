/**
 * * Author: @angl.liz
 * * Github: @AngelLizardo-Waggamer
 * 
 * * The main objective of this challenge is to create a program to register the passengers and the sells of a tourism agency.
 */

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

        public ProgramaVentaBoletos(){
            this.totalVentas = 0.0f;
        }

        public void start(){

        }
    }
}
