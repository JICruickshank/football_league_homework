package models;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "manager")

public class Manager extends Employee {

    public Manager() {
    }

    public Manager(String name, int age, Team team) {
        super(name, age, team);
    }
}





