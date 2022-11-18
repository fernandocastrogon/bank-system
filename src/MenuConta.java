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
            "Seja bem vindo a sua Conta bancária Fernando, escolha sua ação: ",
            "1 - Transferir para a Conta Corrente do Fabricio",
            "2 - Depositar Conta Corrente",
            "3 - Sacar Conta Corrente",
            "4 - Visualizar seus Dados Cadastrais",
            "5 - Visualizar saldo da Conta Poupança",
            "6 - Depositar Conta Poupança",
            "7 - Sacar Conta Poupança",
            "8 - Sair",
    };

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);

        //Criando cliente Fernando, conta corrente e conta poupanca
        Cliente fernando = new Cliente("Fernando", "fernando@gmail.com", "Rua affonso pena 300");
        ContaCorrente cc1 = new ContaCorrente(fernando, 01, 10, 0.50, 1000);
        ContaPoupanca cp1 = new ContaPoupanca(fernando, 01, 10);
        cp1.atualizar(1.0);

        //Criando cliente Fabricio, conta corrente e conta poupanca
        Cliente fabricio = new Cliente("Fabricio", "fabricio@gmail.com", "av affonso pena");
        ContaCorrente cc2 = new ContaCorrente(fabricio, 02, 10, 0.50, 1000);
        ContaPoupanca cp2 = new ContaPoupanca(fabricio, 02, 10);


        int opcao = 0;
        while (opcao != 8) {
            printMenu(opcoes);
            try {
                opcao = ler.nextInt();
                switch (opcao) {
                    case 1:
                        clearConsole();
                        System.out.println("Digite o valor que deseja transferir para a conta do Fabricio");
                        cc1.transferir(ler.nextDouble(), cc2);
                        break;

                    case 2:
                        clearConsole();
                        System.out.println("Digite o valor que quer depositar");
                        cc1.depositar(ler.nextDouble());
                        System.out.println("Valor depositado com sucesso");
                        break;

                    case 3:
                        clearConsole();
                        System.out.println("Digite o valor que quer sacar");
                        if(cc1.sacar(ler.nextDouble())) {
                            System.out.println("Valor sacado com sucesso!");
                        }else {
                            System.out.println("Valor insuficiente ou acima do limite diário");
                            break;
                        }
                        break;
                    case 4:
                        String[] lista = fernando.getDadosCadastrais();
                        for (int i = 0; i < lista.length; i++) {
                            System.out.println(lista[i]);
                        }
                        break;
                    case 5:
                        clearConsole();
                        System.out.println("Seu saldo da Conta Poupança é " + cp1.getSaldo());
                        break;
                    case 6:
                        clearConsole();
                        System.out.println("Digite o valor que deseja depositar na sua Conta Poupança: ");
                        cp1.depositar(ler.nextDouble());
                        System.out.println("Valor depositado com sucesso");
                        break;
                    case 7:
                        clearConsole();
                        System.out.println("Digite o valor que deseja sacar da sua Conta Poupança: ");
                        if(cp1.sacar(ler.nextDouble())){
                            System.out.println("Valor sacado com sucesso!");
                        }else {
                            System.out.println("Saldo insuficiente");
                            break;
                        }
                        break;
                    case 8:
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
