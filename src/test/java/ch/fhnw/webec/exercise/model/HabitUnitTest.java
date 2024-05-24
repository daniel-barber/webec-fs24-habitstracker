package ch.fhnw.webec.exercise.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HabitUnitTest {
    @Test
    public void testAddLog(){
        var habit = new Habit();
        var log = new Log();

        assertEquals(0, habit.getLogs().size());

        habit.addLog(log);

        assertEquals(1, habit.getLogs().size());
    }
    @Test
    public void testAddLogMultipleTimes(){
        var habit = new Habit();
        var log = new Log();

        habit.addLog(log);
        assertEquals(1, habit.getLogs().size());

        habit.addLog(log);
        assertEquals(1, habit.getLogs().size());
    }
}
