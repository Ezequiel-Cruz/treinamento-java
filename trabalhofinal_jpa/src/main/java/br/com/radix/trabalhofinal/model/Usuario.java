package br.com.radix.trabalhofinal.model;

public class Usuario implements IUsuario {
    private String nome;

    Usuario(String nome) {

        this.nome = nome;
    }

    public String obterNome() {

        return this.nome;
    }

    public String obterIdentificador() {

        return this.obterNome();
    }
}
