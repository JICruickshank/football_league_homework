package models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "teams")
public class Team {

    private List<Employee> employees;
    private String name;
    private int id;
    private List<Competition> competitions;

    public Team() {
    }

    public Team(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "team")
    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees ) {
        this.employees = employees;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    @ManyToMany
    @JoinTable(name = "competition_team",
            joinColumns = {@JoinColumn(name = "team_id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "competition_id,", nullable = false, updatable = false)})

    public List<Competition> getCompetitions() {
        return competitions;
    }

    public void setCompetitions(List<Competition> competitions) {
        this.competitions = competitions;
    }

    public void enterCompetition(Competition competition) {
        competitions.add(competition);
    }
}
