package ch.fhnw.webec.exercise.controller;

import ch.fhnw.webec.exercise.repository.HabitRepository;
import ch.fhnw.webec.exercise.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class HabitController {
    @Autowired
    private HabitRepository habitRepository;
    @Autowired
    private LogRepository logRepository;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String index(@RequestParam() Optional <String> search, Model model) {
        model.addAttribute("habits", this.habitRepository.findAll());
        return "habits/index";
    }
}
