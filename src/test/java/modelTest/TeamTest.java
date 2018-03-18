package modelTest;

import models.Manager;
import models.Player;
import models.Position;
import models.Team;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNull;

public class TeamTest {

    private Team team;
    private Manager manager;
    private Player player;

    @Before
    public void setUp() throws Exception {
        team = new Team("Glasgow Celtic");
        manager = new Manager("Brendan Rodgers",45, team);
        player = new Player("Kieran Tierney", 20, team, Position.DEFENDER, 63);

    }

    @Test
    public void testCanGetTeamName() {
        assertEquals("Glasgow Celtic", team.getName());
    }
}
