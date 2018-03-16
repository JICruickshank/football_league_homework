package models;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "manager")

public class Manager extends Staff {

    public Manager() {
    }

    public Manager(String name, int age) {
        super(name, age);
    }
}





