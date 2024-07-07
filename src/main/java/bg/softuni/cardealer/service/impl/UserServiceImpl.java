package bg.softuni.cardealer.service.impl;

import bg.softuni.cardealer.model.dto.UserRegisterDto;
import bg.softuni.cardealer.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public void registerUser(UserRegisterDto userRegisterDto) {
        System.out.println("register");
    }
}
