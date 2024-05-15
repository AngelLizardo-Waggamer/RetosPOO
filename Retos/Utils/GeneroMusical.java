package Retos.Utils;

public class GeneroMusical {
    private String nombre, identificador;

    public GeneroMusical(String nombre){
        this.nombre = nombre;
        this.identificador = IdentifierGenerator.generarIdentificador(nombre);
    }

    public String getIdentificador() {
        return identificador;
    }

    public String getNombre() {
        return nombre;
    }
}
