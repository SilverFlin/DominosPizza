package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Toled
 */
public class DominoGameTest {

    public DominoGameTest() {
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
     * Test of getPool method, of class DominoGame.
     */
    @Test
    public void testGetPool() {
        System.out.println("getPool");
        DominoGame instance = new DominoGame();
        Pool expResult = new Pool();
        instance.setPool(expResult);
        Pool result = instance.getPool();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPool method, of class DominoGame.
     */
    @Test
    public void testSetPool() {
        System.out.println("setPool");
        Pool pool = new Pool();
        DominoGame instance = new DominoGame();
        instance.setPool(pool);
        assertEquals(pool, instance.getPool());
    }

    /**
     * Test of getBoard method, of class DominoGame.
     */
    @Test
    public void testGetBoard() {
        System.out.println("getBoard");
        DominoGame instance = new DominoGame();
        Board expResult = new Board();
        instance.setBoard(expResult);
        Board result = instance.getBoard();
        assertEquals(expResult, result);
    }

    /**
     * Test of setBoard method, of class DominoGame.
     */
    @Test
    public void testSetBoard() {
        System.out.println("setBoard");
        Board board = new Board();
        DominoGame instance = new DominoGame();
        instance.setBoard(board);
        assertEquals(board, instance.getBoard());
    }

    /**
     * Test of getPlayers method, of class DominoGame.
     */
    @Test
    public void testGetPlayers() {
        System.out.println("getPlayers");
        DominoGame instance = new DominoGame();
        List<Player> expResult = new ArrayList<>();
        instance.setPlayers(expResult);
        List<Player> result = instance.getPlayers();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPlayers method, of class DominoGame.
     */
    @Test
    public void testSetPlayers() {
        System.out.println("setPlayers");
        List<Player> players = new ArrayList<>();
        DominoGame instance = new DominoGame();
        instance.setPlayers(players);
        assertEquals(players, instance.getPlayers());
    }

    /**
     * Test of shufflePlayers method, of class DominoGame.
     */
    @Test
    public void testShufflePlayers() {
        System.out.println("shufflePlayers");
        DominoGame instance = new DominoGame();

        // Crear jugadores ficticios
        Player player1 = new Player();
        Player player2 = new Player();
        Player player3 = new Player();

        // Establecer la lista de jugadores en la instancia
        instance.setPlayers(List.of(player1, player2, player3));

        // Obtener la lista original de jugadores
        List<Player> originalOrder = new ArrayList<>(instance.getPlayers());

        // Verificar que la lista de jugadores después de barajar es diferente a la original
        instance.shufflePlayers();
        List<Player> shuffledOrder = instance.getPlayers();

        assertNotEquals(originalOrder, shuffledOrder, "La lista de jugadores no cambió después de barajar.");

        // Verificar que ambas listas tengan los mismos elementos
        assertTrue(originalOrder.containsAll(shuffledOrder) && shuffledOrder.containsAll(originalOrder),
                "Las listas no contienen los mismos elementos después de barajar.");

        // Verificar que la barajada no cambió la cantidad de jugadores
        assertEquals(originalOrder.size(), shuffledOrder.size(),
                "La cantidad de jugadores cambió después de barajar.");

        // Verificar que la barajada no repite jugadores
        Set<Player> uniquePlayers = new HashSet<>(shuffledOrder);
        assertEquals(shuffledOrder.size(), uniquePlayers.size(),
                "La barajada repite jugadores.");
        instance.setPlayers(List.of());

    }

    /**
     * Test of changeTurn method, of class DominoGame.
     */
    @Test
    public void testChangeTurn() {
        System.out.println("changeTurn");

        // Crear una instancia de DominoGame
        DominoGame instance = new DominoGame();

        // Crear jugadores ficticios
        Player player1 = new Player();
        Player player2 = new Player();
        Player player3 = new Player();

        // Establecer la lista de jugadores en la instancia
        instance.setPlayers(Arrays.asList(player1, player2, player3));

        // Obtener el orden original de los jugadores
        List<Player> originalOrder = List.copyOf(instance.getPlayers());

        // Llamar al método changeTurn
        instance.changeTurn();

        // Verificar que la lista de jugadores después de llamar a este método sea diferente a la original
        assertNotEquals(originalOrder, instance.getPlayers());

        // Verificar que el jugador activo después de llamar a este método sea diferente al original
        assertNotEquals(player1, instance.getCurrentPlayer());
    }

    /**
     * Test of getCurrentPlayer method, of class DominoGame.
     */
    @Test
    public void testGetCurrentPlayer() {
        System.out.println("getCurrentPlayer");

        // Crear una instancia de DominoGame
        DominoGame instance = new DominoGame();

        // Crear jugadores ficticios
        Player player1 = new Player();
        Player player2 = new Player();
        Player player3 = new Player();

        // Establecer la lista de jugadores en la instancia
        instance.setPlayers(Arrays.asList(player1, player2, player3));

        // Obtener el jugador activo original
        Player originalActivePlayer = instance.getCurrentPlayer();

        // Llamar al método changeTurn para cambiar el jugador activo
        instance.changeTurn();

        // Verificar que el jugador activo después de llamar a este método sea diferente al original
        assertNotEquals(originalActivePlayer, instance.getCurrentPlayer());
    }

    /**
     * Test of addPlayer method, of class DominoGame.
     */
    @Test
    public void testAddPlayer() {
        System.out.println("addPlayer");
        Player player = new Player();
        player.setAvatar(new Avatar("name", "name.png"));
        DominoGame instance = new DominoGame();
        instance.setPlayers(new ArrayList<>());
        instance.addPlayer(player);
        assertTrue(instance.getPlayers().contains(player));
    }

    /**
     * Test of setTileAmountConfig method, of class DominoGame.
     */
    @Test
    public void testSetTileAmountConfig() {
        System.out.println("setTileAmountConfig");
        int cantTile = 7;
        DominoGame instance = new DominoGame();
        instance.setTileAmountConfig(cantTile);
        assertEquals(cantTile, instance.getConfig().getTilesPerPlayer());
    }

    /**
     * Test of startGame method, of class DominoGame.
     */
    @Test
    public void testStartGame() {
        System.out.println("startGame");

        // Caso: Todos los jugadores listos
        DominoGame instanceAllReady = new DominoGame();
        List<Player> playersAllReady = Arrays.asList(
                new Player(),
                new Player(),
                new Player()
        );
        playersAllReady.forEach(Player::setReady);  // Establecer todos los jugadores como listos
        instanceAllReady.setPlayers(playersAllReady);

        boolean resultAllReady = instanceAllReady.startGame();
        assertTrue(resultAllReady, "Todos los jugadores están listos, el juego debería comenzar.");

        // Caso: Al menos un jugador no está listo
        DominoGame instanceNotReady = new DominoGame();
        List<Player> playersNotReady = Arrays.asList(
                new Player(),
                new Player(),
                new Player()
        );
        instanceNotReady.setPlayers(playersNotReady);

        boolean resultNotReady = instanceNotReady.startGame();
        assertFalse(resultNotReady, "Al menos un jugador no está listo, el juego no debería comenzar.");
    }

    /**
     * Test of putTileBoard method, of class DominoGame.
     */
    @Test
    public void testPutTileBoard() {
        System.out.println("putTileBoard");
        DominoTile tile = new DominoTile(1, 2);
        DominoGame instance = new DominoGame();
        instance.setBoard(new Board());
        instance.putTileBoard(tile);
        BoardTile boardTile = instance.getBoard().getTiles().get(0);
        assertEquals(tile.getLeftValue(), boardTile.getLeftValue());
        assertEquals(tile.getRightValue(), boardTile.getRightValue());
    }

    /**
     * Test of takeFromPool method, of class DominoGame.
     */
    @Test
    public void testTakeFromPool() {
        System.out.println("takeFromPool");
        Player player = new Player();
        DominoGame instance = new DominoGame();
        instance.takeFromPool(player);
        assertEquals(1, player.getTilesInHand().size());
    }
}
