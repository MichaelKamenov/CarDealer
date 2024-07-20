package bg.softuni.cardealer.service.impl;

import bg.softuni.cardealer.model.dto.UserRegisterDto;
import bg.softuni.cardealer.model.entity.UserEntity;
import bg.softuni.cardealer.repository.UserRepository;
import bg.softuni.cardealer.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

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
    public void registerUser(UserRegisterDto userRegisterDto) {
        userRepository.save(map(userRegisterDto));
    }

    private UserEntity map(UserRegisterDto userRegisterDto){
        UserEntity userEntity = modelMapper.map(userRegisterDto, UserEntity.class);
        userEntity.setPassword(passwordEncoder.encode(userRegisterDto.getPassword()));
        return userEntity;
    }
}
