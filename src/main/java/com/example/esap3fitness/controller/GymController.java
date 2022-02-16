package com.example.esap3fitness.controller;


import com.example.esap3fitness.model.Gym;
import com.example.esap3fitness.service.GymService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/gyms")
public class GymController {

    @Autowired
    private GymService gymService;

    @GetMapping("/create")
    public String getCreatePage(Model model) {
        model.addAttribute(new Gym());
        return "create_gym";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Gym gym) {
        gymService.create(gym);
        return "redirect:/gyms";
    }

    @GetMapping
    public String getAll(Model model) {
        List<Gym> gyms = gymService.getAll();
        model.addAttribute("gyms", gyms);
        return "show_gyms";
    }

    @GetMapping("/{id}/update")
    public String getUpdatePage(@PathVariable("id") Long id, Model model) {
        model.addAttribute("gym", gymService.get(id));
        return "update_gym";
    }

    @PatchMapping("/{id}/update")
    public String update(@PathVariable("id") Long id, @ModelAttribute Gym gym) {
        gymService.update(id, gym);
        return "redirect:/gyms";
    }

    @GetMapping("/{id}/season_passes")
    public String getSeasonPasses(@PathVariable("id") Long id, Model model){
        model.addAttribute("seasonPasses",gymService.getSeasonPasses(id));
        return "show_gym_season_passes";
    }

    @DeleteMapping("/{id}/delete")
    public String delete(@PathVariable Long id){
        gymService.delete(id);
        return "redirect:/gyms";
    }
}