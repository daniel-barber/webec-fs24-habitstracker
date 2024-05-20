package ch.fhnw.webec.exercise.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

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
    @JoinColumn(name = "habit_id", nullable = false)
    private Habit habit;

    public Habit getHabit() {
        return habit;
    }

    public void setHabit(Habit habit) {
        this.habit = habit;
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

    public String getEntryTime(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy',' HH:mm 'Uhr'", Locale.GERMAN);
        return entryTime.format(formatter);
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
