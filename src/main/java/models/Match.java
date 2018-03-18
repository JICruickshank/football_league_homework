package models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "matches")

public class Match {

    private Team homeTeam;
    private Team awayTeam;
    private List<Team> teams;
    private Competition competition;
    private List<Goal> homeTeamGoals;
    private List<Goal> awayTeamGoals;
    private int id;

    public Match() {
    }

    public Match(Team homeTeam, Team awayTeam, Competition competition) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.competition = competition;
        this.homeTeamGoals = new ArrayList<Goal>();
        this.awayTeamGoals = new ArrayList<Goal>();
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "home_team_id", nullable = false)
    public Team getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(Team homeTeam) {
        this.homeTeam = homeTeam;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "away_team_id", nullable = false)
    public Team getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(Team awayTeam) {
        this.awayTeam = awayTeam;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "competition_id")
    public Competition getCompetition() {
        return competition;
    }

    public void setCompetition(Competition competition) {
        this.competition = competition;
    }

    @OneToMany(mappedBy = "match")
    @Column(name = "goal_id")
    public List<Goal> getHomeTeamGoals() {
        return homeTeamGoals;
    }

    public void setHomeTeamGoals(List<Goal> goals) {
        this.homeTeamGoals = goals;
    }

    @OneToMany(mappedBy = "match")
    @Column(name = "goal_id")
    public List<Goal> getAwayTeamGoals() {
        return awayTeamGoals;
    }

    public void setGoals(List<Goal> goals) {
        this.homeTeamGoals = goals;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
