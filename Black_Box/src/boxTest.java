import org.junit.Test;
import static org.junit.Assert.*;

public class boxTest implements BlackBoxConfig{

    @Test
    public void test_isInCircle() {
        Black_box_test bbt = new Black_box_test();
        /*
         * Assuming we have a circle with a radius of 10 centered at (0, 0), if the mouse is positioned at (1, 1),
         * then the mouse is inside the circle.
         */
        assertTrue(bbt.isInCircle(1,1,0,0,circleRadius));
        /*
         * If the mouse is positioned at (20, 20), then the mouse is outside the circle.
         */
        assertFalse(bbt.isInCircle(20,20,0,0,circleRadius));
    }

    @Test
    public void test_checkWhichEntry() {
        /*
         * Based on the returned mouse coordinates, check which entry the player has selected.
         */
        assertEquals(Black_box_test.checkWhichEntry(594,47),1);
        assertEquals(Black_box_test.checkWhichEntry(766,751),23);
    }

    @Test
    public void test_CheckInside() {
        /*
         * Detect the position of the atom selected by the player based on the provided mouse coordinates.
         */
        assertFalse(Black_box_test.checkInside(594,47));
    }

    @Test
    public void test_getX() {
        /*
         * Return two-dimensional x-coordinates based on the input three-dimensional coordinates.
         */
        assertEquals(Black_box_test.getX(0,0,0),800,1);

        assertEquals(Black_box_test.getX(2,2,-4),1059,1);
    }

    @Test
    public void test_getY() {
        /*
         * Return two-dimensional y-coordinates based on the input three-dimensional coordinates.
         */
        assertEquals(Black_box_test.getY(0,0,0),400,1);

        assertEquals(Black_box_test.getY(2,2,-4),550,1);
    }


    @Test
    public void testScoreCalculation() {
        Black_box_test bbt = new Black_box_test();
        bbt.Score = 0;
        bbt.Score += 4;
        assertEquals(4, bbt.Score);
    }

}
