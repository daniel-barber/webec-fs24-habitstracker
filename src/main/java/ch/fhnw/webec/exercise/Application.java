package ch.fhnw.webec.exercise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import java.util.TimeZone;

//back
@SpringBootApplication
public class Application {

    // Help from GPT to fix timezone issue
    @EventListener
    void contextRefreshedEvent(ContextRefreshedEvent event) {
        TimeZone.setDefault(TimeZone.getTimeZone("Europe/Zurich"));
    }
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
