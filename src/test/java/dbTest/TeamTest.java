package dbTest;

import db.DBHelper;
import models.Manager;
import models.Player;
import models.Position;
import models.Team;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNull;

public class TeamTest {

    private Team team;
    private Manager manager;
    private Player player;
    private Player player2;

    @Before
    public void setUp() throws Exception {
        team = new Team("Glasgow Celtic");
        manager = new Manager("Brendan Rodgers", 45, team);
        player = new Player("Kieran Tierney", 20, team, Position.DEFENDER, 63);
        player2 = new Player("Scott Brown", 34, team, Position.MIDFIELDER, 8);
        DBHelper.saveOrUpdate(team);
    }

    @Test
    public void testCanSaveAndFind() {
        Team found = DBHelper.findById(Team.class, team.getId());
        assertEquals("Glasgow Celtic", found.getName());
    }

    @Test
    public void testCanUpdate() {
        Team found = DBHelper.findById(Team.class, team.getId());
        found.setName("Manchester United");
        DBHelper.saveOrUpdate(found);
        Team updated = DBHelper.findById(Team.class, found.getId());
        assertEquals("Manchester United", updated.getName());

    }

    @Test
    public void testCanGetPlayers() {
        DBHelper.saveOrUpdate(player);
        DBHelper.saveOrUpdate(player2);
        Team found = DBHelper.findById(Team.class, team.getId());
        List<Player> results = DBHelper.getPlayersFromTeam(found);
        assertEquals(2, results.size());
    }

    @Test
    public void testCanGetManager() {
        DBHelper.saveOrUpdate(manager);
        Team found = DBHelper.findById(Team.class, team.getId());
        Manager result = DBHelper.getManager(found);
        assertEquals("Brendan Rodgers", result.getName());
    }

    @Test
    public void testCanDelete() {
        Team found = DBHelper.findById(Team.class, team.getId());
        assertEquals("Glasgow Celtic", found.getName());
        DBHelper.delete(found);
        Team result = DBHelper.findById(Team.class, found.getId());
        assertNull(result);
    }
}
