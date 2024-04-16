package ch.fhnw.webec.exercise.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;

@Entity
public class Habit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty
    private String name;

    @NotEmpty
    @Column(columnDefinition = "TEXT")
    private String description;

    @NotEmpty
    @OneToMany
    private List<Log> logs;

    public void addLog(Log log){
        if(!this.getLogs().contains(log)){
        this.getLogs().add(log);
        }
        if(log.getHabit() != this){
            log.setHabit(this);
        }

    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Log> getLogs() {
        return logs;
    }

    public void setLogs(List<Log> logs) {
        this.logs = logs;
    }
}
