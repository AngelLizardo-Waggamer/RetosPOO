/*
 * Author: @angl.liz
 * Github: @AngelLizardo-Waggamer
 * 
 * This file is for the Challenge 1 of the POO subject.
 * Basically, this is an IMC, MCM and GEB calculator.
 */

package Retos;
import java.io.IOException;
import java.util.Formatter;
import java.util.Scanner;

public class RetoUno {
    // ! Main method exec()
    public static void exec() throws IOException{
        Scanner entrada = new Scanner(System.in);
        float peso, estatura;
        int edad;
        char sexo;

        // * Option input as a char being the possible options {'A', 'B', 'C'}
        System.out.println("Ingrese una opción: \nA. Cálculo de IMC \nB. Cálculo de masa corporal magra \nC. Cálculo de metabolismo basal (GEB)");
        switch (entrada.nextLine().charAt(0)) {
            case 'A'->{ // * Case 'A'
                Formatter IMC = new Formatter(); // * Formatter object init
                // * Data input
                System.out.println("Ingrese su peso (en kg): ");
                peso = entrada.nextFloat();
                System.out.println("Ingrese su estatura (en cm): ");
                estatura = entrada.nextFloat();
                // * Calculate IMC and give format with Formatter class to have 2 decimals.
                IMC.format("%.2f", persona.calcularIMC(peso, estatura)); // * First parameter of this function is a format, '%' is all the number that is not a decimal & '2f' means two floating decimals. 
                System.out.println("Su IMC es de " + IMC + ". Se encuentra en la categoria de: " + persona.clasificacionIMC(Float.parseFloat(IMC.toString()))); // * IMC is a Formatter object, println() func. converts it to String but any other function doesn't
                IMC.close(); // ! Important to note that you need to close the Formatter object you used after you printed it.
            }
            case 'B'->{ // * Case 'B'
                Formatter MCM = new Formatter(); // * Formatter object init
                // * Data input
                System.out.println("Ingrese su peso (en kg): ");
                peso = entrada.nextFloat();
                System.out.println("Ingrese su estatura (en cm): ");
                estatura = entrada.nextFloat();
                System.out.println("Ingrese su sexo (M/F): ");
                sexo = entrada.next().charAt(0);
                // * Calculate MCM and five format with Formatter class to have 2 decimals. 
                MCM.format("%.2f", persona.calcularMCM(peso, estatura, sexo));
                System.out.println("Su indice de masa corporal magra es de " + MCM + "kg");
                MCM.close(); // ! Formatter object closing func.
            }
            case 'C'->{ // * Case 'C'
                //persona.calcularGEB(peso, estatura, edad, sexo)
                Formatter GEB = new Formatter(); // * Formatter object init
                //* Data input
                System.out.println("Ingrese su peso (en kg): ");
                peso = entrada.nextFloat();
                System.out.println("Ingrese su estatura (en cm): ");
                estatura = entrada.nextFloat();
                System.out.println("Ingrese su edad: ");
                edad = entrada.nextInt();
                System.out.println("Ingrese su sexo (M/F): ");
                sexo = entrada.next().charAt(0);
                //* Calculate GEB and give format with Formatter class to have 2 decimals.
                GEB.format("%.2f", persona.calcularGEB(peso, estatura, edad, sexo));
                System.out.println("Su gasto energético basal es de " + GEB + " calorias.");
                GEB.close(); // ! Formatter object closing func.
            }
        }
        entrada.close();
    }

    private class persona{
        /**
         * * calcularIMC() function calculates the IMC based in the weight and the height of a person.
         * @param peso_kg weight of the person in kilograms.
         * @param estatura_cm height of the person in centimeters, inside the function is converted to meters.
         * @return "Indice de masa corporal".
         */
        public static float calcularIMC(float peso_kg, float estatura_cm){
            return (float)(peso_kg / Math.pow((estatura_cm / 100), 2));
        }
        /**
         * * clasificacionIMC() function classifies an IMC value to return in which category is the person evaluated.
         * @param IMC Coporal Mass Index of a person.
         * @return a message that specifies in which category the person is based in their CMI.
         */
        public static String clasificacionIMC(float IMC){
            if(IMC <= 18.9){
                return "Peso bajo";
            }else if (IMC >= 19.0 && IMC <= 24.99 ){
                return "Peso normal";
            }else if (IMC >= 25.0 && IMC <= 29.99 ){
                return "Sobrepeso";
            }else if (IMC >= 30.0 && IMC <= 34.99 ){
                return "Obesidad leve";
            }else if (IMC >= 35.0 && IMC <= 39.99 ){
                return "Obesidad media";
            }else{
                return "Obesidad mórbida";
            }
        }
        /**
         * * calcularMCM() function calculates the MCM based in the formula specified in Canvas
         * @param peso weight of the person in kilograms.
         * @param estatura height of the person in centimeters.
         * @param sexo sex of the person evaluated.
         * @return "Masa corporal magra" in kilograms.
         */
        public static float calcularMCM(float peso, float estatura, char sexo){
            if (sexo == 'M'){
                return (float)((1.1 * peso) - (128 * (Math.pow(peso, 2) / Math.pow(estatura, 2))));
            }else{
                return (float)((1.07 * peso) - (148 * (Math.pow(peso, 2) / Math.pow(estatura, 2))));
            }
        }
        /**
         * * calcularGEB() function calculares the GEB bsed in the formula of Harris-Benedict
         * @param peso weight of the person in kilograms.
         * @param estatura height of the person in centimeters.
         * @param edad age of the person in years
         * @param sexo sex of the person evaluated.
         * @return "Gasto Energetico Basal" in calories
         */
        public static float calcularGEB(float peso, float estatura, int edad, char sexo){
            if(sexo == 'M'){
                return (float)(66.5 + (13.75 * peso) + (5.003 * estatura) - (6.775 * edad));
            }else{
                return (float)(655.1 + (9.563 * peso) + (1.85 * estatura) - (4.676 * edad));
            }
        }
    }
}