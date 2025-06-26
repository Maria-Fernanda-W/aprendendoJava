package POO;

public class Argo implements Carro{

    @Override
    public void acelerar() {
        System.out.println("Acelerando o carro até 150km/h");
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
