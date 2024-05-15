package Retos.Utils;

import java.io.IOException;
import java.util.ArrayList;

import Retos.Utils.InputHandler.RangedTypes;
import Retos.Utils.InputHandler.Types;

public class PlayList {
    private String nombre, identificador;
    private int numeroCanciones;
    public ArrayList<Cancion> canciones = new ArrayList<Cancion>();

    public PlayList(String nombre, int numeroCanciones) throws IOException{
        this.nombre = nombre;
        this.identificador = IdentifierGenerator.generarIdentificador(nombre);
        this.numeroCanciones = numeroCanciones;
    }

    public String[] getDetalles(){
        String[] detalles = new String[3];
        detalles[0] = nombre;
        detalles[1] = identificador;
        detalles[2] = String.valueOf(numeroCanciones);
        return detalles;
    }

    public ArrayList<GeneroMusical> meterCanciones(ArrayList<GeneroMusical> generos) throws IOException{
        for(int c = 0; c < numeroCanciones; c++){
            Cancion tempCancion;
            String nombre, duracion, cantante, autores;
            GeneroMusical genero;
            int opcGen;

            nombre = InputHandler.input(Types.STRING_NO_VACIO, "Ingrese el nombre de la cancion #" + (c+1) + ": ");
            duracion = InputHandler.input(Types.STRING_NO_VACIO, "Ingrese la duracion: ");
            cantante = InputHandler.input(Types.STRING_NO_VACIO, "Ingrese el nombre del cantante: ");
            autores = InputHandler.input(Types.STRING_NO_VACIO, "Ingrese el/los nombres de los autores: ");
            System.out.println("Ingrese la clave del genero al que pertenece la cancion: ");
            for(int i = 0; i < generos.size(); i++){
                System.out.println((i+1) + ". " + generos.get(i).getNombre() + ". Clave: " + generos.get(i).getIdentificador());
            }
            opcGen = Integer.parseInt(InputHandler.rangedInput(RangedTypes.ENTERO, 1, generos.size() + 1, (generos.size() + 1) + ". Registrar nuevo genero"));
            if(opcGen != (generos.size() + 1)){
                genero = generos.get(opcGen);
            }else{
                GeneroMusical nuevoGen = new GeneroMusical(InputHandler.input(Types.STRING_NO_VACIO, "Ingresa el nombre del genero: "));
                genero = nuevoGen;
                generos.add(nuevoGen);
            }
            tempCancion = new Cancion(nombre, duracion, cantante, autores, genero);
            canciones.add(tempCancion);
        }
        return generos;
    }
}
