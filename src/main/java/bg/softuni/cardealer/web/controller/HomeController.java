package bg.softuni.cardealer.web.controller;

import bg.softuni.cardealer.model.user.CarUserDetails;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {


    @GetMapping("/")
    public String home(@AuthenticationPrincipal UserDetails userDetails, Model model){

        if(userDetails instanceof CarUserDetails carUserDetails){
            model.addAttribute("welcomeMsg", carUserDetails.fullName());
        }else {
            model.addAttribute("welcomeMsg", "Anonymous");
        }

        return "index";
    }
}
