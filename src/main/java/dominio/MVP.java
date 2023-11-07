/*
 * Luis Fernando Aguilar Ortiz 
ITSON ISW 228419
 */

package dominio;

import java.util.Stack;

/**
 *
 * @author Luis Fernando Aguilar Ortiz 228419 ITSON ISW obregon-Camp-Nainari
 */
public class MVP {

    public static void main(String[] args) {
        Stack<Player> players=new Stack<>();
        Player jug1 =new Player(1);
        Player jug2 =new Player(2);
        Player jug3 =new Player(3);
        DominoGame dom=new DominoGame(players);
        dom.agregarJug(jug1);
        dom.agregarJug(jug2);
        dom.agregarJug(jug3);
         System.out.println("antes de shuffle");
        dom.imprimirStack();
        System.out.println("despues de shuffle");
        dom.shufflePlayers();
        
    
        dom.imprimirStack();
        
    }
}
