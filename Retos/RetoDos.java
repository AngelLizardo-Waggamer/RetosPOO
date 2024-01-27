package Retos;

import java.util.Formatter;
import java.util.Scanner;

public class RetoDos {
    public static void exec() {
        Scanner entrada = new Scanner(System.in);

        System.out.println("Elija una de las siguientes opciones:\n1. Calculadora de promedio final\n2. Programa de venta de cajas");
        switch(entrada.nextInt()){
            case 1->{
                int nCal;
                float promedio = 0;
                Formatter promFinal = new Formatter();
                // entrada de datos
                System.out.println("¿Cuantas calificaciones desea promediar?: ");
                nCal = entrada.nextInt();
                // Ingreso de calificaciones
                for(int i = 1; i <= nCal; i++){
                    System.out.println("Ingrese la calificacion #" + i + ": ");
                    promedio += entrada.nextFloat();
                }
                // Calculo de promedio y formato del resultado
                promedio /= nCal;
                promFinal.format("%.1f", promedio);
                // Salida de datos
                System.out.println("El promedio final del alumno es de: " + promFinal.toString());
                promFinal.close();
            }
            case 2->{
                
            }
        }
        
        entrada.close();
    }

    //private class puntoDeVentaCajas{
        
    //}
}