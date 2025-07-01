import service.GerenciadorAgendas;

import java.util.Scanner;

public class MainTeste {
    public static GerenciadorAgendas grdAgenda = new GerenciadorAgendas();
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
                continue;
            } finally {
                scanner.nextLine();
            }
            //System.out.println("valor de menuInicial: "+menuIncial);
            //if (menuIncial > 0) {
            switch (menuIncial) {
                case 1:
                    grdAgenda.adicionarAgenda();
                    break;
                case 2:
                    System.out.println("--> LISTA AGENDAS");
                    System.out.println(grdAgenda.listarAgendas());
                    break;
                case 3:
                    grdAgenda.abrirAgenda();
                    break;
                case 4:
                    break;
                default:
                    System.out.println("\nERRO: Opção Inválida. \nTente Novamente!");
                    //menuIncial = 0;
                    break;
            }
            //}
        } while (menuIncial != 4);

        scanner.close();
        System.out.println("\nSaindo ...");
        System.out.println("Programa Finalizado");
    }

}