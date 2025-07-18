package com.agenda_telefonica.API.Agenda.Telefonica.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
public class Agenda {

    @Setter
    private String nome;

    private ArrayList<Contato> listaContatos;

    public Agenda(String nome) {
        this.nome = nome;
        listaContatos = new ArrayList<>();
    }

    public void adicionarContato(Contato contato) {
        listaContatos.add(contato);
    }

    public void removerContato(Contato contato) {
        listaContatos.remove(contato);
    }

}
