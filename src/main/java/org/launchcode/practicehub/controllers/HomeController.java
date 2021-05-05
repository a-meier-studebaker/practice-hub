package org.launchcode.practicehub.controllers;

import org.launchcode.practicehub.data.PracticeRepository;
import org.launchcode.practicehub.models.Practice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    @Autowired
    private PracticeRepository practiceRepository;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("title", "My Dashboard");
        return "index";
    }

    @PostMapping
    public String processAddPracticeForm(@ModelAttribute Practice newPractice,
                                         Model model) {
        return "redirect:";
    }

    @GetMapping("practices")
    public String displayAllPractices(Model model) {
        model.addAttribute("title", "All Practices");
        return "practices";
    }

}
