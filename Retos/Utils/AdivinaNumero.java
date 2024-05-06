package Retos.Utils;

import java.io.IOException;

import Retos.Utils.InputHandler.RangedTypes;

public class AdivinaNumero extends Juego{

    public AdivinaNumero() throws IOException{
        tipoJuego = "Adivina el numero";
        getDatos();
    }

    public AdivinaNumero(String nombre, String correo, String telefono){
        super(nombre, correo, telefono);
    }

    @Override
    public void iniciarJuego() throws IOException{
        int numero, respuesta;
        respuesta = (int)(Math.random()*10.00d);
        System.out.println("***** Adivina el numero *****");
        for(int i = 1; i <= 3; i++){
            numero = Integer.parseInt(InputHandler.rangedInput(RangedTypes.ENTERO, 1, 10, "Adivine el numero entre el 1 y el 10"));
            if(numero == respuesta){
                System.out.println("*** ¡Correcto! Adivinaste el numero. ***");
                resultadoJuego = true;
                break;
            }else{
                if(i == 3){
                    System.out.println("Perdiste. El numero correcto era: " + respuesta + ". Sigue participando.");
                }else{
                    System.out.println("Fallaste. Tienes " + (3-i) + " intentos mas.");
                }
            }
        }
    }
}
