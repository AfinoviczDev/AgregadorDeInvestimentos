package dev.afinovicz.AgregadorDeInvestimentos.controller;

import dev.afinovicz.AgregadorDeInvestimentos.exception.NotFoundException;
import dev.afinovicz.AgregadorDeInvestimentos.dtos.CreateUserDTO;
import dev.afinovicz.AgregadorDeInvestimentos.entity.User;
import dev.afinovicz.AgregadorDeInvestimentos.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@RequestBody CreateUserDTO createUserDTO) {
        userService.createUser(createUserDTO);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public User findUserById(@PathVariable Long id) throws NotFoundException {
        var user = userService.getUserById(id);
        return user;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

}
