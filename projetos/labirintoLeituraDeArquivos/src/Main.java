public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("\n========================= Testando Labirinto 1 =========================");
        System.out.println("\n---> Lendo informações do arquivo");
        Labirinto labirinto1 = new Labirinto();
        labirinto1.criaLabirinto("src/arquivos/labirinto_1.txt");

        System.out.println("\n---> Imprimindo Labirinto");
        try {
            labirinto1.imprimeLabirinto();
        } catch(NullPointerException e){
            System.err.println("Não é possível imprimir: "+e.getMessage());
        }

        System.out.println("\n---> Buscando saída do labirinto");
        try {
            boolean existeSaida = labirinto1.percorreLabirinto();
            if(existeSaida) {
                System.out.println("Saída encontrada =)");
            } else {
                System.out.println("Saída não foi encontrada =(");
            }
        } catch(NullPointerException e){
            System.err.println("Não é possível percorrer o labirinto: "+e.getMessage());
        }


        System.out.println("\n========================= Testando Labirinto 2 =========================");
        System.out.println("\n---> Lendo informações do arquivo");
        Labirinto labirinto2 = new Labirinto();
        labirinto2.criaLabirinto("src/arquivos/labirinto_2.txt");

        System.out.println("\n---> Imprimindo Labirinto");
        try {
            labirinto2.imprimeLabirinto();
        } catch(NullPointerException e){
            System.err.println("Não é possível imprimir: "+e.getMessage());
        }

        System.out.println("\n---> Buscando saída do labirinto");
        try {
            boolean existeSaida = labirinto2.percorreLabirinto();
            if(existeSaida) {
                System.out.println("Saída encontrada =)");
            } else {
                System.out.println("Saída não foi encontrada =(");
            }
        } catch(NullPointerException e){
            System.err.println("Não é possível percorrer o labirinto: "+e.getMessage());
        }


        System.out.println("\n========================= Testando Labirinto 3 =========================");
        System.out.println("\n---> Lendo informações do arquivo");
        Labirinto labirinto3 = new Labirinto();
        labirinto3.criaLabirinto("src/arquivos/labirinto_3.txt");

        System.out.println("\n---> Imprimindo Labirinto");
        try {
            labirinto3.imprimeLabirinto();
        } catch(NullPointerException e){
            System.err.println("Não é possível imprimir: "+e.getMessage());
        }

        System.out.println("\n---> Buscando saída do labirinto");
        try {
            boolean existeSaida = labirinto3.percorreLabirinto();
            if(existeSaida) {
                System.out.println("Saída encontrada =)");
            } else {
                System.out.println("Saída não foi encontrada =(");
            }
        } catch(NullPointerException e){
            System.err.println("Não é possível percorrer o labirinto: "+e.getMessage());
        }
    }
}
