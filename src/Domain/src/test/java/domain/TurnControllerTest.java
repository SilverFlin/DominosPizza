package domain;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TurnControllerTest {

    public TurnControllerTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of changeTurn method, of class TurnController.
     */
    @Test
    public void testChangeTurn() {
        System.out.println("changeTurn");

        // Crear una lista de jugadores
        List<Player> players = new ArrayList<>();
        Player p1 = new Player();
        Player p2 = new Player();
        Player p3 = new Player();
        players.add(p1);
        players.add(p2);
        players.add(p3);

        TurnController instance = new TurnController();

        // Llamar al método changeTurn
        List<Player> result = instance.changeTurn(players);

        // Verificar que la lista resultante no sea nula
        assertNotNull(result);

        // Verificar que el orden de los jugadores sea p2, p3, p1
        assertEquals(p2, result.get(0));
        assertEquals(p3, result.get(1));
        assertEquals(p1, result.get(2));
    }
}
