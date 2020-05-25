
package br.com.radixeng.treinamentojava.trabalhofinal.app.dao;

import br.com.radixeng.treinamentojava.trabalhofinal.app.controller.model.NovaContaMongo;
import br.com.radixeng.treinamentojava.trabalhofinal.app.controller.model.RespostaConta;
import br.com.radixeng.treinamentojava.trabalhofinal.app.controller.model.RespostaListaContas;
import br.com.radixeng.treinamentojava.trabalhofinal.app.entity.Conta;
import br.com.radixeng.treinamentojava.trabalhofinal.app.entity.TipoDeConta;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;

public class MongoConnection {


    public MongoConnection() {

    }

    public void OpenConnection() {
        try {


        }  catch (Exception e) {
            e.printStackTrace();
        }
    }


    public boolean inserir(String usuario, Map<TipoDeConta,Conta> contas) {
        try {
            // OpenConnection();

            // MongoCollection<Document> document;
           // MongoClient cliente;

            MongoClient mongoClient = MongoClients.create(
                    "mongodb+srv://admin:admin@cluster0-9rzbh.mongodb.net/treinamento?retryWrites=true&w=majority");
            MongoDatabase database = mongoClient.getDatabase("treinamento");

//            cliente = MongoClients.create(
//                    "mongodb+srv://admin:admin@cluster0-shard-00-02-9rzbh.mongodb.net/treinamento?retryWrites=true&w=majority");
//            MongoDatabase database = cliente.getDatabase("treinamento");

            MongoCollection document = database.getCollection("contas");

            RespostaListaContas resultadoConta = new RespostaListaContas();

            Map<TipoDeConta, Conta> conta = contas;
            for (TipoDeConta tipo: conta.keySet()) {
                RespostaConta c = new RespostaConta();
                c.saldo = contas.get(tipo).obterSaldo();
                c.tipo = tipo;
                resultadoConta.contas.add(c);
            }

            NovaContaMongo teste = new NovaContaMongo();

            teste.usuario = usuario;
            teste.contas = resultadoConta.contas;

            Document novoAluno = new Document("nome", "Joao")
                    .append("data_nascimento", new Date(2003, 10, 10))
                    .append("curso", new Document("nome", "Historia"))
                    .append("notas", Arrays.asList(10, 9, 8))
                    .append("habilidades", Arrays.asList(
                            new Document().append("nome", "Ingles").append("nível", "Básico"),
                            new Document().append("nome", "Espanhol").append("nível", "Básico")));

            document.insertOne(novoAluno);

           // Document doc = new Document("nome", usuario.toString());
//                    .append("contas", Arrays.asList(
//                new Document()
//                        .append("tipo", teste.contas.get().tipo)
//                        .append("valor", teste.contas.get().saldo)
//                ));

          //  this.document.insertOne(doc);
            System.out.println(novoAluno);
            mongoClient.close();
            return true;

        } catch (Exception e) {
            System.out.println("Erro no insert: " + e);
            return false;
        }
    }
}
