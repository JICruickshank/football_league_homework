package modelTest;

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
        team1 = new Team("Glasgow Celtic");
        team2 = new Team("Motherwell");
        teams = new ArrayList<Team>();
        competition = new Competition("Scottish Cup", teams);
    }

    @Test
    public void testCanAddTeams() {
        assertEquals(0, competition.getTeams().size());
        competition.addTeam(team1);
        competition.addTeam(team2);
        assertEquals(2, competition.getTeams().size());
    }

    @Test
    public void testCanRemoveTeams() {
        competition.addTeam(team1);
        assertEquals(1, competition.getTeams().size());
        competition.removeTeam(team1);
        assertEquals(0, competition.getTeams().size());
    }

    @Test
    public void testCan() {
    }
}
