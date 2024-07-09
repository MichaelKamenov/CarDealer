package bg.softuni.cardealer.service;

import bg.softuni.cardealer.model.dto.UserRegisterDto;

public interface UserService {

    boolean registerUser(UserRegisterDto userRegisterDto);
}
