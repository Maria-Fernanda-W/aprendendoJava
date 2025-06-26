import java.util.ArrayList;

public class SintaxeBase {
    public static void main(String[] args) {

        //=============================================================================================================
        // TIPOS PRIMITIVOS E STRING
        //=============================================================================================================
        byte b = 100;
        short s = 10000;
        int in = 100000;
        long l = 100000L; //necessário colocar o L no final do valor
        float f = 10.5f; //necessário colocar o f no final do valor
        double d = 20.5;
        boolean bool = true;
        char c = 'A';
        String str = "Maria";

        //=============================================================================================================
        // CONDICIONAIS
        //=============================================================================================================
        System.out.println("\n| Utilizando Condicionais: ");
        if(bool){
            System.out.println("Verdadeiro");
        }  else {
            System.out.println("False");
        }

        if (str.isBlank()){
            System.out.println("string vazia");
        } else if (str.equals("Maria")) {
            System.out.println("valor da string é Maria");
        } else {
            System.out.println("string = "+str);
        }

        //=============================================================================================================
        //  VETORES
        //=============================================================================================================
        System.out.println("\n| Utilizando Vetores: ");
        int colecaoDeInteirosComValor[] = {1, 2, 3, 4, 5};

        String[] colecaoDeInteirosSemValor = new String[4];
        System.out.println("--> Adicionando valor");
        colecaoDeInteirosSemValor[0] = "a";
        colecaoDeInteirosSemValor[1] = "b";
        colecaoDeInteirosSemValor[2] = "c";
        System.out.println("tamanho: "+ colecaoDeInteirosSemValor.length );

        System.out.println("indece 0: "+colecaoDeInteirosSemValor[0]);
        System.out.println("indece 1: "+colecaoDeInteirosSemValor[1]);

        System.out.println("--> Removendo valor");
        colecaoDeInteirosSemValor[0] = null;
        System.out.println("tamanho: "+ colecaoDeInteirosSemValor.length );
        System.out.println("indece 0: "+colecaoDeInteirosSemValor[0]);
        System.out.println("indece 1: "+colecaoDeInteirosSemValor[1]);

        //=============================================================================================================
        // ARRAY LIST
        //=============================================================================================================
        System.out.println("\n| Utilizando ArrayList: ");
        ArrayList<String> nomes = new ArrayList<>();
        System.out.println("--> Adicionando valor");
        nomes.add("Maria");
        nomes.add("Fernanda");
        nomes.add("Eduarda");
        nomes.add("Gabriela");
        nomes.add("Eloiza");

        System.out.println("tamanho: "+nomes.size());
        System.out.println("indece 0: "+nomes.get(0));
        System.out.println("indece 1: "+nomes.get(1));
        System.out.println("indece 1: "+nomes.get(2));

        System.out.println("--> Removendo valor");
        nomes.remove(0);
        nomes.remove("Fernanda");

        System.out.println("tamanho: "+nomes.size());
        System.out.println("indece 0: "+nomes.get(0));
        System.out.println("indece 1: "+nomes.get(1));
        System.out.println("indece 1: "+nomes.get(2));

        //=============================================================================================================
        // LOOPS
        //=============================================================================================================
        System.out.println("\n| Utilizando Loops: ");

        System.out.println("|- Usando for:");
        System.out.println("Exibindo array de números com for:");
        for(int i=0; i < colecaoDeInteirosComValor.length; i++){
            System.out.println(colecaoDeInteirosComValor[i]);
        }

        System.out.println("\nExibindo arrayList de nomes com for:");
        for(int i=0; i < nomes.size(); i++) {
            System.out.println(nomes.get(i));
        }

        System.out.println("\nExibindo array de nomes com for-each");
        for(int numeros: colecaoDeInteirosComValor){
            System.out.println(numeros);
        }

        System.out.println("\nExibindo array de nomes com for-each:");
        for (String nome: nomes){
            System.out.println(nome);
        }

        System.out.println("\n|- Usando while:");
        int contador = 0;
        while (contador < 3) {
            System.out.println("Estou no while");
            contador++;
        }
        System.out.println("Sai do while");

        //=============================================================================================================
        // CASTING
        //=============================================================================================================
        System.out.println("\n| Utilizando Casting: ");
        System.out.println("|- Casting Implícito:");
        int result = 2;
        double resultDouble = result;
        System.out.println("int: "+result);
        System.out.println("int to double: "+resultDouble);

        System.out.println("\n|- Casting Explícito:");
        double resultado = 5.5;
        int resultadoInt = (int) resultado;
        String resultadoStr = String.valueOf(resultadoInt);
        int meuInt = Integer.parseInt(resultadoStr);

        System.out.println("double: "+resultado);
        System.out.println("double to int: "+resultadoInt);
        System.out.println("int to String: "+resultadoStr);
        System.out.println("string to int: "+meuInt);

    }
}