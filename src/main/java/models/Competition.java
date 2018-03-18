package models;

import java.util.ArrayList;
import java.util.List;

public class Competition {

    private String name;
    private List<Team> teams;
    private int id;

    public Competition(String name, List<Team> teams) {
        this.name = name;
        this.teams = new ArrayList<Team>();
    }

    public Competition() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }

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

}
