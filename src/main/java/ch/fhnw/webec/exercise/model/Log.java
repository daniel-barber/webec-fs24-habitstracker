package ch.fhnw.webec.exercise.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class Log {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty
    private String title;

    @CreationTimestamp
    private LocalDateTime entryTime;

    @ManyToOne
    private Habit habit;
    public Habit getHabit() {
        return habit;
    }

    public void setHabit(Habit habit) {
        this.habit = habit;
        this.habit.addLog(this);
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIdNull(){ this.id = Integer.parseInt(null);}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }



//    public Timestamp getEntryTime() {
//        return entryTime;
//    }
//
//    public void setEntryTime(Timestamp entryTime) {
//        this.entryTime = entryTime;
//    }


}
