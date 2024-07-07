package bg.softuni.cardealer.web.controller;

import bg.softuni.cardealer.model.dto.UserRegisterDto;
import bg.softuni.cardealer.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterController {

    private final UserService userService;

    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String register(){
        return "auth-register";
    }

    @PostMapping("/user/register")
    public String doRegister(UserRegisterDto userData){

        userService.registerUser(userData);
        return "redirect:/auth-login";
    }
}
