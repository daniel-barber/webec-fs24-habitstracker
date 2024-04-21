package ch.fhnw.webec.exercise.repository;

import ch.fhnw.webec.exercise.model.Log;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogRepository extends JpaRepository<Log, Integer> {
}
