package br.com.motor;

import br.com.motor.model.*;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner c = new Scanner(System.in);

        Usuario joao = new Usuario("João");
        // Maria
        Usuario maria = new Usuario("Maria");
        // Fernanda
        Usuario fernanda = new Usuario("Fernanda");

        Integer t = 0;
        while(t != -1) {
            t = c.nextInt();

            Banco banco = new Banco();

            // Operações
            banco.criarConta(joao, ContaCorrente.class.getName());
            banco.criarConta(joao, ContaPoupanca.class.getName());
            banco.criarConta(maria, ContaCorrente.class.getName());
            banco.criarConta(maria, ContaInvestimento.class.getName());
            banco.criarConta(fernanda, "ContaEspecial");

            banco.depositar(50.0, joao, ContaCorrente.class.getName());
            banco.transferir(20.0, joao, ContaCorrente.class.getName(), joao, ContaPoupanca.class.getName());

            banco.sacar(10.0, maria, ContaCorrente.class.getName());

            // banco.sacar(10.0, fernanda, ContaCorrente.class.getName());

            banco.transferir(10.0, joao, ContaCorrente.class.getName(), maria, ContaCorrente.class.getName());

            banco.depositar(30.0, maria, ContaInvestimento.class.getName());
            banco.sacar(10.0, maria, ContaInvestimento.class.getName());

            banco.verTodosOsSaldos();
        }
    }
}
