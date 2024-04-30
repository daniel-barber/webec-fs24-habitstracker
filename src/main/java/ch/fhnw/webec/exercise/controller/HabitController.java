package ch.fhnw.webec.exercise.controller;

import ch.fhnw.webec.exercise.model.Habit;
import ch.fhnw.webec.exercise.repository.HabitRepository;
import ch.fhnw.webec.exercise.repository.LogRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

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

    @RequestMapping(path = "/habit/{id}", method = RequestMethod.GET)
    public String detailHabits(@PathVariable() int id, Model model){
        model.addAttribute("habit", this.habitRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)));
        System.out.println(this.habitRepository.findById(id));
        return "habits/detail";
    }
    @RequestMapping(path="/habit/add", method = RequestMethod.GET)
    public String addHabit(Model model){
        return "habits/add";

    }

    @RequestMapping(path = "/habit/add", method = RequestMethod.POST)
    public String addBook(@Valid Habit habit, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("Habit", habit);

            return "habits/add";
        } else {
            this.habitRepository.save(habit);

            return "redirect:/habits/" + habit.getId();
        }
    }
}
