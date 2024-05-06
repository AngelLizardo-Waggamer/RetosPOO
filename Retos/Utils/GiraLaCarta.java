package Retos.Utils;

import java.io.IOException;

import Retos.Utils.InputHandler.RangedTypes;

public class GiraLaCarta extends Juego{

    public GiraLaCarta() throws IOException{
        tipoJuego = "Gira la carta";
        getDatos();
    }

    public GiraLaCarta(String nombre, String correo, String telefono){
        super(nombre, correo, telefono);
        tipoJuego = "Gira la carta";
    }

    @Override
    public void iniciarJuego() throws IOException{
        int res = (int)(Math.random() * 5);
        int inp;
        System.out.println("***** Gira la carta *****");
        System.out.println("Cartas: X X X X X");
        System.out.println("        1 2 3 4 5");
        inp = Integer.parseInt(InputHandler.rangedInput(RangedTypes.ENTERO, 1, 5, "Ingrese la posicion en la que crea que se encuentra ♢"));
        if (inp == res){
            System.out.println("*** ¡Correcto! Acertaste. ***");
        }else{
            System.out.println("Perdiste. El ♢ se encontraba en la posicion " + res + ". Sigue intentando.");
        }
    }
}
