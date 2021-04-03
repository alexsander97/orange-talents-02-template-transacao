package com.example.transacao.dtos;


import com.example.transacao.entities.Transaction;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransactionResponse {

    @JsonProperty("id")
    private String id;

    @JsonProperty("valor")
    private BigDecimal value;

    @JsonProperty("estabelecimento")
    private EstablishmentResponse establishment;

    @JsonProperty("cartao")
    private CardResponse card;

    @JsonProperty("efetivadaEm")
    private LocalDateTime createdAt;

    @Deprecated
    public TransactionResponse(){
    }

    public TransactionResponse(Transaction entity) {
        this.id = entity.getId();
        this.value = entity.getValue();
        this.establishment = new EstablishmentResponse(entity.getEstablishment());
        this.card = new CardResponse(entity.getCard());
        this.createdAt = entity.getCreatedAt();
    }

    public Transaction toEntity() {
        return new Transaction(id, value, establishment.toEntity(), card.toEntity(), createdAt);
    }

    public String getId() {
        return id;
    }

    public BigDecimal getValue() {
        return value;
    }

    public EstablishmentResponse getEstablishment() {
        return establishment;
    }

    public CardResponse getCard() {
        return card;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

}
