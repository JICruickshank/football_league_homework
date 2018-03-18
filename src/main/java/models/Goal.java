package models;

import org.hibernate.annotations.Fetch;

import javax.persistence.*;

@Entity
@Table(name = "goals")
public class Goal {

    private int id;
    private Team team;
    private Player scorer;
    private Match match;
    private int minute;

    public Goal() {
    }

    public Goal(Player scorer, Match match, int minute) {
        this.team = scorer.getTeam();
        this.scorer = scorer;
        this.match = match;
        this.minute = minute;
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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "team_id")
    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    @Column(name = "player")
    public Player getScorer() {
        return scorer;
    }

    public void setScorer(Player scorer) {
        this.scorer = scorer;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "match_id")
    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }

    @Column(name = "minute")
    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }
}
