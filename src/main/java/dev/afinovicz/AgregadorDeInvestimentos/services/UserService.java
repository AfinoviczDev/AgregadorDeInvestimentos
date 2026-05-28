package dev.afinovicz.AgregadorDeInvestimentos.services;

import dev.afinovicz.AgregadorDeInvestimentos.dtos.CreateUserDTO;
import dev.afinovicz.AgregadorDeInvestimentos.entity.User;
import dev.afinovicz.AgregadorDeInvestimentos.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void createUser(CreateUserDTO createUserDTO) {
        userRepository.save(User.builder()
                .username(createUserDTO.username())
                .email(createUserDTO.email())
                .password(createUserDTO.password())
                .build());
    }

    public Optional<User> getUserById(Long id) {
        var user = userRepository.findById(id);
        return user;
    }


}
