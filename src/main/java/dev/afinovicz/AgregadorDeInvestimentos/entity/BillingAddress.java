package dev.afinovicz.AgregadorDeInvestimentos.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "tb_billing_address")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class BillingAddress {

    @Id
    private Long id;
    @Column(name = "street")
    private String street;
    @Column(name = "number")
    private Integer number;
}
