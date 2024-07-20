package bg.softuni.cardealer.service.impl;


import bg.softuni.cardealer.model.entity.UserRoles;
import bg.softuni.cardealer.model.enums.UserRoleEnum;
import bg.softuni.cardealer.model.user.CarUserDetails;
import bg.softuni.cardealer.model.entity.UserEntity;
import bg.softuni.cardealer.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public class CarUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public CarUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository
                .findByEmail(email)
                .map(CarUserDetailsService::map)
                .orElseThrow(() -> new UsernameNotFoundException("This " + email + "is not found!"));
    }

    private static UserDetails map(UserEntity userEntity){
        return new CarUserDetails(
                userEntity.getEmail(),
                userEntity.getPassword(),
                userEntity.getRoles().stream().map(UserRoles::getRole).map(CarUserDetailsService::map).toList(),
                userEntity.getFirstName(),
                userEntity.getLastName());

    }


    private static GrantedAuthority map(UserRoleEnum role){
        return new SimpleGrantedAuthority(
                "ROLE_" + role
        );
    }

}
