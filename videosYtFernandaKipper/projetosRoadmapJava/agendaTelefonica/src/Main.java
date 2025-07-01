import service.Agenda;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static ArrayList<Agenda> listaAgendas =  new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int menuIncial = 0;

        System.out.println("\n------------------------------ AGENDA TELEFÔNICA ------------------------------");

        do {
            System.out.println("\nMenu");
            System.out.println("1 - Criar Agenda Telefônica");
            System.out.println("2 - Listar Agendas");
            System.out.println("3 - Abrir Agenda Telefônica");
            System.out.println("4 - Sair");
            System.out.print("Digite o número desejado: ");

            try {
                menuIncial = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("\nERRO: Opção Inválida. Digite um Número \nTente Novamente!");
            } finally {
                scanner.nextLine();
            }
            //System.out.println("valor de menuInicial: "+menuIncial);
            if (menuIncial > 0) {
                switch (menuIncial) {
                    case 1:
                        adicionarAgenda();
                        System.out.println("\nAgenda adicionada com sucesso!!");
                        break;
                    case 2:
                        System.out.println("--> LISTA AGENDAS");
                        if(listarAgendas().isBlank()) {
                            System.out.println("ATENÇÂO: Nenhuma agenda cadastrada");
                        } else {
                            System.out.println( listarAgendas() );
                        }
                        break;
                    case 3:
                        if(listarAgendas().isBlank()) {
                            System.out.println("ATENÇÂO: Nenhuma agenda cadastrada");
                        } else {
                            System.out.println("--> LISTA AGENDAS");
                            System.out.println(listarAgendas());
                            abrirAgenda();
                        }
                        break;

                    default:
                        System.out.println("\nERRO: Opção Inválida. \nTente Novamente!");
                        menuIncial = 0;
                        break;
                }
            }
        } while (menuIncial != 4);

        scanner.close();
        System.out.println("\nSaindo ...");
        System.out.println("Programa Finalizado");
    }

    static public void adicionarAgenda() {
        try {
            System.out.println("Informe os dados para criar a Agenda");
            String nomeAgenda = scanner.nextLine();
            Agenda agenda = new Agenda(nomeAgenda);
            listaAgendas.add(agenda);

        } catch (Exception e) {
            System.out.println("ERRO: "+e);
        }
    }

    static public String listarAgendas() {
        String lista = "";
        for(int i=0; i < listaAgendas.size(); i++) {
            lista += ( i + " - " + listaAgendas.get(i).getNome() + "\n");
        }

        return lista;
    }

    static public void abrirAgenda() {
        System.out.println("Digite o número desejado:");
        int indexAgendaAberta = scanner.nextInt();
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

            switch (menuAgenda) {
                case 1:
                    System.out.println("opção 1");
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
                default:
                    System.out.println("\nERRO: Opção Inválida. \nTente Novamente!");
                    menuAgenda = 0;
                    break;
            }

        } while (menuAgenda != 5);
        System.out.println("\nVoltando ...");

    }

}