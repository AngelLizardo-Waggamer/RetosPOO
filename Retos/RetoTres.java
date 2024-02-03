/**
 * * Author: @angl.liz
 * * Github: @AngelLizardo-Waggamer
 * 
 * * In this challenge the main objective is to build a Dictionary with a certain amount of words and meanings, also to 
 * * create a number "game" in which we specify the length of a number array, fill it up and calculate a bunch of things :p
 */

package Retos;

import java.io.IOException;
import java.util.Scanner;

public class RetoTres {
    // * By declaring the variables at the top and as static values we can access them in every part of the "RetoTres" class, but the private word restricts the external access of them.
    private static String[] words = new String[]{"Letra", "Abrazar", "Tarea", "Ingeniero", "Software", "Cielo", "Universidad", "Internet", "Verdura", "Fruta"};
    private static String[] meangs = new String[]{
        "Cada uno de los signos gráficos que componen el alfabeto de un idioma.", 
        "Estrechar entre los brazos en señal de cariño.",
        "Trabajo que debe hacerse en tiempo limitado.",
        "Persona con titulación universitaria superior que la capacita para ejercer la ingeniería en alguna de sus ramas.",
        "Conjunto de programas, instrucciones y reglas informáticas para ejecutar ciertas tareas en una computadora.",
        "Esfera aparente azul y diáfana que rodea la Tierra.",
        "Institución de enseñanza superior que comprende diversas facultades, y que confiere los grados académicos correspondientes.",
        "Red informática mundial, descentralizada, formada por la conexión directa entre computadoras mediante un protocolo especial de comunicación.",
        "Hortaliza, especialmente la de hojas verdes.",
        "Fruto comestible de ciertas plantas cultivadas"
    };
    private static Scanner entrada;
    // ! Main method exec()
    public static void exec() throws IOException{
        entrada = new Scanner(System.in);
        RetoTres mnCl = new RetoTres();
        // * Option input. Possible values {1, 2}
        System.out.println("¿Que desea ejecutar? \n1. Diccionario\n2. Juego de numeros");
        switch(entrada.nextInt()){
            case 1->{
                Diccionario Dict = mnCl.new Diccionario(words, meangs); // * As it was mentioned, the classes can only be accessed by creating a "RetoTres" object previously.
                Dict.start();
            }
            case 2->{
                juegoNumeros jN = mnCl.new juegoNumeros();
                jN.start();
            }
        }

        entrada.close();
    }

    private class Diccionario{
        private String[] palabras = new String[]{};
        private String[] significados = new String[]{};

        public Diccionario(String[] words, String[] meanings){ // ! Class constructor
            this.palabras = words;
            this.significados = meanings;
        }

        // ! Main method of Diccionario start()
        public void start(){
            System.out.println("------ DICCIONARIO v1.0 ------");
            char opt = 'I'; // * Default Value.
            while(opt != 'S'){  // * Possible values for {opt} = {'A', 'B', 'C', 'S'}
                opt = seleccionarOpcion();
                switch(opt){
                    case 'A'->{ // * Case 'A'.
                        listarPalabras();
                    }
                    case 'B'->{ // * Case 'B'.
                        listarPalabras();
                        System.out.println("Buscar palabra: ");
                        System.out.println(buscar(entrada.next()));
                        System.out.println("------------------------");
                    }
                    case 'C'->{ // * Case 'C'
                        imprimirDetalles();
                    }
                    case 'S'->{ // * Case 'S'
                        break;
                    }
                    default->{
                        System.out.println("Intenta de nuevo con un valor valido");
                    }
                }
            }
            System.out.println("------ ¡GRACIAS POR USAR EL PROGRAMA! ------");
        }

        /**
         *  Prints all the words registered in the Dictionary.
         */
        private void listarPalabras(){
            System.out.println("Palabras disponibles: ");
            for(String palabra : palabras){ // * Apply a for-each structure to print all the values of the "palabras" String Array
                System.out.println("* " + palabra + ".");
            }
            System.out.println("-------------------");
        }
        /**
         *  Shows the menu and takes the user input for the option.
         * @return option selected by the user as a {@code char}
         */
        private char seleccionarOpcion(){
            System.out.println("Opciones disponibles:\nA. Enlistar palabras del diccionario\nB. Buscar palabras en el diccionario\nC. Detalles del diccionario\nS. Salir"); // * Show the menu
            return entrada.next().charAt(0); // * Return the first character in the input
        }
        /**
         *  Looks for a user-specified word in the dictionary and prints its meaning. If the word is not in the dictionary, it will tell the user
         *  that the word is not registered.
         * @param palabra word to look.
         * @return a {@code String} response depending whether the word was found or not.
         */
        private String buscar(String palabra){
            String res = ""; // * This variable will come in handy to evaluate whether the word is or is not in the dictionary
            for(int i = 0; i < this.palabras.length; i++){ // * For cycle to iterate in the array to find the wanted word
                if(this.palabras[i].equals(palabra)){
                    res = palabra + ": \n" + this.significados[i]; // * If the word is found, the {res} value changes to a string of the word and the meaning
                    break;
                }
            }
            if (res != "") { // * Evaluate if the value of {res} changed, if not, the word is not in the dictionary
                return res;
            }else{
                return "La palabra no esta registrada en el diccionario.";
            }
        }
        /**
         *  Prints: 
         *  <ol> 
         *   <li>The number of available words in the dictionary</li>
         *   <li>List of words with a character count of the word and also from the meaning.</li>
         *  </ol>
         * 
         */
        private void imprimirDetalles(){
            System.out.println("Nombre: Diccionario Provisional AAHL");
            System.out.println("Numero de palabras disponibles: " + this.palabras.length);
            for(int i = 0; i < this.palabras.length; i++){
                System.out.println("* Palabra: " + this.palabras[i] + ". Caracteres: " + this.palabras[i].length() + ". Caracteres del significado: " + this.significados[i].length());
            }
        }
    }
    private class juegoNumeros{
        private int filas, columnas, arrayNumeros[][], total, sumP[], sumI[];

        // ! Main method of juegoNumeros: start()
        public void start(){
            System.out.println("------ CONTADOR DE NUMEROS PARES/IMPARES v1.0 ------");
            crearArray();
            System.out.println("-------------------------");
            imprimirArray();
            System.out.println("-------------------------");
            contarParesImpares('F');
            System.out.println("-------------------------");
            contarParesImpares('C');
            System.out.println("-------------------------");
            System.out.println("Suma total del array: " + total);
        }
        /**
         * Fills the number array. It first asks for the number of rows and columns, then it initializes the number array in the specified size.
         * The arrays used to store the sum of odd and even numbers are initialized with the size of the bigger number: rows or columns.
         * 
         */
        private void crearArray(){
            System.out.println("Ingresa el numero de filas: ");
            this.filas = entrada.nextInt();
            System.out.println("Ingresa el numero de columnas: ");
            this.columnas = entrada.nextInt();
            this.arrayNumeros = new int[this.filas][this.columnas];
            if(this.filas > this.columnas){
                this.sumP = new int[this.filas];
                this.sumI = new int[this.filas];
            }else{
                this.sumP = new int[this.columnas];
                this.sumI = new int[this.columnas];
            }
            for(int fila = 0; fila < this.filas; fila++){{ // * Store the values of the array with two for cycles.
                for(int col = 0; col < this.columnas; col++){
                    int num;
                    System.out.println("Valor en la fila " + fila + " y columna " + col + ":");
                    num = Integer.parseInt(entrada.next());
                    this.arrayNumeros[fila][col] = num;
                    this.total += num;
                    if(num%2 == 0){
                        sumP[fila] += 1;
                    }else{
                        sumI[fila] += 1;
                    }
                }
            }}
        }
        /**
         * Prints all the numbers array
         */
        private void imprimirArray(){
            System.out.println("Array resultante: ");
            String Sfila = "";
            int numT;
            for(int fila = 0; fila < this.filas; fila++){{
                Sfila += "| ";
                for(int col = 0; col < this.columnas; col++){
                    numT = this.arrayNumeros[fila][col];
                    Sfila += espaciarNum(numT) + "| ";
                }
                System.out.println(Sfila);
                Sfila = "";
            }}
        }
        /**
         * Counts the odd and even numbers of the rows and columns and prints how many are of them depending on the chosen function.
         * @param funcion {@code char} of the type of function required. {@code 'F'} for rows and {@code 'C'} for columns.
         */
        private void contarParesImpares(char funcion){
            switch(funcion){
                case 'F'->{ // * Case for rows
                    for(int nFila = 0; nFila < this.filas; nFila++){
                        System.out.println("Fila " + (nFila + 1) + " -> Pares: " + sumP[nFila] + " Impares: " + sumI[nFila]);
                        sumP[nFila] = 0;
                        sumI[nFila] = 0;
                    }
                }
                case 'C'->{ // * Case for columns
                    for(int col = 0; col < this.columnas; col++){{ // * Check all the numbers in the array and count the odd/even numbers for the columns
                        for(int fila = 0; fila < this.filas; fila++){
                            int t;
                            t = this.arrayNumeros[fila][col];
                            if(t%2 == 0){
                                sumP[col] += 1;
                            }else{
                                sumI[col] += 1;
                            }
                        }
                    }}
                    for(int nCol = 0; nCol < this.columnas; nCol++){
                        System.out.println("Columna " + (nCol + 1) + " -> Pares: " + sumP[nCol] + " Impares: " + sumI[nCol]);
                        sumP[nCol] = 0;
                        sumI[nCol] = 0;
                    }
                }
            }
        }
        /**
         * Gives to the given number a certain space format to complete the table correctly.
         * @param numero the number to give format
         * @return {@code String} with the space-formatted number
         */
        private String espaciarNum(int numero){
            String temp = Integer.toString(numero);
            switch(temp.length()){
                case 1->{
                    return temp + "  ";
                }
                case 2->{
                    return temp + " ";
                }
                default->{
                    return temp;
                }
            }
        }
    }
}