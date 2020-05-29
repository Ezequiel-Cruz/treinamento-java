package br.com.radix.trabalhofinal.model;

public class RespostaConta {
    public TipoDeConta tipo;
    public Double saldo;

    public RespostaConta() {

    }

    public RespostaConta(final TipoDeConta tipo, final Double saldo) {
        this.tipo = tipo;
        this.saldo = saldo;
    }

    public Double getSaldo() {

        return saldo;
    }

    public TipoDeConta getTipo() {

        return tipo;
    }
}
