package models;

public class Goal {

    private int id;
    private Team team;
    private Player scorer;
    private Match match;

    public Goal() {
    }

    public Goal(Team team, Player scorer, Match match) {
        this.team = team;
        this.scorer = scorer;
        this.match = match;
    }
}
