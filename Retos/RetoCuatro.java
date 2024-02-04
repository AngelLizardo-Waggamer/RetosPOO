/**
 * * Author: @angl.liz
 * * Github: @AngelLizardo-Waggamer
 * 
 * * The main objective of this challenge is to create a program to register the passengers and the sells of a tourism agency.
 */

package Retos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class RetoCuatro {
    private static BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
    public static void exec() throws IOException{
        RetoCuatro r = new RetoCuatro();
        ProgramaVentaBoletos programa = r.new ProgramaVentaBoletos();
        programa.start();
        entrada.close();
    }

    private class ProgramaVentaBoletos{
        private float totalIngresoVentas = 0;
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
        public void start() throws IOException{
            char op = '.';
            while (op != 'S') {
                op = seleccionarOpcion();
                switch(op){
                    case 'A'->{
                        System.out.println("----------------------------------");
                        realizarVenta();
                    }
                    case 'B'->{
                        imprimirReporte();
                    }
                    case 'S'->{
                        System.out.println("---GRACIAS POR USAR EL PROGRAMA---");
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
        private char seleccionarOpcion() throws IOException{
            char op;
            System.out.println("----------------------------------");
            System.out.println("Ingrese una opcion:\nA. Realizar venta de boleto\nB. Mostrar datos de la lista de ventas\nS. Finalizar Programa");
            op = entrada.readLine().charAt(0);
            return op;
        }
        /**
         * Takes from the user the buyer's name, the ticket quantity and the name of the extra passengers.
         * Then, it prints a ticket with the collected data and the total price.
         */
        private void realizarVenta() throws IOException{
            String comprador;
            int pasajerosAdicionales;
            System.out.println("Ingrese el nombre del pasajero: ");
            comprador = entrada.readLine();
            System.out.println("Numero de pasajeros adicionales: ");
            pasajerosAdicionales = Integer.parseInt(entrada.readLine());
            if(pasajerosAdicionales != 0){
                String[] datosVenta = new String[pasajerosAdicionales + 3];
                float ingreso = 1250.5f * (pasajerosAdicionales + 1);
                datosVenta[0] = Float.toString(ingreso);
                datosVenta[1] = Integer.toString(pasajerosAdicionales);
                datosVenta[2] = comprador;
                for(int p = 3; p < datosVenta.length; p++){
                    System.out.println("Nombre del pasajero adicional #" + (p-2) + ": ");
                    datosVenta[p] = entrada.readLine();
                }
                totalIngresoVentas += ingreso;
                ventas.add(datosVenta);
                imprimirTicket(datosVenta);
            }else{
                String[] datosVenta = new String[3];
                datosVenta[0] = Float.toString(1250.5f);
                datosVenta[1] = "0";
                datosVenta[2] = comprador;
                totalIngresoVentas += 1250.5f;
                ventas.add(datosVenta);
                imprimirTicket(datosVenta);
            }
        }
        /**
         * Prints a list of all the sold tickets, the total of money earned by them and a total passenger count.
         */
        private void imprimirReporte(){
            for(int i = 0; i<ventas.size(); i++){
                System.out.println("----------------------------------");
                String[] temp = ventas.get(i);
                System.out.println("* Venta numero #" + (i + 1) + ": ");
                System.out.println("    Pasajero: " + temp[2]);
                System.out.println("    Importe: " + "$" + temp[0]);
                if(Integer.parseInt(temp[1]) != 0){
                    System.out.println("    Pasajeros adicionales: ");
                    for(int pa = 3; pa < (Integer.parseInt(temp[1]) + 3); pa++){
                        System.out.println("        * " + temp[pa]);
                    }
                }else{
                    System.out.println("    Pasajeros adicionales: N/A");
                }
            }
            System.out.println("*******************************");
            System.out.println("---> Ingresos totales: $" + totalIngresoVentas);
            System.out.println("*******************************");
        }
        /**
         * Prints a ticket that shows the name of the buyer, the name of the extra passengers and the total price.
         * @param datos {@code Array} with the generated data of the purchase.
         */
        private void imprimirTicket(String[] datos){
            System.out.println("------- TICKET DE COMPRA ---------");
            System.out.println("Pasajero: " + datos[2]);
            if(datos[1].equals("0")){
                System.out.println("Pasajeros Adicionales: N/A");
            }else{
                System.out.println("Pasajeros adicionales: ");
                for(int p = 3; p < (Integer.parseInt(datos[1]) + 3); p++){
                    System.out.println("    * " + datos[p]);
                }
            }
            System.out.println("Importe: $" + datos[0]);
        }
    }
}
