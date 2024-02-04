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
        private float totalIngresoVentas;
        private ArrayList<String[]> ventas = new ArrayList<String[]>();

        /**
         * Class constructor
         * 
         */
        public ProgramaVentaBoletos(){
            this.totalIngresoVentas = 0.0f;
        }
        /**
         * Method to start the program
         */
        public void start(){
            System.out.println("-------------------------");
            while (true) {
                switch(seleccionarOpcion()){
                    case 'A'->{
                        realizarVenta();
                    }
                    case 'B'->{
                        imprimirReporte();
                    }
                    case 'S'->{
                        System.out.println("---GRACIAS POR USAR EL PROGRAMA---");
                        break;
                    }
                    default->{
                        System.out.println("Ingresa una opcion valida.");
                    }
                }
            }
        }
        /**
         * Displays the program menu and takes user's input
         * @return {@code char} with the selected option. Possible values: {@code ['A', 'B', 'S']}
         */
        private char seleccionarOpcion(){
            char op;
            System.out.println("Ingrese una opcion:\nA. Realizar venta de boleto\nB. Mostrar datos de la lista de ventas\nS. Finalizar Programa");
            op = entrada.next().charAt(0);
            return op;
        }
        /**
         * Takes from the user the buyer's name, the ticket quantity and the name of the extra passengers.
         * Then, it prints a ticket with the collected data and the total price.
         */
        private void realizarVenta(){
            String comprador;
            int pasajerosAdicionales;
            System.out.println("Ingrese el nombre del pasajero: ");
            comprador = entrada.next();
            System.out.println("Numero de pasajeros adicionales: ");
            pasajerosAdicionales = entrada.nextInt();
            if(pasajerosAdicionales != 0){
                String[] datosVenta = new String[pasajerosAdicionales + 2];
                datosVenta[0] = Float.toString(1250.5f * (pasajerosAdicionales + 1));
                datosVenta[1] = comprador;
                for(int p = 2; p <= (pasajerosAdicionales + 2); p++){
                    System.out.println("Nombre del pasajero adicional #" + p + ": ");
                    datosVenta[p] = entrada.next();
                }
                ventas.add(datosVenta);
                System.out.println("Venta numero " + ventas.size() + " registrada exitosamente.");
            }else{
                String[] datosVenta = new String[2];
                datosVenta[0] = Float.toString(1250.5f);
                datosVenta[1] = comprador;
                ventas.add(datosVenta);
                System.out.println("Venta numero " + ventas.size() + " registrada exitosamente.");
            }
        }
        /**
         * Prints a list of all the sold tickets, the total of money earned by them and a total passenger count.
         */
        private void imprimirReporte(){
            for(int i = 0; i<ventas.size(); i++){
                String[] temp = ventas.get(i);
                System.out.println("* Venta numero #" + i + ": ");
                System.out.println("    Pasajero: " + temp[1]);
                System.out.println("    Importe: " + "$" + temp[0]);
                System.out.println("    Pasajeros adicionales: ");
            }
        }
    }
}
