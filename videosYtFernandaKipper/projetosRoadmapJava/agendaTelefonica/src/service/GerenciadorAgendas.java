package service;

import java.util.ArrayList;
import java.util.Scanner;

public class GerenciadorAgendas {
    private ArrayList<Agenda> listaAgendas = new ArrayList<>();
    private int indexAgendaAberta;
    private Agenda agendaAberta;

    private Scanner scanner = new Scanner(System.in);

    public String listarAgendas() {
        String lista = "";
        if (listaAgendas.isEmpty()) {
            return "ATENÇÂO: Nenhuma agenda cadastrada";

        } else {
            for (int i = 0; i < listaAgendas.size(); i++) {
                lista += "(" + i + ") - " + listaAgendas.get(i).getNome() + "\n";
            }
        }
        return lista;
    }

    public void adicionarAgenda() {
        try {
            System.out.println("Informe o nome para criar a Agenda");
            String nomeAgenda = scanner.nextLine();
            Agenda agenda = new Agenda(nomeAgenda);
            adicionarAgendaPrivate(agenda);

        } catch (Exception e) {
            System.out.println("ERRO: " + e);
        }
    }

    private void adicionarAgendaPrivate(Agenda agenda) {
        try {
            listaAgendas.add(agenda);
            System.out.println("Agenda adicionada com sucesso!!");

        } catch (NullPointerException e) {
            System.out.println("ERRO:Não foi possível adicionar agenda.");
        }
    }

    public void removerAgenda() {
        if (listaAgendas.isEmpty()) {
            System.out.println("\nATENÇÂO: Nenhuma agenda cadastrada");

        } else {
            System.out.println(">> LISTA AGENDAS");
            System.out.println(listarAgendas());

            System.out.print("Digite o n° da agenda para excluir: ");
            int indexAgenda;
            Agenda agenda;
            try {
                indexAgenda = scanner.nextInt();
                agenda = listaAgendas.get(indexAgenda);

            } catch (IndexOutOfBoundsException e) {
                System.out.println("ATENÇÃO: Opção inválida");
                return;
            } finally {
                scanner.nextLine();
            }

            removerAgendaPrivate(agenda);
        }
    }

    private void removerAgendaPrivate(Agenda agenda) {
        try {
            listaAgendas.remove(agenda);
            System.out.println("Agenda excluída com sucesso! ");

        } catch (NullPointerException e) {
            System.out.println("ERRO:Não foi possível excluir agenda.");
        }
    }

    public void abrirAgenda() {
        if (listaAgendas.isEmpty()) {
            System.out.println("\nATENÇÂO: Nenhuma agenda cadastrada");

        } else {
            System.out.println(">> LISTA AGENDAS");
            System.out.println(listarAgendas());
            System.out.print("Digite o n° da agenda para abrir: ");

            try {
                indexAgendaAberta = scanner.nextInt();
                agendaAberta = listaAgendas.get(indexAgendaAberta);

            } catch (IndexOutOfBoundsException e) {
                System.out.println("ATENÇÃO: Opção inválida");
                return;
            } finally {
                scanner.nextLine();
            }

            int menuAgenda = 0;
            do {
                System.out.println("\n--> Menu \n--> Agenda: " + agendaAberta.getNome() );
                System.out.println("1 - Listar Contatos");
                System.out.println("2 - Adicionar Contato");
                System.out.println("3 - Remover Contato");
                System.out.println("4 - Pesquisar Contato por Nome");
                System.out.println("5 - Pesquisar Contato por Telefone");
                System.out.println("6 - Voltar");
                System.out.print("Digite o número desejado: ");

                try {
                    menuAgenda = scanner.nextInt();
                } catch (Exception e) {
                    System.out.println("\nERRO: Opção Inválida. Digite um Número \nTente Novamente!");
                    continue;
                } finally {
                    scanner.nextLine();
                }

                switch (menuAgenda) {
                    case 1:
                        System.out.println("\n--> Agenda: " + agendaAberta.getNome() + "\n>> LISTA CONTATOS ");
                        System.out.println(agendaAberta.listarContatos());
                        break;
                    case 2:
                        agendaAberta.adicionarContato();
                        break;
                    case 3:
                        agendaAberta.removerContato();
                        break;
                    case 4:
                        agendaAberta.pesquisarPorNome();
                        break;
                    case 5:
                        agendaAberta.pesquisarPorTelefone();
                        break;
                    case 6:
                        break;
                    default:
                        System.out.println("\nERRO: Opção Inválida. \nTente Novamente!");
                        break;
                }
            } while (menuAgenda != 6);

            System.out.println("\nVoltando ...");
        }
    }
}