package org.mikedahl.fishingdiary.controllers;

import org.mikedahl.fishingdiary.dto.CatchDto;
import org.mikedahl.fishingdiary.models.*;
import org.mikedahl.fishingdiary.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class CatchController {
    @Autowired
    private CatchService catchService;
    @Autowired
    private GearService gearService;
    @Autowired
    private WeatherService weatherService;
    @Autowired
    private FishSpecsService fishSpecsService;
    @Autowired
    private BOWService bowService;
    @Autowired
    private UserService userService;
    private final String DIARY_PAGE = "redirect:/diarypage";

    private CatchDto maptodto(Catch c){

        CatchDto catchDto = new CatchDto();
        catchDto.setId(c.getId());
        catchDto.setWeather(c.getWeather().getWeatherType());
        catchDto.setBow(c.getBow().getBOW());
        catchDto.setBait(c.getGear().getBait());
        catchDto.setLength(c.getFs().getLength());
        catchDto.setFishSpecies(c.getFs().getFishSpecies());
        catchDto.setPoleType(c.getGear().getPoleType());
        catchDto.setStringWeight(c.getGear().getStringWeight());
        catchDto.setWeight(c.getFs().getWeight());
        return catchDto;
    }

    @PostMapping("/NewCatch")
    public String newcatch(@ModelAttribute("newcatch") CatchDto newcatch, HttpSession session){
        Catch newCatch = new Catch();
        newCatch.setUser(userService.findByEmail(session.getAttribute("username").toString()));
        newCatch.setBow(bowService.saveBOW(new BOW(newcatch.getBow())));
        newCatch.setWeather(weatherService.saveWeather(new Weather(newcatch.getWeather())));
        newCatch.setGear(gearService.saveGear(new Gear(newcatch.getPoleType(),newcatch.getStringWeight(),newcatch.getBait())));
        newCatch.setFs(fishSpecsService.saveFishSpecs(new FishSpecs(newcatch.getFishSpecies(),newcatch.getWeight(),newcatch.getLength())));
        catchService.saveCatch(newCatch);
        return DIARY_PAGE;
    }
    @GetMapping("/catchpage")
    public String catchpage(){
        return "catchpage";
    }

    @ModelAttribute("newcatch")
    public CatchDto catchDto() {
        return new CatchDto();
    }

    @GetMapping("/catch/edit/{id}")
    public String editCatch(@PathVariable Integer id, Model model) {
        model.addAttribute("catch", maptodto(catchService.getCatchById(id)));
        return "update-catchpage";
    }

    @PostMapping("/catch/{id}")
    public String updateCatch(@PathVariable Integer id, @ModelAttribute("catch") CatchDto c, Model model) {
        //get catch from database by id
        Catch existingCatch = catchService.getCatchById(id);
        existingCatch.setId(id);
        existingCatch.setBow(bowService.saveBOW(new BOW(c.getBow())));
        existingCatch.setWeather(weatherService.saveWeather(new Weather(c.getWeather())));
        existingCatch.setGear(gearService.saveGear(new Gear(c.getPoleType(),c.getStringWeight(),c.getBait())));
        existingCatch.setFs(fishSpecsService.saveFishSpecs(new FishSpecs(c.getFishSpecies(),c.getWeight(),c.getLength())));

        //save updated catch
        catchService.updateCatch(existingCatch);
        return DIARY_PAGE;

    }

    // delete catch by ID
    @GetMapping("/catch/{id}")
    public String deleteCatch(@PathVariable Integer id) {
        catchService.deleteCatchById(id);
        return DIARY_PAGE;
    }
}
