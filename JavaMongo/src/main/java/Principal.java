
import java.util.Arrays;
import java.util.Date;
import org.bson.Document;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class Principal {
	public static void main(String[] args) {

		MongoClient cliente = MongoClients.create(
		    "mongodb+srv://");
		MongoDatabase database = cliente.getDatabase("cadastro");
		
		MongoCollection<Document> alunos = database.getCollection("alunos");
		Document aluno = alunos.find().first();
		
		System.out.println(aluno.get("nome").toString());
		
		Document novoAluno = new Document("nome", "Julio")
				  .append("data_nascimento", new Date(1993, 10, 10))
				  .append("curso", new Document("nome", "Computa��o"))
				  .append("notas", Arrays.asList(10, 9, 8))
				  .append("habilidades", Arrays.asList(
				          new Document().append("nome", "Ingles").append("n�vel", "B�sico"),
				          new Document().append("nome", "Espanhol").append("n�vel", "B�sico")));
		 
		alunos.insertOne(novoAluno);
	    System.out.println(novoAluno);
		
		cliente.close();		
	}
}
		