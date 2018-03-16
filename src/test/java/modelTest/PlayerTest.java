package modelTest;

import models.Player;
import models.Position;
import models.Team;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class PlayerTest {

    private Player player;
    private Team team;

    @Before
    public void setUp() throws Exception {
        team = new Team("Glasgow Celtic");
        player = new Player("Kieran Tierney", 20, team, Position.DEFENDER, 63);
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

    @Test
    public void testHasTeam() {
        assertEquals("Glasgow Celtic", player.getTeam().getName());
    }
}
