package org.mikedahl.fishingdiary.controllers;

import org.mikedahl.fishingdiary.models.User;
import org.mikedahl.fishingdiary.services.CatchService;
import org.mikedahl.fishingdiary.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class DiaryController {
    @Autowired
    private CatchService cs;
    @Autowired
    private UserService userService;
    @GetMapping("/diarypage") public String DiaryPage(Model model, HttpSession session){
        User user = userService.findByEmail(session.getAttribute("username").toString());
        model.addAttribute("catches",cs.getAllbyUser(user));
        cs.getAllCatch().stream().forEach(System.out::println);
        System.out.println(session.getAttribute("username"));
        return "diarypage";
    }


}
