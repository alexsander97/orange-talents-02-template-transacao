package com.example.transacao.dtos;

import com.example.transacao.entities.Establishment;
import com.fasterxml.jackson.annotation.JsonProperty;

public class EstablishmentResponse {

    @JsonProperty("nome")
    private String name;

    @JsonProperty("cidade")
    private String city;

    @JsonProperty("endereco")
    private String address;

    @Deprecated
    public EstablishmentResponse() {
    }

    public EstablishmentResponse(Establishment entity) {
        this.name = entity.getName();
        this.city = entity.getCity();
        this.address = entity.getAddress();
    }

    public Establishment toEntity() {
        return new Establishment(name, city, address);
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "EstablishmentResponse{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
