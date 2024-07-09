package bg.softuni.cardealer.service.impl;

import bg.softuni.cardealer.model.dto.UserRegisterDto;
import bg.softuni.cardealer.model.entity.User;
import bg.softuni.cardealer.repository.UserRepository;
import bg.softuni.cardealer.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public boolean registerUser(UserRegisterDto userRegisterDto) {
        Optional<User> byEmail = userRepository.findByEmail(userRegisterDto.getEmail());
        if(byEmail.isPresent()){
            return false;
        }
        User user = new User();

        user.setFirstName(userRegisterDto.getFirstName());
        user.setLastName(userRegisterDto.getLastName());
        user.setEmail(userRegisterDto.getEmail());
        user.setPassword(passwordEncoder.encode(userRegisterDto.getPassword()));

        this.userRepository.save(user);
        return true;
    }
}
