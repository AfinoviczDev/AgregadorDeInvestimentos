package dev.afinovicz.AgregadorDeInvestimentos.repositories;

import dev.afinovicz.AgregadorDeInvestimentos.entity.Account;
import dev.afinovicz.AgregadorDeInvestimentos.entity.BillingAddress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillingAddressRepository extends JpaRepository<BillingAddress, Long> {
}
