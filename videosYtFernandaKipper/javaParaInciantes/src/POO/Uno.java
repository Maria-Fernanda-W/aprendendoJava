package POO;

public class Uno implements Carro {

    @Override
    public void acelerar() {
        System.out.println("Acelerando o carro até 120km/h");
    }

    @Override
    public void freiar() {
        System.out.println("Freiando o carro ");
    }

    @Override
    public void parar() {
        System.out.println("Parando o carro ");
    }

}
