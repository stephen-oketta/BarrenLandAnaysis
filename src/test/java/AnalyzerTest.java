package test.java;

import main.java.Analyzer;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class AnalyzerTest {

    @Test
    public void testNoBarrenLand() {
        int[][] barren = {};

        Analyzer analyzer = new Analyzer();
        String area = analyzer.getArea(barren);

        assertEquals("There should be no barren land", "240000" , area);
    }

    @Test
    public void testAllBarrenLand() {
        int[][] barren = {{0, 0, 399, 599}};

        Analyzer analyzer = new Analyzer();
        String area = analyzer.getArea(barren);

        assertEquals("All area is barren land", "ERROR: All barren land" , area);
    }

    @Test
    public void testMultipleBarrenLand() {
        int[][] barren = { {48, 192, 351, 207}, {48, 392, 351, 407}, {120, 52, 135, 547}, {260, 52, 275, 547}};

        Analyzer analyzer = new Analyzer();
        String area = analyzer.getArea(barren);

        assertEquals("All area is barren land", "22816 192608" , area);
    }
}