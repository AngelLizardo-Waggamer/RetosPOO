package Retos;

import java.io.IOException;
import java.util.Formatter;
import java.util.Scanner;

public class RetoDos {
    private static Scanner entrada;
    public static void exec() throws IOException{
        entrada = new Scanner(System.in);
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
                RetoDos rtd = new RetoDos();
                PuntoDeVenta programa = rtd.new PuntoDeVenta("admin", "admin");
                programa.start();
            }
        }
        entrada.close();
    }

    private class PuntoDeVenta{
        private String adminUsername, adminPassword;
        private int numVentas, numCompras, operacionesTotales;
        float balance, ingresosTotales, egresosTotales;

        public PuntoDeVenta(String user, String pass){
            this.adminUsername = user;
            this.adminPassword = pass;
            this.balance = 0;
            this.ingresosTotales = 0;
            this.egresosTotales = 0;
        }
        public void start(){
            System.out.println("---- PUNTO DE VENTA v1.0 \"Venta de cajas\" ----");
            iniciarSesion();
            int opt = 0;
            while(opt != 4){
                opt = obtenerOpcion();
                switch(opt){
                    case 1->{
                        int nCajas;
                        float costoCajas;
                        // Ingreso de datos
                        System.out.println("¿Cuantas cajas se van a comprar?: ");
                        nCajas = entrada.nextInt();
                        System.out.println("Costo por pieza: ");
                        costoCajas = entrada.nextFloat();
                        // Calculo de monto y salida de datos
                        System.out.println("La compra realizada por " + nCajas + " cajas al costo de $" + costoCajas + " es igual a $" + compra(nCajas, costoCajas));
                    }
                    case 2->{
                        // Vender cajas de papel
                        int nCajas;
                        float precioCajas;
                        //Ingreso de datos
                        System.out.println("¿Cuantas cajas se van a vender?");
                        nCajas = entrada.nextInt();
                        System.out.println("Costo por pieza: ");
                        precioCajas = entrada.nextFloat();
                        // Calculo de monto y salida de datos
                        System.out.println("La venta realizada por " + nCajas + " cajas al precio de $" + precioCajas + " es igual a $" + venta(nCajas, precioCajas));
                    }
                    case 3->{
                        // Mostrar Reporte
                        System.out.println("--- REPORTE GENERAL ---");
                        System.out.println("Balance: " + imprimirBalance(balance));
                        System.out.println("Numero de ventas totales: " + numVentas);
                        System.out.println("Numero de compras totales: " + numCompras);
                        System.out.println("Ingresos totales: $" + ingresosTotales);
                        System.out.println("Egresos totales: $" + egresosTotales);
                    }
                    case 4->{
                        //Salir
                        System.out.println("----------------------");
                        System.out.println("Balance final: " + imprimirBalance(balance));
                        System.out.println("Numero de ventas totales: " + numVentas);
                        System.out.println("Numero de compras totales: " + numCompras);
                        System.out.println("Operaciones totales: " + operacionesTotales);
                        System.out.println("Ingresos totales: $" + ingresosTotales);
                        System.out.println("Egresos totales: $" + egresosTotales);
                        System.out.println("--- ¡GRACIAS POR SU CONFIANZA! ---");
                    }
                    default->{
                        System.out.println("Inserte una opcion valida");
                    }
                }
            }
        }
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
        private int obtenerOpcion(){
            System.out.println("----------------------");
            System.out.println("¿Que desea hacer?\n1. Comprar cajas\n2. Vender cajas\n3. Mostrar reporte \n4. Salir del programa");
            int res;
            res = entrada.nextInt();
            return res;
        }
        private float compra(int cantCajas, float costCajas){
            float res = (float)(costCajas * cantCajas);
            numCompras++;
            operacionesTotales++;
            egresosTotales += res;
            balance -= res;
            return res;
        }
        private float venta(int cantCajas, float precioCajas){
            float res = (float)(cantCajas * precioCajas);
            numVentas++;
            operacionesTotales++;
            ingresosTotales += res;
            balance += res;
            return res;
        }
        private String imprimirBalance(float cantidad){
            if(cantidad<0){
                return (String)("-$"+Math.abs(cantidad));
            }else{
                return (String)("$"+Math.abs(cantidad));
            }
        }
    }
}