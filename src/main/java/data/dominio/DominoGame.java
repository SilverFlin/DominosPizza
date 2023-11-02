package data.dominio;

import java.util.Stack;
import java.util.Collections;

/**
 *
 * @author Luis Fernando Aguilar Ortiz 228419 ITSON ISW obregon-Camp-Nainari
 */
public class DominoGame {

    public Stack<Player> players;
    public TurnController turnController=new TurnController();
    public Config config;
public Pool pool;

    public DominoGame(Stack<Player> players) {
        this.players = players;
    }

    /**
     * para probar funcionalidad del shuffle
     *
     * @param e
     */
    public void agregarJug(Player e) {
        players.add(e);
    }

    public void imprimirStack() {
        for (int x = 0; x < players.size(); x++) {
            System.out.println(players.elementAt(x).getValor());
        }
    }



    /**
     * Del atributo players, este método los reacomoda de forma aleatoria, es
     * necesario antes de iniciar el juego.
     */

    public void shufflePlayers() {
        Collections.shuffle(players);
    }
    /**
     *  Llama a TurnController.changeTurn(...) 
     * para cambiar el turno de los jugadores
     */
    public void changeTurn(){
        turnController.changeTurn(this.players);
        
    }
    /**
     *  Crea una instancia de Config, si es que no hay, 
     * con la cantidad de fichas y la guarda en el juego.
     * @param cantTiles 
     */
    public void setTilesAmountConfig(int cantTiles){
         this.config= new Config(cantTiles);
    }
    

}
