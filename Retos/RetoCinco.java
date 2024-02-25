package Retos;

import java.util.ArrayList;

import Retos.Utils.NumberCurrencyFormatter;

public class RetoCinco {
    // ! Funcion principal de la clase RetoCinco
    public static void exec(){
        // Iniciar el programa
        programa.start();
    }

    /**
     * Clase del programa para el carrito de compras
     */
    private class programa{
        // Declaracion del arraylist del carrito de compras
        private static ArrayList<producto> carritoCompras = new ArrayList<producto>();
        // ! Funcion principal de la clase programa
        public static void start(){

            // Añadir productos al carrito
            carritoCompras.add(new producto("Camiseta Polo Azul", 2)); // Camiseta Polo Azul. Q# = 2
            carritoCompras.add(new producto("Jabon en barra olor a coco", 6, 30.5d)); // Jabon en barra olor a coco. Q# = 6. $ = 30.5
            carritoCompras.add(new producto("Avena con cacao de 200gr", 1)); // Avena con cacao de 200gr. Q# = 1
            carritoCompras.add(new producto("Sandia p/pza", 2, 70.0d));
            carritoCompras.add(new producto("Television Samsung 90\"", 1, 49999.99d));

            // Listar productos
            listarProductos();
        }

        private static void listarProductos(){
            System.out.println("Numero total de productos: " + carritoCompras.size());
            for(producto p : carritoCompras){
                System.out.println("Producto: " + p.nombreProducto);
                System.out.println("Cantidad: " + p.cantidadProducto);
                if(p.tienePrecio){
                    System.out.println("Precio: " + NumberCurrencyFormatter.format(p.precioProducto, "MXN"));
                }else{
                    System.out.println("Precio: No disponible.");
                }
            }
        }
    }

    private static class producto{
        public String nombreProducto;
        public double precioProducto;
        public int cantidadProducto;
        public boolean tienePrecio;
        // tipoDeObjeto {0 para productos sin precio, 1 para productos con precio}

        // Para el caso de que el precio no se tenga a la mano, el constructor #1 no lo exige como parametro.
        public producto(String nombreProducto, int cantidadProducto){
            this.nombreProducto = nombreProducto;
            this.cantidadProducto = cantidadProducto;
            this.tienePrecio = false; 
        }

        // Para el caso de que el precio si se tenga a la mano, el constructor #2 lo exige como parametro.
        public producto(String nombreProducto, int cantidadProducto, double precioProducto){
            this.nombreProducto = nombreProducto;
            this.cantidadProducto = cantidadProducto;
            this.precioProducto = precioProducto;
            this.tienePrecio = true;
        }
    }
}