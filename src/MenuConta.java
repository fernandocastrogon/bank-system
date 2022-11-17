import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.System.exit;



public class MenuConta {

    public static void clearConsole() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            }
            else {
                System.out.print("\033\143");
            }
        } catch (IOException | InterruptedException ex) {
            System.out.println("ERRO");
        }
    }

    public static void printMenu(String[] opcoes) {
        for (String opcao : opcoes) {
            System.out.println(opcao);
        }
        System.out.print("Escolha sua opcao : ");
    }

    private static String[] opcoes = {
            "",
            "Seja bem vindo a sua conta bancária, escolha sua ação: ",
            "1 - Transferir para a conta do Fabricio",
            "2 - Depositar",
            "3 - Sacar",
            "4 - Visualizar dados Cadastrais",
            "5 - Sair",
    };

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);

        //Criando cliente Fernando e conta corrente
        Cliente fernando = new Cliente("Fernando", "fernando@gmail.com", "Rua affonso pena 300");
        ContaCorrente c1 = new ContaCorrente(fernando, 01, 10, 0.50, 1000);

        //Criando cliente Fabricio e conta corrente
        Cliente fabricio = new Cliente("Fabricio", "fabricio@gmail.com", "av affonso pena");
        ContaCorrente c2 = new ContaCorrente(fabricio, 02, 10, 0.50, 1000);


        int opcao = 0;
        while (opcao != 4) {
            printMenu(opcoes);
            try {
                opcao = ler.nextInt();
                switch (opcao) {
                    case 1:
                        clearConsole();
                        System.out.println("Digite o valor que deseja transferir para a conta do Fabricio");
                        c1.transferir(ler.nextDouble(), c2);
                        break;

                    case 2:
                        clearConsole();
                        System.out.println("Digite o valor que quer depositar");
                        c1.depositar(ler.nextDouble());
                        System.out.println("Valor depositado com sucesso");
                        break;

                    case 3:
                        clearConsole();
                        System.out.println("Digite o valor que quer sacar");
                        c1.sacar(ler.nextDouble());
                        System.out.println("Valor sacado com sucesso");
                        break;
                    case 4:
                        String[] lista = fernando.getDadosCadastrais();
                        for (int i = 0; i < lista.length; i++) {
                            System.out.println(lista[i]);
                        }
                    case 5:
                        exit(0);
                }
            } catch (InputMismatchException ex) {
                clearConsole();
                System.out.println("Por favor entre com um numero entre 1 e " + opcoes.length);
                ler.next();
            }


        }


    }

}
