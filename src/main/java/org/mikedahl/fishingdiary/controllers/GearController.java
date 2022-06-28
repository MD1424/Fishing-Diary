package org.mikedahl.fishingdiary.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.mikedahl.fishingdiary.models.Gear;
import org.mikedahl.fishingdiary.services.GearService;

@Controller
public class GearController {

    private GearService gearService;


    @Autowired
    public GearController(GearService gearService) {
        super();
        this.gearService = gearService;

    }

    //handler method to handle list of equipment and return model and view
    @GetMapping("/gear")
    public String listGear(Model model) {
        model.addAttribute("gear", gearService.getAllGear());
        return "gear";
    }
    @GetMapping("/gear/new")
    public String creategearForm(Model model) {
        //create equipment object to hold equipment form data using Track table for choices
        Gear gear = new Gear();
        model.addAttribute("gear", gear);
        return "create_gear";
    }

    @PostMapping("/gear")
    public String saveGear(@ModelAttribute("gear") Gear gear) {
        gearService.saveGear(gear);
        return "redirect:/gear";
    }
    @GetMapping("/gear/edit/{id}")
    public String editGearForm(@PathVariable Integer id, Model model) {
        model.addAttribute("gear", gearService.getGearById(id));


        return "edit_gear";
    }
    @PostMapping("/gear/{id}")
    public String updateGear(@PathVariable Integer id, @ModelAttribute("gear") Gear gear, Model model) {
        //get equipment from database by id
        Gear existingGear = gearService.getGearById(id);
        existingGear.setId(id);
        existingGear.setPoleType(gear.getPoleType());
        existingGear.setStringWeight(gear.getStringWeight());
        existingGear.setBait(gear.getBait());

        //saves updated equipment
        gearService.updateGear(existingGear);
        return "redirect:/Gear";

    }
    @GetMapping("/Gear/{id}")
    public String deleteGear(@PathVariable Integer id) {
        gearService.deleteGearById(id);
        return "redirect:/gear";
    }
}
