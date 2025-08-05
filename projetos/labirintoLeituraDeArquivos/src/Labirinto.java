import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Labirinto {
    private String[][] estruturaLabirinto;
    private boolean[][] visistaLabirinto;

    public Labirinto() {
    }

    public String[][] getEstruturaLabirinto() {
        return estruturaLabirinto;
    }

    public void criaLabirinto(String filename) {
        try {
            FileReader fr = new FileReader(filename);
            BufferedReader in = new BufferedReader(fr);
            int qtdLinhas = (int) in.lines().count(); // cast para int pos retorna log

            // abrindo novamente o arquivo
            fr = new FileReader(filename);
            in = new BufferedReader(fr);
            String line = in.readLine();
            int linhaAtual = 0; // contador para saber a linha atual do meu array
            estruturaLabirinto = new String[qtdLinhas][];

            while (line != null && linhaAtual < qtdLinhas) {
                String[] colunas = line.split("\\*"); // array com as informações da linha

                // inicializa a qtd de colunas
                estruturaLabirinto[linhaAtual] = new String[colunas.length];

                for (int i = 0; i < colunas.length; i++) {
                    estruturaLabirinto[linhaAtual][i] = colunas[i];
                }
                line = in.readLine(); 
                linhaAtual += 1; 
            }
            in.close();

        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado");
        } catch (IOException e) {
            System.out.println("Erro na leitura do arquivo: " + filename);
        }
    }

    public void imprimeLabirinto() throws NullPointerException {
        if (estruturaLabirinto == null)
            throw new NullPointerException();


        for (int i = 0; i < estruturaLabirinto.length; i++) {
            for (int j = 0; j < estruturaLabirinto[i].length; j++) {
                System.out.print(estruturaLabirinto[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean percorreLabirinto() throws NullPointerException {
        if (estruturaLabirinto == null)
            throw new NullPointerException();

        visistaLabirinto = new boolean[estruturaLabirinto.length][estruturaLabirinto[0].length];
        return percorreLabirintoPrivate(0, 0);
    }

    private boolean percorreLabirintoPrivate(int i, int j) {
        // Validaçãoes tamanho da matriz:
        // i < 0 || j < 0 -- não pode indice negativo
        // i >= estruturaLabirinto.length -- passou o limite de linhas
        // j >= estruturaLabirinto[i].length -- passou o limite de colunas
        if (i < 0 ||
                j < 0 ||
                i >= estruturaLabirinto.length ||
                j >= estruturaLabirinto[i].length) {
            return false;
        }

        // caso base: X é uma barreira, não pode passar
        // visistaLabirinto[i][j] --  para não gerar um loop infinito
        if (estruturaLabirinto[i][j].equalsIgnoreCase("X") || visistaLabirinto[i][j]) {
            return false;
        }

        // caso base: D é o final do labirinto
        if (estruturaLabirinto[i][j].equalsIgnoreCase("D")) {
            return true;
        }

       visistaLabirinto[i][j] = true;

        // tenta andar pelo labirinto
        if (percorreLabirintoPrivate(i, j + 1)) {
            return true; // para direita
        }
        if (percorreLabirintoPrivate(i + 1, j)) {
            return true; // para baixo
        }
        if (percorreLabirintoPrivate(i, j - 1)) {
            return true; // para esquerda
        }
        if (percorreLabirintoPrivate(i - 1, j)) {
            return true; // para cima
        }
        return false;
    }
}
