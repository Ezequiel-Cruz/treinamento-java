package br.com.motor.model;

public class Conta {
    private Double valor;

    public void depositar(Double valor) {
        this.valor += valor;
    }
    public Double sacar(Double valor){
        this.valor -= valor;

        return valor;
    }
    public void transferir(Double valor, Conta destino){
        this.sacar(valor);
        destino.depositar(valor);
    }

    public void verSaldo() {
        System.out.println("Valor em conta: " + this.valor);
    }

    Conta() {
        this.valor = 0.0;
    }
}
