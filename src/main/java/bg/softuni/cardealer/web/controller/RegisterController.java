package bg.softuni.cardealer.web.controller;

import bg.softuni.cardealer.model.dto.UserRegisterDto;
import bg.softuni.cardealer.service.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/users")
public class RegisterController {

    private final UserService userService;

    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @ModelAttribute("registerDto")
    public UserRegisterDto userRegisterDto(){
        return new UserRegisterDto();
    }

    @GetMapping("/register")
    public String register(){
        return "auth-register";
    }

    @PostMapping("/register")
    public String register(UserRegisterDto userData){
        userService.registerUser(userData);

        return "redirect:/";
    }
}
