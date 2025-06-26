import java.io.IOException;

public class TratandoExcecoes {

    public static void main(String[] args) {
        Carro carroEstragado = null;

        try {
            carroEstragado.acelerar();

        } catch (NullPointerException exception){
            System.out.println("Vende carro estragado");
        }



    }
}
