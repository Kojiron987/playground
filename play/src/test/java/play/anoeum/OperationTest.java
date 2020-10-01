package play.anoeum;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import play.anoenum.BasicOperation;

public class OperationTest {
    private static final double EPSILON = 0.0000001d;

    @Test
    public void testBasicOperation() {
        double x = 1.2;
        double y = 33.23;

        assertEquals(x+y, BasicOperation.PLUS.apply(x, y), EPSILON);
        assertEquals(x-y, BasicOperation.MINUS.apply(x, y), EPSILON);
        assertEquals(x*y, BasicOperation.TIMES.apply(x, y), EPSILON);
        assertEquals(x/y, BasicOperation.DIVIDE.apply(x, y), EPSILON);
    }
}
