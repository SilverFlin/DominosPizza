package domain;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Pruebas unitarias para la clase Player.
 */
public class PlayerTest {

    public PlayerTest() {
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
     * Test of getTilesInHand method, of class Player.
     */
    @Test
    public void testGetTilesInHand() {
        System.out.println("getTilesInHand");
        Player instance = new Player();
        List<PlayerTile> expResult = new ArrayList<>();
        List<PlayerTile> result = instance.getTilesInHand();
        assertEquals(expResult, result);
    }

    /**
     * Test of setTilesInHand method, of class Player.
     */
    @Test
    public void testSetTilesInHand() {
        System.out.println("setTilesInHand");
        List<PlayerTile> tilesInHand = new ArrayList<>();
        Player instance = new Player();
        instance.setTilesInHand(tilesInHand);
        assertEquals(tilesInHand, instance.getTilesInHand());
    }

    /**
     * Test of getAvatar method, of class Player.
     */
    @Test
    public void testGetAvatar() {
        System.out.println("getAvatar");
        Player instance = new Player();
        Avatar expResult = new Avatar("Default", "default.png");
        instance.setAvatar(expResult);
        Avatar result = instance.getAvatar();
        assertEquals(expResult, result);
    }

    /**
     * Test of setAvatar method, of class Player.
     */
    @Test
    public void testSetAvatar() {
        System.out.println("setAvatar");
        Avatar avatar = new Avatar("Custom", "custom.png");
        Player instance = new Player();
        instance.setAvatar(avatar);
        assertEquals(avatar, instance.getAvatar());
    }

    /**
     * Test of isAdmin method, of class Player.
     */
    @Test
    public void testIsAdmin() {
        System.out.println("isAdmin");
        Player instance = new Player();
        boolean expResult = false;
        boolean result = instance.isAdmin();
        assertEquals(expResult, result);
    }

    /**
     * Test of setIsAdmin method, of class Player.
     */
    @Test
    public void testSetIsAdmin() {
        System.out.println("setIsAdmin");
        boolean isAdmin = true;
        Player instance = new Player();
        instance.setIsAdmin(isAdmin);
        assertEquals(isAdmin, instance.isAdmin());
    }

    /**
     * Test of addTile method, of class Player.
     */
    @Test
    public void testAddTile() {
        System.out.println("addTile");
        Player instance = new Player();
        DominoTile tile = new PlayerTile(1, 2);
        instance.addTile(tile);
        assertTrue(instance.getTilesInHand().contains(tile));
    }

    /**
     * Test of removeTile method, of class Player.
     */
    @Test
    public void testRemoveTile() {
        System.out.println("removeTile");
        Player instance = new Player();
        PlayerTile tile = new PlayerTile(3, 4);
        instance.addTile(tile);
        instance.removeTile(tile);
        assertFalse(instance.getTilesInHand().contains(tile));
    }

    /**
     * Test of isReady method, of class Player.
     */
    @Test
    public void testIsReady() {
        System.out.println("isReady");
        Player instance = new Player();
        boolean expResult = false;
        boolean result = instance.isReady();
        assertEquals(expResult, result);
    }

    /**
     * Test of setReady method, of class Player.
     */
    @Test
    public void testSetReady() {
        System.out.println("setReady");
        Player instance = new Player();
        instance.setReady();
        assertTrue(instance.isReady());
    }
}
