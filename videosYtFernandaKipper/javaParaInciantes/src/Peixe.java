public class Peixe extends SerVivo{

    public Peixe(int idade) {
        super(idade);
    }

    @Override
    public void respirar() {
        System.out.println("Respiração Braquial ");
    }

    @Override
    public void dormir() {
        System.out.println("domirmindo de olho aberto ... glop glop glop ");
    }

    public void nadar(){
        System.out.println("Nadando");
    }
}
