/**
 * * Author: @angl.liz
 * * Github: @AngelLizardo-Waggamer
 * 
 * * In this challenge we built a program that calculates the income of a group of workers. It
 * * also calculates the total of worked hours and the extra hours income.
 */
package Retos;

import java.io.IOException;
import java.time.format.DateTimeFormatter;

import Retos.Utils.InputHandler;

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
    @SuppressWarnings("unused")
    /**
     * Clase donde todo el programa funciona
     */
    private class programa{
        private static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/mm/aa");
        private float horasLaboradas;
        private int totalEmpleados, personasConHorasExtras;
        private empleado[] empleados;

        private static void start() throws IOException{
            // Registar Datos de Categorías
            categoriaEmpleado Gerente = new categoriaEmpleado("GE24", "Gerente", 250.0d, 150.0d);
            categoriaEmpleado Ventas = new categoriaEmpleado("VE24", "Empleado de ventas", 100.0d, 50.0d);
            categoriaEmpleado Administrador = new categoriaEmpleado("AM24", "Administrador", 180.0d, 100.0d);

            // Preguntar el numero de empleados y registrarlos en el array empleados[]
            ingresarEmpleados();
        }

        /**
         * Pregunta el numero de empleados y dimensiona el array empleados
         * @throws IOException because an user input is asked
         */
        private static void ingresarEmpleados() throws IOException{
            int numEmpleados = Integer.parseInt(InputHandler.input(InputHandler.Types.ENTERO_NO_NEGATIVO, "Ingrese el numero de empleados a registrar: "));
        }
        /**
         * Clase para generar los empleados
         */
        private static class empleado{
            private String nombre, telefono;
            private float horasTrabajadas, horasExtraTrabajadas;
            private DateTimeFormatter fechaNacimiento;
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
        }
    }
}
