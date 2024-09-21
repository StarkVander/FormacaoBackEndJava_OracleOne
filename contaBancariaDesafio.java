import java.text.NumberFormat;
import java.util.Scanner;
import java.util.Locale;

public class contaBancariaDesafio {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);

        // Saldo, Deposito, Boas Vindas e Pix
        String boasVindas, menu, usuario = "Vander Viana", saldoFormatado;
        int deposito, saque, opcao;
        double saldo = 4800.00;

        // Formatando o saldo
        NumberFormat formatoBrasileiro = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));

        saldoFormatado = formatoBrasileiro.format(saldo);

        // Boas Vindas!!!
        boasVindas = """
                ******************************************
                *   Bem-vindo à sua Conta Bancária!      *
                *                                        *
                *   Sua satisfação é nossa prioridade.   *
                *   Aqui, você pode gerenciar sua conta  *
                *   de forma fácil e segura.             *
                *                                        *
                *   Para começar, utilize os menus       *
                *   disponíveis e aproveite nossos       *
                *   serviços.                            *
                ******************************************
        """;
        System.out.println(boasVindas);
        // ------------------------------------------------------

        // Menu Principal da Conta
        menu = """
                ******************************************
                *   Opções:                              *
                *                                        *
                *   1 - Saldo                            *
                *   2 - Deposito                         *
                *   3 - Saque                            *
                *   4 - Sair                             *
                ******************************************
        """;

        do {
            System.out.println(menu);
            opcao = leitura.nextInt(); // Armazenando a escolha do usuario.

            switch (opcao) {
                case 1:
                    System.out.println("Conta: " + usuario);
                    System.out.println("Saldo: " + saldoFormatado);
                    break;
                case 2:
                    deposito = leitura.nextInt();
                    System.out.println("Valor do depósito: " + deposito);
                    saldo += deposito;
                    saldoFormatado = formatoBrasileiro.format(saldo);
                    System.out.println("Saldo atual: " + saldoFormatado);
                    break;
                case 3:
                    saque = leitura.nextInt();
                    if (saque > saldo) {
                        System.out.println("Saldo insuficiente");
                        System.out.println("Saldo: " + saldoFormatado);
                    } else {
                        saldo -= saque;
                        saldoFormatado = formatoBrasileiro.format(saldo);
                        System.out.println("Saldo atual: " + saldoFormatado);
                    }
                    break;
            }
        } while (opcao != 4);
    }
}
