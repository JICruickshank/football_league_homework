package dbTest;

import db.DBHelper;
import models.Manager;
import models.Team;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class ManagerTest {

    Manager manager;
    private Team team;

    @Before
    public void setUp() throws Exception {
        team = new Team("Glasgow Celtic");
        manager = new Manager("Brendan Rodgers", 45, team);
    }

    @Test
    public void testCanSave() {
        DBHelper.saveOrUpdate(team);
        DBHelper.saveOrUpdate(manager);
        Manager found = DBHelper.findById(Manager.class, manager.getId());
        assertEquals("Brendan Rodgers", found.getName());
    }
}
