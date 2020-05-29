package br.com.radix.trabalhofinal.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.bson.types.ObjectId;

@Entity
public class NovaConta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private ObjectId id;
	private String usuario;
	@OneToMany
	private List<RespostaConta> contas;

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public List<RespostaConta> getContas() {
		return contas;
	}

	public void setContas(List<RespostaConta> contas) {
		this.contas = contas;
	}

}
