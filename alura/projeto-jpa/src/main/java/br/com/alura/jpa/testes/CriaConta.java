package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;

public class CriaConta {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		
		Conta conta = new Conta();
		conta.setTitular("Julio");
		conta.setNumero(0002);
		conta.setAgencia(7752);
		
//		conta.setTitular("Leonardo");
//		conta.setNumero(0003);
//		conta.setAgencia(5569);
		
		em.getTransaction().begin();
		
		em.persist(conta);

		em.getTransaction().commit();
	}

}
