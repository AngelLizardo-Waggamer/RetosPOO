package Retos;

import java.util.Scanner;

public class RetoTres {
    // * By declaring the variables at the top and as static values we can access them in every part of the "RetoTres" class, but the private word restricts the external access of them.
    private static String[] words = new String[]{"Letra", "Abrazo", "Tarea", "Ingeniero", "Computadora", "Cielo", "Universidad", "Internet", "Verdura", "Fruta"};
    private static String[] meangs = new String[]{};
    private static Scanner entrada;
    // ! Main method exec()
    public static void exec(){
        entrada = new Scanner(System.in);
        RetoTres mnCl = new RetoTres();
        // * Option input. Possible values {1, 2}
        System.out.println("¿Que desea ejecutar? \n1. Diccionario\n2. Juego de numeros");
        switch(entrada.nextInt()){
            case 1->{
                Diccionario Dict = mnCl.new Diccionario(words, meangs); // * As it was mentioned, the classes can only be accessed by creating a "RetoTres" object previously.
                Diccionario.start();
            }
            case 2->{
                juegoNumeros jN = mnCl.new juegoNumeros();
                juegoNumeros.start();
            }
        }

        entrada.close();
    }

    private class Diccionario{
        private String[] palabras = new String[10];
        private String[] significados = new String[10];

        public Diccionario(String[] words, String[] meanings){ // ! Class constructor
            this.palabras = words;
            this.significados = meanings;
        }

        // ! Main method of Diccionario start()
        public static void start(){
            char opt = 'I';
            while(opt != 'S'){

            } 
        }
    }
    private class juegoNumeros{
        private int filas, columnas;
        public static void start(){

        }
    }
}
