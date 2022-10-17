import agh.ics.oop.Vector2d;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Vector2dTest {

    @Test
    public void Test_equals_method(){
        Vector2d vector1 = new Vector2d(2, 1);
        Vector2d vector2 = new Vector2d(2, 1);
        Vector2d vector3 = new Vector2d(5, 1);
        Vector2d vector4 = new Vector2d(2, 5);
        Vector2d vector5 = new Vector2d(5, 5);
        Vector2d vector6 = new Vector2d(-2, -1);
        assertTrue(vector1.equals(vector2));
        assertFalse(vector1.equals(vector3));
        assertFalse(vector1.equals(vector4));
        assertFalse(vector1.equals(vector5));
        assertFalse(vector1.equals(vector6));
    }

    @Test
    public void Test_toString_method(){
        Vector2d vector1 = new Vector2d(2, 1);
        Vector2d vector2 = new Vector2d(-2, 0);
        assertEquals(vector1.toString(), "(2,1)");
        assertEquals(vector2.toString(), "(-2,0)");
    }

    @Test
    public void Test_precedes_method(){
        Vector2d vector1 = new Vector2d(2, 2);
        Vector2d vector2 = new Vector2d(2, 2);
        Vector2d vector3 = new Vector2d(2, 3);
        Vector2d vector4 = new Vector2d(3, 2);
        Vector2d vector5 = new Vector2d(2, 1);
        Vector2d vector6 = new Vector2d(1, 2);
        Vector2d vector7 = new Vector2d(1, 1);
        Vector2d vector8 = new Vector2d(-100, -100);
        Vector2d vector9 = new Vector2d(5, 5);
        assertTrue(vector1.precedes(vector1));
        assertTrue(vector1.precedes(vector2));
        assertTrue(vector1.precedes(vector3));
        assertTrue(vector1.precedes(vector4));
        assertFalse(vector1.precedes(vector5));
        assertFalse(vector1.precedes(vector6));
        assertFalse(vector1.precedes(vector7));
        assertFalse(vector1.precedes(vector8));
        assertTrue(vector1.precedes(vector9));
    }

    @Test
    public void Test_follows_method(){
        Vector2d vector1 = new Vector2d(2, 2);
        Vector2d vector2 = new Vector2d(2, 2);
        Vector2d vector3 = new Vector2d(2, 3);
        Vector2d vector4 = new Vector2d(3, 2);
        Vector2d vector5 = new Vector2d(2, 1);
        Vector2d vector6 = new Vector2d(1, 2);
        Vector2d vector7 = new Vector2d(1, 1);
        Vector2d vector8 = new Vector2d(-100, -100);
        Vector2d vector9 = new Vector2d(5, 5);
        assertTrue(vector1.follows(vector1));
        assertTrue(vector1.follows(vector2));
        assertFalse(vector1.follows(vector3));
        assertFalse(vector1.follows(vector4));
        assertTrue(vector1.follows(vector5));
        assertTrue(vector1.follows(vector6));
        assertTrue(vector1.follows(vector7));
        assertTrue(vector1.follows(vector8));
        assertFalse(vector1.follows(vector9));

    }

    @Test
    public void Test_follows_upperRight(){
        Vector2d vector1 = new Vector2d(2, 2);
        Vector2d vector2 = new Vector2d(2, 2);
        Vector2d vector3 = new Vector2d(2, 3);
        Vector2d vector4 = new Vector2d(3, 2);
        Vector2d vector5 = new Vector2d(2, 1);
        Vector2d vector6 = new Vector2d(1, 2);
        Vector2d vector7 = new Vector2d(1, 1);
        Vector2d vector8 = new Vector2d(-100, -100);
        Vector2d vector9 = new Vector2d(100, 100);
        Vector2d vector10 = new Vector2d(5, 5);

        assertTrue(vector1.upperRight(vector1).equals(new Vector2d(2, 2)));
        assertTrue(vector1.upperRight(vector2).equals(new Vector2d(2, 2)));
        assertTrue(vector1.upperRight(vector3).equals(new Vector2d(2, 3)));
        assertTrue(vector1.upperRight(vector4).equals(new Vector2d(3, 2)));
        assertTrue(vector1.upperRight(vector5).equals(new Vector2d(2, 2)));
        assertTrue(vector1.upperRight(vector6).equals(new Vector2d(2, 2)));
        assertTrue(vector1.upperRight(vector7).equals(new Vector2d(2, 2)));
        assertTrue(vector1.upperRight(vector8).equals(new Vector2d(2, 2)));
        assertTrue(vector1.upperRight(vector9).equals(new Vector2d(100, 100)));
        assertTrue(vector1.upperRight(vector10).equals(new Vector2d(5, 5)));
    }
    @Test
    public void Test_follows_lowerLeft(){
        Vector2d vector1 = new Vector2d(2, 2);
        Vector2d vector2 = new Vector2d(2, 2);
        Vector2d vector3 = new Vector2d(2, 3);
        Vector2d vector4 = new Vector2d(3, 2);
        Vector2d vector5 = new Vector2d(2, 1);
        Vector2d vector6 = new Vector2d(1, 2);
        Vector2d vector7 = new Vector2d(1, 1);
        Vector2d vector8 = new Vector2d(-100, -100);
        Vector2d vector9 = new Vector2d(100, 100);
        Vector2d vector10 = new Vector2d(5, 5);

        assertTrue(vector1.lowerLeft(vector1).equals(new Vector2d(2, 2)));
        assertTrue(vector1.lowerLeft(vector2).equals(new Vector2d(2, 2)));
        assertTrue(vector1.lowerLeft(vector3).equals(new Vector2d(2, 2)));
        assertTrue(vector1.lowerLeft(vector4).equals(new Vector2d(2, 2)));
        assertTrue(vector1.lowerLeft(vector5).equals(new Vector2d(2, 1)));
        assertTrue(vector1.lowerLeft(vector6).equals(new Vector2d(1, 2)));
        assertTrue(vector1.lowerLeft(vector7).equals(new Vector2d(1, 1)));
        assertTrue(vector1.lowerLeft(vector8).equals(new Vector2d(-100, -100)));
        assertTrue(vector1.lowerLeft(vector9).equals(new Vector2d(2, 2)));
        assertTrue(vector1.lowerLeft(vector10).equals(new Vector2d(2, 2)));
    }

    @Test
    public void Test_add_method(){
        Vector2d vector1 = new Vector2d(2, 1);
        Vector2d vector2 = new Vector2d(-2, -1);
        Vector2d vector3 = new Vector2d(5, 1);
        Vector2d vector4 = new Vector2d(50, 20);
        Vector2d vector5 = new Vector2d(0, 0);


        assertTrue(vector1.add(vector1).equals(new Vector2d(4, 2)));
        assertTrue(vector1.add(vector2).equals(new Vector2d(0, 0)));
        assertTrue(vector1.add(vector3).equals(new Vector2d(7, 2)));
        assertTrue(vector1.add(vector4).equals(new Vector2d(52, 21)));
        assertTrue(vector1.add(vector5).equals(new Vector2d(2, 1)));

    }

    @Test
    public void Test_subtract_method(){
        Vector2d vector1 = new Vector2d(2, 1);
        Vector2d vector2 = new Vector2d(-2, -1);
        Vector2d vector3 = new Vector2d(5, 5);
        Vector2d vector4 = new Vector2d(50, 20);
        Vector2d vector5 = new Vector2d(0, 0);
        assertTrue(vector1.subtract(vector1).equals(new Vector2d(0, 0)));
        assertTrue(vector1.subtract(vector2).equals(new Vector2d(4, 2)));
        assertTrue(vector1.subtract(vector3).equals(new Vector2d(-3, -4)));
        assertTrue(vector1.subtract(vector4).equals(new Vector2d(-48, -19)));
        assertTrue(vector1.subtract(vector5).equals(new Vector2d(2, 1)));


    }

    @Test
    public void Test_opposite_method() {
        Vector2d vector1 = new Vector2d(2, 1);
        Vector2d vector2 = new Vector2d(-2, -1);
        Vector2d vector3 = new Vector2d(5, -5);
        Vector2d vector4 = new Vector2d(0, 0);
        assertTrue(vector1.opposite().equals(new Vector2d(-2, -1)));
        assertTrue(vector2.opposite().equals(new Vector2d(2, 1)));
        assertTrue(vector3.opposite().equals(new Vector2d(-5, 5)));
        assertTrue(vector4.opposite().equals(new Vector2d(0, 0)));


    }
}
