package br.com.bytebank;

import br.com.bytebank.model.Tipo;
import br.com.bytebank.registrador.Pagamento;
import br.com.bytebank.registrador.RegistroDePagamento;

import java.util.Arrays;
import java.util.List;

public class Principal {

    public static void main(String[] args) {
        Pagamento almoco = new Pagamento("Almoço na feijuca", Tipo.DEBITO, 20);
        Pagamento videogame = new Pagamento("PS4", Tipo.CREDITO, 1020);

        List<Pagamento> pagamentos = Arrays.asList(almoco, videogame);

        RegistroDePagamento registrador = new RegistroDePagamento();
        registrador.registra(pagamentos);
    }
}
