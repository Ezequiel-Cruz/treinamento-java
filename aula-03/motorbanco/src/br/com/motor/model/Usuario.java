package br.com.motor.model;

public class Usuario {
    private String nome;

    public Usuario(String nome) {
        this.nome = nome;
    }

    public String obterNome() {
        return this.nome;
    }
}
