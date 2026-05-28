package dev.afinovicz.AgregadorDeInvestimentos.repositories;

import dev.afinovicz.AgregadorDeInvestimentos.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
