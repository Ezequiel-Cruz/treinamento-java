package br.com.radix.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Collection;

@Document
public class Cliente {

    private ObjectId _id;
    @Id
    private String nome;
    private int idade;
    private String email;
    @DBRef
    private Collection<Conta> contas = new ArrayList<Conta>();


    public ObjectId get_id() {
        return _id;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public Collection<Conta> getContas() {
        return contas;
    }

    public void setContas(Collection<Conta> contas) {
        this.contas = contas;
    }


    public Cliente() {
        this._id = ObjectId.get();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ObjectId getId() {
        return _id;
    }

    public void setId(ObjectId id) {
        this._id = id;
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

}
