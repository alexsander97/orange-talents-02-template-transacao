package com.example.transacao.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Transaction {

    @Id
    private String id;

    @Positive
    @Column(nullable = false)
    private BigDecimal value;

    @NotNull
    @Embedded
    private Establishment establishment;

    @NotNull
    @Embedded
    private Card card;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Deprecated
    public Transaction() {

    }

    public Transaction(String id, BigDecimal value, Establishment establishment, Card card, LocalDateTime createdAt) {
        this.id = id;
        this.value = value;
        this.establishment = establishment;
        this.card = card;
        this.createdAt = createdAt;
    }

    public String getId() {
        return id;
    }

    public BigDecimal getValue() {
        return value;
    }

    public Establishment getEstablishment() {
        return establishment;
    }

    public Card getCard() {
        return card;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
