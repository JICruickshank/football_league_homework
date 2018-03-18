package models;

import java.util.ArrayList;
import java.util.List;

public class Match {

    private Team homeTeam;
    private Team awayTeam;
    private Competition competition;
    private List<Goal> goals;
    private int id;

    public Match() {
    }

    public Match(Team homeTeam, Team awayTeam, Competition competition) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.competition = competition;
        this.goals = new ArrayList<Goal>();
    }
}
