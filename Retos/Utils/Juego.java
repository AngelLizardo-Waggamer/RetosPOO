package Retos.Utils;

import java.io.IOException;

import Retos.Utils.InputHandler.Types;

public class Juego {
    public String nombre, correo, telefono, tipoJuego;
    public boolean resultadoJuego;

    public Juego(){};

    public Juego(String nombre, String correo, String telefono){
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
    }

    public void getDatos() throws IOException{
        nombre = InputHandler.input(Types.STRING_NO_VACIO, "Ingrese su nombre: ");
        correo = InputHandler.input(Types.STRING_NO_VACIO, "Ingrese su correo: ");
        telefono = InputHandler.input(Types.STRING_NO_VACIO, "Ingrese su telefono: ");
    }

    public void iniciarJuego() throws IOException {}
}
