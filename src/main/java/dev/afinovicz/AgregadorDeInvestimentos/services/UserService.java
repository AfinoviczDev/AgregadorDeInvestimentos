package dev.afinovicz.AgregadorDeInvestimentos.services;

import dev.afinovicz.AgregadorDeInvestimentos.dtos.CreateAccountDTO;
import dev.afinovicz.AgregadorDeInvestimentos.dtos.UpdateUserDTO;
import dev.afinovicz.AgregadorDeInvestimentos.entity.Account;
import dev.afinovicz.AgregadorDeInvestimentos.entity.BillingAddress;
import dev.afinovicz.AgregadorDeInvestimentos.exception.NotFoundException;
import dev.afinovicz.AgregadorDeInvestimentos.dtos.CreateUserDTO;
import dev.afinovicz.AgregadorDeInvestimentos.entity.User;
import dev.afinovicz.AgregadorDeInvestimentos.repositories.AccountRepository;
import dev.afinovicz.AgregadorDeInvestimentos.repositories.BillingAddressRepository;
import dev.afinovicz.AgregadorDeInvestimentos.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final AccountRepository accountRepository;
    private final BillingAddressRepository billingAddressRepository;

    public User createUser(CreateUserDTO createUserDTO) {
        return userRepository.save(User.builder()
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

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void deleteUserById(Long id) throws NotFoundException {
        var user = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Usuário não encontrado!"));
        userRepository.deleteById(user.getId());
    }

    public void updateUserById(Long id,
                               UpdateUserDTO updateUserDTO) throws NotFoundException {
         var userEntity = userRepository.findById(id);
         if(userEntity.isPresent()) {
             var user = userEntity.get();
             if(updateUserDTO.username() != null) {
                 user.setUsername(updateUserDTO.username());
             }
             if(updateUserDTO.password() != null) {
                 user.setPassword(updateUserDTO.password());
             }
             userRepository.save(user);
         }
         else {
            throw new NotFoundException("Usuário não existe!");
         }


    }

    @Transactional
    public void createAccount(Long id, CreateAccountDTO createAccountDTO) throws NotFoundException {
        var user = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Usuário não encontrado"));
        //DTO -> ENTITY
        var account = new Account(
                null,
                createAccountDTO.description(),
                user,
                null,
                new ArrayList<>()
        );

        var accountCreated = accountRepository.save(account);
        var billingAddress = new BillingAddress(
                accountCreated.getAccountId(),
                createAccountDTO.street(),
                createAccountDTO.number(),
                account
        );

        billingAddressRepository.save(billingAddress);
    }

}
