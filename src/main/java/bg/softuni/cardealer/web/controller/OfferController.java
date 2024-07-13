package bg.softuni.cardealer.web.controller;

import bg.softuni.cardealer.model.dto.AddOfferDto;
import bg.softuni.cardealer.model.enums.EngineType;
import bg.softuni.cardealer.service.OfferService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class OfferController {

    private final OfferService offerService;

    public OfferController(OfferService offerService) {
        this.offerService = offerService;
    }

    @ModelAttribute("allEngineTypes")
    public EngineType[] allEngineTypes(){
        return EngineType.values();
    }

    @GetMapping("/offers/add")
    public String addOffer(Model model){
        if (!model.containsAttribute("addOfferDto")) {
            model.addAttribute("addOfferDto", AddOfferDto.empty());
        }

        return "offer-add";
    }

    @PostMapping("/offers/add")
    public String createOffer(@Valid AddOfferDto addOfferDto,
                              BindingResult bindingResult,
                              RedirectAttributes redirectAttributes){

        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("addOfferDto",addOfferDto);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.addOfferDto",bindingResult);
            return "redirect:/offers/add";
        }

        long offer = offerService.createOffer(addOfferDto);
        return "redirect:/offers/" + offer;
    }

}
