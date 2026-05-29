package dev.afinovicz.AgregadorDeInvestimentos.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "tb_stocks")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class Stock {

    @Id
    @Column(name = "stock_id")
    private String stockId; // PETR4, MGLU4
    @Column(name = "description")
    private String description;
}
