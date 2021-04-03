package com.example.transacao.dtos;

import com.example.transacao.entities.Card;

public class CardResponse {

    private String id;

    private String email;

    @Deprecated
    public CardResponse() {
    }

    public CardResponse(Card card) {
        this.id = card.getId();
        this.email = card.getEmail();
    }

    public Card toEntity() {
        return new Card(id, email);
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "CardResponse{" +
                "id='" + id + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
