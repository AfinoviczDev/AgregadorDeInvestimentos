package dev.afinovicz.AgregadorDeInvestimentos.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;
import org.hibernate.annotations.Columns;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class AccountStockId {

    @Column(name = "account_id")
    private Long accountId;
    @Column(name = "stock_id")
    private Long stockId;

}
