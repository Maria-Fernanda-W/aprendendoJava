package service;

import model.Contato;

import java.util.ArrayList;
import java.util.Scanner;

public class Agenda {
    String nome;
    ArrayList<Contato> listaContatos;

    private Scanner scanner = new Scanner(System.in);

    public Agenda(String nome) {
        this.nome = nome;
        listaContatos = new ArrayList<>();
    }

    public String listarContatos() {
        String lista = "";
        if (listaContatos.isEmpty()) {
            return "ATENÇÂO: Nenhum contato cadastrado";

        } else {
            for (int i = 0; i < listaContatos.size(); i++) {
                lista += "(" + i + ") - Nome: " + listaContatos.get(i).getNome() + " Telefone: " + listaContatos.get(i).getTelefone() + "\n";
            }
        }
        return lista;
    }

    public void adicionarContato() {
        try {
            System.out.println("Informe os dados para adicionar o Contato");
            System.out.print("Nome: ");
            String nomeContato = scanner.nextLine();
            System.out.print("Telefone: ");
            String telefoneContato = scanner.nextLine();
            Contato contato = new Contato(nomeContato, telefoneContato);

            adicionarContatoPrivate(contato);

        } catch (Exception e) {
            System.out.println("ERRO: " + e);
        }
    }

    private void adicionarContatoPrivate(Contato contato) {
        try {
            listaContatos.add(contato);
            System.out.println("Usuário adicionado com sucesso!!");

        } catch (NullPointerException e) {
            System.out.println("Não foi possíviel adicionar contato!");
        }
    }

    public void removerContato() {
        if (listaContatos.isEmpty()) {
            System.out.println("ATENÇÂO: Nenhuma agenda cadastrada");

        } else {
            System.out.println("\n--> Agenda: " + nome + "\n>> LISTA CONTATOS ");
            System.out.println(listarContatos());
            System.out.print("Digite o n° do contato para excluir: ");
            int indexContato;
            Contato contato;
            try {
                indexContato = scanner.nextInt();
                contato = listaContatos.get(indexContato);

            } catch (IndexOutOfBoundsException e) {
                System.out.println("ATENÇÃO: Opção inválida");
                return;
            } finally {
                scanner.nextLine();
            }

            removerContatoPrivate(contato);
        }
    }

    public void removerContatoPrivate(Contato contato) {
        try {
            listaContatos.remove(contato);
            System.out.println("Contato excluído com sucesso! ");

        } catch (NullPointerException e) {
            System.out.println("Não foi possíviel remover contato!");
        }
    }

    public void pesquisarPorNome() {
        System.out.println("\n>> Pesquisa por Nome");
        System.out.print("Digite o nome para pesquisar: ");
        String nome = scanner.nextLine();

        Contato resultado = pesquisarPorNomePrivate(nome);

        if( resultado == null ) {
            System.out.println("ERRO: Contato não encontrado");
        } else {
            System.out.println("Resultado:");
            System.out.println( resultado.toString() );

        }
    }

    private Contato pesquisarPorNomePrivate(String nome) {
        nome = nome.trim().toUpperCase();
        int inf = 0;
        int sup = listaContatos.size() - 1;

        while (inf <= sup) {
            int med = (inf + sup) / 2;

            if (listaContatos.get(med).getNome().trim().toUpperCase().compareToIgnoreCase(nome) == 0) {
                return listaContatos.get(med);
            } else if (listaContatos.get(med).getNome().trim().toUpperCase().compareToIgnoreCase(nome) > 0) {
                sup = med - 1;
            } else {
                inf = med + 1;
            }
        }
        return null;
    }

    public void pesquisarPorTelefone() {
        System.out.println("\n>> Pesquisa por Telefone");
        System.out.print("Digite o telefone para pesquisar: ");
        String telefone = scanner.nextLine();

        Contato resultado = pesquisarPorTelefonePrivate(telefone);

        if( resultado == null ) {
            System.out.println("ERRO: Contato não encontrado");
        } else {
            System.out.println("Resultado:");
            System.out.println( resultado.toString() );

        }
    }

    private Contato pesquisarPorTelefonePrivate(String telefone) {
        telefone = telefone.trim().toUpperCase();
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

    public int getQuantidadeContatos() {
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
