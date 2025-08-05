package POO;

public class Poo {
    public static void main(String[] args) {

        //=============================================================================================================
        // INTERFACES
        //=============================================================================================================
        System.out.println("\n| Utilizando Interfaces: ");
        Carro carro1 = new Uno();
        Carro carro2 = new Argo();

        carro1.acelerar();
        carro2.acelerar();

        //=============================================================================================================
        // HERANÇA E POLIMORFISMO
        //=============================================================================================================
        System.out.println("\n| Utilizando Heranças: ");
        //assim só consegue acessar os métodos do super Servivo
        SerVivo ser1 = new Humano(20, "Maria");
        ser1.respirar();
        ser1.dormir();
        ser1.comer();
        /*ser1.caminhar(); //da erro porque é um método de POO.Humano, não de POO.SerVivo*/

        //assim consegue acessar todos os dados do POO.SerVivo e POO.Peixe
        Peixe ser2 = new Peixe(2);
        ser2.respirar();
        ser2.dormir();
        ser2.comer();
        ser2.nadar();
    }
}


