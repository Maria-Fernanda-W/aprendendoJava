package service;

import model.Contato;

import java.util.ArrayList;
import java.util.Scanner;

public class GerenciadorAgendas {
    private ArrayList<Agenda> listaAgendas =  new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    private int indexAgendaAberta;

    public void adicionarAgenda() {
        try {
            System.out.println("Informe o nome para criar a Agenda");
            String nomeAgenda = scanner.nextLine();
            Agenda agenda = new Agenda(nomeAgenda);
            listaAgendas.add(agenda);

            System.out.println("\nAgenda adicionada com sucesso!!");

        } catch (Exception e) {
            System.out.println("ERRO: "+e);
        }
    }

    public String listarAgendas() {
        String lista = "";

        if( !listaAgendas.isEmpty() ) {
            for(int i=0; i < listaAgendas.size(); i++) {
                lista += ( i + " - " + listaAgendas.get(i).getNome() + "\n");
            }
        } else {
            return"ATENÇÂO: Nenhuma agenda cadastrada";
        }
        return lista;
    }

    public void abrirAgenda() {
        if ( listaAgendas.isEmpty() ) {
            System.out.println("\nATENÇÂO: Nenhuma agenda cadastrada");

        } else {
            System.out.println("--> LISTA AGENDAS");
            System.out.println(listarAgendas());
            System.out.println("Digite o n° da agenda desejada:");
            indexAgendaAberta = scanner.nextInt();
            String nomeAgendaAberta = listaAgendas.get(indexAgendaAberta).getNome();

            int menuAgenda = 0;

            do {
                System.out.println("\n--> Menu Agenda: "+nomeAgendaAberta);
                System.out.println("1 - Adicionar Contato");
                System.out.println("2 - Listar Contatos");
                System.out.println("3 - Editar Contato");
                System.out.println("4 - Remover Contato");
                System.out.println("5 - Voltar");
                System.out.print("Digite o número desejado: ");

                try {
                    menuAgenda = scanner.nextInt();
                } catch (Exception e) {
                    System.out.println("\nERRO: Opção Inválida. Digite um Número \nTente Novamente!");
                } finally {
                    scanner.nextLine();
                }

                if (menuAgenda > 0){
                    switch (menuAgenda) {
                        case 1:
                            System.out.println("opção 1");
                            adicionarContato();
                            break;
                        case 2:
                            System.out.println("opção 2");
                            break;
                        case 3:
                            System.out.println("opção 3");
                            break;
                        case 4:
                            System.out.println("opção 4");
                            break;
                        case 5:
                            break;
                        default:
                            System.out.println("\nERRO: Opção Inválida. \nTente Novamente!");
                            //menuAgenda = 0;
                            break;
                    }
                }
            } while (menuAgenda != 5);

            System.out.println("\nVoltando ...");
        }
    }

    public void adicionarContato() {
        try {
            System.out.println("Informe os dados para adicionar o Contato");
            System.out.print("Nome: ");
            String nomeContato = scanner.nextLine();
            System.out.print("Telefone: ");
            String telefoneContato = scanner.nextLine();
            Contato contato = new Contato(nomeContato, telefoneContato, null, null);
            listaAgendas.get(indexAgendaAberta).adicionarContato(contato);

            System.out.println("\nUsuário adicionado com sucesso!!");

        } catch (Exception e) {
            System.out.println("ERRO: "+e);

        }
    }

}
