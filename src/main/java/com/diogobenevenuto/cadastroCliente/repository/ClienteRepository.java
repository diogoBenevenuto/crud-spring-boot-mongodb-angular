package com.diogobenevenuto.cadastroCliente.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.diogobenevenuto.cadastroCliente.model.Clientes;

@Repository
public interface ClienteRepository extends MongoRepository<Clientes, String> {
	List<Clientes> findByCityId(String cityId);
}
