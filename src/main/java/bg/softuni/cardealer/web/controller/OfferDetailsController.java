package bg.softuni.cardealer.web.controller;

import bg.softuni.cardealer.service.OfferService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class OfferDetailsController {

    private final OfferService offerService;

    public OfferDetailsController(OfferService offerService) {
        this.offerService = offerService;
    }

    @GetMapping("/offers/{id}")
    public String offerDetails(@PathVariable("id") Long id, Model model){
        model.addAttribute("offerDetails", offerService.getOfferDetails(id));


        return "details";
    }
}
