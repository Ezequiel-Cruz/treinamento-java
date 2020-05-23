
package br.com.radixeng.treinamentojava.trabalhofinal.app.dao;

import org.bson.Document;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoConnection {

    public MongoConnection() {
        try {
            MongoClient cliente = MongoClients.create(
                    "mongodb+srv://admin:admin@cluster0-9rzbh.mongodb.net/treinamento?retryWrites=true&w=majority");
            MongoDatabase database = cliente.getDatabase("treinamento");

            MongoCollection<Document> alunos = database.getCollection("contas");
            Document aluno = alunos.find().first();

            System.out.println(aluno.get("nome").toString());
            cliente.close();

        }  catch (Exception e) {
            e.printStackTrace();
        }
    }

    // public boolean inserir() {
       // document.put("id", "ezequiel");
     //   colecao.createIndex(document);
     //   return true;
   // }
}
