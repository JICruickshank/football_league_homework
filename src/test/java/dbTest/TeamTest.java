package dbTest;

import db.DBHelper;
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
        team = new Team("Glasgow Celtic");
        manager = new Manager("Brendan Rodgers", 45, team);
        player = new Player("Kieran Tierney", 20, team, Position.DEFENDER, 63);
        DBHelper.saveOrUpdate(team);
        DBHelper.saveOrUpdate(manager);
        DBHelper.saveOrUpdate(player);

    }

    @Test
    public void testCanGetPlayers() {
        Team found = DBHelper.findById(Team.class, team.getId());
        int result = DBHelper.getPlayersFromTeam(found).size();
        assertEquals(1, result);
    }

    @Test
    public void testCanGetManager() {
        Team found = DBHelper.findById(Team.class, team.getId());
        Manager result = DBHelper.getManager(found);
        assertEquals("Brendan Rodgers", result.getName());
    }
}
