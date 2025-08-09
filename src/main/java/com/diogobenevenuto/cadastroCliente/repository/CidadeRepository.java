package com.diogobenevenuto.cadastroCliente.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.diogobenevenuto.cadastroCliente.model.Cidade;

@Repository
public interface CidadeRepository extends MongoRepository<Cidade, String> {

}
