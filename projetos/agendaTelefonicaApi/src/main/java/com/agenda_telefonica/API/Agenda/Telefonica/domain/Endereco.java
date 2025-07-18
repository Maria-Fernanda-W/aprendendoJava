package com.agenda_telefonica.API.Agenda.Telefonica.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Endereco {
    private String rua, bairro, cidade, estado;
    private int numero, cep;

    @Override
    public String toString() {
        return rua +  ", " +  numero + " - " + bairro + ", " + cidade + " - " + estado + ", " + cep;
    }
}
