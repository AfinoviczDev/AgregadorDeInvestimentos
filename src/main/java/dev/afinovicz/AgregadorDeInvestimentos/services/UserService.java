package dev.afinovicz.AgregadorDeInvestimentos.services;

import dev.afinovicz.AgregadorDeInvestimentos.exception.NotFoundException;
import dev.afinovicz.AgregadorDeInvestimentos.dtos.CreateUserDTO;
import dev.afinovicz.AgregadorDeInvestimentos.entity.User;
import dev.afinovicz.AgregadorDeInvestimentos.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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

    public User getUserById(Long id) throws NotFoundException {
        var user = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Usuário não encontrado!"));
        return user;
    }


}
