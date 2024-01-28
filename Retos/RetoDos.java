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
        private String adminUsername;
        private String adminPassword;

        public PuntoDeVenta(String user, String pass){
            this.adminUsername = user;
            this.adminPassword = pass;
        }
        public void start(){
            System.out.println("---- PUNTO DE VENTA v1.0 \"Venta de cajas\" ----");
            iniciarSesion();
            int opt = obtenerOpcion();
            while(opt != 4){
                switch(opt){
                    case 1->{
                        // Comprar cajas de papel
                    }
                    case 2->{
                        // Vender cajas de papel
                    }
                    case 3->{
                        // Mostrar Reporte
                    }
                    case 4->{
                        //Salir
                        System.out.println("--- FIN DEL PROGRAMA ---");
                    }
                    default->{
                        System.out.println("Inserte una opcion valida");
                    }
                }
            }
            System.out.println("--- FIN DEL PROGRAMA ---");
        }
        public void iniciarSesion(){
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
        public int obtenerOpcion(){
            System.out.println("¿Que desea hacer?\n1. Comprar cajas\n2. Vender cajas\n3. Mostrar reporte \n4. Salir del programa");
            int res;
            res = entrada.nextInt();
            return res;
        }
    }
}