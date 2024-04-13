import java.util.ArrayList;
import Retos.Utils.Player;

/**
 * RetoOcho
 */
public class RetoOcho {

    public static void exec(){
        // jugadorUno is declared with setters
        Player jugadorUno = new Player();
        jugadorUno.setnameTag("Eugenio");
        jugadorUno.setHP(100);
        jugadorUno.setDMGDLT(4);

        // jugadorDos is declared with constructor with two parameters
        Player jugadorDos = new Player("Manolo",100);

        // jugadorTres is declared cloning JugadorDos and changing the name
        Player jugadorTres = new Player(jugadorDos);
        jugadorTres.setnameTag("Eustaquio");
        jugadorTres.setDMGDLT(9);

        // JugadorCuatro is declared with all its atributes in the constructor
        Player jugadorCuatro = new Player("Willy", 200, 14);

        // JuegoUno is a standard game (two players)
        Juego juegoUno = new Juego(jugadorUno, jugadorDos);
        System.out.println("----------JUEGO UNO----------");
        juegoUno.start();

        // JuegoDos is declared by cloning juegoUno but removing player two and inserting jugadorTres
        Juego juegoDos = new Juego(juegoUno);
        juegoDos.removePlayer(1);
        juegoDos.addPlayer(jugadorTres);
        System.out.println("----------JUEGO DOS----------");
        juegoDos.start();
        
        // JuegoTres uses an ArrayList with players to create the instance
        ArrayList<Player> PlayersJuegoTres = new ArrayList<Player>();
        PlayersJuegoTres.add(jugadorUno);
        PlayersJuegoTres.add(jugadorDos);
        PlayersJuegoTres.add(jugadorTres);
        PlayersJuegoTres.add(jugadorCuatro);

        Juego juegoTres = new Juego(PlayersJuegoTres);
        System.out.println("----------JUEGO TRES----------");
        juegoTres.start();
    }

    private static class Juego{
        
        private ArrayList<Player> Players = new ArrayList<Player>();
        
        // Constructor for two players (standard game)
        public Juego(Player p1, Player p2){
            Players.add(p1);
            Players.add(p2);
        }

        // Constructor for more than two players (Not standard game)
        public Juego(ArrayList<Player> Players){
            this.Players = Players;
        }

        // Constructor for cloning games
        public Juego(Juego juego){
            this.Players = juego.Players;
        }

        // Setter to add a player
        public void addPlayer(Player newPlayer){
            this.Players.add(newPlayer);
        }

        // Setter to remove a player
        public void removePlayer(int playerIndex){
            this.Players.remove(playerIndex);
        }

        // Function to start the game (show stats)
        public void start(){
            System.out.println("Número de jugadores: " + Players.size());
                for(int i = 0; i < Players.size(); i++){
                    Player p = Players.get(i);
                    System.out.println("** Jugador #" + (i+1) + " **");
                    System.out.println("    - Nombre: " + p.getnameTag());
                    System.out.println("    - Health Points (vida): " + p.getHP());
                    if(p.getDMGDLT() != 0){
                        System.out.println("    - Daño: " + p.getDMGDLT());
                    }
                }
        }
    }
}