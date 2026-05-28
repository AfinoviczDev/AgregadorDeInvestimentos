package dev.afinovicz.AgregadorDeInvestimentos.controller;

import dev.afinovicz.AgregadorDeInvestimentos.dtos.CreateUserDTO;
import dev.afinovicz.AgregadorDeInvestimentos.entity.User;
import dev.afinovicz.AgregadorDeInvestimentos.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public void createUser(@RequestBody CreateUserDTO createUserDTO) {
      userService.createUser(createUserDTO);
    }

    @GetMapping("/{id}")
    public Optional<User> findUserById(@PathVariable Long id) {
        var user = userService.getUserById(id);
        return user;
    }

}
