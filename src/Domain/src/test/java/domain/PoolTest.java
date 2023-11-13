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
 * Pruebas unitarias para la clase Pool.
 */
public class PoolTest {

    public PoolTest() {
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
     * Test of getDominoes method, of class Pool.
     */
    @Test
    public void testGetDominoes() {
        System.out.println("getDominoes");
        Pool instance = new Pool();
        List<PoolTile> expResult = new ArrayList<>();
        List<PoolTile> result = instance.getDominoes();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDominoes method, of class Pool.
     */
    @Test
    public void testSetDominoes() {
        System.out.println("setDominoes");
        List<PoolTile> dominoes = new ArrayList<>();
        Pool instance = new Pool();
        instance.setDominoes(dominoes);
        assertEquals(dominoes, instance.getDominoes());
    }

    /**
     * Test of takeTile method, of class Pool.
     */
    @Test
    public void testTakeTile() {
        System.out.println("takeTile");
        Pool instance = new Pool();
        PoolTile expResult = new PoolTile(1, 2);

        // Crear una lista mutable (ArrayList) en lugar de una lista inmutable
        instance.setDominoes(new ArrayList<>(List.of(expResult)));

        PoolTile result = instance.takeTile();
        assertEquals(expResult, result);
        assertTrue(instance.getDominoes().isEmpty());
    }

    /**
     * Test of validateRemainingTiles method, of class Pool.
     */
    @Test
    public void testValidateRemainingTiles() {
        System.out.println("validateRemainingTiles");
        Pool instance = new Pool();
        boolean expResult = false;
        boolean result = instance.validateRemainingTiles();
        assertEquals(expResult, result);
    }
}
