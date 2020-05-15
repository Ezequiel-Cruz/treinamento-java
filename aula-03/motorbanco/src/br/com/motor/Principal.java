package br.com.motor;

import br.com.motor.model.Banco;
import br.com.motor.model.Usuario;

public class Principal {
    public static void main(String[] args) {
        Usuario joao = new Usuario("João");
        Usuario maria = new Usuario("Maria");

        Banco banco = new Banco();

        banco.criarConta(joao);
        banco.criarConta(maria);

        banco.depositar(50.0, joao);
        banco.sacar(10.0, maria);
        banco.transferir(10.0, joao, maria);

        banco.verTodosOsSaldos();
    }
}
