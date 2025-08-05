import POO.Carro;

public class TratandoExcecoes {

    public static void main(String[] args) {
        Carro carroEstragado = null;

        try {
            carroEstragado.acelerar();

        } catch (NullPointerException exception){
            System.out.println("Vende carro estragado");
        }

        /*Lista de exceções mais comuns:
        * NullPointerException  — esta tentando acessar algo nulo
        * ArrayIndexOutOfBoundsException — esta tentando acessar um posição fora do array
        * RuntimeException  — exceções mais gerais,
        * IOException  — erros na leitura de arquivos
        * ArithmeticException  — erros aritiméticos, exp: divisão por zero
        */

    }
}
