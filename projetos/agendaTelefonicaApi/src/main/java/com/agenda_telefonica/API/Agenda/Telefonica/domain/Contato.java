package com.agenda_telefonica.API.Agenda.Telefonica.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
public class Contato {
    private String nome;
    private int telefone;
    private Endereco endereco;
}
