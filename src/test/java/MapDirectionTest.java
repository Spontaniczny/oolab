import agh.ics.oop.MapDirection;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MapDirectionTest {

    @Test
    public void Test_next_method(){
        MapDirection direction = MapDirection.EAST;
        assertEquals(direction.next(), MapDirection.SOUTH);
        assertEquals(direction.next().next(), MapDirection.WEST);
        assertEquals(direction.next().next().next(), MapDirection.NORTH);
        assertEquals(direction.next().next().next().next(), MapDirection.EAST);
    }

    @Test
    public void Test_previous_method(){
        MapDirection direction = MapDirection.EAST;
        assertEquals(direction.previous(), MapDirection.NORTH);
        assertEquals(direction.previous().previous(), MapDirection.WEST);
        assertEquals(direction.previous().previous().previous(), MapDirection.SOUTH);
        assertEquals(direction.previous().previous().previous().previous(), MapDirection.EAST);
    }
}
