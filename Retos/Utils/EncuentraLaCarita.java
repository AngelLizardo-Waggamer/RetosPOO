package Retos.Utils;

import java.io.IOException;

import Retos.Utils.InputHandler.RangedTypes;

public class EncuentraLaCarita extends Juego{

    public EncuentraLaCarita() throws IOException{
        tipoJuego = "Encuentra la carita";
        getDatos();
    }

    public EncuentraLaCarita(String nombre, String correo, String telefono){
        super(nombre, correo, telefono);
    }

    @Override
    public void iniciarJuego() throws IOException{
        int posRdeX, posRdeY;
        int inpX, inpY;
        posRdeX = (int)(Math.random()*3) - 1;
        posRdeY = (int)(Math.random()*3) - 1;
        System.out.println("***** Encuentra la Carita *****");
        imprimirtabla();
        inpX = Integer.parseInt(InputHandler.rangedInput(RangedTypes.ENTERO, 0, 2, "Ingrese la posicion horizontal de su intento: "));
        inpY = Integer.parseInt(InputHandler.rangedInput(RangedTypes.ENTERO, 0, 2, "Ingrese la posicion vertical de su intento: "));
        if(inpX == posRdeX && inpY == posRdeY){
            System.out.println("*** ¡Correcto! Acertaste. ***");
        }else{
            System.out.println("Perdiste. La carita se encontraba en " + "[" + posRdeX + ", " + posRdeY + "]. Sigue participando.");
        }
    }

    private void imprimirtabla(){
        String sFila = "";
        for(int fila = 0; fila < 3; fila++){
            for(int col = 0; col < 3; col++){
                sFila += "| xx |";
            }
            System.out.println(sFila);
            sFila = "";
        }
    }
}
