package dev.afinovicz.AgregadorDeInvestimentos.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_accounts_stocks")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class AccountStock {

    @EmbeddedId
    private AccountStockId accountStockId;

    @ManyToOne
    @MapsId("accountId")
    @JoinColumn(name = "account_id")
    private Account account;

    @ManyToOne
    @MapsId("stockId")
    @JoinColumn(name = "stock_id")
    private Stock stock;

    @Column(name = "quantity")
    private Integer quantity;
}
