package service;

import model.Contato;

import java.util.ArrayList;

public class Agenda {
    String nome;
    ArrayList<Contato> listaContatos;

    public Agenda(String nome) {
        this.nome = nome;
        listaContatos = new ArrayList<>();
    }

    public void adicionarContato(Contato contato) {
        try {
            listaContatos.add(contato);
        } catch (NullPointerException e) {
            System.out.println("Não foi possíviel adicionar contato!");
        }

    }

//    public void editarContato(String nome) {
//        try {
//
//
//        } catch (NullPointerException e) {
//            System.out.println("Não foi possíviel editar contato!");
//        }
//    }

    public void removerContato(String nome) {
        try {
            Contato contato = pesquisarPorNome(nome);
            listaContatos.remove(contato);

        } catch (NullPointerException e) {
            System.out.println("Não foi possíviel remover contato!");
        }
    }

    public Contato pesquisarPorNome(String nome) {
        int inf = 0;
        int sup = listaContatos.size() - 1;

        while (inf <= sup) {
            int med = (inf + sup) / 2;

            if (listaContatos.get(med).getNome().compareToIgnoreCase(nome) == 0) {
                return listaContatos.get(med);
            } else if (listaContatos.get(med).getNome().compareToIgnoreCase(nome) > 0) {
                sup = med - 1;
            } else {
                inf = med + 1;
            }
        }
        return null;
    }

    public Contato pesquisarPorNumero(String telefone) {
        int inf = 0;
        int sup = listaContatos.size() - 1;

        while (inf <= sup) {
            int med = (inf + sup) / 2;

            if (listaContatos.get(med).getTelefone().compareToIgnoreCase(telefone.trim()) == 0) {
                return listaContatos.get(med);
            } else if (listaContatos.get(med).getTelefone().trim().compareToIgnoreCase(telefone.trim()) > 0) {
                sup = med - 1;
            } else {
                inf = med + 1;
            }
        }
        return null;
    }

    public int quantidadeContatos() {
        return listaContatos.size();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String toString() {
        return "Agenda: " + nome;
    }
}
