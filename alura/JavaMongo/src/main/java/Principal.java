
import java.util.Arrays;
import java.util.Date;
import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class Principal {
	public static void main(String[] args) {
		try {

	        MongoCredential credential = MongoCredential.createCredential("java", "treinamento", "java@".toCharArray());
	        MongoClient cliente = new MongoClient(new ServerAddress("localhost", 27017), Arrays.asList(credential));

	        MongoDatabase database = cliente.getDatabase("treinamento");
				
	        System.out.println("Sucesso na conexão: " + cliente);
	        
	        System.out.println("Sucesso na base de dados: " + database);
	        
	        MongoCollection<Document> alunos = database.getCollection("contas");
	        
	        System.out.println("Sucesso na colection: " + alunos);
  
	        Document novoAluno = new Document("nome", "Joao")
	                .append("data_nascimento", new Date(2000, 10, 10))
	                .append("curso", new Document("nome", "Historia"))
	                .append("notas", Arrays.asList(10, 9, 8))
	                .append("habilidades", Arrays.asList(
	                        new Document().append("nome", "Ingles").append("nível", "Básico"),
	                        new Document().append("nome", "Espanhol").append("nível", "Básico")));

	        alunos.insertOne(novoAluno);
	        System.out.println(novoAluno);
	        cliente.close();
		} catch (Exception e) {
			 System.out.println("Erro" + e);
		}
			
		
		
	}
}
		