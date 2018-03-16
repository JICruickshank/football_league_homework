package models;

public class Player extends Staff {

    private Position position;
    private int squadNumber;

    public Player() {
    }

    public Player(String name, int age, Position position, int squadNumber) {
        super(name, age);
        this.position = position;
        this.squadNumber = squadNumber;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public int getSquadNumber() {
        return squadNumber;
    }

    public void setSquadNumber(int squadNumber) {
        this.squadNumber = squadNumber;
    }
}
