package org.mikedahl.fishingdiary.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/")
    public String root() {
        return "redirect:/diarypage";
    }

    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }

    @GetMapping("/user")
    public String userIndex() {
        return "user/index";
    }
    @GetMapping("/fishtypes")
    public String fishTypes(){return "fishtypes";}
    @GetMapping("/about")
    public String about(){return "about";}
}
