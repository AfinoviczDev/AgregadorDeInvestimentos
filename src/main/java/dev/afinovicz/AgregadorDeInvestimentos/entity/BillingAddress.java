package dev.afinovicz.AgregadorDeInvestimentos.entity;

import jakarta.persistence.*;
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
    @Column(name = "account_id")
    private Long id;
    @Column(name = "street")
    private String street;
    @Column(name = "number")
    private Integer number;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id")
    @MapsId
    private Account account;
}
