package dbTest;

import db.DBHelper;
import models.Manager;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class ManagerTest {

    Manager manager;

    @Before
    public void setUp() throws Exception {
        manager = new Manager("Brendan Rodgers", 45);
    }

    @Test
    public void testCanSave() {
        DBHelper.saveOrUpdate(manager);
        Manager found = DBHelper.findById(Manager.class, manager.getId());
        assertEquals("Brendan Rodgers", found.getName());
    }
}
