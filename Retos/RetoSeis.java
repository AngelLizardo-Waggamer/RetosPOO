/**
 * * Author: @angl.liz
 * * Github: @AngelLizardo-Waggamer
 * 
 * * In this challenge we built a program that calculates the income of a group of workers. It
 * * also calculates the total of worked hours and the extra hours income.
 */
package Retos;

import java.io.IOException;
import java.util.ArrayList;

import Retos.Utils.InputHandler;
import Retos.Utils.NumberCurrencyFormatter;

/**
 * Reto seis
 */
public class RetoSeis {
    /**
     * Main function to execute RetoSeis code
     */
    public static void exec() throws IOException{
        programa.start();
    }
    /**
     * Clase donde todo el programa funciona
     */
    @SuppressWarnings("unused")
    private class programa{
        /**
         * Total de horas laboradas en general.
         */
        private static double horasNormales, horasExtras;
        private static int totalEmpleados, personasConHorasExtras;
        private static double pagoNeto, pagoNetoHorasNormales, PagoNetoHorasExtras;
        /**
         * Lista de empleados
         */
        private static ArrayList<empleado> empleados = new ArrayList<empleado>();
        private static categoriaEmpleado Gerente = new categoriaEmpleado("GE24", "Gerente", 250.0d, 150.0d);
        private static categoriaEmpleado Ventas = new categoriaEmpleado("VE24", "Empleado de ventas", 100.0d, 50.0d);
        private static categoriaEmpleado Administrador = new categoriaEmpleado("AM24", "Administrador", 180.0d, 100.0d);

        private static void start() throws IOException{
            // Registar Datos de Categorías
            
            
            

            // Preguntar el numero de empleados y registrarlos en el ArrayList empleados[]
            ingresarEmpleados();

            // Calcular los datos de la nómina
            calcularNomina();

        }

        /**
         * Pregunta el numero de empleados y dimensiona el array empleados
         * @throws IOException because an user input is asked
         */
        private static void ingresarEmpleados() throws IOException{
            totalEmpleados = Integer.parseInt(InputHandler.input(InputHandler.Types.ENTERO_NO_NEGATIVO, "Ingrese el numero de empleados a registrar: "));
            for(int i = 0; i < totalEmpleados; i++){
                String nombre = InputHandler.input(InputHandler.Types.STRING_NO_VACIO, "Ingresa el nombre del empleado: ");
                String telefono = InputHandler.input(InputHandler.Types.STRING_NO_VACIO, "Ingresa el telefono del empleado: ");
                float horasTrabajadas = Float.parseFloat(InputHandler.input(InputHandler.Types.FLOTANTE_NO_NEGATIVO, "Ingresa las horas trabajadas por el empleado: "));
                float horasExtraTrabajadas = Float.parseFloat(InputHandler.input(InputHandler.Types.FLOTANTE_NO_NEGATIVO, "Ingresa las horas extra trabajadas por el empleado: "));
                categoriaEmpleado categoria = switch(InputHandler.input(InputHandler.Types.STRING_NO_VACIO, "Ingrese la clave de categoria del empleado: ")){
                    case "GE24"->{
                        yield Gerente;
                    }
                    case "VE24"->{
                        yield Ventas;
                    }
                    case "AM24"->{
                        yield Administrador;
                    }
                    default->{
                        yield Ventas;
                    }
                };
                System.out.println(categoria.getClave());
                empleado em = new empleado(nombre, telefono, horasTrabajadas, horasExtraTrabajadas, categoria);
                empleados.add(em);
            }
        }

        private static void calcularNomina(){
            System.out.println("----- Reporte de nomina -----");
            System.out.println("CANTIDAD DE EMPLEADOS: " + totalEmpleados);
            System.out.println("Datos de los empleados: ");
            for(int e = 0; e < empleados.size(); e++){
                empleado emp = empleados.get(e);
                double pagoHorasNormales, pagoHorasExtras;
                System.out.println((e + 1) + ".- " + emp.getNombre() + " - Categoria: " + emp.getCategoria().getNombre());
                System.out.println("    Sueldo base: " + NumberCurrencyFormatter.format(emp.getCategoria().getSueldoBase(), "MXN"));
                System.out.println("    Horas trabajadas: " + emp.getHorasTrabajadas());
                System.out.println("    Horas extras: " + emp.getHorasExtraTrabajadas());
                horasNormales+=emp.getHorasTrabajadas();
                horasExtras+=emp.getHorasExtraTrabajadas();
                if(emp.getHorasExtraTrabajadas()>0.0d){
                    personasConHorasExtras+=1;
                }
                pagoHorasNormales = emp.getHorasTrabajadas() * emp.getCategoria().getSueldoBase();
                pagoHorasExtras = emp.getHorasExtraTrabajadas() * emp.getCategoria().getBonoHorasExtra();
                System.out.println("    Pago neto: " + NumberCurrencyFormatter.format((pagoHorasNormales + pagoHorasExtras), "MXN"));
                PagoNetoHorasExtras+= pagoHorasExtras;
                pagoNetoHorasNormales+= pagoHorasNormales;
                pagoNeto+= pagoHorasExtras + pagoHorasNormales;

            }
            System.out.println("----------------------------------");
            System.out.println("Pago total: " + NumberCurrencyFormatter.format(pagoNeto, "MXN"));
            System.out.println("Pago total de horas normales: " + NumberCurrencyFormatter.format(pagoNetoHorasNormales, "MXN"));
            System.out.println("Pago total de horas extras: " + NumberCurrencyFormatter.format(PagoNetoHorasExtras, "MXN"));
            System.out.println("Total de horas normales laboradas: " + horasNormales);
            System.out.println("Total de empleados c/horas extras: " + personasConHorasExtras);
            System.out.println("Total de empleados s/horas extras: " + (empleados.size()-personasConHorasExtras));
            System.out.println("Total de horas extras: " + horasExtras);
            System.out.println("------- Fin del programa -------");
        }
        /**
         * Clase para generar los empleados
         */
        private static class empleado{
            private String nombre, telefono;
            private float horasTrabajadas, horasExtraTrabajadas;
            private categoriaEmpleado categoria;

            public empleado(String nombre, String telefono, float horasTrabajadas, float horasExtraTrabajadas, categoriaEmpleado categoria){
                this.nombre = nombre;
                this.telefono = telefono;
                this.horasExtraTrabajadas = horasExtraTrabajadas;
                this.horasTrabajadas = horasTrabajadas;
                this.categoria = categoria;
            }
            public String getNombre(){
                return nombre;
            }
            public String getTelefono(){
                return telefono;
            }
            public float getHorasTrabajadas(){
                return horasTrabajadas;
            }
            public float getHorasExtraTrabajadas(){
                return horasExtraTrabajadas;
            }
            public categoriaEmpleado getCategoria() {
                return categoria;
            }
        }
        /**
         * Clase para la categoria del empleado
         */
        private static class categoriaEmpleado{
            private String claveCategoria;
            public String nombreCategoria;
            public double sueldoBase, bonoHorasExtra;

            public categoriaEmpleado(String clave, String nombre, double sueldoBase, double bonoHorasExtra){
                this.claveCategoria = clave;
                this.nombreCategoria = nombre;
                this.sueldoBase = sueldoBase;
                this.bonoHorasExtra = bonoHorasExtra;
            }
            public String getClave(){
                return claveCategoria;
            }
            public String getNombre(){
                return nombreCategoria;
            }
            public double getSueldoBase(){
                return sueldoBase;
            }
            public double getBonoHorasExtra(){
                return bonoHorasExtra;
            }
        }
    }
}