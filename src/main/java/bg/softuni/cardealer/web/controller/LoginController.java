package bg.softuni.cardealer.web.controller;

import bg.softuni.cardealer.model.dto.UserLoginDto;
import bg.softuni.cardealer.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class LoginController {

    @GetMapping("/login")
    public String login(){
        return "auth-login";
    }


}
