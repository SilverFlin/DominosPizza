/*
 * Luis Fernando Aguilar Ortiz 
ITSON ISW 228419
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.util.List;
import java.util.Stack;

/**
 *
 * @author Luis Fernando Aguilar Ortiz 228419 ITSON ISW obregon-Camp-Nainari
 */
public class TurnController {
   public List<User> players;
   /**
    * Recorre la pila, mandando al que tenía
    * el turno actual al final.
     * @param players
    */
   public void changeTurn(Stack<Player> players){
       Player JugCambio=players.pop();
    players.add(JugCambio);
}
}
