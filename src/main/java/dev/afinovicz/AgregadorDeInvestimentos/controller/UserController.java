package dev.afinovicz.AgregadorDeInvestimentos.controller;

import dev.afinovicz.AgregadorDeInvestimentos.exception.NotFoundException;
import dev.afinovicz.AgregadorDeInvestimentos.dtos.CreateUserDTO;
import dev.afinovicz.AgregadorDeInvestimentos.entity.User;
import dev.afinovicz.AgregadorDeInvestimentos.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
    public User findUserById(@PathVariable Long id) throws NotFoundException {
        var user = userService.getUserById(id);
        return user;
    }

}
