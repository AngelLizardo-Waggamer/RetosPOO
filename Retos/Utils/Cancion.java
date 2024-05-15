package Retos.Utils;

public class Cancion {
    private String nombre, duracion, cantante, autores;
    private GeneroMusical genero;

    public Cancion(String nombre, String duracion, String cantante, String autores, GeneroMusical genero) {
        this.nombre = nombre;
        this.duracion = duracion;
        this.cantante = cantante;
        this.autores = autores;
        this.genero = genero;
    }
    
    public String[] getDetalles(){
        String[] data = new String[5];
        data[0] = nombre;
        data[1] = duracion;
        data[2] = cantante;
        data[3] = autores;
        data[4] = genero.getNombre();
        return data;
    }
}
