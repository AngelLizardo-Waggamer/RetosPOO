/*
 * Author: @angl.liz
 * Github: @AngelLizardo-Waggamer
 * 
 * This Challenge has inside of it two programs: 
 * 1. A mean calculator for school grades.
 * 2. A management system for a store that buys/sells boxes.
 */

package Retos;

import java.io.IOException;
import java.util.Formatter;
import java.util.Scanner;

public class RetoDos {
    // ! Scanner is declared as a static variable because it needs to be closed in one point of the code, and closing it before ending a complete cycle of execution can lead to errors.
    private static Scanner entrada;
    // ! Main method exec()
    public static void exec() throws IOException{
        entrada = new Scanner(System.in);
        // * Option input to execute the desired program. Possible options: {1, 2}
        System.out.println("Elija una de las siguientes opciones:\n1. Calculadora de promedio final\n2. Programa de venta de cajas");
        switch(entrada.nextInt()){
            case 1->{ // * Case 1
                // * Init the temporal variables
                int nCal;
                float promedio = 0;
                Formatter promFinal = new Formatter(); // * Init a Formatter object to give format to the result of the operation.
                //* Data input
                System.out.println("¿Cuantas calificaciones desea promediar?: ");
                nCal = entrada.nextInt();
                //* Grades input. The number of grades that you need to introduce is determined by the user.
                for(int i = 1; i <= nCal; i++){
                    System.out.println("Ingrese la calificacion #" + i + ": ");
                    promedio += entrada.nextFloat();
                }
                //* Calculate the mean and give format to it.
                promedio /= nCal;
                promFinal.format("%.1f", promedio);
                //* Result output
                System.out.println("El promedio final del alumno es de: " + promFinal.toString());
                promFinal.close(); // ! Formatter object closing func.
            }
            case 2->{ // * Case 2
                // ! Since we are using a private class inside the public class "RetoDos" we need to declare a RetoDos object and then declaree a PuntoDeVenta object. 
                RetoDos rtd = new RetoDos();
                PuntoDeVenta programa = rtd.new PuntoDeVenta("admin", "admin");
                programa.start();
            }
        }
        entrada.close();
    }

    private class PuntoDeVenta{
        // ! Variables need to stay private because of safety good practices, most of this values do not need to be accesible.
        private String adminUsername, adminPassword;
        private int numVentas, numCompras, operacionesTotales;
        private float balance, ingresosTotales, egresosTotales;

        public PuntoDeVenta(String user, String pass){ // * Class constructor, in other words, the initializer function for any PuntoDeVenta object.
            // * Initialize the admin user and password, and also set a value of zero to some numeric variables.
            this.adminUsername = user;
            this.adminPassword = pass;
            this.balance = 0;
            this.ingresosTotales = 0;
            this.egresosTotales = 0;
        }
        // ! Main method for the class start()
        public void start(){
            System.out.println("---- PUNTO DE VENTA v1.0 \"Venta de cajas\" ----");
            iniciarSesion(); //* The first step in the program is to validate that the user is an authorized administrator
            int opt = 0; 
            while(opt != 4){ //* The menu needs to show up 'n' times until user specifies the option 4, which is end the program.
                opt = obtenerOpcion(); //* We show the menu of options everytime we need to know which option the user wants to execute.
                switch(opt){ // * Possible opt values {1, 2, 3, 4}
                    case 1->{ // ! Case 1: Buy boxes
                        int nCajas;
                        float costoCajas;
                        //* Data input
                        System.out.println("¿Cuantas cajas se van a comprar?: ");
                        nCajas = entrada.nextInt();
                        System.out.println("Costo por pieza: ");
                        costoCajas = entrada.nextFloat();
                        //* Result output
                        System.out.println("La compra realizada por " + nCajas + " cajas al costo de $" + costoCajas + " es igual a $" + compra(nCajas, costoCajas));
                    }
                    case 2->{ // ! Case 2: Sell boxes
                        int nCajas;
                        float precioCajas;
                        //* Data input
                        System.out.println("¿Cuantas cajas se van a vender?");
                        nCajas = entrada.nextInt();
                        System.out.println("Costo por pieza: ");
                        precioCajas = entrada.nextFloat();
                        //* Result output
                        System.out.println("La venta realizada por " + nCajas + " cajas al precio de $" + precioCajas + " es igual a $" + venta(nCajas, precioCajas));
                    }
                    case 3->{ // ! Case 3: General report
                        System.out.println("--- REPORTE GENERAL ---");
                        System.out.println("Balance: " + imprimirBalance(balance));
                        System.out.println("Numero de ventas totales: " + numVentas);
                        System.out.println("Numero de compras totales: " + numCompras);
                        System.out.println("Ingresos totales: $" + ingresosTotales);
                        System.out.println("Egresos totales: $" + egresosTotales);
                    }
                    case 4->{ // ! Case 4: Exit the program
                        System.out.println("----------------------");
                        System.out.println("Balance final: " + imprimirBalance(balance));
                        System.out.println("Numero de ventas totales: " + numVentas);
                        System.out.println("Numero de compras totales: " + numCompras);
                        System.out.println("Operaciones totales: " + operacionesTotales);
                        System.out.println("Ingresos totales: $" + ingresosTotales);
                        System.out.println("Egresos totales: $" + egresosTotales);
                        System.out.println("--- ¡GRACIAS POR SU CONFIANZA! ---");
                    }
                    default->{ // ! Default case: No valid option was given
                        System.out.println("Inserte una opcion valida");
                    }
                }
            }
        }
        /**
         * * Validates if the user is authorized to use the program by asking an administrator user and password. 
         * * The program will not start if the given username and password are not the correct ones.
         *  
         */
        private void iniciarSesion(){
            String tempUser = ".";
            String tempPass = ".";
            while(tempUser.equals(this.adminUsername) == false && tempPass.equals(this.adminPassword) == false){
                System.out.println("Usuario: ");
                tempUser = entrada.next();
                System.out.println("Contrasenia: ");
                tempPass = entrada.next();
                if(tempUser.equals(this.adminUsername) == true && tempPass.equals(this.adminPassword) == true){
                    System.out.println("Se ha iniciado sesion correctamente.");
                    break;
                }else{
                    System.out.println("Los datos introducidos son incorrectos. Intente de nuevo.");
                }
            }
        }
        /**
         * Prints a menu with the possible options and asks the user for an Integer input which is later returned.
         * @return option chosen by the user as an Integer
         */
        private int obtenerOpcion(){
            System.out.println("----------------------");
            System.out.println("¿Que desea hacer?\n1. Comprar cajas\n2. Vender cajas\n3. Mostrar reporte \n4. Salir del programa");
            int res;
            res = entrada.nextInt();
            return res;
        }
        /**
         * Calculates the amount of money spent in buying 'n' number of boxes at 'm' cost.
         * @param cantCajas the quantity of boxes that you are going to buy
         * @param costCajas the cost of each box
         * @return total cost of the buying as a float
         */
        private float compra(int cantCajas, float costCajas){
            float res = (float)(costCajas * cantCajas);
            numCompras++;
            operacionesTotales++;
            egresosTotales += res;
            balance -= res;
            return res;
        }
        /**
         * * Calculates the amount of money earned by selling 'n' number of boxes at 'm' cost
         * @param cantCajas the quantity of boxes that you are going to buy
         * @param precioCajas the price of each box
         * @return total earned money of the selling as a float
         */
        private float venta(int cantCajas, float precioCajas){
            float res = (float)(cantCajas * precioCajas);
            numVentas++;
            operacionesTotales++;
            ingresosTotales += res;
            balance += res;
            return res;
        }
        /**
         * * Prints in a correct way negative quantities of money with the '$' sign.
         * @param cantidad the quantity of money that you want to print
         * @return a String that can or cannot have a negative sign at the start depending of the given params.
         */
        private String imprimirBalance(float cantidad){
            if(cantidad<0){
                return (String)("-$"+Math.abs(cantidad));
            }else{
                return (String)("$"+Math.abs(cantidad));
            }
        }
    }
}