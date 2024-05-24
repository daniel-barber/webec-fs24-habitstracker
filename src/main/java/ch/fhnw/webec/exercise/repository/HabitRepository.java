package ch.fhnw.webec.exercise.repository;

import ch.fhnw.webec.exercise.model.Habit;
import ch.fhnw.webec.exercise.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface HabitRepository extends JpaRepository<Habit, Integer> {
    List<Habit> findByUser(User user);
}
