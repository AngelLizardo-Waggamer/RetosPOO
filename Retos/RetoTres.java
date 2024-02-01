package Retos;

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
    public static void exec(){
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
        private String[] palabras = new String[10];
        private String[] significados = new String[10];

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
         *  listarPalabras() func. prints all the words registered in the Dictionary.
         */
        private void listarPalabras(){
            System.out.println("Palabras disponibles: ");
            for(String palabra : palabras){ // * Apply a for-each structure to print all the values of the "palabras" String Array
                System.out.println("* " + palabra + ".");
            }
            System.out.println("-------------------");
        }
        /**
         *  seleccionarOpcion() func. shows the menu and takes the user input for the option.
         * @return option selected by the user as a {@code char}
         */
        private char seleccionarOpcion(){
            System.out.println("Opciones disponibles:\nA. Enlistar palabras del diccionario\nB. Buscar palabras en el diccionario\nC. Detalles del diccionario\nS. Salir"); // * Show the menu
            return entrada.next().charAt(0); // * Return the first character in the input
        }
        /**
         *  buscar() func. looks for a user-specified word in the dictionary and prints its meaning. If the word is not in the dictionary, it will tell the user
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
         *  imprimirDetalles() func. prints: 
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
        private int filas, columnas;
        public void start(){
            System.out.println("------ CONTADOR DE NUMEROS PARES/IMPARES v1.0 ------");
        }
    }
}
