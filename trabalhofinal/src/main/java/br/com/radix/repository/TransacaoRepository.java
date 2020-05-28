package br.com.radix.repository;

import br.com.radix.entity.Transacao;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TransacaoRepository extends MongoRepository<Transacao, String> {
}
