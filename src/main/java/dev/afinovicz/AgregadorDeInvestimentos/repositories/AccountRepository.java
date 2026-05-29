package dev.afinovicz.AgregadorDeInvestimentos.repositories;

import dev.afinovicz.AgregadorDeInvestimentos.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
