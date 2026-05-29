package dev.afinovicz.AgregadorDeInvestimentos.repositories;

import dev.afinovicz.AgregadorDeInvestimentos.entity.Account;
import dev.afinovicz.AgregadorDeInvestimentos.entity.AccountStock;
import dev.afinovicz.AgregadorDeInvestimentos.entity.AccountStockId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountStockRepository extends JpaRepository<AccountStock, AccountStockId> {
}
