package br.com.radix.repository;

import br.com.radix.entity.Conta;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ContaRepository extends MongoRepository<Conta, String> {
}
