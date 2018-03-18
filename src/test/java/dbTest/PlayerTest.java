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
    private Team team2;

    @Before
    public void setUp() throws Exception {
        team = new Team("Glasgow Celtic");
        team2 = new Team("Wigan Athletic");
        player = new Player("Kieran Tierney", 20, team, Position.DEFENDER, 63);
    }

    @Test
    public void testCanChangeTeam() {
        DBHelper.saveOrUpdate(team);
        DBHelper.saveOrUpdate(team2);
        DBHelper.saveOrUpdate(player);
        Player foundPlayer = DBHelper.findById(Player.class, player.getId());
        assertEquals("Glasgow Celtic", foundPlayer.getTeam().getName());
        foundPlayer.setTeam(team2);
        DBHelper.saveOrUpdate(foundPlayer);
        Player updatedPlayer = DBHelper.findById(Player.class, player.getId());
        assertEquals("Wigan Athletic", updatedPlayer.getTeam().getName());
    }

//    @Test
//    public void testCanDelete() {
//        DBHelper.saveOrUpdate(team);
//        DBHelper.saveOrUpdate(player);
//        Player found = DBHelper.findById(Player.class, player.getId());
//        assertEquals("Kieran Tierney", found.getName());
//        DBHelper.delete(found);
//        assertNull(DBHelper.findById(Player.class, player.getId()));
//    }
}
