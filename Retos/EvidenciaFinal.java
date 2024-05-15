package Retos;

import java.io.IOException;
import java.util.ArrayList;

import Retos.Utils.Cancion;
import Retos.Utils.GeneroMusical;
import Retos.Utils.InputHandler;
import Retos.Utils.InputHandler.RangedTypes;
import Retos.Utils.InputHandler.Types;
import Retos.Utils.PlayList;

/**
 * EvidenciaFinal
 */
public class EvidenciaFinal {

    public static void exec() throws IOException{
        ArrayList<GeneroMusical> generosDisponibles = new ArrayList<GeneroMusical>();
        generosDisponibles.add(new GeneroMusical("Corridos Tumbados"));
        generosDisponibles.add(new GeneroMusical("Baladas"));
        ArrayList<PlayList> playlists = new ArrayList<PlayList>();
        // TODO: Registrar las dos playlist predefinidas 
        char opc;
        do{
           opc = menu();
           switch(opc){
                case 'A'->{ // Agregar Playlist
                    String nombre = InputHandler.input(Types.STRING_NO_VACIO, "Ingrese el nombre de la nueva playlist: ");
                    int nCanciones = Integer.parseInt(InputHandler.input(Types.ENTERO_NO_NEGATIVO, "Ingrese el numero de canciones a insertar: "));
                    playlists.add(new PlayList(nombre, nCanciones));
                    generosDisponibles = playlists.getLast().meterCanciones(generosDisponibles);
                }
                case 'B'->{ // Reproducir musica
                    System.out.println("----- Playlist disponibles -----");
                    for(int i = 0; i < playlists.size(); i++){
                        System.out.println((i+1) + ". " + playlists.get(i).getDetalles()[0]);
                    }
                    int playSel = Integer.parseInt(InputHandler.rangedInput(RangedTypes.ENTERO, 1, playlists.size(), "Ingrese la playlist que desea reproducir: "));
                    PlayList playlistSeleccionada = playlists.get(playSel);
                    System.out.println("----- Canciones en la playlist  -----");
                    for(int c = 0; c < playlistSeleccionada.canciones.size(); c++){
                        Cancion tempCancion = playlistSeleccionada.canciones.get(c);
                        System.out.println((c+1) + ". (" + tempCancion.getDetalles()[1] + ") " + tempCancion.getDetalles()[0] + " - " + tempCancion.getDetalles()[2]);
                    }
                    int cancionSel = Integer.parseInt(InputHandler.rangedInput(RangedTypes.ENTERO, 1, playlistSeleccionada.canciones.size(), "Ingrese la cancion que desea reproducir: "));
                    Cancion reproduccionActual = playlistSeleccionada.canciones.get(cancionSel);
                    System.out.println("Reproduciendo ahora:\n" + reproduccionActual.getDetalles()[0] + " - " + reproduccionActual.getDetalles()[2]);
                    System.out.println("Duracion: " + reproduccionActual.getDetalles()[1]);
                    System.out.println("Genero: " + reproduccionActual.getDetalles()[4]);
                    System.out.println("Autores: " + reproduccionActual.getDetalles()[3]);
                }
                default->{
                    System.out.println("Ingrese una opción válida");
                }
            }
        }while(opc != 'C');
        System.out.println("----- Fin del programa -----");
    }

    private static char menu() throws IOException{
        System.out.println("");
        char opt = InputHandler.input(Types.STRING_NO_VACIO, "Elige una opcion: \nA. Agregar playlist \nB. Reproducir Musica \nC. Salir").charAt(0);
        return opt;
    }
}