package test.java;


import main.java.InputProcessor;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class InputProcessorTest {

    @Test
    public void testInvalidInput() {
        InputProcessor processor = new InputProcessor();

        int[][] result = processor.getInput("{\"1 2 3 5\"");

        assertNull("Should return null for invalid barren land coordinates", result);
    }

    @Test
    public void testValidInput() {
        InputProcessor processor = new InputProcessor();
        int[][] expected = { {1, 2, 3, 5}, {6, 7, 8, 9}};

        int[][] result = processor.getInput("{\"1 2 3 5\", \"6 7 8 9\"}");

        assertTrue("Should return barren land coordinates", Arrays.deepEquals(expected, result));
    }

    @Test
    public void testNoBarrenLand() {
        InputProcessor processor = new InputProcessor();
        int[][] expected = {};

        int[][] result = processor.getInput("{}");

        assertTrue("Should return no barren land", Arrays.deepEquals(expected, result));
    }
}