package modelTest;

import models.Manager;
import models.Team;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class TeamTest {

    private Team team;
    private Manager manager;

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
}
