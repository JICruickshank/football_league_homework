package models;

import java.util.ArrayList;
import java.util.List;

public class Team {

    private List<Player> players;
    private Manager manager;
    private String name;
    private int id;

    public Team() { }

    public Team(String name, Manager manager) {
        this.players = new ArrayList<Player>();
        this.manager = manager;
        this.name = name;
    }


    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }


    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void addPlayerToTeam(Player player) {
        players.add(player);
    }
}

