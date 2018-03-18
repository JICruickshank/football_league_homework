package modelTest;

import models.Competition;
import models.Match;
import models.Team;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class MatchTest {

    private Team team1;
    private Team team2;
    private Competition competition;
    private Match match;

    @Before
    public void setUp() throws Exception {
        team1 = new Team("Glasgow Celtic");
        team2 = new Team("Motherwell");
        competition = new Competition("Scottish Cup");
        match = new Match(team1, team2, competition);
    }

    @Test
    public void testHasHomeTeam() {
        assertEquals("Glasgow Celtic", match.getHomeTeam().getName());
    }
}
