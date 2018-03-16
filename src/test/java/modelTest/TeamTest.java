package modelTest;

import models.Manager;
import models.Player;
import models.Position;
import models.Team;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class TeamTest {

    private Team team;
    private Manager manager;
    private Player player;

    @Before
    public void setUp() throws Exception {
        manager = new Manager("Brendan Rodgers", 45);
        team = new Team("Glasgow Celtic", manager);
    }

    @Test
    public void testCanGetTeamName() {
        assertEquals("Glasgow Celtic", team.getName());
    }

    @Test
    public void testCanGetManager() {
        assertEquals("Brendan Rodgers", team.getManager().getName());
    }

    @Test
    public void testCanAddPlayer() {
        assertEquals(0, team.getPlayers().size());
        player = new Player("Kieran Tierney", 20, Position.DEFENDER, 63);
        team.addPlayerToTeam(player);
        assertEquals(1, team.getPlayers().size());
        }
}
