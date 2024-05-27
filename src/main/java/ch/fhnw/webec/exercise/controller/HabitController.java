package ch.fhnw.webec.exercise.controller;

import ch.fhnw.webec.exercise.model.Habit;
import ch.fhnw.webec.exercise.model.Log;
import ch.fhnw.webec.exercise.model.User;
import ch.fhnw.webec.exercise.repository.HabitRepository;
import ch.fhnw.webec.exercise.repository.LogRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.Authentication;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Controller
public class HabitController {
    @Autowired
    private HabitRepository habitRepository;
    @Autowired
    private LogRepository logRepository;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String index(@RequestParam() Optional <String> search, Model model) {

        // Fetch habits only for the logged-in user
        User currentUser = getCurrentUser();
        List<Habit> habits = this.habitRepository.findByUser(currentUser);
        model.addAttribute("habits", habits);
        return "habit/index";
    }

    @RequestMapping(path = "/habit/{id}", method = RequestMethod.GET)
    public String detailHabits(@PathVariable() int id, Model model){
        Habit habit = this.habitRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        // Ensure that the habit belongs to the logged-in user
        User currentUser = getCurrentUser();
        if (habit.getUser().getId() != currentUser.getId()) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);
        }

        model.addAttribute("habit", habit);
        return "habit/detail";
    }

    @RequestMapping(path="/habit/add", method = RequestMethod.GET)
    public String addHabit(Model model){
        return "habit/add";

    }

    @RequestMapping(path = "/habit/add", method = RequestMethod.POST)
    public String addHabit(@Valid Habit habit, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("habit", habit);
            return "habit/add";
        } else {
            User currentUser = getCurrentUser();
            // Check if authentication is working correctly
            if (currentUser == null) {
                throw new ResponseStatusException(HttpStatus.FORBIDDEN, "User is not authenticated");
            }

            //set current user to the habit
            habit.setUser(currentUser);

            this.habitRepository.save(habit);
            return "redirect:/habit/" + habit.getId();

        }
    }


    @RequestMapping(path = "/habit/{id}/edit", method = RequestMethod.GET)
    public String editHabit(@PathVariable int id, Model model) {
        Habit habit = this.habitRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        // Ensure that the habit belongs to the logged-in user
        User currentUser = getCurrentUser();
        if (habit.getUser().getId() != currentUser.getId()) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);
        }

        model.addAttribute("habit", habit);
        return "habit/edit";
    }
//help from ChatGPT
    @RequestMapping(path = "/habit/{id}/edit", method = RequestMethod.POST)
    public String editHabit(@PathVariable int id, @Valid Habit habit, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("habit", habit);
            return "habit/edit";
        } else {
            Habit existingHabit = this.habitRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

            // Ensure that the habit belongs to the logged-in user
            User currentUser = getCurrentUser();
            if (existingHabit.getUser().getId() != currentUser.getId()) {
                throw new ResponseStatusException(HttpStatus.FORBIDDEN);
            }

            // Update the existing habit's properties
            existingHabit.setName(habit.getName());
            existingHabit.setDescription(habit.getDescription());

            // Save the updated habit
            Habit updatedHabit = this.habitRepository.save(existingHabit);

            model.addAttribute("habit", updatedHabit);
            model.addAttribute("logs", updatedHabit.getLogs());

            return "redirect:/habit/" + updatedHabit.getId();
        }
    }






    @RequestMapping(path = "/habit/{habitId}/log/add", method = RequestMethod.POST)
    public String addLog(@PathVariable int habitId, @Valid Log log, BindingResult bindingResult, Model model){
        Habit habit = this.habitRepository.findById(habitId)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        // Ensure that the habit belongs to the logged-in user
        User currentUser = getCurrentUser();
        if (habit.getUser().getId() != currentUser.getId()) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);
        }

        if (bindingResult.hasErrors()) {
            model.addAttribute("habit", habit);
            model.addAttribute("log", log);
            return "/habit/" + habit.getId();
        } else {
            log.setHabit(habit);
            try {
                this.logRepository.save(log);
            } catch (Exception e) {
                System.err.println("Error saving log: " + e.getMessage());
                e.printStackTrace();
                model.addAttribute("errorMessage", "Error saving log: " + e.getMessage());
                return "redirect:/habit/" + habit.getId();
            }
            return "redirect:/habit/" + habit.getId();
        }
    }


    @RequestMapping(path = "/habit/{id}/delete", method = RequestMethod.POST)
    public String deleteHabit(@PathVariable int id) {
        Habit habit = this.habitRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        // Ensure that the habit belongs to the logged-in user
        User currentUser = getCurrentUser();
        if (habit.getUser().getId() != currentUser.getId()) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);
        }

        this.habitRepository.delete(habit);
        return "redirect:/";
    }

    private User getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return (User) authentication.getPrincipal();
    }

}
