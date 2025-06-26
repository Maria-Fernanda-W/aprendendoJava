package POO;

public class Humano extends SerVivo{
    String nome;

    public Humano(int idade, String nome) {
        super(idade);
        this.nome = nome;
    }

    @Override
    public void respirar() {
        System.out.println("Respiração Pulmonar ");
    }

    @Override
    public void comer(){
        System.out.println("Alimentação Onivora");
    }

    public void caminhar(){
        System.out.println("Caminhando");
    }

}
