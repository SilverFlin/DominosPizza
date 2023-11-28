package domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Pruebas unitarias para la clase DominoTile.
 */
public class DominoTileTest {

    public DominoTileTest() {
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
     * Test of getLeftValue method, of class DominoTile.
     */
    @Test
    public void testGetLeftValue() {
        System.out.println("getLeftValue");
        DominoTile instance = new DominoTile(3, 5);
        int expResult = 3;
        int result = instance.getLeftValue();
        assertEquals(expResult, result);
    }

    /**
     * Test of setLeftValue method, of class DominoTile.
     */
    @Test
    public void testSetLeftValue() {
        System.out.println("setLeftValue");
        int leftValue = 7;
        DominoTile instance = new DominoTile(3, 5);
        instance.setLeftValue(leftValue);
        assertEquals(leftValue, instance.getLeftValue());
    }

    /**
     * Test of getRightValue method, of class DominoTile.
     */
    @Test
    public void testGetRightValue() {
        System.out.println("getRightValue");
        DominoTile instance = new DominoTile(3, 5);
        int expResult = 5;
        int result = instance.getRightValue();
        assertEquals(expResult, result);
    }

    /**
     * Test of setRightValue method, of class DominoTile.
     */
    @Test
    public void testSetRightValue() {
        System.out.println("setRightValue");
        int rightValue = 8;
        DominoTile instance = new DominoTile(3, 5);
        instance.setRightValue(rightValue);
        assertEquals(rightValue, instance.getRightValue());
    }

}
