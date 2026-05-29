package dev.afinovicz.AgregadorDeInvestimentos.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_accounts")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private Long accountId;
    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
