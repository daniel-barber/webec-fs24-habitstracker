package ch.fhnw.webec.exercise.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

import java.util.ArrayList;
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

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "habit", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Log> logs = new ArrayList<>();

    public void addLog(Log log) {
        if (!this.logs.contains(log)) {
            this.logs.add(log);
            log.setHabit(this);
        }
    }
    public void removeLog(Log log) {
        if (this.logs.contains(log)) {
            this.logs.remove(log);
            log.setHabit(null);
        }
    }


    public void setLogs(List<Log> logs) {
        // Remove existing logs
        for (Log log : new ArrayList<>(this.logs)) {
            removeLog(log);
        }
        // Add new logs
        for (Log log : logs) {
            addLog(log);
        }
    }

    // Getters and setters
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

    public User getUser() {
        return user;
    }

    public void setUser(User currentUser) {
        this.user = currentUser;
    }
}
