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
    private class programa{
        /**
         * Total de horas laboradas en general.
         */
        private float horasLaboradas;
        private static int totalEmpleados, personasConHorasExtras;
        /**
         * Lista de empleados
         */
        private static ArrayList<empleado> empleados = new ArrayList<empleado>();

        private static void start() throws IOException{
            // Registar Datos de Categorías
            categoriaEmpleado Gerente = new categoriaEmpleado("GE24", "Gerente", 250.0d, 150.0d);
            categoriaEmpleado Ventas = new categoriaEmpleado("VE24", "Empleado de ventas", 100.0d, 50.0d);
            categoriaEmpleado Administrador = new categoriaEmpleado("AM24", "Administrador", 180.0d, 100.0d);

            // Preguntar el numero de empleados y registrarlos en el ArrayList empleados[]
            ingresarEmpleados();

            // Calcular los datos de la nómina
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
                empleado em = new empleado(nombre, telefono, horasTrabajadas, horasExtraTrabajadas);
                empleados.add(em);
            }
        }
        /**
         * Clase para generar los empleados
         */
        private static class empleado{
            private String nombre, telefono;
            private float horasTrabajadas, horasExtraTrabajadas;

            public empleado(String nombre, String telefono, float horasTrabajadas, float horasExtraTrabajadas){
                this.nombre = nombre;
                this.telefono = telefono;
                this.horasExtraTrabajadas = horasExtraTrabajadas;
                this.horasTrabajadas = horasTrabajadas;
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
