package ch.fhnw.webec.exercise.repository;

import ch.fhnw.webec.exercise.model.Habit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface HabitRepository extends JpaRepository<Habit, Integer> {

    @Query("""
            SELECT DISTINCT habit FROM Habit habit
            INNER JOIN habit.name name
        """)
    List<Habit> findBySearch(@Param("search") String search);

}
