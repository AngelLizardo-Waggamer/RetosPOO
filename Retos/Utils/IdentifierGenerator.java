package Retos.Utils;

/**
 * IdentifierGenerator
 */
public class IdentifierGenerator {

    public static String generarIdentificador(String nombre) {
        String res = "";
        String[] iniciales;
        iniciales = nombre.split(" ");
        for(int i = 0; i < iniciales.length; i++){
            res += iniciales[i].toUpperCase();
        }
        return res;
    }
}