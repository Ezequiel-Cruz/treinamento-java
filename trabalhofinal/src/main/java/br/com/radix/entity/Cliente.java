package br.com.radix.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document
public class Cliente {

    @Id
    private String nome;
    private int idade;
    private String email;
    private List<Conta> contas  = new ArrayList<>();

    public Cliente(){
        super();
    }

    public Cliente(String nome, int idade, String email, List<Conta> contas) {
        this.nome = nome;
        this.idade = idade;
        this.email = email;
        this.contas = contas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Conta> getContas() {
        return contas;
    }

    public void setContas(List<Conta> contas) {
        this.contas = contas;
    }

}
