package models;

import javax.persistence.*;

@Entity
@Table(name = "players")
public class Player extends Employee {

    private Position position;
    private int squadNumber;

    public Player() {
    }

    public Player(String name, int age, Team team, Position position, int squadNumber) {
        super(name, age, team);
        this.position = position;
        this.squadNumber = squadNumber;
    }

    @Column(name = "position")
    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    @Column(name = "squad_number")
    public int getSquadNumber() {
        return squadNumber;
    }

    public void setSquadNumber(int squadNumber) {
        this.squadNumber = squadNumber;
    }
}
