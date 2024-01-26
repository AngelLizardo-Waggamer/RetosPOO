package Retos;
import java.io.IOException;
import java.util.Formatter;
import java.util.Scanner;

public class RetoUno {

    public static void exec() throws IOException{
        Scanner entrada = new Scanner(System.in);
        float peso, estatura;
        int edad;
        char sexo;

        System.out.println("Ingrese una opción: \nA. Cálculo de IMC \nB. Cálculo de masa corporal magra \nC. Cálculo de metabolismo basal (GEB)");
        switch (entrada.nextLine().charAt(0)) {
            case 'A'->{
                Formatter IMC = new Formatter();
                // Ingreso de datos
                System.out.println("Ingrese su peso (en kg): ");
                peso = entrada.nextFloat();
                System.out.println("Ingrese su estatura (en cm): ");
                estatura = entrada.nextFloat();
                // Cálculo de IMC y mandar respuesta
                IMC.format("%.2f", persona.calcularIMC(peso, estatura));
                System.out.println("Su IMC es de " + IMC + ". Se encuentra en la categoria de: " + persona.clasificacionIMC(Float.parseFloat(IMC.toString())));
                IMC.close();
            }
            case 'B'->{
                Formatter MCM = new Formatter();
                //persona.calcularMCM(peso, estatura, sexo);
                // Ingreso de datos
                System.out.println("Ingrese su peso (en kg): ");
                peso = entrada.nextFloat();
                System.out.println("Ingrese su estatura (en cm): ");
                estatura = entrada.nextFloat();
                System.out.println("Ingrese su sexo: ");
                sexo = entrada.next().charAt(0);
                //Calcular indice e imprimirlo
                MCM.format("%.2f", persona.calcularMCM(peso, estatura, sexo));
                System.out.println("Su indice de masa corporal magra es de " + MCM + "kg");
                MCM.close();
            }
            case 'C'->{
                //persona.calcularGEB(peso, estatura, edad, sexo)
                Formatter GEB = new Formatter();
                //Ingreso de datos
                System.out.println("Ingrese su peso (en kg): ");
                peso = entrada.nextFloat();
                System.out.println("Ingrese su estatura (en cm): ");
                estatura = entrada.nextFloat();
                System.out.println("Ingrese su edad: ");
                edad = entrada.nextInt();
                System.out.println("Ingrese su sexo: ");
                sexo = entrada.next().charAt(0);
                //Calculo de GEB e imprimirlo
                GEB.format("%.2f", persona.calcularGEB(peso, estatura, edad, sexo));
                System.out.println("Su gasto energético basal es de " + GEB + " calorias.");
                GEB.close();
            }
        }
        entrada.close();
    }

    private class persona{
        public static float calcularIMC(float peso_kg, float estatura_cm){
            return (float)(peso_kg / Math.pow((estatura_cm / 100), 2));
        }
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
        public static float calcularMCM(float peso, float estatura, char sexo){
            if (sexo == 'M'){
                return (float)((1.1 * peso) - (128 * (Math.pow(peso, 2) / Math.pow(estatura, 2))));
            }else{
                return (float)((1.07 * peso) - (148 * (Math.pow(peso, 2) / Math.pow(estatura, 2))));
            }
        }
        public static float calcularGEB(float peso, float estatura, int edad, char sexo){
            if(sexo == 'M'){
                return (float)(66.5 + (13.75 * peso) + (5.003 * estatura) - (6.775 * edad));
            }else{
                return (float)(655.1 + (9.563 * peso) + (1.85 * estatura) - (4.676 * edad));
            }
        }
    }
}