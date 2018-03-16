package dbTest;

import db.DBHelper;
import models.Player;
import models.Position;
import models.Team;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class PlayerTest {

    private Player player;
    private Team team;

    @Before
    public void setUp() throws Exception {
        team = new Team("Glasgow Celtic");
        player = new Player("Kieran Tierney", 20, team, Position.DEFENDER, 63);
        DBHelper.saveOrUpdate(team);
        DBHelper.saveOrUpdate(player);

    }

    @Test
    public void testCanSave() {
        Player found = DBHelper.findById(Player.class, player.getId());
        assertEquals(63, found.getSquadNumber());
    }

    @Test
    public void testCanUpdate() {
        Player found = DBHelper.findById(Player.class, player.getId());
        assertEquals(63, found.getSquadNumber());
        found.setSquadNumber(12);
        DBHelper.saveOrUpdate(found);
        Player updated = DBHelper.findById(Player.class, found.getId());
        assertEquals(12, found.getSquadNumber());
    }

    @Test
    public void testCanGetList() {
        Player player2 = new Player("Moussa Dembele", 20, team, Position.ATTACKER, 10);
        DBHelper.saveOrUpdate(player2);
        List<Player> players = DBHelper.getAll(Player.class);
        assertTrue(players.size() > 0);
    }

        @Test
    public void testCanDelete() {
        Player found = DBHelper.findById(Player.class, player.getId());
        assertEquals("Kieran Tierney", player.getName());
        DBHelper.delete(found);
        Player result = DBHelper.findById(Player.class, player.getId());
        assertNull(result);


    }
}
