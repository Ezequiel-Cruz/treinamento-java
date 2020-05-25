package br.com.radixeng.treinamentojava.trabalhofinal.app.controller.model;

import br.com.radixeng.treinamentojava.trabalhofinal.app.entity.TipoDeConta;

public class RespostaConta {
    public TipoDeConta tipo;
    public Double saldo;

    public Double getSaldo() {
        return saldo;
    }

    public TipoDeConta getTipo() {
        return tipo;
    }
}
