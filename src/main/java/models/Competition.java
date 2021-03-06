package models;

import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "competitions")

public class Competition {

    private String name;
    private List<Team> teams;
    private int id;
    private List<Match> fixtures;

    public Competition() { }

    public Competition(String name) {
        this.name = name;
        this.teams = new ArrayList<Team>();
        this.fixtures = new ArrayList<Match>();
    }


    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "competitions")
    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
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

    public void addTeam(Team team) {
        this.teams.add(team);
    }

    public void removeTeam(Team team) {
        this.teams.remove(team);
    }

    @OneToMany(mappedBy = "competition")
//    @Column(name = "match_id")
    public List<Match> getFixtures() {
        return fixtures;
    }

    public void setFixtures(List<Match> fixtures) {
        this.fixtures = fixtures;
    }
}
