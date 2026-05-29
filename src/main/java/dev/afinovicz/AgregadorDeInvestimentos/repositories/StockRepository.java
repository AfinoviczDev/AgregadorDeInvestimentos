package dev.afinovicz.AgregadorDeInvestimentos.repositories;

import dev.afinovicz.AgregadorDeInvestimentos.entity.Account;
import dev.afinovicz.AgregadorDeInvestimentos.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock, String> {
}
