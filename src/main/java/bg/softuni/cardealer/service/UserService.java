package bg.softuni.cardealer.service;

import bg.softuni.cardealer.model.dto.UserLoginDto;
import bg.softuni.cardealer.model.dto.UserRegisterDto;

public interface UserService {

    void registerUser(UserRegisterDto userRegisterDto);
}
