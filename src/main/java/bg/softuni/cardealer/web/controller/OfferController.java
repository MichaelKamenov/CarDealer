package bg.softuni.cardealer.web.controller;

import bg.softuni.cardealer.model.dto.AddOfferDto;
import bg.softuni.cardealer.model.enums.EngineType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class OfferController {

    @GetMapping("/offers/add")
    public String addOffer(Model model){
        if (!model.containsAttribute("addOfferDto")) {
            model.addAttribute("addOfferDto", new AddOfferDto());
        }

        model.addAttribute("allEngineTypes", EngineType.values());
        return "offer-add";
    }

    @PostMapping("/offers/add")
    public String createOffer(AddOfferDto addOfferDto){
        return "offer-add";
    }

}
