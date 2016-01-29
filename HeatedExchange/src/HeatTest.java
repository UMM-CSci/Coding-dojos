import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class HeatTest {
    
    Room room1;
    Room room2;
    Wall wall;
    Building home = new Building();
    
    @Before
    public void setup() {
        room1 = new Room(50.0);
        room2 = new Room(66.0);
        wall = new Wall(.5, room1, room2);
        home.buildWall(wall);
    }
    
    @Test
    public void testInitial() {
        assertEquals(50.0, room1.getTemp(), .01);
        assertEquals(66.0, room2.getTemp(), .01);
        assertEquals(.5, wall.getInsulation(), .01);
        assertEquals(room1, wall.getRoom1());
        assertEquals(room2, wall.getRoom2());
    }

    @Test
    public void testFirstHour() {
        home.passHour();
        assertEquals(54.0, room1.getTemp(), .01);
        assertEquals(62.0, room2.getTemp(), .01);
    }
    
    @Test
    public void testSecondHour() {
        for (int i = 0; i < 2; i++) {
            home.passHour();
        }
        assertEquals(56.0, room1.getTemp(), .01);
        assertEquals(60.0, room2.getTemp(), .01);
    }
    
    @Test
    public void testThirdHour() {
        for (int i = 0; i < 3; i++) {
            home.passHour();
        }
        assertEquals(57.0, room1.getTemp(), .01);
        assertEquals(59.0, room2.getTemp(), .01);
    }
}
