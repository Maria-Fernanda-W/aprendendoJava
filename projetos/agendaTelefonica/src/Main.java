import service.GerenciadorAgendas;

import java.util.Scanner;

public class Main {
    public static GerenciadorAgendas grdAgenda = new GerenciadorAgendas();
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int menuIncial = 0;

        System.out.println("\n------------------------------ AGENDA TELEFÔNICA ------------------------------");
        do {
            System.out.println("\n--> Menu");
            System.out.println("1 - Listar Agendas");
            System.out.println("2 - Criar Agenda Telefônica");
            System.out.println("3 - Excluir Agenda Telefônica");
            System.out.println("4 - Abrir Agenda Telefônica");
            System.out.println("5 - Sair");
            System.out.print("Digite o número desejado: ");

            try {
                menuIncial = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("\nERRO: Opção Inválida. Digite um Número \nTente Novamente!");
                continue;
            } finally {
                scanner.nextLine();
            }

            switch (menuIncial) {
                case 1:
                    System.out.println(">> LISTA AGENDAS");
                    System.out.println(grdAgenda.listarAgendas());
                    break;
                case 2:
                    grdAgenda.adicionarAgenda();
                    break;
                case 3:
                    grdAgenda.removerAgenda();
                    break;
                case 4:
                    grdAgenda.abrirAgenda();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("\nERRO: Opção Inválida. \nTente Novamente!");
                    break;
            }
        } while (menuIncial != 5);

        scanner.close();
        System.out.println("\nSaindo ...");
        System.out.println("Programa Finalizado");
    }
}