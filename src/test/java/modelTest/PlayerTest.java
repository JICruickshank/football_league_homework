package modelTest;

import models.Player;
import models.Position;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class PlayerTest {

    private Player player;

    @Before
    public void setUp() throws Exception {
        player = new Player("Kieran Tierney", 20, Position.DEFENDER, 63);
    }

    @Test
    public void testHasName() {
        assertEquals("Kieran Tierney", player.getName());
    }

    @Test
    public void testCanGetAge() {
        assertEquals(20, player.getAge());
    }

    @Test
    public void testCanGetPosition() {
        assertEquals(Position.DEFENDER, player.getPosition());
    }

    @Test
    public void testCanGetSquadNumber() {
        assertEquals(63, player.getSquadNumber());
    }
}
