package dbTest;

import db.DBHelper;
import models.Competition;
import models.Team;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;

public class CompetitionTest {

    private Competition competition;
    private Team team1;
    private Team team2;
    private List<Team> teams;

    @Before
    public void setUp() throws Exception {
        teams = new ArrayList<Team>();
        team1 = new Team("Glasgow Celtic");
        team2 = new Team("Motherwell");
        competition = new Competition("Scottish Cup");
    }

    @Test
    public void testCanSave() {
        DBHelper.saveOrUpdate(competition);
        Competition found = DBHelper.findById(Competition.class, competition.getId());
        assertEquals("Scottish Cup", found.getName());
    }
}
