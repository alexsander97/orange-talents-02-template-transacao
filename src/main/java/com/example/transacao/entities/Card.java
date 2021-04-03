package com.example.transacao.entities;

import javax.persistence.Embeddable;


@Embeddable
public class Card {

    private String idCard;

    private String email;

    @Deprecated
    public Card() {

    }
    public Card(String idCard, String email) {
        this.idCard = idCard;
        this.email = email;
    }

    public String getId() {
        return idCard;
    }

    public String getEmail() {
        return email;
    }
}
