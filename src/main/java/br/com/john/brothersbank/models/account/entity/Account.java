package br.com.john.brothersbank.models.account.entity;

import br.com.john.brothersbank.config.BooleanToStringConverter;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "accounts")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "account_number", unique = true)
    private String accountNumber;

    protected BigDecimal balance;

    @Column(name = "owner_name")
    private String ownerName;

    @Column(name = "owner_id")
    private Long ownerId;

    @Column(name = "account_type")
    @Enumerated(EnumType.STRING)
    private AccountType accountType;

    @Convert(converter = BooleanToStringConverter.class)
    @Column(name = "status")
    private Boolean active;
}
