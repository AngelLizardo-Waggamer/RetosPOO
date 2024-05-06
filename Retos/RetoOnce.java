package Retos;

import java.io.IOException;
import java.util.ArrayList;
import Retos.Utils.AdivinaNumero;
import Retos.Utils.DataGenerator;
import Retos.Utils.EncuentraLaCarita;
import Retos.Utils.GiraLaCarta;
import Retos.Utils.InputHandler;
import Retos.Utils.Juego;
import Retos.Utils.InputHandler.RangedTypes;

public class RetoOnce {
    private static ArrayList<Juego> partidas = new ArrayList<Juego>();
    public static void exec() throws IOException{
        int option = Integer.parseInt(InputHandler.rangedInput(RangedTypes.ENTERO, 1, 2, "Ingrese una opcion de ejecucion: "));
        if(option == 1){
            OpcionUno();
        }else{
            OpcionDos();
        }
    }

    private static void OpcionUno() throws IOException{
        System.out.println("---------- DEMO JUEGOS ----------");
        for(int i = 0; i < 10; i++){
            Juego juego = null;
            int opc = Integer.parseInt(InputHandler.rangedInput(RangedTypes.ENTERO, 1, 3, "Ingrese el numero de juego que desea:\n1. Adivina el numero\n2. Encuentra la carita\n3. Gira la carta"));
            juego = switch(opc){
                case 1->{ yield new AdivinaNumero(); }
                case 2->{ yield new EncuentraLaCarita(); }
                case 3->{ yield new GiraLaCarta(); }
                default->{ yield null; }
            };
            juego.iniciarJuego();
            partidas.add(juego);
        }
        System.out.println("---------- INFORME ----------");
        for(int j = 0; j < 10; j++){
            System.out.println("* Juego " + (j+1) + ": ");
            System.out.println("    Usuario: " + partidas.get(j).nombre);
            System.out.println("    Correo: " + partidas.get(j).correo);
            System.out.println("    Telefono: " + partidas.get(j).telefono);
            System.out.println("    Tipo de juego: " + partidas.get(j).tipoJuego);
            if(partidas.get(j).resultadoJuego){
                System.out.println("    Resultado del juego: Ganado");
            }else{
                System.out.println("    Resultado del juego: Perdido");
            }
        }
    }

    private static void OpcionDos() throws IOException {
        System.out.println("---------- DEMO JUEGOS ----------");
        for(int i = 0; i < 10; i++){
            Juego juego = null;
            String[] nomYcorreo;
            String telefono;
            nomYcorreo = DataGenerator.NameAndEmail();
            telefono = DataGenerator.GeneratePhone("993");
            int opc = Integer.parseInt(InputHandler.rangedInput(RangedTypes.ENTERO, 1, 3, "Ingrese el numero de juego que desea:\n1. Adivina el numero\n2. Encuentra la carita\n3. Gira la carta"));
            juego = switch(opc){
                case 1->{ yield new AdivinaNumero(nomYcorreo[0], nomYcorreo[1], telefono); }
                case 2->{ yield new EncuentraLaCarita(nomYcorreo[0], nomYcorreo[1], telefono); }
                case 3->{ yield new GiraLaCarta(nomYcorreo[0], nomYcorreo[1], telefono); }
                default->{ yield null; }
            };
            juego.iniciarJuego();
            partidas.add(juego);
        }
        System.out.println("---------- INFORME ----------");
        for(int j = 0; j < 10; j++){
            System.out.println("* Juego " + (j+1) + ": ");
            System.out.println("    Usuario: " + partidas.get(j).nombre);
            System.out.println("    Correo: " + partidas.get(j).correo);
            System.out.println("    Telefono: " + partidas.get(j).telefono);
            System.out.println("    Tipo de juego: " + partidas.get(j).tipoJuego);
            if(partidas.get(j).resultadoJuego){
                System.out.println("    Resultado del juego: Ganado");
            }else{
                System.out.println("    Resultado del juego: Perdido");
            }
        }
    }
}